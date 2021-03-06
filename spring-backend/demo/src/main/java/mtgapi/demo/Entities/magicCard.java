package mtgapi.demo.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "magic_card")
public class magicCard {

    //This allows database to automatically generate id
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

//    @Column(nullable = false)
    @Getter @Setter @NotBlank
    String name;

//    @Column(nullable = false)
    @Getter @Setter @NotNull
    Long manaCostId;

//    @Column(nullable = false)
    @Getter @Setter @NotNull
    Long typeLineId;

//    @Column(nullable = false)
    @Getter @Setter @NotNull
    Long expansionSymbolId;

//    @Column(nullable = false)
    @Getter @Setter @NotNull
    String abilities;

//    @Column(nullable = false)
    @Getter @Setter @NotNull
    String flavourText;

//    @Column(nullable = false)
    @Getter @Setter @NotBlank
    String symbolRarity;

//    @Column(nullable = false)
    @Getter @Setter @NotBlank
    String artistInfo;

//    @Column(nullable = false)
    @Getter @Setter @NotNull
    Integer collectorNum;

//    @Column(nullable = false)
    @Getter @Setter @NotNull
    Integer powerTough;

    //Use enum for card borders because there are only 5 of them
//    @Column(nullable = false)
    @Getter @Setter @NotNull
    Long cardBorderId;

    @Getter @Setter @NotBlank
    String cardImage;

    public magicCard(String name, Long manaCostId, Long typeLineId, Long expansionSymbolId, String abilities, String flavourText, String symbolRarity, String artistInfo, Integer collectorNum, Integer powerTough, Long cardBorderId, String cardImage) {
        this.name = name;
        this.manaCostId = manaCostId;
        this.typeLineId = typeLineId;
        this.expansionSymbolId = expansionSymbolId;
        this.abilities = abilities;
        this.flavourText = flavourText;
        this.symbolRarity = symbolRarity;
        this.artistInfo = artistInfo;
        this.collectorNum = collectorNum;
        this.powerTough = powerTough;
        this.cardBorderId = cardBorderId;
        this.cardImage = cardImage;
    }

    public magicCard () {}
}
