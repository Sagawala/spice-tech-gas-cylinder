package com.spicetech.gascylinderapp.Service;


import com.spicetech.gascylinderapp.Entity.GasSensor;
import com.spicetech.gascylinderapp.Repository.GasSensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GasSensorService {

    private final GasSensorRepository gasSensorRepository;

    @Autowired
    public GasSensorService(GasSensorRepository gasSensorRepository) {
        this.gasSensorRepository = gasSensorRepository;
    }

    public GasSensor addGasSensor(GasSensor gasSensor) {
        return gasSensorRepository.save(gasSensor);
    }

    public List<GasSensor> getAllGasSensors() {
        return gasSensorRepository.findAll();
    }

    public Optional<GasSensor> getGasSensorById(Long id) {
        return gasSensorRepository.findById(id);
    }

    public GasSensor updateGasSensorById(Long id, GasSensor updatedGasSensor) {
        Optional<GasSensor> existingGasSensor = gasSensorRepository.findById(id);
        if (existingGasSensor.isPresent()) {
            GasSensor gasSensor = existingGasSensor.get();
            gasSensor.setCylinderId(updatedGasSensor.getCylinderId());
            gasSensor.setReading(updatedGasSensor.getReading());
            gasSensor.setTimestamp(updatedGasSensor.getTimestamp());
            return gasSensorRepository.save(gasSensor);
        }
        return null;
    }

    public void deleteGasSensorById(Long id) {
        gasSensorRepository.deleteById(id);
    }
}
