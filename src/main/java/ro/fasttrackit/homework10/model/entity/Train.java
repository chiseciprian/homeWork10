package ro.fasttrackit.homework10.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "trains")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Train {
    @Id
    private String trainId;

    private int carts;
    private String model;

    @NonNull
    private String locationId;
}
