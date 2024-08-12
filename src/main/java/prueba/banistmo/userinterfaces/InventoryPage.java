package prueba.banistmo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InventoryPage {
	public static final Target RED_SHIRT = Target.the("red shirt")
			.located(By.xpath("//android.widget.TextView[@text='Red Shirt']"));
	public static final Target ADD_TO_CART_BUTTON = Target.the("add to cart button")
			.locatedBy("//android.widget.Button[@content-desc='Add to Cart']");
}
