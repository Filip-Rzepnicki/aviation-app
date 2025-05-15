package com.fly.airplanes.aircraft;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "v1/aircraft")
public class AircraftController {
    private final AircraftService aircraftService;


    @Autowired
    public AircraftController(AircraftService aircraftService){
        this.aircraftService = aircraftService;
    }

    @GetMapping
    public List<Aircraft> getAircraft(
            @RequestParam(required = false) String manufacturer,
            @RequestParam(required = false) String icaoCode,
            @RequestParam(required = false) String modelFaa,
            @RequestParam(required = false) String engineClass){

        if(manufacturer != null){
            return aircraftService.getAircraftsFromManufacturer(manufacturer);
        }
        else if(icaoCode != null){
            return aircraftService.getAircraftsByIcaoCode(icaoCode);
        }
        else if(modelFaa != null){
            return aircraftService.getAircraftByModel(modelFaa);
        }
        else if(engineClass != null){
            return aircraftService.getAircraftByEngineType(engineClass);
        }
        else{
            return aircraftService.getAircrafts();
        }

    }

    @GetMapping("/search")
    public List<Aircraft> searchAircraft(@RequestParam String q){
        return aircraftService.searchAircraft(q);
    }


    @PostMapping
    public ResponseEntity<Aircraft> addPlayer(@RequestBody Aircraft aircraft){
        Aircraft createdAircraft = aircraftService.addAircraft(aircraft);
        return new ResponseEntity<>(createdAircraft, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Aircraft> updateAircraft(@RequestBody Aircraft aircraft){
        Aircraft resultAircraft = aircraftService.updateAircraft(aircraft);
        if(resultAircraft != null){
            return new ResponseEntity<>(resultAircraft, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{icaoCode}")
    public ResponseEntity<String> deletePlayer(@PathVariable String icaoCode){
        aircraftService.deleteAircraft(icaoCode);
        return new ResponseEntity<>("Aircraft deleted sucessfully", HttpStatus.OK);
    }

}
