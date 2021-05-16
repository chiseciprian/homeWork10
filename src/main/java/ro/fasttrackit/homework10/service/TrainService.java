package ro.fasttrackit.homework10.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.homework10.controller.exception.ValidationException;
import ro.fasttrackit.homework10.model.TrainFilters;
import ro.fasttrackit.homework10.model.entity.Train;
import ro.fasttrackit.homework10.repository.TrainDao;
import ro.fasttrackit.homework10.repository.TrainRepository;
import ro.fasttrackit.homework10.service.validator.TrainValidator;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainService {
    private final TrainRepository trainRepository;
    private final TrainValidator validator;
    private final TrainDao trainDao;

    public Train addTrain(Train train) {
        validator.validateLocationThrow(train.getLocationId());
        return trainRepository.save(train);
    }

    public void deleteTrain(String trainId) {
        trainRepository.deleteById(trainId);
    }

    public Train updateTrain(String trainId, Train train) {
        train.setTrainId(trainId);
        validator.validateReplaceThrow(trainId, train);

        Train dbTrain = trainRepository.findById(trainId)
                .orElseThrow(() -> new ValidationException("Couldn't find train with id " + trainId));
        copyTrain(train, dbTrain);
        return trainRepository.save(dbTrain);
    }

    private void copyTrain(Train train, Train dbTrain) {
        dbTrain.setCarts(train.getCarts());
        dbTrain.setLocationId(train.getLocationId());
        dbTrain.setModel(train.getModel());
    }

    public List<Train> getAllByFilters(TrainFilters filters) {
        return trainDao.getAll(filters);
    }
}
