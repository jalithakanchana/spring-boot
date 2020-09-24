package com.dinitha.testapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EntityScan("com.dinitha.testapp.entity")
@PropertySource(value = { "classpath:application.properties"})
public class DinithaTestApplication {

    private static final Logger LOG = LoggerFactory.getLogger(DinithaTestApplication.class);

    private final Environment env;

    @Autowired
    public DinithaTestApplication(Environment env){
        this.env = env;
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DinithaTestApplication.class);
        Environment env = app.run(args).getEnvironment();
        String host = null;
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException exception) {
            LOG.error("Host not found : ", exception);
        }

        LOG.info(
                "\n----------------------------------------------------------\n\t"
                        + "Application '{}' is running! Access URLs:\n\t" + "Local: \t\thttp://localhost:{}\n\t"
                        + "External: \thttp://{}:{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"), env.getProperty("server.port"), host,
                env.getProperty("server.port"));
    }

}
