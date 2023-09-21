package com.spicetech.gascylinderapp.Service;


import com.spicetech.gascylinderapp.Entity.Cylinder;
import com.spicetech.gascylinderapp.Repository.CylinderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CylinderService {

    private final CylinderRepository cylinderRepository;

    @Autowired
    public CylinderService(CylinderRepository cylinderRepository) {
        this.cylinderRepository = cylinderRepository;
    }

    public Cylinder addCylinder(Cylinder cylinder) {
        return cylinderRepository.save(cylinder);
    }

    public List<Cylinder> getAllCylinders() {
        return cylinderRepository.findAll();
    }

    public Optional<Cylinder> getCylinderById(Long id) {
        return cylinderRepository.findById(id);
    }

    public Cylinder updateCylinderById(Long id, Cylinder updatedCylinder) {
        Optional<Cylinder> existingCylinder = cylinderRepository.findById(id);
        if (existingCylinder.isPresent()) {
            Cylinder cylinder = existingCylinder.get();
            cylinder.setOwnerId(updatedCylinder.getOwnerId());
            cylinder.setGasLevel(updatedCylinder.getGasLevel());
            cylinder.setThreshold(updatedCylinder.getThreshold());
            return cylinderRepository.save(cylinder);
        }
        return null;
    }

    public void deleteCylinderById(Long id) {
        cylinderRepository.deleteById(id);
    }
}
