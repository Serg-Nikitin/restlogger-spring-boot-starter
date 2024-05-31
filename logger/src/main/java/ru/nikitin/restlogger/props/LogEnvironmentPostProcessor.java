package ru.nikitin.restlogger.props;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Optional;

@Slf4j
public class LogEnvironmentPostProcessor implements EnvironmentPostProcessor {

    private final YamlPropertySourceLoader loader;

    public LogEnvironmentPostProcessor() {
        this.loader = new YamlPropertySourceLoader();
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        var resource = new ClassPathResource("properties.yaml");
        String inKey = "spring.rest-logger.level";

        Optional<String> level = Optional.ofNullable(environment.getProperty(inKey));
        PropertySource<?> propertySource;
        if (level.isPresent() && "debug".equals(level.get())) {
            try {
                propertySource = loader.load("loggingProperties", resource).get(0);
                environment.getPropertySources().addFirst(propertySource);
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}
