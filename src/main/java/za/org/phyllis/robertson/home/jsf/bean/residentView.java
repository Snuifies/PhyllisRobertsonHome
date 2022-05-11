/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.org.phyllis.robertson.home.jsf.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.org.phyllis.robertson.home.model.ResidentDO;
import za.org.phyllis.robertson.home.model.RoomDO;
import za.org.phyllis.robertson.home.service.ResidentService;
import za.org.phyllis.robertson.home.service.RoomService;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;


@Component(value = "residentView")
@RequestScoped
public class residentView implements Serializable {

    @Autowired
    ResidentService service;

    private List<ResidentDO> residents;

    @PostConstruct
    public void init() {
        residents = service.findAllResidents();
    }

    public List<ResidentDO> getResidents() {
        return residents;
    }
}
