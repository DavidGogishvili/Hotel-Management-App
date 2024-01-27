package David.Hotel.Entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Rooms extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rooms_id_seq-generator")
    @SequenceGenerator(name = "rooms_id_seq-generator", sequenceName = "rooms_id_seq", allocationSize = 1)
    @Id
    private Integer id;

    @Column(name = "room_number")
    private String roomNumber;

    @Column (name = "beds")
    private Integer numberOfBed;

    @Column (name = "category")
    private String standardRoom;

    @Column (name = "isavalable")
    private Boolean available;

    @Column (name = "floor")
    private Integer floor;





}
