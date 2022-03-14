package za.org.phyllis.robertson.home.service.security;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.org.phyllis.robertson.home.api.model.RoleDO;
import static org.junit.jupiter.api.Assertions.*;
import za.org.phyllis.robertson.home.api.model.UserRole;

/**
 *
 * @author snuif
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {

    @Autowired
    RoleService roleService;

    @Test
    public void testGetAllRoles() {
	List<RoleDO> roles = roleService.getAllRoles();
	assertEquals(3, roles.size());
    }

    @Test
    public void deleteRoleById() {
	RoleDO roleDO = roleService.createRole("TEST_1");
	assertNotNull(roleDO.getId());
	roleService.deleteRole(roleDO.getId());

//	roleDO = roleService.getRoleById(roleDO.getId());
//	assertNull(roleDO);
    }

    @Test
    public void deleteRoleByRole() {
	RoleDO roleDO = roleService.createRole("TEST_2");
	assertNotNull(roleDO.getId());
	roleService.deleteRole(roleDO.getRole());
//	roleDO = roleService.getRoleByName(roleDO.getRole());
//	assertNull(roleDO);

    }

    @Test
    public void createRole() {
	RoleDO roleDO = roleService.createRole("TEST_0");
	assertNotNull(roleDO.getId());
	roleService.deleteRole(roleDO.getId());
    }

    @Test
    public void getRoleById() {
	RoleDO roleDO = roleService.getRoleById(1L);
	assertEquals(UserRole.ADMINISTRATOR.name(), roleDO.getRole());
    }

    @Test
    public void getRoleByName() {
	RoleDO roleDO = roleService.getRoleByName(UserRole.ADMINISTRATOR.name());
	assertEquals(UserRole.ADMINISTRATOR.name(), roleDO.getRole());
    }
}
