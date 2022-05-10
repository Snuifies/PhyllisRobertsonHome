/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.org.phyllis.robertson.home.jsf.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.org.phyllis.robertson.home.model.RoomDO;
import za.org.phyllis.robertson.home.service.RoomService;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;

/**
 * @author JavaRevolutions
 */
@Component(value = "roomView")
@RequestScoped
public class RoomView implements Serializable {

    @Autowired
    RoomService service;

    private List<RoomDO> rooms;

    @PostConstruct
    public void init() {
        rooms = service.findAllRooms();
    }

    public List<RoomDO> getRooms() {
        return rooms;
    }
}
