package ro.fasttrackit.homework10.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "routes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Route {
    private String routeId;

    private int length;

    private String startLocationId;
    private String destinationLocationId;
    private String trainId;
}
