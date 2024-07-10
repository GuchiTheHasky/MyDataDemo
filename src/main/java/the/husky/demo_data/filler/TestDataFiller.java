package the.husky.demo_data.filler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import the.husky.demo_data.entity.MyData;
import the.husky.demo_data.repository.DataRepository;

import java.util.Random;

@Component
@Slf4j
@RequiredArgsConstructor
public class TestDataFiller {
    private final DataRepository dataRepository;

    public void fillDb(int count, int size) {
        if (dataRepository.count() < count) {
            log.info("Filling the database with test data.");
            for (int i = 0; i < count; i++) {
                MyData myData = new MyData();
                myData.setBytes(generateRandomBytes(size));
                dataRepository.save(myData);
            }
            log.info("Fulfilling completed.");
        }
        log.info("Data repository table count: {}", dataRepository.count());
    }

    private byte[] generateRandomBytes(int size) {
        byte[] bytes = new byte[size];
        new Random().nextBytes(bytes);
        return bytes;
    }
}
