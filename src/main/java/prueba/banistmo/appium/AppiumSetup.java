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
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, properties.getProperty("appium.platformName"));
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, properties.getProperty("appium.deviceName"));
            capabilities.setCapability(MobileCapabilityType.APP, properties.getProperty("appium.app"));
            capabilities.setCapability("app","D:\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, properties.getProperty("appium.automationName"));
            capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
            capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
            capabilities.setCapability("adbExecTimeout", 3000000);
            capabilities.setCapability("uiautomator2ServerLaunchTimeout", 3000000);
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
