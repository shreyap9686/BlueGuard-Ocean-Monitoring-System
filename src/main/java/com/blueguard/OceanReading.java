package com.blueguard;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ocean_readings")
public class OceanReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double waterTemperature;
    private Double waveHeight;
    private Double windSpeed;
    private Double seaLevel;

    private LocalDateTime recordedAt;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private CoastalLocation location;

    public OceanReading() {
    }

    @PrePersist
    public void prePersist() {
        if (recordedAt == null) {
            recordedAt = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public Double getWaterTemperature() {
        return waterTemperature;
    }

    public void setWaterTemperature(Double waterTemperature) {
        this.waterTemperature = waterTemperature;
    }

    public Double getWaveHeight() {
        return waveHeight;
    }

    public void setWaveHeight(Double waveHeight) {
        this.waveHeight = waveHeight;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Double getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(Double seaLevel) {
        this.seaLevel = seaLevel;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

    public CoastalLocation getLocation() {
        return location;
    }

    public void setLocation(CoastalLocation location) {
        this.location = location;
    }
}
