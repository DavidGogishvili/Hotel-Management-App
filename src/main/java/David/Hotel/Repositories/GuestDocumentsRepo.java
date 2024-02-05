package David.Hotel.Repositories;

import David.Hotel.Entities.GuestDocuments;
import David.Hotel.Entities.Guests;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestDocumentsRepo extends JpaRepository<GuestDocuments, Integer> {

    List<GuestDocuments> findAllById(Integer id);

}
