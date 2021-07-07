package com.edad.service;

import com.edad.dto.request.DateRequestDTO;
import com.edad.dto.response.DateResponseDTO;
import com.edad.model.DateModel;
import com.edad.util.ParserTime;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class DateService {
    DozerBeanMapper mapper = new DozerBeanMapper();

    public DateResponseDTO getAgeOfDate(DateRequestDTO dateRequestDTO){
        DateModel dateModel = mapper.map(dateRequestDTO, DateModel.class);
        
        int y = dateModel.getYear();
        int m = dateModel.getMonth();
        int d = dateModel.getDay();

        Calendar birth = new GregorianCalendar(y,m-1,d);
        Calendar actual = new GregorianCalendar();

        long diff = actual.getTimeInMillis() - birth.getTimeInMillis();

        DateResponseDTO dateResponseDTO = new DateResponseDTO();
        dateResponseDTO.setAge(ParserTime.milliSecondsToYears(diff));
        return dateResponseDTO;
    }
}
