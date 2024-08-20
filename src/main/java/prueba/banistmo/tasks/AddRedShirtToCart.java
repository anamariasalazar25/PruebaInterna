package prueba.banistmo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import prueba.banistmo.userinterfaces.InventoryPage;

public class AddRedShirtToCart implements Task {
	public static AddRedShirtToCart add() {
		return new AddRedShirtToCart();
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Scroll.to(InventoryPage.RED_SHIRT),
				Click.on(InventoryPage.ADD_TO_CART_BUTTON)
		);
	}
}
