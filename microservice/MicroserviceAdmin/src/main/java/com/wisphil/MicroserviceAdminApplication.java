package com.wisphil;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class MicroserviceAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAdminApplication.class, args);
	}

}
