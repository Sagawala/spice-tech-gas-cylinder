package com.spicetech.gascylinderapp.Controller;


import com.spicetech.gascylinderapp.Entity.GasSensor;
import com.spicetech.gascylinderapp.Service.GasSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/gas-sensors")
public class GasSensorController {

    @Autowired
    private GasSensorService gasSensorService;

    @PostMapping
    public ResponseEntity<GasSensor> addGasSensor(@RequestBody GasSensor gasSensor) {
        GasSensor addedGasSensor = gasSensorService.addGasSensor(gasSensor);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedGasSensor);
    }

    @GetMapping
    public ResponseEntity<List<GasSensor>> getAllGasSensors() {
        List<GasSensor> gasSensors = gasSensorService.getAllGasSensors();
        return ResponseEntity.ok(gasSensors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GasSensor> getGasSensorById(@PathVariable Long id) {
        Optional<GasSensor> gasSensor = gasSensorService.getGasSensorById(id);
        if (gasSensor.isPresent()) {
            return ResponseEntity.ok(gasSensor.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GasSensor> updateGasSensorById(@PathVariable Long id, @RequestBody GasSensor updatedGasSensor) {
        GasSensor gasSensor = gasSensorService.updateGasSensorById(id, updatedGasSensor);
        if (gasSensor != null) {
            return ResponseEntity.ok(gasSensor);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGasSensorById(@PathVariable Long id) {
        gasSensorService.deleteGasSensorById(id);
        return ResponseEntity.noContent().build();
    }
}
