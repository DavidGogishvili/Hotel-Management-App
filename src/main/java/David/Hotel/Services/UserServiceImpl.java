package David.Hotel.Services;

import David.Hotel.Entities.Users;
import David.Hotel.Models.UserCreateModel;
import David.Hotel.Repositories.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private  final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public Users createUser(UserCreateModel userCreateModel) {
        var user = new Users ();
        user.setEmail(userCreateModel.email());
        user.setPassword(userCreateModel.password());
        userRepo.save(user);
        return user;
    }
}
