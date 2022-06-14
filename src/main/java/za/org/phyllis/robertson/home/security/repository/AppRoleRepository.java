/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.org.phyllis.robertson.home.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import za.org.phyllis.robertson.home.security.entity.AppRole;

import java.util.List;

@Repository
@Transactional
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {

    @Query(value = "SELECT AR.ROLE_NAME FROM APP_ROLE AR JOIN USER_ROLE UR ON UR.ROLE_ID = AR.ROLE_ID WHERE UR.USER_ID = :userId", nativeQuery = true)
    List<String> findByUserId(@Param("userId") Long userId);

}
