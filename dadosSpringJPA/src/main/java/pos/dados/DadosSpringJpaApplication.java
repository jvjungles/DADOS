package pos.dados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class DadosSpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DadosSpringJpaApplication.class, args);
	}

}
