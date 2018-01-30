package com.margo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by pglg on 30.01.2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Station {
    public Long id;
    public City city;

    public static class City{
        public String name;
    }

}
