package mtgapi.demo.Repositories;

import mtgapi.demo.Entities.magicCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface magicCardRepository extends JpaRepository<magicCard, Long> {

    Optional<magicCard>findById(long id);
    List<magicCard>findByName(String name);
    Optional<magicCard>findByManaCostId(long ManaCostId);
    Optional<magicCard>findByTypeLineId(long TypeLineId);
    Optional<magicCard>findByExpansionSymbolId(long ExpansionSymbolId);
    List<magicCard>findByAbilities(String abilities);
    List<magicCard>findByFlavourText(String flavourText);
    List<magicCard>findBySetSymbolAndRarity(String setSymbolAndRarity);
    List<magicCard>findByArtistInfo(String artistInfo);
    List<magicCard>findByCollectorNum(int collectorNum);
    List<magicCard>findByPowerTough(String powerTough);
    Optional<magicCard>findByCardBorderId(long CardBorderId);
}
