package prueba.banistmo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Ensure;
import prueba.banistmo.userinterfaces.CheckoutConfirmationPage;

public class VerifyPurchaseConfirmation implements Task {
	public static VerifyPurchaseConfirmation messageDisplayed() {
		return new VerifyPurchaseConfirmation();
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Ensure.that(CheckoutConfirmationPage.CONFIRMATION_MESSAGE).isDisplayed()
		);
	}
}
