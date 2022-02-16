package mtgapi.demo.Controllers;

import mtgapi.demo.Entities.magicCard;
import mtgapi.demo.Payloads.Requests.mtgCardCreatePayload;
import mtgapi.demo.Services.magicCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/magic_card")
public class magicCardController {
    @Autowired
    private magicCardService service;

    //Retrieve all records in database
    @GetMapping
    public List<magicCard> all() {
        return this.service.all();
    }

    // GET /magic_card/{id}
    @GetMapping(value = "/{id}")
    public magicCard findById (@PathVariable Long id) {
        return this.service.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Magic Card not found"));
    }

    // POST /magic_card
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void save(@Valid @RequestBody mtgCardCreatePayload mtgCard) {
        this.service.create(mtgCard);
    }

}
