package prueba.banistmo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
	public static final Target USERNAME_FIELD = Target.the("username field")
			.located(By.xpath("//*[@content-desc='test-Username']"));
	public static final Target PASSWORD_FIELD = Target.the("password field")
			.located(By.xpath("//*[@content-desc='test-Password']"));
	public static final Target LOGIN_BUTTON = Target.the("login button")
			.located(By.xpath("//*[@content-desc='test-LOGIN']"));
}

