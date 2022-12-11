package com.mukul.vehicle.io.repository;

import com.mukul.vehicle.io.model.Client;
import com.mukul.vehicle.io.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
