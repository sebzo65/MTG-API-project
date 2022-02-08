package mtgapi.demo.Payloads.Requests;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class testCreatePayload {

    @Getter @Setter @NotBlank
    private String name;

    @Getter @Setter @NotNull
    private Integer power;

    //Constructor
    public testCreatePayload () {}

    //Overloading constructor
    public testCreatePayload (String name, Integer power) {
        this.name = name;
        this.power = power;
    }
}
