package za.org.phyllis.robertson.home.service.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.org.phyllis.robertson.home.api.model.RoleDO;
import za.org.phyllis.robertson.home.entity.security.Role;
import za.org.phyllis.robertson.home.exception.ResourceAlreadyExistsException;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.repository.security.RoleRepository;

@Service
public class RoleService {

    RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
	this.roleRepository = roleRepository;
    }

    @Transactional
    public void deleteAllRoles() {
	roleRepository.deleteAll();
    }

    @Transactional
    public void deleteRole(long id) {
	roleRepository.deleteById(id);
    }

    @Transactional
    public void deleteRole(String role) {
	roleRepository.deleteByRole(role);
    }

    @Transactional
    public RoleDO createRole(String role) {
	if (roleRepository.findByRole(role).isPresent()) {
	    throw new ResourceAlreadyExistsException(role);
	};
	Role entity = new Role(role);
	entity = roleRepository.save(entity);
	return new RoleDO(entity);
    }

    @Transactional
    public RoleDO getRoleById(Long id) {
	return roleRepository.findById(id)
		.map(RoleDO::new)
		.orElseThrow(() -> new ResourceNotFoundException(id.toString()));
    }

    @Transactional
    public List<RoleDO> getAllRoles() {
	List<RoleDO> roleDos = new ArrayList<>();
	roleRepository.findAll().forEach((role) -> {
	    roleDos.add(new RoleDO(role));
	});
	return roleDos;
    }

    @Transactional
    public RoleDO getRoleByName(String role) {
	return roleRepository.findByRole(role).map(RoleDO::new)
		.orElseThrow(() -> new ResourceNotFoundException(role));
    }
}
