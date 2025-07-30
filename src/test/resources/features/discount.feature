Feature: Cálculo de descuento

  Scenario Outline: Calcular descuento en diferentes condiciones
    Given que ingreso a la página de descuentos
    When selecciono membresía "<membresia>", monto "<monto>", método "<metodo>", promoción especial <promo>
    Then debería ver el resultado "<resultado>"

    Examples:
      | membresia | monto | metodo     | promo       | resultado |
      | regular   | 100   | credit     | activada    | 15%       |
      | premium   | 100   | paypal     | desactivada | 12%       |
      | regular   | 600   | paypal     | desactivada | 7%        |
      | premium   | 100   | credit     | desactivada | 10%       |
      | regular   | 600   | credit     | desactivada | 5%        |
      | regular   | 400   | transfer   | desactivada | 0%        |
      | premium   | 400   | transfer   | desactivada | 10%       |
      | regular   | 600   | transfer   | desactivada | 5%        |
      | premium   | 1000  | transfer   | activada    | 15%       |
