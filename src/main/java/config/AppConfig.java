package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Main Java Configuration class
 */
@Configuration
@PropertySource("classpath:config.properties")
@ComponentScan({"services","utils"})
@Import(DBConfig.class)
public class AppConfig {
}
