package David.Hotel.Security;

import David.Hotel.Entities.Roles;
import David.Hotel.Entities.UserRoles;
import David.Hotel.Entities.Users;
import David.Hotel.Repositories.UserRepo;
import David.Hotel.Repositories.UserRolesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class UserManager implements UserDetailsService {
    private final UserRepo userRepo;
    private final UserRolesRepo userRolesRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> users = userRepo.findAllByEmail(username);
        if (users.isEmpty()) {
            throw new RuntimeException("user %s not found".formatted(username));
        }


        var user = users.get();
        var uroles = userRolesRepo.findAllByUserId(user.getId());
        List<Roles> roles = new ArrayList<>();
        for (UserRoles r : uroles) {
            roles.add(r.getRole());
        }
        user.setRolesList(roles);
        System.out.println("User " + username + " has logged in");
        return user;
    }

        public static Users getCurrentUser () {
            var auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth==null || auth.getPrincipal() == null) {
                throw new RuntimeException("auth needed");
            }
            if (auth.getPrincipal() instanceof Users user) {
                return user;
            }
            throw new RuntimeException("Anonymous");
        }


    }
