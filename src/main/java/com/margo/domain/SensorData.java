package com.margo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by pglg on 30.01.2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SensorData {
    public String key;
    public List<SensorValue> values;

    public static class SensorValue{
        public LocalDateTime date;
        public Double value;
    }
}
