package com.fly.airplanes;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AircraftService {

    private final AircraftRepository repository;

    public AircraftService(AircraftRepository repository) {
        this.repository = repository;
    }

    public List<Aircraft> getAllAircraft() {
        return repository.findAll();
    }

    public Aircraft getAircraftByIcao(String icaoCode) {
        Aircraft aircraft = repository.findByIcaoCode(icaoCode);
        if (aircraft == null) {
            throw new AircraftNotFoundException(icaoCode);
        }
        return aircraft;
    }

    public Aircraft saveAircraft(Aircraft aircraft) {
        return repository.save(aircraft);
    }

    public Aircraft updateAircraft(String icaoCode, Aircraft aircraft) {
        Aircraft existing = getAircraftByIcao(icaoCode);

        existing.setManufacturer(aircraft.getManufacturer());
        existing.setModel(aircraft.getModel());
        existing.setAircraftType(aircraft.getAircraftType());
        existing.setPhysicalClassEngine(aircraft.getPhysicalClassEngine());

        return repository.save(existing);
    }

    @Transactional
    public void deleteAircraft(String icaoCode) {
        getAircraftByIcao(icaoCode);
        repository.deleteByIcaoCode(icaoCode);
    }

    public Set<Aircraft> searchAircraft(String query) {
        Set<Aircraft> result = new HashSet<>();
        result.addAll(repository.findByManufacturerContainingIgnoreCase(query));
        result.addAll(repository.findByModelContainingIgnoreCase(query));
        result.addAll(repository.findByAircraftTypeContainingIgnoreCase(query));
        return result;
    }
}
