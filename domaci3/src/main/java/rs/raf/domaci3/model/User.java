package rs.raf.domaci3.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USERS_PERMISSIONS",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "ID")
    )
    private List<Permission> permissions = new ArrayList<>();


    public void addPermission(Permission permission) {
        permissions.add(permission);
        permission.getUsers().add(this);
    }

    public User(UserResponse u){
        this.id = u.getId();
        this.email = u.getEmail();
        this.name = u.getName();
        this.surname = u.getSurname();
        this.password = u.getPassword();
        this.permissions = new ArrayList<>();
        for(String p: u.getPermissions()){
            for(Permissions perm: Permissions.values()){
                if(p.equals(perm.toString()))
                    this.permissions.add(new Permission(perm));
            }
        }
    }

    public User(){}
}
