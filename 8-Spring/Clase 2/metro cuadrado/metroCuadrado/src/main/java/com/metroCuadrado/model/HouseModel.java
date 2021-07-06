package com.metroCuadrado.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter
public class HouseModel {
    @NotNull(message = "Name is necessary")
    private String name;
    @NotNull(message = "Address is necesary")
    private String address;
    @NotNull(message = "House must be have a room")
    private List<RoomModel> roomModelList;

    public void addRoom(RoomModel roomModel){
        roomModelList.add(roomModel);
    }
}
