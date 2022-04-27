package com.example.graceful.core;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;

/**
 * description 测试数据库链接配置
 *
 * @author jiangyu-045
 * @date 2022-04-25 16:37
 **/

public class DatabaseTestConfiguration {

    /**
     * description 返回指定版本的 docker 镜像
     * 指定 bean 初始化时启动容器， bean 销毁的时候停止容器以实现容器仅在测试时运行
     * 须等待容器端口启动成功，否则拿不到数据源
     *
     * @return org.testcontainers.containers.MySQLContainer<?>
     * @author jiangyu-045
     * @date 2022/4/25 16:44
     */
    @Bean(initMethod = "start", destroyMethod = "stop")
    public MySQLContainer<?> mySQLContainer() {
        return new MySQLContainer<>("mysql:8.0").waitingFor(Wait.forListeningPort());
    }

    @Bean
    @FlywayDataSource
    public DataSource dataSource(MySQLContainer<?> mySQLContainer) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(mySQLContainer.getJdbcUrl());
        hikariConfig.setUsername(mySQLContainer.getUsername());
        hikariConfig.setPassword(mySQLContainer.getPassword());
        return new HikariDataSource(hikariConfig);
    }


}
