/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.org.phyllis.robertson.home.jsf.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.org.phyllis.robertson.home.model.ResidentDO;
import za.org.phyllis.robertson.home.model.UserDO;
import za.org.phyllis.robertson.home.service.ResidentService;
import za.org.phyllis.robertson.home.service.UserService;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;


@Component(value = "userView")
@RequestScoped
public class userView implements Serializable {

    @Autowired
    UserService service;

    private List<UserDO> users;

    @PostConstruct
    public void init() {
        users = service.findAll();
    }

    public List<UserDO> getUsers() {
        return users;
    }
}
