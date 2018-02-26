package com.open.micro.service.config.datasourceConfig;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.open.micro.service.model.enums.DataSourceType;

/**
 * @TargetDataSource 使用在 class 时，表示class下的所有方法都要设置dataSource
 * 当class 和 方法 都使用了@TargetDataSource 时，方法的value值覆盖类的value值
 * @author jiaguang
 *
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface TargetDataSource {
	DataSourceType value() default DataSourceType.PRIMARY;
}