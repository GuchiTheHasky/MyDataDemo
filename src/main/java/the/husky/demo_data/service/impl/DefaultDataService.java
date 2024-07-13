package the.husky.demo_data.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import the.husky.demo_data.entity.MyData;
import the.husky.demo_data.exception.ProcessException;
import the.husky.demo_data.repository.DataRepository;
import the.husky.demo_data.service.DataService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultDataService implements DataService {

    private final DataRepository dataRepository;

    @Value("${page.size}")
    private int pageSize;

    @Override
    @Transactional
    public void process(int count) {
        int pageNumber = 0;
        Page<MyData> dataPage;

        do {
            Pageable page = PageRequest.of(pageNumber, pageSize);
            log.info("Page number: {}", pageNumber);
            dataPage = dataRepository.findAll(page);

            List<MyData> data = new ArrayList<>(dataPage.getContent());

            modifyProcess(data);
            pageNumber++;
            count = exitProcess(count);
        } while (dataPage.hasNext());
    }

    public void modifyProcess(List<MyData> data) {
        try {
            LocalDateTime now = LocalDateTime.now();
            log.info("New date: {}", now);
            data.forEach(myData -> myData.setModifyAt(now));
            dataRepository.saveAll(data);
        } catch (Exception e) {
            log.error("An error while modifying data", e);
        }
    }

    private int exitProcess(int count) {
       if (count <= 0) throw new ProcessException();
       return count - 1;
    }
}


