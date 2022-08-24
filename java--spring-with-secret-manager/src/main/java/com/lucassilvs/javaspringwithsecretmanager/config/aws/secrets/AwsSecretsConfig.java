package com.lucassilvs.javaspringwithsecretmanager.config.aws.secrets;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@Profile("localstack")
@ConfigurationProperties
@EnableConfigurationProperties
@Component
public class AwsSecretsConfig {

    @Value("${spring.aws.secretsmanager.secretName}")
    private  String secretName;

    @Value("${spring.aws.secretsmanager.endpoint}")
    private  String url;



    @Bean(initMethod = "awsBeanCredentials")
    public void retrieveCredentialsDBConfig(){
        AwsClientBuilder.EndpointConfiguration  config  =  new  AwsClientBuilder.EndpointConfiguration(url, "us-east-1");
        AWSSecretsManagerClientBuilder clientBuilder  =  AWSSecretsManagerClientBuilder.standard();
        clientBuilder.setEndpointConfiguration(config);
        AWSSecretsManager client  =  clientBuilder.build();

        GetSecretValueRequest getSecretValueRequest  =  new  GetSecretValueRequest().withSecretId(secretName);

        GetSecretValueResult getSecretValueResponse  =  null;
        getSecretValueResponse  =  client.getSecretValue(getSecretValueRequest);

         // Decrypted secret using the associated KMS key // Depending on whether the secret was a string or binary, one of these fields will be populated
        String secret = getSecretValueResponse.getSecretString();

        if (secret != null) {
            Map<String, String> map = new Gson().fromJson(secret, Map.class);
            AwsSecretsProperties.setUsername(map.get("username"));
            AwsSecretsProperties.setPassword(map.get("password"));
            AwsSecretsProperties.setUrl(map.get("url"));
            AwsSecretsProperties.setDriverClassName(map.get("driverClassName"));
        }
        else  {
            Logger.getGlobal().log(new LogRecord(Level.WARNING, "The Secret String returned is null"));
        }
    }


}
