package David.Hotel.Services;

import David.Hotel.Entities.Rooms;
import David.Hotel.Models.RoomCreateModel;
import David.Hotel.Repositories.RoomsRepo;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomsRepo roomsRepo;

    public RoomServiceImpl(RoomsRepo roomsRepo) {
        this.roomsRepo = roomsRepo;
    }

    @Override
    public Rooms createRoom(RoomCreateModel roomCreateModel) {
        Rooms rooms = new Rooms();
        rooms.setRoomNumber(roomCreateModel.roomNumber());
        rooms.setNumberOfBed(Integer.valueOf(roomCreateModel.beds()));
        rooms.setStandardRoom(Boolean.valueOf(roomCreateModel.standardRoom()));
        rooms.setAvailable(Boolean.valueOf(roomCreateModel.available()));
        rooms.setPriceForNight(roomCreateModel.priceForNight());
        rooms.setFloor(roomCreateModel.floor());
        roomsRepo.save(rooms);
        return rooms;


    }
}
