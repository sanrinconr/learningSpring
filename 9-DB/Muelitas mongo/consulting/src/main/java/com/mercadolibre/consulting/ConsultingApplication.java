package com.mercadolibre.consulting;

import com.mercadolibre.consulting.enums.ProfessionalServices;
import com.mercadolibre.consulting.enums.TurnStatus;
import com.mercadolibre.consulting.model.PatientModel;
import com.mercadolibre.consulting.model.ProfessionalModel;
import com.mercadolibre.consulting.model.TurnModel;
import com.mercadolibre.consulting.repository.PatientRepository;
import com.mercadolibre.consulting.repository.ProfessionalRepository;
import com.mercadolibre.consulting.repository.TurnRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@SpringBootApplication
public class ConsultingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultingApplication.class, args);
	}

}



