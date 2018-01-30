package com.margo.controller;

import com.margo.service.MeasurementDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * Created by pglg on 30.01.2018.
 */
@RestController
@RequestMapping("/margo/api")
public class MainController {

    @Autowired
    private MeasurementDataService measurementDataService;

    @GetMapping("/measurements/cities/{city}/paramTypes/{paramType:.+}")
    public String getAvgMeasurementFromStationsInCity(@PathVariable String city,
                                                      @PathVariable String paramType){

        Double measurement = measurementDataService.getMeasurement(city, paramType);

        return String.format(Locale.US,"%.2f",measurement);
    }
}
