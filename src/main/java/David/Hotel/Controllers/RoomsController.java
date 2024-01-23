package David.Hotel.Controllers;


import David.Hotel.Entities.Rooms;
import David.Hotel.Models.RoomCreateModel;
import David.Hotel.Services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rooms")
public class RoomsController {


private final RoomService roomService;

@PostMapping("/create")
    public Rooms createRoom(@RequestBody RoomCreateModel roomCreateModel) {
    return roomService.createRoom(roomCreateModel);
    }
     }
