package mtgapi.demo.Payloads.Requests;

import mtgapi.demo.Entities.TextBox;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class mtgCardCreatePayload {

    @Getter @Setter @NotBlank
    private String name;

    @Getter @Setter @NotBlank
    private String manaCost;

    @Getter @Setter @NotBlank
    private String typeLine;

    @Getter @Setter @NotBlank
    private String expansionSymbol;

    @Getter @Setter @NotNull
    private TextBox textBox;

    @Getter @Setter @NotBlank
    private String artistInfo;

    @Getter @Setter @NotNull
    private Integer collectorNum;

    @Getter @Setter @NotNull
    private Integer powerTough;

    @Getter @Setter @NotBlank
    private String setSymbolAndRarity;

    //Create 2 Constructors - One empty and the other with all the fields
}
