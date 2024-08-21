package stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
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
import prueba.banistmo.util.AndroidDriverAbility;
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
		OnStage.setTheStage(Cast.ofStandardActors());
		user = OnStage.theActorCalled("User");
		user.can(AndroidDriverAbility.withDriver((AndroidDriver<AndroidElement>) driver));
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
