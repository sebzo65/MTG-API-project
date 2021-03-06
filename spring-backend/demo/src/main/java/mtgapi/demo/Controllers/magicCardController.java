package mtgapi.demo.Controllers;

import mtgapi.demo.Entities.magicCard;
import mtgapi.demo.Payloads.Requests.mtgCardCreatePayload;
import mtgapi.demo.Payloads.Requests.mtgCardUpdatePayload;
import mtgapi.demo.Services.magicCardService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/magic_card")
public class magicCardController {
    @Autowired
    private magicCardService service;

    //    http://127.0.0.1:8090/magic_card/test
    @GetMapping(value = "/test")
    public String test() {
        return "hello, world!";
    }

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

    // PATCH /magic_card/{id}
    @PatchMapping(value = "/{id}")
    public ResponseEntity<magicCard> update(@PathVariable Long id, @RequestBody mtgCardUpdatePayload data) {
        magicCard card = this.service.update(id, data);

        if (card == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    // DELETE /magic_card/{id}
    @DeleteMapping(value = "/{id}")
    //Return a 204 Success message, because no content returned
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.service.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "magic card not found"));
        this.service.delete(id);
    }

}
