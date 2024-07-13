package the.husky.demo_data.aop;

import org.aspectj.lang.annotation.Pointcut;

public class DataPointcut {

    @Pointcut("execution(* the.husky.demo_data.repository.DataRepository.saveAll(..))")
    public void saveAllPointcut() {}

}
