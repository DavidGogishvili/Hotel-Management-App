package David.Hotel.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.Period;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(schema = "public", name = "guests")
public class Guests extends BaseEntity{

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guests_id_seq-generator")
    @SequenceGenerator(name = "guests_id_seq-generator", sequenceName = "guests_id_seq", allocationSize = 1)
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "birthdate")
    private LocalDate birthDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "citizenship")
    private String citizenship;

    @Column (name = "age")
    private Integer age;

    @OneToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private GuestDocuments guestDocuments;
}
