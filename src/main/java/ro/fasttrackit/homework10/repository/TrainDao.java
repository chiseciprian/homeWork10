package ro.fasttrackit.homework10.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.homework10.model.TrainFilters;
import ro.fasttrackit.homework10.model.entity.Location;
import ro.fasttrackit.homework10.model.entity.Train;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Repository
@RequiredArgsConstructor
public class TrainDao {
    private final MongoTemplate mongo;

    public List<Train> getAll(TrainFilters filters) {
        Criteria trainCriteria = getTrainCriteria(filters);
        Criteria locationCriteria = getLocationCriteria(filters);
        List<Train> trains = getTrains(trainCriteria);
        List<Location> location = getLocations(locationCriteria);
        return filterTrains(trains, location);
    }

    private List<Train> filterTrains(List<Train> trains, List<Location> locations) {
        return trains.stream()
                .filter(train -> locations.stream()
                        .anyMatch(location -> location.getLocationId().equals(train.getLocationId()))
                ).collect(Collectors.toList());
    }

    private List<Train> getTrains(Criteria trainCriteria) {
        Query trainQuery = new Query(trainCriteria);
        return mongo.find(trainQuery, Train.class);
    }

    private List<Location> getLocations(Criteria locationCriteria) {
        Query locationQuery = new Query(locationCriteria);
        return mongo.find(locationQuery, Location.class);
    }

    private Criteria getLocationCriteria(TrainFilters filters) {
        Criteria locationCriteria = new Criteria();
        ofNullable(filters.getLocationId())
                .ifPresent(locationId -> locationCriteria.and("locationId").is(locationId));
        return locationCriteria;
    }

    private Criteria getTrainCriteria(TrainFilters filters) {
        Criteria trainCriteria = new Criteria();
        ofNullable(filters.getTrainModel())
                .ifPresent(trainModel -> trainCriteria.and("model").is(trainModel));
        ofNullable(filters.getMinCarts())
                .ifPresent(minCarts -> trainCriteria.and("carts").gt(minCarts));
        ofNullable(filters.getMaxCarts())
                .ifPresent(maxCarts -> trainCriteria.and("carts").lt(maxCarts));
        return trainCriteria;
    }
}
