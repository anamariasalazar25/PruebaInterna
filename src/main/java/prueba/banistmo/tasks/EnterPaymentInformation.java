package prueba.banistmo.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;

public class EnterPaymentInformation implements Task {
	private final String firstName;
	private final String lastName;
	private final String postalCode;

	public EnterPaymentInformation(String firstName, String lastName, String postalCode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.postalCode = postalCode;
	}

	public static EnterPaymentInformation withDetails(String firstName, String lastName, String postalCode) {
		return new EnterPaymentInformation(firstName, lastName, postalCode);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Enter.theValue(firstName).into(CheckoutInformationPage.FIRST_NAME_FIELD),
				Enter.theValue(lastName).into(CheckoutInformationPage.LAST_NAME_FIELD),
				Enter.theValue(postalCode).into(CheckoutInformationPage.POSTAL_CODE_FIELD),
				Click.on(CheckoutInformationPage.CONTINUE_BUTTON)
		);
	}
}
