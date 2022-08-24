package com.lucassilvs.javaspringwithsecretmanager.config.aws.secrets;

public class AwsSecretsProperties {

    private  static String username;
    private  static String password;
    private  static String url;
    private static String driverClassName;

    private AwsSecretsProperties() {
        throw new IllegalStateException("Classe estatica "+ this.getClass().getName() + " não pode ser instanciada");
    }

    public static String getDriverClassName() {
        return driverClassName;
    }

    public static void setDriverClassName(String driverClassName) {
        AwsSecretsProperties.driverClassName = driverClassName;
    }

    public static void setUsername(String username) {
        AwsSecretsProperties.username = username;
    }

    public static void setPassword(String password) {
        AwsSecretsProperties.password = password;
    }

    public static void setUrl(String url) {
        AwsSecretsProperties.url = url;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static String getUrl() {
        return url;
    }
}
