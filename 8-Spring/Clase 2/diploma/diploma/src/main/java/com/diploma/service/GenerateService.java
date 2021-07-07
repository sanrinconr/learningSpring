package com.diploma.service;

import com.diploma.dto.request.AssignRequestDTO;
import com.diploma.dto.request.StudentAssignsDTO;
import com.diploma.dto.response.CertificateResponseDTO;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class GenerateService {
    public CertificateResponseDTO generateCertificate(StudentAssignsDTO studentAssignsDTO) {

        //Construction of aveage
        Double average = this.getAverage(studentAssignsDTO.getAssignRequestDTOList());
        //Construction of message
        String message = average > 9 ? "Felicitaciones! tuviste un excelente promedio" : "Diploma entregado en el año 2021";

        //Define response
        CertificateResponseDTO certificateResponseDTO = new CertificateResponseDTO();
        certificateResponseDTO.setName(studentAssignsDTO.getName());
        certificateResponseDTO.setAverage(average);
        certificateResponseDTO.setMessage(message);
        return certificateResponseDTO;
    }
    public Double getAverage(List<AssignRequestDTO> assignRequestDTOList){
        Double average = assignRequestDTOList
                .stream()
                .mapToDouble(assign->assign.getQualification())
                .reduce(0.0,(x,y)->x+y);
        average = average/assignRequestDTOList.size();
        return average;
    }
}
