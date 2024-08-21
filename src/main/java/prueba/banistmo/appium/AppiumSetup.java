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
        String serverUrl="";
        Properties properties = new Properties();
        try (InputStream input = AppiumSetup.class.getClassLoader().getResourceAsStream("appium.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find serenity.properties");
                return null;
            }
            properties.load(input);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, properties.getProperty("appium.platformName"));
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, properties.getProperty("appium.deviceName"));
            capabilities.setCapability(MobileCapabilityType.APP, properties.getProperty("appium.app"));
            capabilities.setCapability("automationName", properties.getProperty("appium.automationName"));
            capabilities.setCapability("avd",properties.getProperty("appium.avd"));
            capabilities.setCapability("appPackage", properties.getProperty("appium.appPackage"));
            capabilities.setCapability("appActivity", properties.getProperty("appium.appActivity"));
            capabilities.setCapability("adbExecTimeout", 3000000);
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600000);

            serverUrl = properties.getProperty("appium.server.url");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return new AndroidDriver(new URL(serverUrl), capabilities);
    }
}
