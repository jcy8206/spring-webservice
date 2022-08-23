package com.jcy.springwebservice;

import com.jcy.springwebservice.config.Config;
import com.jcy.springwebservice.repository.ItemRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Import(Config.class)
@SpringBootApplication(scanBasePackages = "com.jcy.springwebservice.web")
public class SpringWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebserviceApplication.class, args);
	}


}
