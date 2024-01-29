package David.Hotel.Controllers;


import David.Hotel.Entities.Rooms;
import David.Hotel.Models.RoomCreateModel;
import David.Hotel.Repositories.RoomsRepo;
import David.Hotel.Services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rooms")
public class RoomsController {


private final RoomService roomService;
private final RoomsRepo roomsRepo;

@PostMapping("/create")
    public Rooms createRoom(@RequestBody RoomCreateModel roomCreateModel) {
    return roomService.createRoom(roomCreateModel);
    }


    @GetMapping("/find")
    public List <Rooms> getRooms () {
    return roomsRepo.findAll();
    }




     }
