package mtgapi.demo.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//@Entity(name = "magicCard")
public class magicCard {

    //This allows database to automatically generate id
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Getter @Setter @NotBlank
    String name;

    @Getter @Setter @NotBlank
    String manaCost;

    @Getter @Setter @NotBlank
    String typeLine;

    @Getter @Setter @NotBlank
    String expansionSymbol;

    @Getter @Setter @NotNull
    TextBox textBox;

    @Getter @Setter @NotBlank
    String artistInfo;

    @Getter @Setter @NotNull
    Integer collectorNum;

    @Getter @Setter @NotNull
    Integer powerTough;

    //Use enum for card borders because there are only 5 of them
    @Getter @Setter @NotBlank
    String cardBorder;

    public magicCard(String name, String manaCost, String typeLine, String expansionSymbol, TextBox textBox, String artistInfo, Integer collectorNum, Integer powerTough) {
        this.name = name;
        this.manaCost = manaCost;
        this.typeLine = typeLine;
        this.expansionSymbol = expansionSymbol;
        this.textBox = textBox;
        this.artistInfo = artistInfo;
        this.collectorNum = collectorNum;
        this.powerTough = powerTough;
    }

    public magicCard () {}
}
