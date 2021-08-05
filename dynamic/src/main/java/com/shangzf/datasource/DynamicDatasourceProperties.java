package com.shangzf.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;
import java.util.TreeMap;

@ConfigurationProperties(prefix = DynamicDatasourcePropertiesConstant.PREFIX)
public class DynamicDatasourceProperties {

    private boolean enabled = false;

    private Map<String, DataSourcePropertiesConfiguration> datasource;

    public DynamicDatasourceProperties() {
        this.datasource = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Map<String, DataSourcePropertiesConfiguration> getDatasource() {
        return datasource;
    }

    public void setDatasource(Map<String, DataSourcePropertiesConfiguration> datasource) {
        this.datasource = datasource;
    }
}
