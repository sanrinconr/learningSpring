package com.metroCuadrado.service;

import com.metroCuadrado.dto.response.HouseSquareMetersDTO;
import com.metroCuadrado.dto.response.HouseValueDTO;
import com.metroCuadrado.dto.response.RoomMetersDTO;
import com.metroCuadrado.model.HouseModel;
import com.metroCuadrado.model.RoomModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseService {
    final double PRICE_METER = 800;

    public HouseValueDTO getHouseValue(HouseModel houseModel){
        double price;
        List<RoomModel> rooms = houseModel.getRoomModelList();
        price = rooms.stream().mapToDouble(room -> room.getWidth() * room.getLarge() * 800).sum();

        HouseValueDTO houseValueDTO = new HouseValueDTO();
        houseValueDTO.setValue(price);

        return houseValueDTO;
    }

    public HouseSquareMetersDTO getHouseTotalSquareMeters(HouseModel houseModel){
        double total;
        List<RoomModel> rooms = houseModel.getRoomModelList();
        total = rooms.stream().mapToDouble(room -> room.getWidth() * room.getLarge()).sum();

        HouseSquareMetersDTO houseSquareMetersDTO = new HouseSquareMetersDTO();
        houseSquareMetersDTO.setSquareMeters(total);

        return houseSquareMetersDTO;
    }

    public RoomModel getBiggerRoom(HouseModel houseModel) {
        RoomModel actualRoom = houseModel.getRoomModelList().get(0);
        for(RoomModel room:houseModel.getRoomModelList()){
            double metersActual = actualRoom.getLarge() * actualRoom.getWidth();
            double metersNew = room.getLarge() * room.getWidth();
            if(metersNew > metersActual){
                actualRoom = room;
            }
        }
        return actualRoom;
    }

    public List<RoomMetersDTO> getMetersPerRoom(HouseModel houseModel) {
        List<RoomMetersDTO> out = new ArrayList<>();
        for (RoomModel room:houseModel.getRoomModelList()){
            RoomMetersDTO roomMetersDTO = new RoomMetersDTO();
            roomMetersDTO.setName(room.getName());
            roomMetersDTO.setMeters(room.getLarge() * room.getWidth());
            out.add(roomMetersDTO);
        }
        return out;
    }
}
