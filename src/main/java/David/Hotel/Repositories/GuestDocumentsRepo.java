package David.Hotel.Repositories;

import David.Hotel.Entities.GuestDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GuestDocumentsRepo extends JpaRepository<GuestDocuments, Integer>, JpaSpecificationExecutor<GuestDocuments> {
}
