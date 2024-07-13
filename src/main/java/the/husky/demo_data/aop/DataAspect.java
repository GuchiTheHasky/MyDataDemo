package the.husky.demo_data.aop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
@RequiredArgsConstructor
public class DataAspect {

    @PersistenceContext
    private final EntityManager entityManager;

    @AfterReturning("the.husky.demo_data.aop.DataPointcut.saveAllPointcut()")
    public void afterSaveAllAdvice() {
        entityManager.flush();
        entityManager.clear();
        log.info("EntityManager flushed and cleared");
    }

}
