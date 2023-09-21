package com.spicetech.gascylinderapp.Repository;


import com.spicetech.gascylinderapp.Entity.GasSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GasSensorRepository extends JpaRepository<GasSensor, Long> {
}
