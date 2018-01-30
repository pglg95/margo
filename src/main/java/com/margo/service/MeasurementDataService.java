package com.margo.service;

import com.margo.domain.Sensor;
import com.margo.domain.SensorData;
import com.margo.domain.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by pglg on 30.01.2018.
 */
@Service
public class MeasurementDataService {

    @Autowired
    private RestTemplate restTemplate;


    public Double getMeasurement(String city,String paramType){
        return Arrays.stream(restTemplate.getForObject(FIND_ALL_STATIONS_EXTERNAL_API_URL, Station[].class))
                .filter(s -> s.city.name.equals(city))
                .flatMap(s ->
                        Arrays.stream(restTemplate.getForObject(FIND_ALL_SENSORS_FOR_STATION_EXTERNAL_API_BASIC_URL,
                                Sensor[].class, s.id))
                                .filter(se -> se.param.paramCode.equals(paramType)))
                .map(se ->
                        restTemplate.getForObject(GET_MEASUREMENT_DATA_FOR_SENSOR_EXTERNAL_API_BASIC_URL,
                                SensorData.class, se.id).values.stream()
                                .filter(sed-> Objects.nonNull(sed.value))
                                .max((a,b)->a.date.isAfter(b.date) ? 1 : -1)
                )
                .mapToDouble(sed->sed.get().value)
                .average()
                .getAsDouble();

    }

    private final String FIND_ALL_STATIONS_EXTERNAL_API_URL="http://api.gios.gov.pl/pjp-api/rest/station/findAll";
    private final String FIND_ALL_SENSORS_FOR_STATION_EXTERNAL_API_BASIC_URL="http://api.gios.gov.pl/pjp-api/rest/station/sensors/{stationId}";
    private final String GET_MEASUREMENT_DATA_FOR_SENSOR_EXTERNAL_API_BASIC_URL="http://api.gios.gov.pl/pjp-api/rest/data/getData/{sensorId}";

}
