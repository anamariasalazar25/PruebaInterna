package prueba.banistmo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.GivenWhenThen;
import prueba.banistmo.questions.IsElementVisible;
import prueba.banistmo.userinterfaces.CheckoutConfirmationPage;
import static org.hamcrest.Matchers.is;

public class VerifyPurchaseConfirmation implements Task {
	public static VerifyPurchaseConfirmation messageDisplayed() {
		return new VerifyPurchaseConfirmation();
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.should(
				GivenWhenThen.seeThat("El mensaje de confirmación está visible",
						IsElementVisible.forTarget(CheckoutConfirmationPage.CONFIRMATION_MESSAGE),
						is(true))
		);
	}
}

