package ro.fasttrackit.homework10.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.homework10.model.entity.Train;

@Repository
public interface TrainRepository extends MongoRepository<Train, String> {
}
