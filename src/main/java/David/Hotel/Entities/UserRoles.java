package David.Hotel.Entities;
import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
@Table(schema = "public", name = "user_roles")
public class UserRoles {

    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="user_roles_seq-generator")
    @SequenceGenerator(name="user_roles_seq-generator", sequenceName="user_roles_id_seq", allocationSize = 1)
    @Id
    private Integer id;

    @Column (name = "user_id")
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles role;
}
