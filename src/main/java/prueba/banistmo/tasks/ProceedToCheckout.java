package prueba.banistmo.tasks;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import prueba.banistmo.userinterfaces.CartPage;
import prueba.banistmo.userinterfaces.CheckoutConfirmationPage;
import prueba.banistmo.util.AndroidDriverAbility;

public class ProceedToCheckout implements Task {
	public static ProceedToCheckout now() {
		return new ProceedToCheckout();
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Click.on(CartPage.INTRO_CHECKOUT_BUTTON)
//				WaitUntil.the(CartPage.CONFIRMATION_MESSAGE, WebElementStateMatchers.isVisible())
		);
		AndroidDriver<AndroidElement> driver = (AndroidDriver<AndroidElement>) actor.abilityTo(AndroidDriverAbility.class).getDriver();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\"test-CHECKOUT\"))"
		);
		actor.attemptsTo(
				Click.on(CartPage.CHECKOUT_BUTTON_CONTINUE)
		);
	}
}
