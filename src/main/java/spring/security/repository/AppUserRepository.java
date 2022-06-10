/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.security.entity.AppUser;

import java.util.Optional;

/**
 * @author snuif
 */
@Repository
@Transactional
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    @Query("SELECT AU FROM AppUser AU WHERE AU.userName = :userName")
    Optional<AppUser> findByUsername(@Param("userName") String userName);

}
