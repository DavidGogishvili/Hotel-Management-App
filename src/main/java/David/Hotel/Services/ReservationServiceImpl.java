package David.Hotel.Services;

import David.Hotel.Entities.Reservations;
import David.Hotel.Models.ReservationCreateModel;
import David.Hotel.Repositories.ReservationsRepo;
import David.Hotel.Repositories.RoomsRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationsRepo reservationsRepo;



    public ReservationServiceImpl(ReservationsRepo reservationsRepo) {
        this.reservationsRepo = reservationsRepo;
    }



    @Override
    public Reservations createBooking(ReservationCreateModel reservationCreateModel) {
        String roomNumber = reservationCreateModel.roomNumber().toString();
        LocalDateTime startDateTime = reservationCreateModel.startDateTime();
        LocalDateTime endDateTime = reservationCreateModel.endDateTime();
        if (roomExists(roomNumber)) {
            throw new RuntimeException("ოთახი ნომრით N " + roomNumber + " ჯერ არ გვაქვს სასტუმროში, ბოდიში :)");
        }
        if (!roomIsBooked(roomNumber, startDateTime, endDateTime)) {
            throw new RuntimeException("ოთახი აღნიშნულ ვადებში უკვე დაჯავშნილია.");
        }
        Reservations reservations = new Reservations();
        reservations.setBookNumber(reservationCreateModel.bookNumber());
        reservations.setRoomNumber(String.valueOf(reservationCreateModel.roomNumber()));
        reservations.setBookedAt(reservationCreateModel.startDateTime());
        reservations.setBookedTill(reservationCreateModel.endDateTime());
        reservations.setBookedBy(reservationCreateModel.bookedBy());
        reservations.setBookedFrom(reservationCreateModel.bookedFrom());
        reservations.setPrice(reservationCreateModel.price());
        reservations.setPromotion(reservationCreateModel.promotion());
        reservations.setPromotionalPrice(reservationCreateModel.promotionalPrice());
        reservationsRepo.save(reservations);
        return reservations;
    }

    private boolean roomIsBooked(String roomNumber, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        List<Reservations> bookings = reservationsRepo.findBookingsInDateRange(roomNumber, startDateTime, endDateTime);
        return !bookings.isEmpty();
    }

    private boolean roomExists(String roomNumber) {
        return !reservationsRepo.existsByRoomNumber(roomNumber);
    }

    
        @Override
    public String isRoomBookedInDateRange(String roomNumber, LocalDateTime startDateTime, LocalDateTime endDateTime) {
         if (roomExists(roomNumber)) {
             throw new RuntimeException("ოთახი ნომრით N " + roomNumber + " ჯერ არ გვაქვს სასტუმროში, ბოდიში :)");
         }
        List<Reservations> bookings = reservationsRepo.findBookingsInDateRange(roomNumber, startDateTime, endDateTime);
         if (bookings.isEmpty()) {
             return "ოთახი აღნიშნულ ვადებში თავისუფალია.";
         } else {
             return "ოთახი აღნიშნულ ვადებში არ არის თავისუფალი.";
         }
              }



}

