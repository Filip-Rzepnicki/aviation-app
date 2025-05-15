package com.fly.airplanes.aircraft;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AircraftService {

    private final Aircraft_Repository aircraft_Repository;

    @Autowired
    public AircraftService(Aircraft_Repository aircraft_Repository) {
        this.aircraft_Repository = aircraft_Repository;

    }

    public List<Aircraft> getAircrafts() {
        return aircraft_Repository.findAll();
    }


    public List<Aircraft> getAircraftsFromManufacturer(String manufacturerName) {
        return aircraft_Repository.findAll().stream()
                .filter(aircraft -> manufacturerName.equals(aircraft.getManufacturer()))
                .collect(Collectors.toList());


    }

    public List<Aircraft> getAircraftsByIcaoCode(String searchText) {
        return aircraft_Repository.findAll().stream()
                .filter(aircraft -> aircraft.getIcaoCode().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }



    public List<Aircraft> getAircraftByModel(String searchText){
        return aircraft_Repository.findAll().stream()
                .filter(aircraft->aircraft.getModel_FAA().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Aircraft> getAircraftByEngineType(String searchText){
        return aircraft_Repository.findAll().stream()
                .filter(aircraft->aircraft.getPhysical_Class_Engine().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Aircraft addAircraft(Aircraft aircraft){
        aircraft_Repository.save(aircraft);
        return aircraft;
    }

    public Aircraft updateAircraft(Aircraft updatedaircraft){
        Optional<Aircraft> existingAircraft = aircraft_Repository.findByIcaoCode(updatedaircraft.getIcaoCode());

        if(existingAircraft.isPresent()){
            Aircraft aircraftToUpdate = existingAircraft.get();
            aircraftToUpdate.setManufacturer(updatedaircraft.getManufacturer());
            aircraftToUpdate.setIcaoCode(updatedaircraft.getIcaoCode());
            aircraftToUpdate.setModel_FAA(updatedaircraft.getModel_FAA());
            aircraftToUpdate.setPhysical_Class_Engine(updatedaircraft.getPhysical_Class_Engine());

            aircraft_Repository.save(aircraftToUpdate);
            return aircraftToUpdate;

        }
        return null;
    }


    @Transactional
    public void deleteAircraft(String icaoCode){
        aircraft_Repository.deleteByIcaoCode(icaoCode);


    }

    public List<Aircraft> searchAircraft(String query){
        String lowerQuery = query.toLowerCase();

        return aircraft_Repository.findAll().stream()
                .filter(aircraft ->
                        (aircraft.getManufacturer() != null && aircraft.getManufacturer().toLowerCase().contains(lowerQuery)) ||
                                (aircraft.getModel_FAA() != null && aircraft.getModel_FAA().toLowerCase().contains(lowerQuery)) ||
                                (aircraft.getIcaoCode() != null && aircraft.getIcaoCode().toLowerCase().contains(lowerQuery)) ||
                                (aircraft.getPhysical_Class_Engine() != null && aircraft.getPhysical_Class_Engine().toLowerCase().contains(lowerQuery))
                )
                .collect(Collectors.toList());
    }
}
