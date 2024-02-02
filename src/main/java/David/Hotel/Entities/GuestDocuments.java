package David.Hotel.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(schema = "public", name = "guests_documents")
public class GuestDocuments extends BaseEntity{


    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guests_documents_id_seq-generator")
    @SequenceGenerator(name = "guests_documents_id_seq-generator", sequenceName = "guests_documents_id_seq", allocationSize = 1)
    @Id
    private Integer id;


    @Column (name = "passport_number")
    private String passportNumber;

    @Column (name = "passport_expiration_date")
    private LocalDate passportExpDate;

    @Column (name = "private_number")
    private String privateNumber;

    @Column (name = "identification_card_expiration_date")
    private LocalDate idExpDate;

    @Column (name = "certificate_of_residence_number")
    private String residenceNumber;

    @Column (name = "certificate_of_residence_expiration_date")
    private LocalDate residenceExpDate;

    @Column (name = "temporary_certificate_of_displaced_person_number")
    private String temporaryDisplacedNumber;

    @Column (name = "temporary_certificate_of_displaced_person_expiration_date")
    private LocalDate temporaryDisplacedExpDate;

    @Column (name = "driving_licence_number")
    private String drivingLicenceNumber;

    @Column (name = "driving_licence_expiration_date")
    private LocalDate drivingLicenceExpDate;

    @Column (name = "guest_id")
    private Integer guestId;

    @Column (name = "permanent_document")
    private String permanent;

    @OneToOne
    @JoinColumn(name = "guest_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Guests guests;


}
