package mtgapi.demo.Payloads.Requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class textBoxCreatePayload {

    @Getter @Setter @NotBlank
    private String abilities;

    @Getter @Setter @NotBlank
    private String flavourText;

//Create 2 Constructors - One empty and the other with all the fields
}
