package com.sctp.module3project2.repository;

// import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
import com.sctp.module3project2.entity.Berth;

// @Repository
public interface BerthRepository extends JpaRepository<Berth, Long> {
    // Update by Farhan
    // List<Berth> findAllByPortLocationIsNotNull();

    Berth findBerthPortLocationById(Long id);
}
