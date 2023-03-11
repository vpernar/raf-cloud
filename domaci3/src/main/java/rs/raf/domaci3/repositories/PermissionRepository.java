package rs.raf.domaci3.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rs.raf.domaci3.model.Permission;

@Repository
public interface PermissionRepository extends CrudRepository<Permission, String> {
}
