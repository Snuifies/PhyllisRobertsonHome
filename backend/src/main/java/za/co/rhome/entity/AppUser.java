/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.rhome.entity;

import lombok.Data;

import javax.persistence.*;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "APP_USER", //
	uniqueConstraints = { //

		@UniqueConstraint(name = "APP_USER_USER_NAME", columnNames = "USER_NAME")})
/**
 *
 * @author snuif
 */
public class AppUser {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID", nullable = false)
	private Long userId;

	@Column(name = "USER_NAME", length = 64, nullable = false)
	private String userName;

	@Column(name = "PASSWORD", length = 128, nullable = false)
	private String password;

	@Column(name = "ENABLED", length = 1, nullable = false)
	private boolean enabled;

}
