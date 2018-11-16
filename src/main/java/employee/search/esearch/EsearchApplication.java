package employee.search.esearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EsearchApplication {

	private static final Logger log = LoggerFactory.getLogger(EsearchApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EsearchApplication.class, args);
	}
	 
	
}
