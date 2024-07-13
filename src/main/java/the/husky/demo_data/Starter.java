package the.husky.demo_data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import the.husky.demo_data.filler.TestDataFiller;
import the.husky.demo_data.service.DataService;
import the.husky.demo_data.service.impl.DefaultDataService;

@SpringBootApplication
public class Starter {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Starter.class, args);
//
//		int rowCount = Integer.parseInt(args[0]);
//		int rowByteSize = Integer.parseInt(args[1]);
//
//		TestDataFiller dataFiller = context.getBean(TestDataFiller.class);
//		dataFiller.fillDb(rowCount, rowByteSize);
//
		int forceExitCount = Integer.parseInt(args[2]);

		DataService dataService = context.getBean(DefaultDataService.class);
		dataService.process(forceExitCount);
	}
}
