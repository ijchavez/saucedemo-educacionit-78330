Feature: Login de usuario

  Como usuario del sistema
  Quiero poder iniciar sesión
  Para recibir una respuesta visual según mi estado

  Scenario Outline: Login con distintos usuarios
    Given que abro la página de login
    When ingreso usuario "<username>" y contraseña "<password>"
    Then debería ver el mensaje debajo "<mensajeEsperado>"

    Examples:
      | username    | password | mensajeEsperado                    |
      | activo      | 1234     | Login exitoso                      |
      | suspendido  | 4567     | Tu cuenta está suspendida          |
      | bloqueado   | 8901     | Tu cuenta ha sido bloqueada        |
      | otro        | 1234     | Credenciales inválidas             |
      | activo      | 0000     | Credenciales inválidas             |
