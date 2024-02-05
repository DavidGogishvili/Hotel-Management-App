package David.Hotel.Services;

import David.Hotel.Entities.GuestDocuments;
import David.Hotel.Entities.Guests;
import David.Hotel.Models.GuestAndDocumentCreateModel;
import David.Hotel.Repositories.GuestDocumentsRepo;
import David.Hotel.Repositories.GuestsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class GuestDocumentServiceImpl implements GuestDocumentService {

    private final GuestsRepo guestsRepo;
    private final GuestDocumentsRepo guestDocumentsRepo;

    @Autowired
    public GuestDocumentServiceImpl(GuestsRepo guestsRepo, GuestDocumentsRepo guestDocumentsRepo) {
        this.guestsRepo = guestsRepo;
        this.guestDocumentsRepo = guestDocumentsRepo;
    }

    @Override
    @Transactional
    public Guests createGuestAndDocument(GuestAndDocumentCreateModel model) {

        Guests guests = new Guests();
        guests.setName(model.name());
        guests.setLastName(model.lastName());
        guests.setPhoneNumber(model.phoneNumber());
        guests.setEmail(model.email());
        guests.setBirthDate(model.birthDate());
        guests.setGender(model.gender());
        guests.setCitizenship(model.citizenship());
        guestsRepo.save(guests);

        GuestDocuments guestDocuments = new GuestDocuments();
        guestDocuments.setGuestId(guests.getId());
        guestDocuments.setPrivateNumber(model.passportNumber());
        guestDocuments.setPassportExpDate(model.passportExpDate());
        guestDocuments.setPrivateNumber(model.privateNumber());
        guestDocuments.setIdExpDate(model.idExpDate());
        guestDocuments.setResidenceNumber(model.residenceNumber());
        guestDocuments.setResidenceExpDate(model.residenceExpDate());
        guestDocuments.setTemporaryDisplacedNumber(model.temporaryDisplacedNumber());
        guestDocuments.setTemporaryDisplacedExpDate(model.temporaryDisplacedExpDate());
        guestDocuments.setDrivingLicenceNumber(model.drivingLicenceNumber());
        guestDocuments.setDrivingLicenceExpDate(model.drivingLicenceExpDate());
        guestDocumentsRepo.save(guestDocuments);

        return guests;
    }

    @Override
    public List<GuestDocuments> getGuestWithDocument(Integer id) {
        return guestDocumentsRepo.findAllById(id);
    }

    @Override
    public List<GuestDocuments> findAllGuestWithDocuments() {
        return guestDocumentsRepo.findAll();
    }


}
