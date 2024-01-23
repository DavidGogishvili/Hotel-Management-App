package David.Hotel.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(schema = "public", name = "bookings")
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

    @Column(name = "booked_by")
    private Integer bookedBy;

    @Column(name = "booked_from")
    private String bookedFrom;

    @Column(name = "price")
    private String price;

    @Column(name = "promotion")
    private String promotion;

    @Column(name = "promotional_price")
    private String promotionalPrice;

    @Column(name = "book_interval")
    private String booked;

    public void preInsert() {
        booked = calculateBookedInterval();
    }

    private String calculateBookedInterval() {
        LocalDateTime bookedAt = this.getBookedAt();
        LocalDateTime bookedTill = this.getBookedTill();

        if (bookedAt != null && bookedTill != null) {
            long days = ChronoUnit.DAYS.between(bookedAt, bookedTill);
            return String.valueOf(days);
        } else {
            throw new IllegalStateException("ვერ ვითვლი დაჯავშნილ დღეებს, სორი :)");
        }
    }
}
