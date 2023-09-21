package com.spicetech.gascylinderapp.Controller;


import com.spicetech.gascylinderapp.Entity.Cylinder;
import com.spicetech.gascylinderapp.Service.CylinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cylinders")
public class CylinderController {

    @Autowired
    private CylinderService cylinderService;

    @PostMapping
    public ResponseEntity<Cylinder> addCylinder(@RequestBody Cylinder cylinder) {
        Cylinder addedCylinder = cylinderService.addCylinder(cylinder);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedCylinder);
    }

    @GetMapping
    public ResponseEntity<List<Cylinder>> getAllCylinders() {
        List<Cylinder> cylinders = cylinderService.getAllCylinders();
        return ResponseEntity.ok(cylinders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCylinderById(@PathVariable Long id) {
        Optional<Cylinder> cylinder = cylinderService.getCylinderById(id);
        if (cylinder.isPresent()) {
            return ResponseEntity.ok(cylinder.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cylinder> updateCylinderById(@PathVariable Long id, @RequestBody Cylinder updatedCylinder) {
        Cylinder cylinder = cylinderService.updateCylinderById(id, updatedCylinder);
        if (cylinder != null) {
            return ResponseEntity.ok(cylinder);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCylinderById(@PathVariable Long id) {
        cylinderService.deleteCylinderById(id);
        return ResponseEntity.noContent().build();
    }
}
