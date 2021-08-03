package com.mercadolibre.consulting;

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
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootApplication
public class ConsultingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultingApplication.class, args);
	}

}

@Component
class RunAtStart implements CommandLineRunner {
	final Logger logger = LoggerFactory.getLogger(ConsultingApplication.class);

	@Value("${SCOPE}")
	private String SCOPE;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private ProfessionalRepository professionalRepository;
	@Autowired
	private TurnRepository turnRepository;

	@Override
	public void run(String... args) {
		if (SCOPE == null) throw new IllegalArgumentException("${ENVIRONMENT} must be seted");
		logger.info("ENVIRONMENT: " + SCOPE);
		if (SCOPE.equals("dev")) {
			//Create patients
			PatientModel pa1 = PatientModel.builder().name("Ana").last_name("Quevedo").build();
			patientRepository.save(pa1);

			PatientModel pa2 = PatientModel.builder().name("Juan").last_name("Rojas").build();
			patientRepository.save(pa2);

			PatientModel pa3 = PatientModel.builder().name("Juana").last_name("Martinez").build();
			patientRepository.save(pa3);


			//Create professional
			ProfessionalModel pr1 = ProfessionalModel.builder().name("Diana").last_name("Tazares").service("General").build();
			professionalRepository.save(pr1);

			//Create turns
			TurnModel tr1 = TurnModel.builder().f_entry(LocalDateTime.now()).f_out(LocalDateTime.now().plusMinutes(30)).patientModel(pa1).professionalModel(pr1).attended(false).build();
			turnRepository.save(tr1);

			TurnModel tr2 = TurnModel.builder().f_entry(LocalDateTime.now().plusMinutes(30)).f_out(LocalDateTime.now().plusMinutes(60)).patientModel(pa2).professionalModel(pr1).attended(false).build();
			turnRepository.save(tr2);
		}

	}
}

