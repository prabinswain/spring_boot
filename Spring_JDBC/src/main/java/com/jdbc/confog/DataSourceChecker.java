package com.jdbc.confog;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataSourceChecker {

    private final DataSource dataSource;

    public DataSourceChecker(DataSource dataSource) {
        this.dataSource = dataSource;

    }

    @PostConstruct
    public  void  checkDataSource(){
        System.out.println("datasource classs name " + dataSource.getClass());
    }


}
