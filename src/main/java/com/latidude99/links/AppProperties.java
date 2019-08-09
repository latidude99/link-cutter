package com.latidude99.links;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "links")
public class AppProperties {

    private String appName;
    private String urlBase;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getUrlBase() {
        return urlBase;
    }

    public void setUrlBase(String urlBase) {
        this.urlBase = urlBase;
    }
}
