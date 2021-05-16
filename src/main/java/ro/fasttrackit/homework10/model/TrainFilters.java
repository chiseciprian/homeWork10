package ro.fasttrackit.homework10.model;

import lombok.Value;

@Value
public class TrainFilters {
    String locationId;
    String trainModel;
    Integer minCarts;
    Integer maxCarts;
}
