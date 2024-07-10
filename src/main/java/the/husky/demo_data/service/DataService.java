package the.husky.demo_data.service;

import org.springframework.transaction.annotation.Transactional;

public interface DataService {

    void process(int count);
}
