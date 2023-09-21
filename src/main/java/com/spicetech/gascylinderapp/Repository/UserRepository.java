package com.spicetech.gascylinderapp.Repository;

;
import com.spicetech.gascylinderapp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
