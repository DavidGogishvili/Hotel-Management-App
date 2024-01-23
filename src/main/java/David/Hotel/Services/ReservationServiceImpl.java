package David.Hotel.Services;

import David.Hotel.Entities.Reservations;
import David.Hotel.Models.ReservationCreateModel;
import David.Hotel.Repositories.ReservationsRepo;
import David.Hotel.Repositories.RoomsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationsRepo reservationsRepo;


    public ReservationServiceImpl(ReservationsRepo reservationsRepo, RoomsRepo roomsRepo) {
        this.reservationsRepo = reservationsRepo;
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
    public List <Reservations> findBookings() {
        return reservationsRepo.findAll();
    }


    @Override
    public Reservations getBooking(Integer roomNumber) {
        return reservationsRepo.findAllByRoomNumber(String.valueOf(roomNumber)).orElseThrow();
    }
}
