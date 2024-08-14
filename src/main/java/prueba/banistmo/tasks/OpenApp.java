package prueba.banistmo.tasks;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenApp implements Task {
	public static OpenApp open( AppiumDriver<MobileElement>  driver) {
		MobileElement loginScreenElement = driver.findElementById("com.swaglabsmobileapp:id/test-Login");
		if (loginScreenElement == null) {
			throw new IllegalStateException("No se ha podido encontrar la pantalla de inicio de sesión.");
		}
		return new OpenApp();
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		// Aquí abres la aplicación inicial (puede ser mediante una URL o actividad de la app)
		// actor.attemptsTo(Open.url("app://your_app_package_name"));

	}
}

