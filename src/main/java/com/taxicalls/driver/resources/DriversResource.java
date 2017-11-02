package com.taxicalls.driver.resources;

import com.taxicalls.driver.model.Driver;
import com.taxicalls.driver.service.DriverService;
import com.taxicalls.driver.services.TripService;
import com.taxicalls.protocol.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drivers")
public class DriversResource {

    @Autowired
    private DriverService driverService;

    @Autowired
    private TripService tripService;

    protected static final Logger LOGGER = Logger.getLogger(DriverService.class.getName());

    @RequestMapping(method = RequestMethod.POST)
    public Response createDriver(@RequestBody Driver driver) {
        LOGGER.log(Level.INFO, "createDriver invoked");
        Driver createDriver = driverService.createDriver(driver);
        LOGGER.log(Level.INFO, "driver created id {0}", createDriver.getId());
        tripService.createDriver(createDriver);
        return Response.successful(createDriver);
    }

    @RequestMapping
    public Response getDrivers() {
        return Response.successful(driverService.getDrivers());
    }

    @RequestMapping(value = "/{id}")
    public Response getDriver(@PathVariable("id") Long id) {
        Driver driver = driverService.getDriver(id);
        if (driver == null) {
            return Response.notFound();
        }
        return Response.successful(driver);
    }
}
