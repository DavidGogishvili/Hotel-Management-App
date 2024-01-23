package David.Hotel.Services;

import David.Hotel.Entities.Rooms;
import David.Hotel.Models.RoomCreateModel;

public interface RoomService {

    Rooms createRoom (RoomCreateModel roomCreateModel);
}
