package com.margo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by pglg on 30.01.2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SensorData {
    public List<SensorValue> values;

    public static class SensorValue{
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        public LocalDateTime date;
        public Double value;
    }
}
