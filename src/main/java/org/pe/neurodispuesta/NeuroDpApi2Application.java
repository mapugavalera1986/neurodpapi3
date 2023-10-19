package org.pe.neurodispuesta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NeuroDpApi2Application {

	public static void main(String[] args) {
		SpringApplication.run(NeuroDpApi2Application.class, args);
		System.out.println("El servicio ya funciona");
	}
}
