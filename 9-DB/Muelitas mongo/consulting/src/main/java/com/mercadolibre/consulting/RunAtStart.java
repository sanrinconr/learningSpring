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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RunAtStart implements CommandLineRunner {
    final Logger logger = LoggerFactory.getLogger(ConsultingApplication.class);

    @Value("${SCOPE}")
    private String SCOPE;

    private static PatientRepository patientRepository;
    private static ProfessionalRepository professionalRepository;
    private static TurnRepository turnRepository;

    public RunAtStart(PatientRepository pat, ProfessionalRepository pro, TurnRepository tur){
        patientRepository = pat;
        professionalRepository = pro;
        turnRepository = tur;
    }

    @Override
    public void run(String... args) {
        if (SCOPE == null) throw new IllegalArgumentException("${ENVIRONMENT} must be seted");
        logger.info("ENVIRONMENT: " + SCOPE);
        if (SCOPE.equals("dev") || SCOPE.equals("test")) {
            cleanDB();
            insertTestData();
        }
    }
    public static void cleanDB(){
        patientRepository.deleteAll();
        turnRepository.deleteAll();
        professionalRepository.deleteAll();
    }
    public static void insertTestData(){
        PatientModel pa1 = PatientModel.builder().dni("1").name("Ana").last_name("Quevedo").build();
        patientRepository.save(pa1);

        PatientModel pa2 = PatientModel.builder().dni("2").name("Juan").last_name("Rojas").build();
        patientRepository.save(pa2);

        PatientModel pa3 = PatientModel.builder().dni("3").name("Juana").last_name("Martinez").build();
        patientRepository.save(pa3);


        //Create professional
        ProfessionalModel pr1 = ProfessionalModel.builder().dni("100000").name("Diana").last_name("Tazares").service(ProfessionalServices.GENERAL).build();
        professionalRepository.save(pr1);

        //Create turns
        TurnModel tr1 = TurnModel.builder().f_entry(LocalDateTime.now()).f_out(LocalDateTime.now().plusMinutes(30)).patientModel(pa1).professionalModel(pr1).status(TurnStatus.PENDING).build();
        turnRepository.save(tr1);

        TurnModel tr2 = TurnModel.builder().f_entry(LocalDateTime.now().plusMinutes(30)).f_out(LocalDateTime.now().plusMinutes(60)).patientModel(pa2).professionalModel(pr1).status(TurnStatus.PENDING).build();
        turnRepository.save(tr2);
    }
}