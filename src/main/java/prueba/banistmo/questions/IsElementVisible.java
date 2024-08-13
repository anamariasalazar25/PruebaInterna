package prueba.banistmo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class IsElementVisible implements Question<Boolean> {
	private final Target target;

	public IsElementVisible(Target target) {
		this.target = target;
	}

	public static IsElementVisible forTarget(Target target) {
		return new IsElementVisible(target);
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		return target.resolveFor(actor).isDisplayed();
	}
}

