package com.shangzf.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

public class DataSourcePropertiesConfiguration {

    private ClassLoader classLoader;

    /**
     * Fully qualified name of the connection pool implementation to use. By default, it
     * is auto-detected from the classpath.
     */
    private Class<? extends DataSource> type;

    /**
     * Fully qualified name of the JDBC driver. Auto-detected based on the URL by default.
     */
    private String driverClassName;

    /**
     * JDBC URL of the database.
     */
    private String url;

    /**
     * Login username of the database.
     */
    private String username;

    /**
     * Login password of the database.
     */
    private String password;

    public DataSource initializeDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(getUrl());
        dataSource.setDriverClassName(determineDriverClassName());
        dataSource.setUsername(getUsername());
        dataSource.setPassword(getPassword());
        //return DataSourceBuilder.create(getClassLoader()).type(getType()).driverClassName(determineDriverClassName())
        //                        .url(getUrl()).username(getUsername()).password(getPassword());
        return dataSource;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public Class<? extends DataSource> getType() {
        return type;
    }

    public void setType(Class<? extends DataSource> type) {
        this.type = type;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String determineDriverClassName() {
        if (StringUtils.hasText(this.driverClassName)) {
            Assert.state(driverClassIsLoadable(), () -> "Cannot load driver class: " + this.driverClassName);
            return this.driverClassName;
        }
        String driverClassName = null;
        if (StringUtils.hasText(this.url)) {
            driverClassName = DatabaseDriver.fromJdbcUrl(this.url).getDriverClassName();
        }
        if (!StringUtils.hasText(driverClassName)) {
            throw new RuntimeException("Failed to determine a suitable driver class");
        }
        return driverClassName;
    }

    private boolean driverClassIsLoadable() {
        try {
            ClassUtils.forName(this.driverClassName, null);
            return true;
        } catch (UnsupportedClassVersionError ex) {
            // Driver library has been compiled with a later JDK, propagate error
            throw ex;
        } catch (Throwable ex) {
            return false;
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
