package com.lucassilvs.javaspringwithsecretmanager.config.datasource;

import com.lucassilvs.javaspringwithsecretmanager.config.aws.secrets.AwsSecretsProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class CustomDatasource {
    //A anotação @DependOn informa que esse bean só será gerado após o bean método bean RetrieveCredentialsDBConfig
    @Profile("!local")
    @DependsOn("retrieveCredentialsDBConfig")
    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(AwsSecretsProperties.getDriverClassName());
        dataSourceBuilder.url(AwsSecretsProperties.getUrl());
        dataSourceBuilder.username(AwsSecretsProperties.getUsername());
        dataSourceBuilder.password(AwsSecretsProperties.getPassword());
        return dataSourceBuilder.build();
    }
}

