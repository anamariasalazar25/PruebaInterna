package prueba.banistmo.util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.screenplay.Ability;
public class AndroidDriverAbility implements Ability {
    private final AndroidDriver<AndroidElement> driver;

    public AndroidDriverAbility(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

    public static AndroidDriverAbility withDriver(AndroidDriver<AndroidElement> driver) {
        return new AndroidDriverAbility(driver);
    }
}
