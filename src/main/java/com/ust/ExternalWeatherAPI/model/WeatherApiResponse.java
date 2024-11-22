package com.ust.ExternalWeatherAPI.model;

import lombok.Data;

@Data
public class WeatherApiResponse {
    private Location location;
    private Current current;

    @Data
    public static class Location {
        private String name;
        private String region;
        private String country;
    }

    @Data
    public static class Current {
        private double temp_c; // For temperature in Celsius
        private Condition condition;

        @Data
        public static class Condition {
            private String text;
            private String icon;
        }
    }
}
