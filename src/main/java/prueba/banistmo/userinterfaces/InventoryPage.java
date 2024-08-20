package prueba.banistmo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InventoryPage {
	public static final Target RED_SHIRT = Target.the("Item title")
			.locatedBy("//android.widget.TextView[@content-desc='test-Item title' and @text='Text.allTheThingds() T.Shirt (Red)']");
	public static final Target ADD_TO_CART_BUTTON = Target.the("ADD TO CART button")
			.locatedBy("(//android.widget.TextView[@text='ADD TO CART'])[6]");
}
