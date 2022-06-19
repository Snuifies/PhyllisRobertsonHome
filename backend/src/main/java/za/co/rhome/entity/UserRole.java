/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.rhome.entity;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.*;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "USER_ROLE",
	uniqueConstraints = {
		@UniqueConstraint(name = "USER_ROLE_UK", columnNames = {"USER_ID", "ROLE_ID"})})
public class UserRole implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "USER_ROLE_ID", nullable = false)
	private Long userRoleId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	private AppUser userId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID", nullable = false)
	private AppRole roleId;
}
