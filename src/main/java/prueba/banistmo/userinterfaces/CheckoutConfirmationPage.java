package prueba.banistmo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutConfirmationPage {
	public static final Target CONFIRMATION_MESSAGE = Target.the("confirmation message")
			.located(By.xpath("//android.widget.TextView[@text='Thank you for your order!']"));
}

