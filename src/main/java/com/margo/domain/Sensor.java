package com.margo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by pglg on 30.01.2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sensor {
    public Long id;
    public Long stationId;
    public SensorParam param;

    public static class SensorParam{
        public String paramCode;
    }

   public static final String PM10_SENSOR_PARAM_TYPE="PM10";
    public static final String PM25_SENSOR_PARAM_TYPE="PM2,5";
}
