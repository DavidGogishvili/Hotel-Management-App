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
        if (roomsRepo.existsByRoomNumber(roomCreateModel.roomNumber())) {
            throw new RuntimeException("ბრაატ, ეგ ნომერი არსებობს უკვე :)");
        }
        Rooms rooms = new Rooms();
        rooms.setRoomNumber(roomCreateModel.roomNumber());
        rooms.setCategory(roomCreateModel.category());
        rooms.setFloor(roomCreateModel.floor());
        roomsRepo.save(rooms);
        return rooms;

    }


}
