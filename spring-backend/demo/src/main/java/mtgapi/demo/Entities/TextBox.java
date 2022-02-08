package mtgapi.demo.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class TextBox {

    @Getter @Setter @NotBlank
    public String abilities;

    @Getter @Setter @NotBlank
    public String flavourText;

    public TextBox (String abilities, String flavourText) {
        this.abilities = abilities;
        this.flavourText = flavourText;
    }

    public String getAbilities() {
        return abilities;
    }
}
