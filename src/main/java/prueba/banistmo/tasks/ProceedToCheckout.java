package prueba.banistmo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import prueba.banistmo.userinterfaces.CartPage;

public class ProceedToCheckout implements Task {
	public static ProceedToCheckout now() {
		return new ProceedToCheckout();
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Click.on(CartPage.CHECKOUT_BUTTON)
		);
	}
}
