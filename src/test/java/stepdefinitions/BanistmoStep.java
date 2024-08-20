package stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import prueba.banistmo.appium.AppiumSetup;
import prueba.banistmo.questions.IsElementVisible;
import prueba.banistmo.tasks.*;
import prueba.banistmo.userinterfaces.CheckoutConfirmationPage;
import prueba.banistmo.userinterfaces.LoginPage;
import prueba.banistmo.util.CheckVisibility;

import java.net.MalformedURLException;

import static org.hamcrest.Matchers.is;

public class BanistmoStep {

	@Managed(driver = "appium")
	AppiumDriver driver;

	private Actor user = Actor.named("User");

	@Before
	public void setUp() throws MalformedURLException {
		driver = AppiumSetup.initializeDriver();
		// Configura la escena de actores
		OnStage.setTheStage(Cast.ofStandardActors());
		// Configura el actor 'user' para que pueda navegar por la web
		user.can(BrowseTheWeb.with(driver));
		// Agrega al actor 'user' al escenario de OnStage
		OnStage.theActorCalled("User").can(BrowseTheWeb.with(driver));
	}

	@Given("^el usuario está en la pantalla de inicio de sesión$")
	public void elUsuarioEstaEnLaPantallaDeInicioDeSesion() {
		user.attemptsTo((Performable) OpenApp.open(driver));

		OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(CheckVisibility.isVisible(LoginPage.LOGIN_BUTTON)));
		OnStage.theActorInTheSpotlight().attemptsTo(
				Click.on(LoginPage.LOGIN_BUTTON)
		);
	}

	@When("^el usuario inicia sesión con usuario y contraseña$")
	public void elUsuarioIniciaSesionConUsuarioYContrasena() {
		user.attemptsTo(Login.withCredentials("standard_user", "secret_sauce"));
	}


	@And("el usuario añade una camisa roja al carrito")
	public void elUsuarioAnadeUnaCamisaRojaAlCarrito() {
		user.attemptsTo(AddRedShirtToCart.add());
	}

	@And("el usuario procede al checkout")
	public void elUsuarioProcedeAlCheckout() {
		driver.findElement(new MobileBy.ByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
						+ "new UiSelector().description(\"Text.allTheThingds()\"));"));
		user.attemptsTo(ProceedToCheckout.now());
	}

	@And("el usuario ingresa la información de pago con nombre, apellido, y código postal")
	public void elUsuarioIngresaInformacionDePago() {
		// el usuario ingresa la información de pago con nombre "John", apellido "Doe", y código postal "12345"
		user.attemptsTo(EnterPaymentInformation.withDetails("John", "Doe", "12345"));
	}

	@Then("^el usuario debería ver la pantalla de confirmación de compra$")
	public void elUsuarioDeberiaVerLaPantallaDeConfirmacionDeCompra() {
		OnStage.theActorInTheSpotlight().should(
				GivenWhenThen.seeThat("El mensaje de confirmación está visible",
						IsElementVisible.forTarget(CheckoutConfirmationPage.CONFIRMATION_MESSAGE),
						is(true))
		);
	}
}
