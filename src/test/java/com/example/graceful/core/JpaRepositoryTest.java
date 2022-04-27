package com.example.graceful.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * description jpa repository 测试 复合注解
 * 引入 DatabaseTestConfiguration 则使用 container 构建 docker 数据库进行测试
 * 不引入则默认使用项目配置的数据库进行测试
 * DataJpaTest 注解仅启动 jpa 相关
 * 若不声明 AutoConfigureTestDatabase 注解 replace 属性为 NONE 则 spring 会默认使用自带的 H2 内存数据库替换数据源
 *
 * @author jiangyu-045
 * @date 2022-04-25 17:05
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@DataJpaTest
//@Import(DatabaseTestConfiguration.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public @interface JpaRepositoryTest {
}
