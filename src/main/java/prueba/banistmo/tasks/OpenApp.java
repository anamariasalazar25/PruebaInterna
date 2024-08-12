package prueba.banistmo.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenApp implements Task {
	public static OpenApp open() {
		return new OpenApp();
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		// Aquí abres la aplicación inicial (puede ser mediante una URL o actividad de la app)
		actor.attemptsTo(Open.url("app://your_app_package_name"));
	}
}

