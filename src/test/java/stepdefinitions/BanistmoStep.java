import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class PurchaseSteps {

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
		user.attemptsTo(Ensure.that(CheckoutConfirmationPage.CONFIRMATION_MESSAGE).isDisplayed());
	}
}
