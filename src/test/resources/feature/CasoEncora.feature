Feature: Prueba de Automatizacion Encora
  Como usuario
  Quiero crearme una cuenta en Parabank
  Para ahorrar dinero

  Background:
    Given Se ingresa a la pagina de Parabank

  @TEST_ENCORA
  Scenario Outline: Validar que al generar una cuenta exitosamente puedo ingresar a la pagina
    Given Hago click en Registar
    And Relleno los campos "<nombre>" "<apellido>" "<direccion>" "<ciudad>" "<estado>""<cod postal>""<telefono>""<ssn>""<usuario>""<contraseña>""<confirmacion>"
    And Doy click en el boton registar
    And Aparece el mensaje de registro correcto y regreso al inicio
    When Estoy en la pagina de inicio
    And Ingreso mis credenciales "<usuario>" y "<contraseña>"
    Then Hago un logeo exitoso
    Examples:
      | nombre | apellido | direccion       | ciudad   | estado      | cod postal | telefono  | ssn          | usuario | contraseña | confirmacion |
      | Jon    | Smith    | calle tulipanes | trujillo | La Libertad | 13007      | 987654321 | 111111111111 | jsmith  | perucho28  | perucho28      |
