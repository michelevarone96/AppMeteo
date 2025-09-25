package com.mvarone.appmeteo.config;

import java.util.Base64;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "openweather.core")
public class OpenWeatherConfig {

    private String key;
    private String baseurl;

    public String getKey() {
        if (key == null) {
            return null;
        }
        byte[] decodedBytes = Base64.getDecoder().decode(key);
        return new String(decodedBytes);
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getBaseurl() {
        return baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
    }
}
