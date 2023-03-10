# Swag-Lag

Pruebas automatizadas de la página Swag Lag

## Tecnologías utilizadas

- Selenium 4
- Java
- TestNG
- Maven
- Allure

## Configuracion del proyecto:
En la ruta **src/test/resources** esta el archivo **config.properties** en el cual se pueden modificar las siguientes variables:

    browser=<chrome/edge>
    headless=<true/false>
    timeout=<segundos>
    open_report_auto=<true/false>

Las credenciales del usuario se encuentran en el archivo **profile.properties** ubicado en la ruta **src/test/resources**:

    user<usuario>
    password<contraseña>


## Instalación del proyecto

- Descargar e isntalar alguna version de [JDK8+] (https://www.oracle.com/java/technologies/downloads/)

- Descargar [Allure] (https://github.com/allure-framework/allure2/releases) y agregar como una variable de entorno el path ***"[allure path]/bin"***

- Utilizar **Maven** para descargar todas las dependencias.
  [Descargar de Maven](https://maven.apache.org/download.cgi)
  ***"[Maven path]/bin"***

## Ejecución del proyecto

En el root directory del proyecto ejecutar el siguiente comando

`mvn clean test -DsuitXmlFile=testSuit.xml`

***Nota**: Se debe de tener maven disponible en una variable de entorno o utilizar un IDE que posea Maven previamente configurado.*

Para visualizar el reporte con los resultados de las pruebas se debe ejecutar el siguiente comando:

`./results.bat`
