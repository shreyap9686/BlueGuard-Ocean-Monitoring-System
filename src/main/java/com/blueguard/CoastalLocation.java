package com.blueguard;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "coastal_locations")
public class CoastalLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "location_name")
    private String locationName;

    private Double latitude;

    private Double longitude;

    @Column(name = "station_code")
    private String stationCode;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public CoastalLocation() {
    }

    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}