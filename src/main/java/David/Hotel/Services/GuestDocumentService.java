package David.Hotel.Services;
import David.Hotel.Entities.GuestDocuments;
import David.Hotel.Entities.Guests;
import David.Hotel.Models.GuestAndDocumentCreateModel;

import java.util.List;

public interface GuestDocumentService {

    Guests createGuestAndDocument(GuestAndDocumentCreateModel requestModel);


    List <GuestDocuments> getGuestWithDocument (Integer id);

    List <GuestDocuments> findAllGuestWithDocuments();

}
