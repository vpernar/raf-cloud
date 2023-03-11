package rs.raf.domaci3.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import rs.raf.domaci3.model.Permission;
import rs.raf.domaci3.model.Permissions;
import rs.raf.domaci3.model.User;
import rs.raf.domaci3.repositories.PermissionRepository;
import rs.raf.domaci3.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class BootstrapData implements CommandLineRunner {

    private final PermissionRepository permissionRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public BootstrapData(PermissionRepository permissionRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.permissionRepository = permissionRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Loading Data...");

        Permissions[] PERMISSION_LIST = {Permissions.can_create_users, Permissions.can_read_users,
                Permissions.can_update_users, Permissions.can_delete_users,
                Permissions.can_create_nodes, Permissions.can_destroy_nodes,
                Permissions.can_restart_nodes, Permissions.can_search_nodes,
                Permissions.can_start_nodes, Permissions.can_stop_nodes};

        List<Permission> permissions = new ArrayList<>();
        for (int i = 0; i < PERMISSION_LIST.length; i++) {

            Permission permission = new Permission(PERMISSION_LIST[i]);
            permissions.add(permission);

            permissionRepository.save(permission);
        }

        User user1 = new User();
        user1.setEmail("vpernar@raf.rs");
        user1.setName("Veljko");
        user1.setSurname("Pernar");
        user1.setPassword(this.passwordEncoder.encode("pernar"));
        for (Permission p : permissions) {
            user1.addPermission(p);
        }
        userRepository.save(user1);

        User user2 = new User();
        user2.setEmail("user@gmail.com");
        user2.setName("User");
        user2.setSurname("Gmail");
        user2.setPassword(this.passwordEncoder.encode("pass"));
        userRepository.save(user2);


        System.out.println("Data loaded!");
    }
}
