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
    List<magicCard>findByManaCostId(long ManaCostId);
    List<magicCard>findByTypeLineId(long TypeLineId);
    List<magicCard>findByExpansionSymbolId(long ExpansionSymbolId);
    List<magicCard>findByAbilities(String abilities);
    List<magicCard>findByFlavourText(String flavourText);
    List<magicCard>findBySymbolAndRarity(String symbolAndRarity);
    List<magicCard>findByArtistInfo(String artistInfo);
    List<magicCard>findByCollectorNum(Integer collectorNum);
    List<magicCard>findByPowerTough(String powerTough);
    List<magicCard>findByCardBorderId(long CardBorderId);
}
