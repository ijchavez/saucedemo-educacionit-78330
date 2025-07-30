Feature: Filtro por edad en tabla estática

  Background:
    Given el usuario abre la página de datos estáticos

  Scenario Outline: Filtrar por edades visibles en un rango
    When selecciona el filtro "<filtro>"
    Then todas las edades visibles deben estar entre <min> y <max>

    Examples:
      | filtro  | min | max |
      | 0-20    | 0   | 20  |
      | 21-40   | 21  | 40  |
      | 41-55   | 41  | 55  |

  Scenario: Filtrar por edad de 60 o más
    When selecciona el filtro "60+"
    Then todas las edades visibles deben ser 60 o más

  Scenario: Mostrar todos los registros
    When selecciona el filtro "all"
    Then deben mostrarse todos los registros
