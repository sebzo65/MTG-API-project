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
    public magicCard update(Long id, mtgCardUpdatePayload data) {
        Optional<magicCard> fetchedCard = this.repository.findById(id);

        if (fetchedCard.isEmpty()) {
            return null;
        }
        magicCard card = fetchedCard.get();

        if (data.getName() != null && !"".equals(data.getName())) {
            card.setName(data.getName());
        }

        if (data.getManaCostId() != null && !"".equals(data.getManaCostId())) {
            card.setManaCostId(data.getManaCostId());
        }

        if (data.getTypeLineId() != null && !"".equals(data.getTypeLineId())) {
            card.setTypeLineId(data.getTypeLineId());
        }

        if (data.getExpansionSymbolId() != null && !"".equals(data.getExpansionSymbolId())) {
            card.setExpansionSymbolId(data.getExpansionSymbolId());
        }

        if (data.getAbilities() != null && !"".equals(data.getAbilities())) {
            card.setAbilities(data.getAbilities());
        }

        if (data.getSymbolRarity() != null && !"".equals(data.getSymbolRarity())) {
            card.setSymbolRarity(data.getSymbolRarity());
        }

        if (data.getArtistInfo() != null && !"".equals(data.getArtistInfo())) {
            card.setArtistInfo(data.getArtistInfo());
        }

        if (data.getCollectorNum() != null && !"".equals(data.getCollectorNum())) {
            card.setCollectorNum(data.getCollectorNum());
        }

        if (data.getPowerTough() != null && !"".equals(data.getPowerTough())) {
            card.setPowerTough(data.getPowerTough());
        }

        if (data.getCardBorderId() != null && !"".equals(data.getCardBorderId())) {
            card.setCardBorderId(data.getCardBorderId());
        }

        return this.repository.save(card);
    }
}
