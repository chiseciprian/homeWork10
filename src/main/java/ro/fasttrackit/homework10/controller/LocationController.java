package ro.fasttrackit.homework10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.homework10.model.entity.Location;
import ro.fasttrackit.homework10.service.LocationService;

@RestController
@RequestMapping("locations")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @PostMapping
    Location addLocation(@RequestBody Location location) {
        return locationService.addLocation(location);
    }

    @DeleteMapping(path = "/{locationId}")
    void deleteLocation(@PathVariable String locationId) {
        locationService.deleteLocation(locationId);
    }
}
