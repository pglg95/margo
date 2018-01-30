package com.margo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by pglg on 30.01.2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sensor {
    public Long id;
    public SensorParam param;

    public static class SensorParam{
        public String paramCode;
    }
}
