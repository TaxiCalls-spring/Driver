package com.taxicalls.driver.services;

import com.taxicalls.driver.model.Trip;
import com.taxicalls.protocol.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author romulo
 */
@FeignClient(name = "passenger")
public interface PassengerService {

    @RequestMapping(method = RequestMethod.POST, value = "/trips")
    public Response acceptTrip(Trip trip);
}
