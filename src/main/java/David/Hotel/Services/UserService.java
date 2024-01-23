package David.Hotel.Services;

import David.Hotel.Entities.Users;
import David.Hotel.Models.UserCreateModel;

public interface UserService {

    Users createUser(UserCreateModel userCreateModel);

}
