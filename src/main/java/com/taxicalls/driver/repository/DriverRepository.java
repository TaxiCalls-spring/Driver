package com.taxicalls.driver.repository;

import com.taxicalls.driver.model.Driver;
import org.springframework.data.repository.CrudRepository;

public interface DriverRepository extends CrudRepository<Driver, Integer> {

}
