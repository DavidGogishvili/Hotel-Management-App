package David.Hotel.Controllers;

import David.Hotel.Entities.Users;
import David.Hotel.Models.UserCreateModel;
import David.Hotel.Repositories.UserRepo;
import David.Hotel.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final UserRepo userRepo;

    @PostMapping("/create")
    public Users createUser(@RequestBody UserCreateModel userCreateModel) {
        return userService.createUser(userCreateModel);
    }


    @GetMapping("/find")
    public List <Users> getAllUsers() {
        return userRepo.findAll();

    }

}
