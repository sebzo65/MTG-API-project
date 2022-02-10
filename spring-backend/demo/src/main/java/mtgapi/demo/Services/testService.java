package mtgapi.demo.Services;

//import com.fasterxml.jackson.core.JsonProcessingException;
import mtgapi.demo.Entities.testEntity;
import mtgapi.demo.Payloads.Requests.testCreatePayload;
import mtgapi.demo.Payloads.Requests.testUpdatePayload;
import mtgapi.demo.Repositories.testRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
//import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class testService {

    @Autowired
    private testRepository repository;

    //Find all records in the database
    public List<testEntity> all() {return this.repository.findAll();}

    //Find a record in the database by the Id
    public testEntity findById(Long id) {
        Optional<testEntity> testEntity = this.repository.findById(id);
        if(testEntity.isEmpty()) {
            throw new Error(String.format("testEntity with id:%d does not exist", id));
        }
        return testEntity.get();
    }

    //Creating a record in the database
    public void create(testCreatePayload test) {
        testEntity newTestEntity = new testEntity(test.getName(), test.getPower());

        repository.save(newTestEntity);
    }

    //Updating a record in the database
    public testEntity update(Long id, testUpdatePayload data) {
        Optional<testEntity> fetchedTest = this.repository.findById(id);

        if (fetchedTest.isEmpty()) {
            return null;
        }

        testEntity test = fetchedTest.get();

        if (data.getName() != null && !"".equals(data.getName())) {
            test.setName(data.getName());
        }

        if (data.getPower() != null && !"".equals(data.getPower())) {
            test.setPower(data.getPower());
        }

        return this.repository.save(test);
    }
}
