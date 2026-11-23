package com.blueguard;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OceanReadingService {

    private final OceanReadingRepository oceanReadingRepository;

    public OceanReadingService(OceanReadingRepository oceanReadingRepository) {
        this.oceanReadingRepository = oceanReadingRepository;
    }

    public List<OceanReading> getAllReadings() {
        return oceanReadingRepository.findAll();
    }

    public List<OceanReading> getReadingsByLocation(Long locationId) {
        return oceanReadingRepository.findByLocationId(locationId);
    }

    public OceanReading saveReading(OceanReading reading) {
        return oceanReadingRepository.save(reading);
    }
}
