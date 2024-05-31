package ru.nikitin.restlogger;


import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import ru.nikitin.restlogger.props.RestLoggerProperties;


@ComponentScan()
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
@EnableConfigurationProperties(RestLoggerProperties.class)
@ConditionalOnProperty(prefix = "spring.rest-logger", value = "enabled", havingValue = "true")
@AutoConfiguration
public class LoggerApplication {

}
