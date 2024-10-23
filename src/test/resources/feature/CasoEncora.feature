Feature: Prueba de Automatizacion Encora
  Como usuario
  Quiero crearme una cuenta en Parabank
  Para ahorrar dinero

  Background:
    Given Se ingresa a la pagina de Parabank

  @TEST_ENCORA
  Scenario Outline: Validar que al generar una cuenta exitosamente puedo ingresar a la pagina
    Given Hago click en Registar
    When Relleno los campos "<nombre>" "<apellido>" "<direccion>" "<ciudad>" "<estado>""<cod postal>""<telefono>""<ssn>""<usuario>""<contraseña>""<confirmacion>"
    And Doy click en el boton registar
    Then Aparece el mensaje de registro correcto
    Examples:
      | nombre | apellido | direccion | ciudad | estado | cod postal | telefono | ssn | usuario | contraseña | confirmacion |
      |        |          |           |        |        |            |          |     |         |            |              |
