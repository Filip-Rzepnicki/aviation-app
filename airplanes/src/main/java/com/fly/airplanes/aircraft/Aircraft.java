package com.fly.airplanes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aircraft_statistic")
public class Aircraft {

    @Id
    private String icaoCode;

    private String manufacturer;
    private String model;
    private String physicalClassEngine;
    private String aircraftType;

    public Aircraft() {
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPhysicalClassEngine() {
        return physicalClassEngine;
    }

    public void setPhysicalClassEngine(String physicalClassEngine) {
        this.physicalClassEngine = physicalClassEngine;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }
}
