package David.Hotel.Services;

import David.Hotel.Entities.Reservations;
import David.Hotel.Models.ReservationCreateModel;
import David.Hotel.Repositories.ReservationsRepo;
import David.Hotel.Repositories.RoomsRepo;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationsRepo reservationsRepo;
    private final RoomsRepo roomsRepo;



    public ReservationServiceImpl(ReservationsRepo reservationsRepo, RoomsRepo roomsRepo) {
        this.reservationsRepo = reservationsRepo;
        this.roomsRepo = roomsRepo;
    }



    @Override
    public Reservations createBooking(ReservationCreateModel reservationCreateModel) {
        Integer roomNumber = reservationCreateModel.roomNumber();
        LocalDateTime startDateTime = reservationCreateModel.startDateTime();
        LocalDateTime endDateTime = reservationCreateModel.endDateTime();

        List<Reservations> exitingReservations = reservationsRepo.findBookingsInDateRange(roomNumber.toString(), startDateTime, endDateTime);
        if (!exitingReservations.isEmpty()) {
            throw new RuntimeException("ოთახი აღნიშნულ ვადებში უკვე დაჯავშნილია.");
        } else {
        Reservations reservations = new Reservations();
        reservations.setBookNumber(reservationCreateModel.bookNumber());
        reservations.setRoomNumber(String.valueOf(reservationCreateModel.roomNumber()));
        reservations.setBookedAt(reservationCreateModel.startDateTime());
        reservations.setBookedTill(reservationCreateModel.endDateTime());
        reservations.setBookedBy(reservationCreateModel.bookedBy());
        reservations.setBookedFrom(reservationCreateModel.bookedFrom());
        reservations.setPrice(Double.valueOf(reservationCreateModel.price()));
        reservations.setPromotion(Double.valueOf(reservationCreateModel.promotion()));
        reservationsRepo.save(reservations);
        return reservations;
    }}

    @Override
    public String isRoomBookedInDateRange(String roomNumber, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        List<Reservations> existingReservations = reservationsRepo.findBookingsInDateRange(
                roomNumber, startDateTime, endDateTime);

        if (!existingReservations.isEmpty()) {
            return "ოთახი აღნიშნულ ვადებში დაჯავშნილია.";
        } else {
            return "ოთახი აღნიშნულ ვადებში თავისუფალია.";
        }
    }


}

