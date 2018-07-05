package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Java configuration class for DB
 */
@Configuration
@PropertySource("classpath:dbprops.properties")
public class DBConfig {
}
