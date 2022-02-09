package mtgapi.demo.Repositories;

import mtgapi.demo.Entities.testEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface testRepository extends JpaRepository<testEntity, Long> {

    Optional<testEntity> findById(long id);
    List<testEntity> findByName(String name);
    List<testEntity> findByPower(Integer power);

    Boolean existsByName(String name);
    Boolean existsByNameAndId(String name, Long id);
}
