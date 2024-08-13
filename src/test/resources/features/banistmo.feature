Feature: Flujo de inicio de sesión y compra

  @EscenarioPrincipal
  Scenario: Usuario realiza una compra exitosa de una camisa roja
    Given el usuario está en la pantalla de inicio de sesión
    When el usuario inicia sesión con usuario "standard_user" y contraseña "secret_sauce"
    And el usuario añade una camisa roja al carrito
    And el usuario procede al checkout
    And el usuario ingresa la información de pago con nombre "John", apellido "Doe", y código postal "12345"
    Then el usuario debería ver la pantalla de confirmación de compra


