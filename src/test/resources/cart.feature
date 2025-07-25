Feature: Compra de producto desde el carrito

  Como usuario autenticado
  Quiero agregar un producto al carrito
  Y completar el proceso de compra
  Para confirmar que se genera la orden exitosamente

  Scenario: Compra completa del producto "Sauce Labs Backpack"
    Given que el usuario se encuentra en la página de login
    When el usuario inicia sesión con usuario "standard_user" y contraseña "secret_sauce"
    And agrega el producto "Sauce Labs Backpack" al carrito
    And accede al carrito
    And presiona el botón de Checkout
    And completa el formulario de compra con datos válidos
    And confirma la orden
    Then debería ver el mensaje "THANK YOU FOR YOUR ORDER"
    And el texto "Your order has been dispatched, and will arrive just as fast as the pony can get there!"
