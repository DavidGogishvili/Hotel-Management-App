package David.Hotel.Entities;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;


@Entity
@Data
@Table(schema = "public", name = "roles")

public class Roles implements GrantedAuthority {

    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="roles_seq-generator")
    @SequenceGenerator(name="roles_seq-generator", sequenceName="roles_id_seq", allocationSize = 1)
    @Id
    private Integer id;

    @Column (name = "name")
    private String name;

    @Column(name = "description")
    private String description;


    @Override
    public String getAuthority() {
        return name;
    }
}
