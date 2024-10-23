#Autor: Luis Retamozo

  Feature: Apertura de cuenta millonaria
    Como usuario
    Quiero aperturar una cuenta millonaria
    Para ser millonario

    Background:
      Given Se ingresa a la pagina de interbank

    @TEST_DPXD-2 @regresion
      Scenario: Validar que al generar una cuenta millonario se solicite un correo de seguridad
        When selecciona abre tu cuenta
#        And digito mi dni "<dni>" correo "<correo>" celular "<celular>"
#        And selecciono la opción siguiente
#        Then el sistema me debe mostrar la pantalla de identificacion "Te enviaremos un código de verificación para que continúes. Elige dónde quisieras recibirlo:"
#        Examples:
#          | dni      | correo                            | celular   |
#          | 44147611 | lhuyz87@gmail.com | 992937222 |



