package com.fly.airplanes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AircraftRepository extends JpaRepository<Aircraft, String> {

    Aircraft findByIcaoCode(String icaoCode);

    void deleteByIcaoCode(String icaoCode);

    List<Aircraft> findByManufacturerContainingIgnoreCase(String query);

    List<Aircraft> findByModelContainingIgnoreCase(String query);

    List<Aircraft> findByAircraftTypeContainingIgnoreCase(String query);
}
