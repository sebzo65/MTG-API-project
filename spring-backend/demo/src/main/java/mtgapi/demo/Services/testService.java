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

    public List<testEntity> all() {return this.repository.findAll();}

    public testEntity findById(Long id) {
        Optional<testEntity> testEntity = this.repository.findById(id);
        if(testEntity.isEmpty()) {
            throw new Error(String.format("testEntity with id:%d does not exist", id));
        }
        return testEntity.get();
    }

    public void create(testCreatePayload test) {
        testEntity newTestEntity = new testEntity(test.getName(), test.getPower());

        repository.save(newTestEntity);
    }

    public testEntity update (Long id, testUpdatePayload data) {
        if (this.repository.existsByNameAndId(data.getName(), id)) {
            throw new Error(String.format("testEntity with name %s already exists",
                    data.getName()));
        }
        var test = this.findById(id);

        return this.repository.save(test);
    }
}
