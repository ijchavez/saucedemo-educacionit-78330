Feature: Gestión de estados de órdenes

  Scenario: Transición válida de Pending a Processing
    Given el usuario está en la pantalla de estado de orden
    When confirma el pago
    Then el estado de la orden debe ser "Processing"
    And no debe mostrarse mensaje de error

  Scenario: Transición válida de Processing a Shipped
    Given el usuario está en la pantalla de estado de orden
    When confirma el pago
    And marca la orden como enviada
    Then el estado de la orden debe ser "Shipped"
    And no debe mostrarse mensaje de error

  Scenario: Transición válida de Shipped a Delivered
    Given el usuario está en la pantalla de estado de orden
    When confirma el pago
    And marca la orden como enviada
    And marca la orden como entregada
    Then el estado de la orden debe ser "Delivered"
    And no debe mostrarse mensaje de error

  Scenario: Transición válida de Pending a Cancelled
    Given el usuario está en la pantalla de estado de orden
    When cancela la orden
    Then el estado de la orden debe ser "Cancelled"
    And no debe mostrarse mensaje de error

  Scenario: Transición inválida de Pending a Delivered
    Given el usuario está en la pantalla de estado de orden
    When marca la orden como entregada
    Then debe mostrarse un mensaje de error

  Scenario: Transición inválida de Processing a Delivered
    Given el usuario está en la pantalla de estado de orden
    When confirma el pago
    And marca la orden como entregada
    Then debe mostrarse un mensaje de error
