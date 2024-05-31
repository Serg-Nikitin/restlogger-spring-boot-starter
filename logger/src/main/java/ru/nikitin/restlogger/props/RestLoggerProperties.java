package ru.nikitin.restlogger.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "rest-logger")
public class RestLoggerProperties {
    private Boolean enabled;
    private String level;
}