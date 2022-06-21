/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  za.co.phyllis.robertson.home.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import  za.co.phyllis.robertson.home.entity.AppUser;

/**
 * @author snuif
 */
@Repository
@Transactional
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	@Query("SELECT AU FROM AppUser AU WHERE AU.username = :username")
	Optional<AppUser> findByUsername(@Param("username") String username);

}
