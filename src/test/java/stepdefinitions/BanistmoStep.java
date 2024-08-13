
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import prueba.banistmo.tasks.*;

public class BanistmoStep {

	@Managed(driver = "appium")
	WebDriver driver;

	private Actor user = Actor.named("User");

	@Before
	public void setUp() {
		user.can(BrowseTheWeb.with(driver));
	}

	@Given("el usuario está en la pantalla de inicio de sesión")
	public void elUsuarioEstaEnLaPantallaDeInicioDeSesion() {
		user.attemptsTo(OpenApp.open());
	}

	@When("el usuario inicia sesión con usuario {string} y contraseña {string}")
	public void elUsuarioIniciaSesion(String username, String password) {
		user.attemptsTo(Login.withCredentials(username, password));
	}

	@When("el usuario añade una camisa roja al carrito")
	public void elUsuarioAnadeUnaCamisaRojaAlCarrito() {
		user.attemptsTo(AddRedShirtToCart.add());
	}

	@When("el usuario procede al checkout")
	public void elUsuarioProcedeAlCheckout() {
		user.attemptsTo(ProceedToCheckout.now());
	}

	@When("el usuario ingresa la información de pago con nombre {string}, apellido {string}, y código postal {string}")
	public void elUsuarioIngresaInformacionDePago(String firstName, String lastName, String postalCode) {
		user.attemptsTo(EnterPaymentInformation.withDetails(firstName, lastName, postalCode));
	}

	@Then("el usuario debería ver la pantalla de confirmación de compra")
	public void elUsuarioDeberiaVerLaPantallaDeConfirmacionDeCompra() {
		//user.attemptsTo(Ensure.that(CheckoutConfirmationPage.CONFIRMATION_MESSAGE).isDisplayed());
	}
}
