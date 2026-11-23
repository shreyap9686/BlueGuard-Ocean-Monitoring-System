package com.blueguard;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OceanReadingRepository
        extends JpaRepository<OceanReading, Long> {

    List<OceanReading> findByLocationId(Long locationId);

}
