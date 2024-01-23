package David.Hotel.Repositories;

import David.Hotel.Entities.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRolesRepo extends JpaRepository<UserRoles, Integer> {

    List<UserRoles> findAllByUserId(Integer id);

}
