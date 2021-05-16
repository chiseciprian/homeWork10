package ro.fasttrackit.homework10.service.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.fasttrackit.homework10.controller.exception.ValidationException;
import ro.fasttrackit.homework10.model.entity.Train;
import ro.fasttrackit.homework10.repository.LocationRepository;
import ro.fasttrackit.homework10.repository.TrainRepository;

import java.util.Optional;

import static java.util.Optional.empty;

@Component
@RequiredArgsConstructor
public class TrainValidator {
    private final TrainRepository repository;
    private final LocationRepository locationRepository;

    public void validateLocationThrow(String locationId) {
        existsLocation(locationId)
                .ifPresent(ex -> {
                    throw ex;
                });
    }

    public void validateReplaceThrow(String trainId, Train newTrain) {
        existsTrain(trainId)
                .or(() -> existsLocation(newTrain.getLocationId()))
                .ifPresent(ex -> {
                    throw ex;
                });
    }

    private Optional<ValidationException> existsTrain(String trainId) {
        return repository.existsById(trainId)
                ? empty()
                : Optional.of(new ValidationException("Train with id " + trainId + " doesn't exist"));
    }

    private Optional<ValidationException> existsLocation(String locationId) {
        return locationRepository.existsById(locationId)
                ? empty()
                : Optional.of(new ValidationException("Location with id " + locationId + " doesn't exist"));
    }
}
