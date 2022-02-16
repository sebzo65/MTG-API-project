package mtgapi.demo.Payloads.Requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class mtgCardCreatePayload {

    @Getter @Setter @NotBlank
    private String name;

    @Getter @Setter @NotNull
    private Long manaCostId;

    @Getter @Setter @NotNull
    private Long typeLineId;

    @Getter @Setter @NotNull
    private Long expansionSymbolId;

    @Getter @Setter @NotBlank
    private String abilities;

    @Getter @Setter @NotBlank
    private String flavourText;

    @Getter @Setter @NotBlank
    private String symbolAndRarity;

    @Getter @Setter @NotBlank
    private String artistInfo;

    @Getter @Setter @NotNull
    private Integer collectorNum;

    @Getter @Setter @NotNull
    private Integer powerTough;

    @Getter @Setter @NotNull
    private Long cardBorderId;

    //Create 2 Constructors - One empty and the other with all the fields
    public mtgCardCreatePayload(){}

    public mtgCardCreatePayload(
            String name,
            Long manaCostId,
            Long typeLineId,
            Long expansionSymbolId,
            String abilities,
            String flavourText,
            String symbolAndRarity,
            String artistInfo,
            Integer collectorNum,
            Integer powerTough,
            Long cardBorderId
    ) {
        this.setName(name);
        this.setManaCostId(manaCostId);
        this.setTypeLineId(typeLineId);
        this.setExpansionSymbolId(expansionSymbolId);
        this.setAbilities(abilities);
        this.setFlavourText(flavourText);
        this.setSymbolAndRarity(symbolAndRarity);
        this.setArtistInfo(artistInfo);
        this.setCollectorNum(collectorNum);
        this.setPowerTough(powerTough);
        this.setCardBorderId(cardBorderId);
    }
}
