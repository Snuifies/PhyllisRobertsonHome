/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  za.co.phyllis.robertson.home.model;

import java.util.Date;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author snuif
 */
@Data
@ToString
@Builder
public class AppUserModel {

	private String username;

	private boolean enabled;

	private boolean locked;

	private boolean expired;

	private Date lastUsed;

	private List<String> roles;

}
