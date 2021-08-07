package com.mercadolibre.consulting.dataGenerators.turn;

import com.mercadolibre.consulting.dataGenerators.professional.ProfessionalGenerator;
import com.mercadolibre.consulting.enums.TurnStatus;
import com.mercadolibre.consulting.model.PatientModel;
import com.mercadolibre.consulting.model.ProfessionalModel;
import com.mercadolibre.consulting.model.TurnModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TurnsGenerator {
    public static List<TurnModel> generateListOldTurnsOfProfessional(ProfessionalModel professionalModel){
        List<TurnModel> oldTurns = new ArrayList<>();
        oldTurns.add(TurnModel.builder()
                .patientModel(new PatientModel())
                .professionalModel(professionalModel)
                .f_entry(LocalDateTime.now())
                .f_out(LocalDateTime.now().plusMinutes(30))
                .status(TurnStatus.PENDING)
                .build());

        return oldTurns;
    }
}
