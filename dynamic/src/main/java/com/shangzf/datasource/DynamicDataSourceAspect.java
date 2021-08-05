package com.shangzf.datasource;

import com.shangzf.datasource.annotation.DS;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(name = {DynamicDatasourcePropertiesConstant.PREFIX + "." + DynamicDatasourcePropertiesConstant.ENABLE}, matchIfMissing = true)
@Aspect
@Order(-5)
@Component
public class DynamicDataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);


    @Before("@annotation(ds)")
    public void changeDataSource(JoinPoint point, DS ds) throws Throwable {
        String dsId = ds.value();
        if (DynamicDataSourceContextHolder.containsDataSource(dsId)) {
            logger.info("使用数据源[{}] > {}", dsId, point.getSignature());
            DynamicDataSourceContextHolder.setDataSourceRouterKey(dsId);
        } else {
            logger.info("数据源[{}]不存在，使用默认数据源 > {}", dsId, point.getSignature());
            DynamicDataSourceContextHolder.setDataSourceRouterKey("default");
        }
    }

    @After("@annotation(ds)")
    public void restoreDataSource(JoinPoint point, DS ds) {
        logger.info("销毁[{}]数据源 > {}", ds.value(), point.getSignature());
        //方法执行完毕之后，销毁当前数据源信息，进行垃圾回收。
        DynamicDataSourceContextHolder.removeDataSourceRouterKey();
    }

}
