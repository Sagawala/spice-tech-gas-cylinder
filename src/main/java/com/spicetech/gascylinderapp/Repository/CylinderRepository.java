package com.spicetech.gascylinderapp.Repository;


import com.spicetech.gascylinderapp.Entity.Cylinder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CylinderRepository extends JpaRepository<Cylinder, Long> {
}
