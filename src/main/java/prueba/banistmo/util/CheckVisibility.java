package prueba.banistmo.util;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

public class CheckVisibility {

    public static Question<Boolean> isVisible(Target target) {
        return actor -> {
            try {
                WebElement element = target.resolveFor(actor);
                return element.isDisplayed();
            } catch (Exception e) {
                return false;
            }
        };
    }
}
