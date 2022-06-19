/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.rhome.entity;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.*;
import lombok.ToString;

/**
 *
 * @author snuif
 */
@Data
@ToString
@Entity
@Table(name = "APP_ROLE",
	uniqueConstraints = {
		@UniqueConstraint(name = "APP_ROLE_ROLE_NAME", columnNames = "ROLE_NAME")})
public class AppRole implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "ROLE_ID", nullable = false)
	private Long roleId;

	@Column(name = "ROLE_NAME", length = 30, nullable = false)
	private String roleName;

}
