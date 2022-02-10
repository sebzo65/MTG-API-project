package mtgapi.demo.Controllers;

import mtgapi.demo.Entities.testEntity;
import mtgapi.demo.Payloads.Requests.testCreatePayload;
import mtgapi.demo.Payloads.Requests.testUpdatePayload;
import mtgapi.demo.Repositories.testRepository;
import mtgapi.demo.Services.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
        return this.service.findById(id);
    }


    // POST /test_entity
    @PostMapping
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

}
