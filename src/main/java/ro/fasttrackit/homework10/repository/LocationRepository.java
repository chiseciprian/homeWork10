package ro.fasttrackit.homework10.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.homework10.model.entity.Location;

@Repository
public interface LocationRepository extends MongoRepository<Location, String> {
}
