package prueba.banistmo.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class AppiumSetup {

    public static AppiumDriver initializeDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        Properties properties = new Properties();
        try (InputStream input = AppiumSetup.class.getClassLoader().getResourceAsStream("serenity.conf")) {
            if (input == null) {
                System.out.println("Sorry, unable to find serenity.properties");
                return null;
            }
            properties.load(input);
            capabilities.setCapability("platformName", properties.getProperty("appium.platformName"));
            capabilities.setCapability("deviceName", properties.getProperty("appium.deviceName"));
            capabilities.setCapability("app", properties.getProperty("appium.app"));
            capabilities.setCapability("automationName", properties.getProperty("appium.automationName"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }
}
