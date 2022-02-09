package mtgapi.demo.Payloads.Requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class testUpdatePayload {

    @Getter @Setter @NotBlank
    private String name;

    @Getter @Setter @NotNull
    private Integer power;

    public testUpdatePayload() {}

    public testUpdatePayload (String name, Integer power) {
        this.name = name;
        this.power = power;
    }
}
