package com.taxicalls.driver.resources;

import com.taxicalls.driver.model.Driver;
import com.taxicalls.driver.service.DriverService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drivers")
public class DriversResource {

    @Autowired
    private DriverService driverService;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public Driver createDriver(Driver driver) {
        return driverService.createDriver(driver);
    }

    @RequestMapping("/")
    public List<Driver> getDrivers() {
        return driverService.getDrivers();
    }

    @RequestMapping(value = "/{id}")
    public Driver getDriver(@PathVariable("id") Integer id) {
        return driverService.getDriver(id);
    }

}
