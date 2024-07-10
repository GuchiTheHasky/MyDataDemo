package the.husky.demo_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import the.husky.demo_data.entity.MyData;

public interface DataRepository extends JpaRepository<MyData, Integer> {

}
