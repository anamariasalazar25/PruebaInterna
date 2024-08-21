package prueba.banistmo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import prueba.banistmo.userinterfaces.InventoryPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import prueba.banistmo.util.AndroidDriverAbility;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

public class AddRedShirtToCart implements Task {
	public static AddRedShirtToCart add() {
		return new AddRedShirtToCart();
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		try {
			AndroidDriver<AndroidElement> driver = (AndroidDriver<AndroidElement>) actor.abilityTo(AndroidDriverAbility.class).getDriver();
			driver.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + "Test.allTheThings() T-Shirt (Red)" + "\"))"
			);
			/*WebDriverWait wait = new WebDriverWait(driver, 10);
			MobileElement viewGroup = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(InventoryPage.ITEM_IMAGE_BY));
			viewGroup.click();*/
			actor.attemptsTo(
					WaitUntil.the(InventoryPage.ITEM_IMAGE, WebElementStateMatchers.isVisible()),
					Click.on(InventoryPage.ADD_TO_CART_BUTTON)
//					WaitUntil.the(InventoryPage.ITEM_IMAGE, WebElementStateMatchers.isVisible())
			);
			/*actor.attemptsTo(
					ScrollToElement.withText("Test.allTheThings() T-Shirt (Red)")
					Scroll.to(InventoryPage.RED_SHIRT),
					Click.on(InventoryPage.ITEM_IMAGE),
					Click.on(InventoryPage.ADD_TO_CART_BUTTON)
			);*/
		} catch (Exception e) {
			throw new RuntimeException("Failed to scroll to the target", e);
		}
		// Verificar que los Targets no sean null
		if (InventoryPage.RED_SHIRT == null || InventoryPage.ADD_TO_CART_BUTTON == null) {
			throw new NullPointerException("Target(s) are not initialized.");
		}

	}
}
