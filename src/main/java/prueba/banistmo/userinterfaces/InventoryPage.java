package prueba.banistmo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InventoryPage {
	public static final String TEXTO="Test.allTheThings() T-Shirt (Red)";
	public static final Target RED_SHIRT = Target.the("Item title")
			.located(By.xpath("//android.widget.TextView[@content-desc='test-Item title' and @text='"+TEXTO+"']"));
	public static final Target ITEM_IMAGE = Target.the("Item image")
			.located(By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[4]/android.view.ViewGroup/android.widget.ImageView"));
	public static final By ITEM_IMAGE_BY = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[4]/android.view.ViewGroup/android.widget.ImageView");

	public static final By ADD_TO_CART_BUTTON = By.xpath("//android.widget.TextView[@content-desc='test-Item title' and @text='"+TEXTO+"']/following-sibling::android.view.ViewGroup[@content-desc='test-ADD TO CART']");
//			By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[4]");
}
