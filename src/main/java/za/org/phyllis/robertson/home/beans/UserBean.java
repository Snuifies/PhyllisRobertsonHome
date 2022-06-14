/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.org.phyllis.robertson.home.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import za.org.phyllis.robertson.home.service.AppUserService;

/**
 *
 * @author snuif
 */

@Component("userBean")
@ViewScoped
public class UserBean implements Serializable {

    List<UserDetails> userDetails;

    private UserDetails selectedUser;

    AppUserService appUserService;

    @Autowired
    public UserBean(AppUserService appUserService) {
        this.appUserService = appUserService;
    }
    

//    @PostConstruct
//    public void init() {
//        userDetails = new DataModel<UserDetails>() {
//            @Override
//            public int count(Map<String, FilterMeta> filterBy) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//            }
//
//            @Override
//            public List<UserDetails> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
//                List<UserDetails> result = new ArrayList();
//                try {
//                    System.out.println("######### Invoke pagination consultarSismos. . .");
//                    result = appUserService.findAll();
//                } catch (Exception e) {
//                }
//                return result;
//            }
//        };
//    }
//    public boolean deleteUser(String username) {
//        return true;
//    }
//
//    public boolean addUser() {
//        return true;
//    }
//
//    public boolean updateUser() {
//        return true;
//    }
//
    public UserDetails getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(UserDetails selectedUser) {
        this.selectedUser = selectedUser;
    }

    public List<UserDetails> getUserDetails() {
        if (userDetails == null) {
            userDetails = appUserService.findAll();
        }
        return userDetails;
    }

    public void setUserDetails(List<UserDetails> userDetails) {
        this.userDetails = userDetails;
    }

}
