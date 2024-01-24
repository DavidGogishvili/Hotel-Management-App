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
        Reservations reservations = new Reservations();
        reservations.setBookNumber(reservationCreateModel.bookNumber());
        reservations.setRoomNumber(String.valueOf(reservationCreateModel.roomNumber()));
        reservations.setBookedAt(reservationCreateModel.bookedAt());
        reservations.setBookedTill(reservationCreateModel.bookedTill());
        reservations.setBookedBy(reservationCreateModel.bookedBy());
        reservations.setBookedFrom(reservationCreateModel.bookedFrom());
        reservations.setPrice(reservationCreateModel.price());
        reservations.setPromotion(reservationCreateModel.promotion());
        reservations.setPromotionalPrice(reservationCreateModel.promotionalPrice());
        reservationsRepo.save(reservations);
        return reservations;
    }


     @Override
    public String isRoomBookedInDateRange(String roomNumber, LocalDateTime startDateTime, LocalDateTime endDateTime) {
         if (!roomExists(roomNumber)) {
             throw new RuntimeException("ოთახი ნომრით N " + roomNumber + " ჯერ არ გვაქვს სასტუმროში, ბოდიში :)");
         }
        List<Reservations> bookings = reservationsRepo.findBookingsInDateRange(roomNumber, startDateTime, endDateTime);
         if (!bookings.isEmpty()) {
             return "ოთახი აღნიშნულ ვადებში თავისუფალია.";
         } else {
             return "ოთახი აღნიშნულ ვადებში არ არის თავისუფალი.";
         }
              }


    private boolean roomExists(String roomNumber) {
             return roomsRepo.existsByRoomNumber(roomNumber);
    }


}

