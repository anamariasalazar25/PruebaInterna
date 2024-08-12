package prueba.banistmo.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Login implements Task {
	private final String username;
	private final String password;

	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public static Login withCredentials(String username, String password) {
		return new Login(username, password);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Enter.theValue(username).into(LoginPage.USERNAME_FIELD),
				Enter.theValue(password).into(LoginPage.PASSWORD_FIELD),
				Click.on(LoginPage.LOGIN_BUTTON)
		);
	}
}
