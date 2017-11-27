package com.taxicalls.driver.resources;

import com.taxicalls.driver.model.Driver;
import com.taxicalls.driver.service.DriverService;
import com.taxicalls.protocol.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class AuthenticateResource {

    @Autowired
    private DriverService driverService;

    protected static final Logger LOGGER = Logger.getLogger(DriverService.class.getName());

    @RequestMapping(method = RequestMethod.POST)
    public Response authenticateDriver(@RequestBody Driver driver) {
        LOGGER.log(Level.INFO, "createDriver invoked");
        List<Driver> drivers = driverService.getDrivers();
        for (Driver stored : drivers) {
            if (stored.getEmail() == null) {
                continue;
            }
            if (stored.getPassword() == null) {
                continue;
            }
            if (stored.getEmail().equals(driver.getEmail()) && stored.getPassword().equals(driver.getPassword())) {
                return Response.successful(stored);
            }
        }
        return Response.notFound();
    }

}
