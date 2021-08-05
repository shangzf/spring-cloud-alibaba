package com.shangzf.datasource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@ConditionalOnProperty(name = {DynamicDatasourcePropertiesConstant.PREFIX + "." + DynamicDatasourcePropertiesConstant.ENABLE}, matchIfMissing = true)
@EnableConfigurationProperties({DynamicDatasourceProperties.class})
public class DynamicDatasourceAutoConfiguration {

    @Autowired
    private DynamicDatasourceProperties datasourceProperties;

    @Bean(name = "datasource")
    @Primary
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> customDataSources = new HashMap<>();
        // 默认的数据源
        Map<String, DataSourcePropertiesConfiguration> propertiesDatasource = datasourceProperties.getDatasource();
        if (propertiesDatasource.isEmpty()) {
            throw new RuntimeException("至少需要一个数据源");
        }
        Map.Entry<String, DataSourcePropertiesConfiguration> configurationEntry = propertiesDatasource.entrySet()
                                                                                                      .stream()
                                                                                                      .findFirst()
                                                                                                      .get();
        DataSource defaultDataSource = configurationEntry.getValue().initializeDataSource();
        dynamicDataSource.setDefaultTargetDataSource(defaultDataSource);
        DynamicDataSourceContextHolder.setDataSourceRouterKey("default");
        // 其他数据源
        for (Map.Entry<String, DataSourcePropertiesConfiguration> entry : propertiesDatasource.entrySet()) {
            String key = entry.getKey();
            DataSourcePropertiesConfiguration configuration = entry.getValue();
            DataSource source = configuration.initializeDataSource();
            DynamicDataSourceContextHolder.dataSourceIds.add(key);
            customDataSources.put(key, source);
        }
        dynamicDataSource.setTargetDataSources(customDataSources);
        return dynamicDataSource;
    }
}
