package com.taxicalls.driver.resources;

import com.taxicalls.driver.model.Trip;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.taxicalls.driver.services.NotificationService;
import com.taxicalls.driver.services.BillingService;
import com.taxicalls.driver.services.PassengerService;
import com.taxicalls.driver.services.TripService;
import com.taxicalls.protocol.Response;
import java.util.logging.Level;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/trips")
public class TripsResource {

    protected static final Logger LOGGER = Logger.getLogger(TripsResource.class.getName());

    @Autowired
    private TripService tripService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private BillingService billingService;

    @RequestMapping(method = RequestMethod.POST)
    public Response acceptTrip(@RequestBody Trip trip) {
        LOGGER.log(Level.INFO, "acceptTrip() invoked");
        notificationService.acceptTrip(trip);
        passengerService.acceptTrip(trip);
        billingService.acceptTrip(trip);
        tripService.acceptTrip(trip);
        return Response.successful();
    }

}
