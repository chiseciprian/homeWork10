package ro.fasttrackit.homework10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.homework10.model.TrainFilters;
import ro.fasttrackit.homework10.model.entity.Train;
import ro.fasttrackit.homework10.service.TrainService;

import java.util.List;

@RestController
@RequestMapping("trains")
@RequiredArgsConstructor
public class TrainController {
    private final TrainService trainService;

    @GetMapping
    List<Train> getAll(TrainFilters filters) {
        return trainService.getAllByFilters(filters);
    }

    @PostMapping
    Train addTrain(@RequestBody Train train) {
        return trainService.addTrain(train);
    }

    @PutMapping(path = "/{trainId}")
    Train updateTrain(@PathVariable String trainId, @RequestBody Train train) {
        return trainService.updateTrain(trainId, train);
    }

    @DeleteMapping(path = "/{trainId}")
    void deleteTrain(@PathVariable String trainId) {
        trainService.deleteTrain(trainId);
    }
}
