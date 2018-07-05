package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/**
 * Main Java Configuration class
 */
@Configuration
@PropertySource("classpath:config.properties")
@ComponentScan({"services","utils"})
@Import(DBConfig.class)
public class AppConfig {

    @Bean
    public WebDriver getPhantomJSWebDriver(@Value("${phantomJS.path}") String phantomSystemPath){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomSystemPath);
        return new PhantomJSDriver(caps);
    }



}
