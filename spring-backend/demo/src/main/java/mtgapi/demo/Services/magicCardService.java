package mtgapi.demo.Services;

import mtgapi.demo.Entities.magicCard;
import mtgapi.demo.Payloads.Requests.mtgCardCreatePayload;
import mtgapi.demo.Payloads.Requests.mtgCardUpdatePayload;
import mtgapi.demo.Repositories.magicCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class magicCardService {
    @Autowired
    private magicCardRepository repository;

    //Find all records in the database
    public List<magicCard> all() {
        return this.repository.findAll();
    }

    //Find a record in the database by the Id
    public Optional<magicCard> findById(Long id) {
        return this.repository.findById(id);
    }

    //Create a new record in the database
    public void create(mtgCardCreatePayload card) {
        magicCard magicCard = new magicCard(
                card.getName(),
                card.getManaCostId(),
                card.getTypeLineId(),
                card.getExpansionSymbolId(),
                card.getAbilities(),
                card.getFlavourText(),
                card.getSymbolRarity(),
                card.getArtistInfo(),
                card.getCollectorNum(),
                card.getPowerTough(),
                card.getCardBorderId()
                );
    repository.save(magicCard);
    }

    //Updating a record in the database
//    public magicCard update(Long id, mtgCardUpdatePayload data) {
//
//    }
}
