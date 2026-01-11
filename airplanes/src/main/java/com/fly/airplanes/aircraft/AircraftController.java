package com.fly.airplanes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/v1/aircraft")
public class AircraftController {

    private final AircraftService service;

    public AircraftController(AircraftService service) {
        this.service = service;
    }

    @GetMapping
    public List<Aircraft> getAllAircraft() {
        return service.getAllAircraft();
    }

    @GetMapping("/{icaoCode}")
    public Aircraft getAircraft(@PathVariable String icaoCode) {
        return service.getAircraftByIcao(icaoCode);
    }

    @PostMapping
    public ResponseEntity<Aircraft> createAircraft(@RequestBody Aircraft aircraft) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveAircraft(aircraft));
    }

    @PutMapping("/{icaoCode}")
    public Aircraft updateAircraft(
            @PathVariable String icaoCode,
            @RequestBody Aircraft aircraft
    ) {
        return service.updateAircraft(icaoCode, aircraft);
    }

    @DeleteMapping("/{icaoCode}")
    public ResponseEntity<Void> deleteAircraft(@PathVariable String icaoCode) {
        service.deleteAircraft(icaoCode);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public Set<Aircraft> searchAircraft(@RequestParam String q) {
        return service.searchAircraft(q);
    }
}
