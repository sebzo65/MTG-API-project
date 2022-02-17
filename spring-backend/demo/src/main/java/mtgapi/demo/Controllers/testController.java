package mtgapi.demo.Controllers;
import mtgapi.demo.Entities.testEntity;
import mtgapi.demo.Payloads.Requests.testCreatePayload;
import mtgapi.demo.Payloads.Requests.testUpdatePayload;
import mtgapi.demo.Services.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/test_entity")
public class testController {
    @Autowired
    private testService service;

    //    http://127.0.0.1:8090/test_entity/test
    @GetMapping(value = "/test")
    public String test() {
        return "hello, world!";
    }

    @GetMapping(value = "/test/{name}")
    public String testName(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping(value = "/test/{name}/{age}")
    public String testNameAge(@PathVariable String name, @PathVariable int age) {
        return String.format("Hello %s, you are %d years old", name, age);
    }

    @GetMapping
    public List<testEntity> all() {
        return this.service.all();
    }

    // GET /test_entity/{id}
    @GetMapping(value = "/{id}")
    public testEntity findById (@PathVariable Long id) {

        return this.service
                .findById(id) //Optional<testEntity>
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "testEntity not found"));
    }
    //Lambda function with implicit return value
    //orElseThrow is a method in the Optional class


    // POST /test_entity
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED) //Returns 201 message (which is only for CREATE)
    public void save(@Valid @RequestBody testCreatePayload test) {
        this.service.create(test);
    }


    // PATCH /test_entity/{id}
    @PatchMapping(value = "/{id}")
    public ResponseEntity<testEntity> update(@PathVariable Long id, @RequestBody testUpdatePayload data) {
        testEntity test = this.service.update(id, data);

        if (test == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    // DELETE /test_entity/{id}
    @DeleteMapping(value = "/{id}")
    //Return a 204 Success message, because no content returned
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.service.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "testEntity not found"));
        this.service.delete(id);
    //Adding 404 Error is important because we need to let user know that they've done something
        //wrong, like pass in id that doesn't exist. Otherwise, default is 500 internal server error,
        //& user will assume it's not their fault
    }

}
