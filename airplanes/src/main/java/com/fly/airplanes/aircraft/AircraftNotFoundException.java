package com.fly.airplanes;

public class AircraftNotFoundException extends RuntimeException {

    public AircraftNotFoundException(String icaoCode) {
        super("Aircraft with ICAO code " + icaoCode + " not found");
    }
}
