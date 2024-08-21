package prueba.banistmo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutInformationPage {
	public static final Target FIRST_NAME_FIELD = Target.the("first name field")
			.located(By.xpath("//android.widget.EditText[@content-desc=\"test-First Name\"]"));
	public static final Target LAST_NAME_FIELD = Target.the("last name field")
			.located(By.xpath("//android.widget.EditText[@content-desc=\"test-Last Name\"]"));
	public static final Target POSTAL_CODE_FIELD = Target.the("postal code field")
			.located(By.xpath("//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]"));
	public static final Target CONTINUE_BUTTON = Target.the("continue button")
			.located(By.xpath("//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]"));
}

