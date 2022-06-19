/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.rhome.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author snuif
 */
@Data
@ToString
@Entity
@Table(name = "PERSISTENT_LOGINS")
public class PersistentLogin implements Serializable {

	@Id
	@Column(name = "USERNAME", nullable = false)
	private String username;
	@Column(name = "SERIES", nullable = false)
	private String series;
	@Column(name = "TOKEN", nullable = false)
	private String token;
	@Column(name = "LAST_USED", nullable = false)
	private Timestamp lastUsed;

}
