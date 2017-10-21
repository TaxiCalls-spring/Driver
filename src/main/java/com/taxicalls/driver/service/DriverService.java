/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxicalls.driver.service;

import com.taxicalls.driver.model.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taxicalls.driver.repository.DriverRepository;

/**
 *
 * @author romulo
 */
@Service
public class DriverService {

    protected static final Logger LOGGER = Logger.getLogger(DriverService.class.getName());

    @Autowired
    protected DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
        LOGGER.log(Level.INFO, "DriverRepository says system has {0} accounts", driverRepository.count());
    }

    public Driver createDriver(Driver driver) {
        Driver save = driverRepository.save(driver);
        return save;
    }

    public List<Driver> getDrivers() {
        LOGGER.log(Level.INFO, "getDrivers() invoked");
        List<Driver> drivers = new ArrayList<>();
        Iterable<Driver> findAll = driverRepository.findAll();
        for (Driver driver : findAll) {
            drivers.add(driver);
        }
        LOGGER.log(Level.INFO, "getDrivers() found {0}", drivers.size());
        return drivers;
    }

    public Driver getDriver(Integer id) {
        Driver driver = driverRepository.findOne(id);
        return driver;
    }

}
