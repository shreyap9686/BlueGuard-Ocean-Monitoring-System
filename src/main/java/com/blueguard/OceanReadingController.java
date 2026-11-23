package com.blueguard;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ocean")
@CrossOrigin(origins = "*")
public class OceanReadingController {

    private final OceanReadingService oceanReadingService;

    public OceanReadingController(OceanReadingService oceanReadingService) {
        this.oceanReadingService = oceanReadingService;
    }

    @GetMapping("/readings")
    public List<OceanReading> getAllReadings() {
        return oceanReadingService.getAllReadings();
    }

    @GetMapping("/readings/location/{locationId}")
    public List<OceanReading> getReadingsByLocation(
            @PathVariable Long locationId) {
        return oceanReadingService.getReadingsByLocation(locationId);
    }

    @PostMapping("/readings")
    public OceanReading saveReading(@RequestBody OceanReading reading) {
        return oceanReadingService.saveReading(reading);
    }
}
