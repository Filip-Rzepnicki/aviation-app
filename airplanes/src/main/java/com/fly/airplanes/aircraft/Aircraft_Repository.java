package com.fly.airplanes.aircraft;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Aircraft_Repository extends JpaRepository<Aircraft, String> {

    void deleteByIcaoCode(String aircraftIcaoCode);
    Optional<Aircraft> findByIcaoCode(String icaoCode);
}
