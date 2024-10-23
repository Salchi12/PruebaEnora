# README #

Este archivo contiene los pasos necesarios para ejecutar la solución de automatización de pruebas.

* Set Up
* Execute
* About


## Set Up

**Instalacion y configuracion Gradle**
1. Descargar e instalar la versión completa de gradle 8.9 desde el sitio web: [Descarga de Gradle](https://gradle.org/next-steps/?version=8.9&format=bin)

2. Crear la carpeta gradle en al siguiente ruta : `C:\Users\[nombre_Usuario]\.gradle\`

3. Configuración de la variable de entorno GRADLE_HOME :

* En Variable del sistema, haga clic en Nuevo para agregar una nueva variable con el nombre GRADLE_HOME o, si existe la variable GRADLE_HOME, selecciónela y haga clic en editar.
* Ahora ingrese la ruta de instalación de Gradle como valor (por ejemplo, `C:\gradle\gradle-8.9` )

4. Configuración de la variable de entorno PATH :

* Ir a "Variables de entorno" y agregar la carpeta de instalación de Gradle (por ejemplo, `%GRADLE_HOME%\bin` ) a la variable PATH en User Variables.

5. Validar instalacion
* Abrir y copiar el siguiente comando en una shell de windows `gradle -version`

### Configuración de variables de ambiente

### Configuración de variables dentro de la solución de automatización de pruebas
Dentro del archivo <code>serenity.properties</code> modificar de ser necesario las siguientes variables:

| Nombre de propiedad                                                        | Descripción                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
|----------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| serenity.project.name                                                      | Especifica el nombre del proyecto.                                                                                                                                                                                                                                                                                                                                                                                                                               |
| report.customfields.ApplicationVersion                                     | Especifica la versión de la aplicación que se está probando.                                                                                                                                                                                                                                                                                                                                                                                                     |
| report.customfields.environment                                            | Especifica en qué ambiente se están ejecutando las pruebas. Ej. UAT, DEV, STG.                                                                                                                                                                                                                                                                                                                                                                                   |
| report.customfields.user                                                   | Especifica el usuario que está ejecutando las pruebas.                                                                                                                                                                                                                                                                                                                                                                                                           |
| report.customfields.squad                                                  | Especifica el nombre del equipo que está ejecutando las pruebas automatizadas.                                                                                                                                                                                                                                                                                                                                                                                   |
| traceability.integration.jira.report-attachment                            | Especifica si se adjuntará el reporte de resultados de pruebas en Jira. <br/>Admite los valores <code>true</code>/<code>false</code>. <br/><br/> **Nota:** Tomar en consideración que no deben tener espacios. |                                                                                                                                                                                                                                                                                                                             |
| traceability.manager.execution.source                                      | Especifica desde dónde se ejecutará la integración con Xray/Jira, si es local o desde el pipeline. <br/>Admite los valores <br/><code>local</code>: En caso se desee realizar la integración de manera local. <br/><code>remote</code>: Cuando la integración se va a manejar por medio de la pipeline, <br/><code>none</code>: En caso que no se desee realizar ningún tipo de integración con Jira/Xray. <br/><br/> **Nota:** Tomar en consideración que no deben tener espacios. |
| traceability.integration.xray.synchcronization                             | Especifica si se realizará la sincronización de los archivos .feature con Jira. Admite los valores <code>true</code>/<code>false</code>. <br/><br/> **Nota:** Tomar en consideración que no deben tener espacios. |                                                                                                                                                                                                                                                                                                                                    |


## Execute

**Configuracion de Variables por Ambiente - serenity.conf**
* En el archivo serenity.conf almacena las variables que posteriormente se configuraran para ser usadas de acuerdo al ambiente requerido
```
environments {
    default {
        restapi.baseurl.zippopotam = "https://api.zippopotam.us"
        restapi.baseurl.regresIn = "https://reqres.in"
        restapi.baseurl.petstore = "https://petstore.swagger.io"
        graphql.baseurl.netlify = "https://swapi-graphql.netlify.app"
    }
    dev {
        restapi.baseurl.zippopotam = "https://api.zippopotam.us"
        restapi.baseurl.extern = "https://apis.dev.interbank.pe"
        restapi.baseurl.intern = "https://api.dev.interbank.per"
        restapi.baseurl.regresIn = "https://reqres.in"
    }
    uat {
        restapi.baseurl.zippopotam = "https://api.zippopotam.us"
        restapi.baseurl.extern = "https://apis.uat.interbank.pe"
        restapi.baseurl.intern = "https://api.uat.interbank.per"
        restapi.baseurl.regresIn = "https://reqres.in"
    }
}
```
* De no contarse con el archivo `serenity.conf` o estar esta vacia es de importancia solicitarla ya que la ejecucion de casos fallara

**Estructura de los tags de ejecución**
* Los tags de los features estan conformados por 3 areas principales, la primera correspondiente a los tags del jira y el segundo correspondiente a tags de flujo y el ultimo a tags opcionales.

**1. Tags referentes a jira**
* Tags correspondientes a los casos mostrados en el Jira-Xray

```bash
Test Execution el cual representa a un feature y esta definido por [@JIRA01]
[@JIRA01]
Característica: ...
@JIRA02 @JIRA03
Escenario: ...
```

```bash
Test Case @tag por el cual representa a un escenario y esta definido por [@JIRA02]
@JIRA01
Característica: ...
[@JIRA02] @JIRA03
Escenario: ...
```

```bash
Test Set @tag por el cual representa a un grupo de escenarios y esta definido por [@JIRA03]
@JIRA01
Característica: ...
@JIRA02 [@JIRA03]
Escenario: ...
```

**2. Tags de flujo**
* Tags correspondientes a el ambiente, tipos de test, al flujo y a los microservicios que intervienen en el flujo.

|TAG              |DEFINICIÓN|
|-----------------|----------|
|@uat             |Casos del ambiente de uat|
|@dev             |Casos del ambiente de dev|
|@happyPath       |Casos de happy path, casos que no arrojan mensajes de error|
|@unHappyPath     |Casos de unhappy path, casos de errores|
|@regression      |Todos los casos menos los que necesiten de la activación de los mocks|
|@smokeTest       |Casos correctos o críticos, verifica la estabilidad del servicio, también comprende los casos de ejecución diaria.|
|@sanityTest      |Casos de nuevas funciones o bug fixes|
|@regressionMock  |Para los casos que requieran la activación de los mocks|

**3. Tags opcionales**
* No existe limite de tags, pero se recomienda no colocar demasiados tags para que no sea difícil de entender.

```bash
Orden de tags
@JIRA-CASE01 @JIRA-SET01 @(uat|dev) @(happyPath|unhappyPath)
@(regression|regressionMock) @smokeTest @sanityTest 
@tagOpcional01 @tagOpcional02
```

**Ejecucion Gradle**

Para ejecutar el proyecto de manera local con las configuraciones por <code>default</code> y generar el reporte puede usar el siguiente comando.
```shell
gradle build test
```

Ejecuta los siguientes comandos para obtener un resultado mas personalizado
```shell
gradle build test -Denvironment=xxx -Dcucumber.filter.tags="@tag"
```

**Nota:**
* Reemplazar <code>@tag</code> por el tag de ejecucion del escenario, grupo de escenarios o feature

* Reemplazar <code>xxxx</code> por el nombre del ambiente configurado en el archivo serenity.conf

Tambien es posible ejecutar varios tags a la vez
```shell
gradle test reports -Denvironment=uat -Dcucumber.filter.tags="@JIRA0000 and @uat"`
```


## Informe en Serenity
1. Abrir el reporte generado en al ruta : `target\site\serenity\index.html`
## About
###  Estructura de paquetes
El template de pruebas automatizadas cuenta con la siguiente estructura:

````text 
sigla_app-functional_purpose-test-web/                        
├───devops
│   ├───pipelines
│   ├───templates
│   │   └───jobs
│   └───variables
├───src
│   ├───main
│   │   └───java
│   │       └───pe
│   │           └───interbank
│   │               └───dso
│   │                   ├───exceptions
│   │                   ├───interaction
│   │                   │   ├───package1
│   │                   │   └───package1
│   │                   ├───model
│   │                   ├───question
│   │                   │   └───package1
│   │                   │   └───package2
│   │                   ├───tasks
│   │                   ├───userInterface
│   │                   └───util
│   └───test
│       ├───java
│       │   └───pe
│       │       └───interbank
│       │           └───dso
│       │               ├───runner
│       │               ├───stepdefinition
│       │               └───util
│       └───resources
│           ├───asset
│           ├───driver
│           └───feature


````

> Para ver mayor detalle del arquetipo accede al repositorio [ibkteam/ads-web-testing-archetype](https://bitbucket.org/ibkteam/ads-web-testing-archetype/src/master/README.md).

## Who do I talk to?

- Propietario o administrador del repositorio
- Otro contacto del equipo