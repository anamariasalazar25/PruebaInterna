package prueba.banistmo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {
	public static final Target INTRO_CHECKOUT_BUTTON = Target.the("checkout button")
			.located(By.xpath("//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView"));
	public static final Target CONFIRMATION_MESSAGE = Target.the("confirmation message")
			.located(By.xpath("//android.widget.TextView[@text=\"Test.allTheThings() T-Shirt (Red)\"]"));

	public static final Target CHECKOUT_BUTTON_CONTINUE = Target.the("buttom checkout")
			.located(By.xpath("//android.view.ViewGroup[@content-desc='test-CHECKOUT']"));
}

