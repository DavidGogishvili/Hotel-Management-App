package David.Hotel.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(schema = "public", name = "reservations")
public class Reservations extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "books_id_seq-generator")
    @SequenceGenerator(name = "books_id_seq-generator", sequenceName = "books_id_seq", allocationSize = 1)
    @Id
    private Integer id;


    @Column(name = "book_number")
    private Integer bookNumber;

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "booked_at")
    private LocalDateTime bookedAt;

    @Column(name = "booked_till")
    private LocalDateTime bookedTill;

    @Column (name = "booked_by")
    private Integer bookedBy;

    @Column(name = "booked_from")
    private String bookedFrom;

    @Column(name = "price")
    private Double price;

    @Column(name = "promotion")
    private Double promotion;

    @Column(name = "promotional_price")
    private Double promotionalPrice;

    @Column(name = "book_interval")
    private String booked;

    @Column (name = "tax")
    private Double tax;




}
