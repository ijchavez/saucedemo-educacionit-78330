Feature: Filtrado de productos por categoría

  Scenario: Ver frutas al seleccionar categoría "fruta"
    Given que abro la página de productos
    When selecciono la categoría "fruta"
    Then debería ver los productos:
      | Manzana |
      | Banana  |

  Scenario: Ver verduras al seleccionar categoría "verdura"
    Given que abro la página de productos
    When selecciono la categoría "verdura"
    Then debería ver los productos:
      | Zanahoria |
      | Lechuga   |
