package prueba.banistmo.tasks;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.slf4j.Logger;
import prueba.banistmo.appium.AppiumSetup;
import prueba.banistmo.util.TestUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class OpenApp implements Task {

	private AppiumDriver<?> driver;
	private Properties config;

	public OpenApp(AppiumDriver<?> driver) {
		this.driver = driver;
		config= new Properties();
		try (InputStream input = AppiumSetup.class.getClassLoader().getResourceAsStream("appium.properties")) {
			if (input == null) {
				System.out.println("Sorry, unable to find serenity.properties");
				return;
			}
			config.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public static OpenApp open(AppiumDriver<?> driver) {
		return new OpenApp(driver);
	}

	@Override
	public void performAs(Actor actor) {
		if(config!=null){
			String appium = config.getProperty("appium[appPackage]");
			String appPackage = config.getProperty("appium.appPackage");
			String appActivity = config.getProperty("appium.appActivity");
			System.out.println(appPackage +" "+ appActivity);
			if (appPackage == null || appActivity == null) {
				throw new RuntimeException("appPackage or appActivity property not found in serenity.conf");
			}
		}else {
			throw new RuntimeException("appPackage or appActivity property not found in serenity.conf");
		}
	}
}
