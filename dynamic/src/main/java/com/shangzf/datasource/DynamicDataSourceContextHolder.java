package com.shangzf.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据源上下文
 */
public class DynamicDataSourceContextHolder {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);

    private static final ThreadLocal<String> HOLDER = new ThreadLocal<>();

    /**
     * 存储已经注册的数据源的key
     */
    public static List<String> dataSourceIds = new ArrayList<>();

    public static String getDataSourceRouterKey() {
        return HOLDER.get();
    }

    public static void setDataSourceRouterKey(String dataSourceRouterKey) {
        logger.info("切换至{}数据源", dataSourceRouterKey);
        HOLDER.set(dataSourceRouterKey);
    }

    public static void removeDataSourceRouterKey() {
        HOLDER.remove();
    }

    /**
     * 判断指定DataSource当前是否存在
     */
    public static boolean containsDataSource(String dataSourceId) {
        return dataSourceIds.contains(dataSourceId);
    }

}
