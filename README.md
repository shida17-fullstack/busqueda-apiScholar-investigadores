# Acerca de: Aplicación Java con Estructura Modelo Vista Controlador (MVC) - Conexión a SerpApi Google Scholar Profile y Autor y MySQL

## Objetivo del Proyecto

El objetivo principal de este proyecto es desarrollar una aplicación Java que utilice la arquitectura Modelo Vista Controlador (MVC) para buscar y recopilar información detallada sobre investigadores reconocidos de universidades del norte de México. La conexión a las APIs de SerpApi, específicamente Google Scholar Profile y Autor, será fundamental para obtener datos precisos y enriquecidos sobre los investigadores. Además, se ha implementado la funcionalidad de guardar estos datos en una base de datos MySQL utilizando el conector JDBC.

## Características del Proyecto

### Tecnologías Utilizadas

- Java: JDK 21
- Gestión de Dependencias: Gradle 8.5
- Base de Datos: MySQL 8.3.0
- Connector JDBC: mysql-connector-java 8.0.23


### Arquitectura MVC (Modelo Vista Controlador)

- **Model (Modelo):** Encargado de gestionar los datos y la lógica del negocio. Almacenará y estructurará la información recopilada de los investigadores.Se ha modificado el archivo ScholarInvestigatorModel.java para incluir la funcionalidad de guardar datos en la base de datos MySQL.

  
- **View (Vista):** Responsable de la presentación de la información al usuario. Permitirá visualizar informes, estadísticas y resultados visuales de manera clara y organizada.
  
- **Controller (Controlador):** Actúa como intermediario entre el modelo y la vista. Gestionará las interacciones del usuario y las actualizaciones en el modelo, asegurando una comunicación eficiente.


## Configuración de Conexión a la Base de Datos MySQL

Para establecer una conexión exitosa con la base de datos MySQL, asegúrate de tener los siguientes elementos instalados y configurados:

### 1. MySQL Server

Asegúrate de tener un servidor MySQL en ejecución. Puedes descargar e instalar MySQL Server desde el [sitio oficial de MySQL](https://dev.mysql.com/downloads/mysql/).

### 2. MySQL Connector

El proyecto utiliza el conector MySQL JDBC para facilitar la comunicación entre la aplicación Java y la base de datos MySQL. Puedes obtener el conector MySQL JDBC desde el [sitio oficial de MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/).

### 3. Cliente MySQL (Opcional)

Para interactuar directamente con la base de datos a través de la línea de comandos, puedes instalar un cliente MySQL. Puedes descargar el cliente MySQL desde el [sitio oficial de MySQL](https://dev.mysql.com/downloads/mysql/).

Asegúrate de tener las configuraciones correctas en el archivo `BDConnect.java` ubicado en la carpeta `baseDatos` dentro de `src/main/java/baseDatos/`. Los parámetros de conexión, como la URL (`JDBC_URL`), el nombre de usuario (`USER`) y la contraseña (`PASSWORD`), deben coincidir con la configuración de tu servidor MySQL.


```java

// Archivo: BDConnect.java

package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnect {
    // Configuración de la conexión
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ScholarAuthor";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Método para obtener la conexión a la base de datos
    public static Connection getConnection() {
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Obtener la conexión
            return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al conectar a la base de datos");
        }
    }
}

```

Asegúrate de modificar los siguientes valores según tu configuración:

**JDBC_URL:** Reemplaza con la dirección de tu servidor de base de datos MySQL. Puede ser la dirección IP del servidor o el nombre del host, seguido del número de puerto y el nombre de la base de datos.

**USER:** Reemplaza con tu nombre de usuario para acceder a la base de datos.

**PASSWORD:** Reemplaza con tu contraseña de acceso a la base de datos.

## Ejemplo modificado:

```java

// Archivo: BDConnect.java

package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnect {
    // Configuración de la conexión
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mi_base_de_datos";
    private static final String USER = "mi_usuario";
    private static final String PASSWORD = "mi_contraseña";

    // Método para obtener la conexión a la base de datos
    public static Connection getConnection() {
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Obtener la conexión
            return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al conectar a la base de datos");
        }
    }
}


```
Guarda los cambios en el archivo. Esta configuración debe coincidir con la configuración de tu servidor MySQL. Asegúrate de tener un servidor MySQL en ejecución y accesible desde la aplicación Java. Además, modifica estos valores con precaución, ya que contienen información sensible como nombre de usuario y contraseña.

### Comandos para Ver la Tabla de la Base de Datos
Puedes utilizar los siguientes comandos SQL en Git Bash para ver la tabla de investigadores en la base de datos:

## Conectar a MySQL en otra consola:

Si estás utilizando una consola diferente para conectarte a MySQL, puedes utilizar el siguiente comando. 

```bash

/d/Usuario/Descargas/mysql-8.3.0-winx64/bin/mysql -u root -p

```
Este comando se usa para iniciar una sesión de MySQL desde la línea de comandos. Al ejecutarlo, se te pedirá ingresar la contraseña del usuario root para acceder a MySQL.

Recuerda que esta ruta ficticia es solo un ejemplo. Asegúrate de proporcionar la ruta correcta hasta el directorio bin de tu instalación de MySQL en tu sistema.


Seleccionar la base de datos:


```bash

USE nombre_de_tu_base_de_datos;

```

Mostrar la tabla de investigadores:

```bash

SELECT * FROM scholar_autor;

```
### Aclaración sobre la Conexión a MySQL

Es importante mencionar que, además de utilizar la línea de comandos para interactuar con MySQL, existen otras formas de administrar y visualizar la base de datos. Puedes explorar herramientas gráficas como MySQL Workbench o DBeaver, que ofrecen interfaces intuitivas para gestionar bases de datos MySQL. Asegúrate de configurar estas herramientas con la misma información de conexión que se encuentra en BDConnect.java para garantizar la coherencia en la administración de la base de datos.
.-P
## Cambios en la Estructura del Proyecto
Se han realizado modificaciones en la estructura del proyecto. Los archivos afectados incluyen:

**ScholarInvestigatorModel.java:** Se ha actualizado para incluir la funcionalidad de guardar datos en la base de datos MySQL.
**BDConnect.java:** Nuevo archivo que gestiona la conexión a la base de datos MySQL.

## Captura de la Consola MySQL
A continuación, se presenta una captura de la consola de MySQL después de ejecutar los comandos mencionados:

![Consola Mysql](/src/main/resources/capturas/consola/Segunda_ConsolaMysql_02.png)

## Funcionalidades Específicas

- **Conexión a SerpApi:** Implementación de peticiones GET a las APIs de SerpApi (Google Scholar Profile y Autor) para obtener datos detallados de investigadores.

- **Estructuración de Datos:** Modelado eficiente de la estructura de datos para almacenar y gestionar la información en el modelo de acuerdo con los resultados obtenidos de SerpApi.

- **Conexión a Base de Datos:** Integración de una base de datos MySQL para almacenar y gestionar datos de investigadores. La clase BDConnect en la carpeta baseDatos se encarga de la configuración y conexión a la base de datos.

- **Desarrollo bajo Patrón MVC:** Implementación y adherencia estricta al patrón Modelo Vista Controlador para garantizar una estructura de código organizada y modular.

- **Presentación de Resultados:** Utilización de la vista para presentar de manera clara y comprensible los resultados obtenidos por consola, ya sea a través de informes, mensajes, gráficos textuales u otros medios visuales en la interfaz de la consola.

- **Integración con SerpApi Google Scholar Profile y Autor**

- **Enriquecimiento de Datos:** Utilización de SerpApi para mejorar y complementar la información recopilada, garantizando datos precisos y actualizados.

- **Optimización de Resultados:** La conexión a SerpApi permite optimizar la calidad de los resultados, mejorando la presentación de informes visuales y ofreciendo una experiencia más completa al usuario.

## Contenido - Carpetas y Archivos

- **bin:** Carpeta que contiene los archivos compilados y ejecutables de la aplicación.
  - **app:** Almacena el archivo ejecutable App.class.
  - **controller:** Contiene el controlador ScholarInvestigatorController.class.
  - **model:** Guarda el modelo ScholarInvestigatorModel.class.
  - **utils:** Incluye clases de utilidades como ConfigExample.class, y SerpApiRequest.class.
  - **view:** Contiene la vista Author.class y ScholarInvestigatorView.class.

- **build:** Carpeta generada durante el proceso de construcción del proyecto.
  - **classes:** Contiene las clases compiladas.
  - **generated:** Carpeta que guarda recursos generados durante la construcción.
  - **libs:** Contiene el archivo JAR ejecutable busqueda-apiScholar-investigadores.jar.

- **gradle:** Carpeta relacionada con la configuración de Gradle.
  - **wrapper:** Contiene archivos esenciales para el funcionamiento del wrapper de Gradle.
  
- **gradle-8.5-bin:** Carpeta que contiene los archivos esenciales de Gradle versión 8.5.

- **src:** Carpeta principal que contiene el código fuente de la aplicación.
  - **main:** Carpeta principal de código fuente.
    - **java:** Contiene el código fuente en Java.
      - **app:** Contiene el archivo principal App.java.
      - **baseDatos:** Contiene el archivo BDConnect.java para la conexión a la base de datos MySQL **AGREGADO**
      - **controller:** Contiene ScholarInvestigatorController.java.
      - **model:** Contiene ScholarInvestigatorModel.java.**MODIFICADO**
      - **utils:** Contiene clases de utilidades como Config.java, ConfigExample.java, y SerpApiRequest.java.
      - **view:** Contiene las clases de vista Author.java y ScholarInvestigatorView.java.
    - **resources:** Contiene recursos adicionales.
      - **capturas:** Carpeta que guarda capturas de pantalla.
      **consola:** Contiene capturas de la consola.

		   Consola_Mysql_01.png: **AGREGADO**
	       Consola_Mysql_02.png: **AGREGADO**
	       Segunda_ConsolaMysql_01.png: **AGREGADO**
	       Segunda_ConsolaMysql_02.png: **AGREGADO**
	       Segunda_ConsolaMysql_03.png: **AGREGADO**
	       Segunda_ConsolaMysql_04.png: **AGREGADO**
	       Segunda_ConsolaMysql_05.png: **AGREGADO**
	       Tercera_Consola-GradleBuild-Run.png: **AGREGADO**

## Cambio de Clave Secreta

### Configuración de Clave Secreta en `ConfigExample.java`

En el archivo `ConfigExample.java` ubicado en la carpeta `utils`, se proporciona un ejemplo para configurar la clave secreta de SerpApi Google Scholar Profile y Author. Sigue estos pasos:

1. Abre el archivo `ConfigExample.java`.
2. Localiza la variable `API_KEY` y reemplaza `"YOUR_API_KEY_HERE"` con tu clave secreta proporcionada por SerpApi.

Recuerda que `ConfigExample.java` es un ejemplo, y la configuración real debe realizarse en el archivo `Config.java` para garantizar la seguridad de la clave secreta.


## Dependencias

```gradle

dependencies {
	    implementation 'com.fasterxml.jackson.core:jackson-databind:2.13.0'
	    implementation 'com.fasterxml.jackson.core:jackson-annotations:2.13.0'
	    implementation 'com.fasterxml.jackson.core:jackson-core:2.13.0'
	    implementation 'mysql:mysql-connector-java:8.0.23' 
	   
	}

```

Estructura del proyecto

```plaintext
  

busqueda-apiScholar-investigadores
├── bin
│   └── main
│       ├── app
│       │   └── App.class
│       ├── controller
│       │   └── ScholarInvestigatorController.class
│       ├── model
│       │   └── ScholarInvestigatorModel.class
│       ├── utils
│       │   ├── Config.class
│       │   ├── ConfigExample.class
│       │   └── SerpApiRequest.class
│       └── view
│           ├── Author.class
│           └── ScholarInvestigatorView.class
├── build
│   ├── classes
│   │   └── java
│   │       └── main
│   │           ├── app
│   │           │   └── App.class
│   │           ├── controller
│   │           │   └── ScholarInvestigatorController.class
│   │           ├── model
│   │           │   └── ScholarInvestigatorModel.class
│   │           ├── utils
│   │           │   ├── Config.class
│   │           │   ├── ConfigExample.class
│   │           │   └── SerpApiRequest.class
│   │           └── view
│   │               ├── Author.class
│   │               └── ScholarInvestigatorView.class
│   ├── generated
│   │   └── sources
│   │       ├── annotationProcessor
│   │       │   └── java
│   │       └── headers
│   │           └── java
│   └── libs
│       └── busqueda-apiScholar-investigadores.jar
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradle-8.5-bin
│   └── gradle-8.5
│       ├── LICENSE
│       ├── NOTICE
│       ├── README
│       ├── bin
│       │   ├── gradle
│       │   └── gradle.bat
│       ├── init.d
│       │   └── readme.txt
│       └── lib
│           ├── HikariCP-4.0.3.jar
│           ├── ... (otros archivos de la biblioteca de Gradle)
├── src
│   └── main
│       ├── java
│       │   ├── app
│       │   │   └── App.java
│       │   │── baseDatos
│       │   │   └── BDConnect.java
│       │   ├── controller
│       │   │   └── ScholarInvestigatorController.java
│       │   ├── model
│       │   │   └── ScholarInvestigatorModel.java
│       │   ├── utils
│       │   │   ├── Config.java
│       │   │   ├── ConfigExample.java
│       │   │   └── SerpApiRequest.java
│       │   └── view
│       │       ├── Author.java
│       │       └── ScholarInvestigatorView.java
│       └── resources
│           └── capturas
│               ├── busquedas_totales
│               │   └── Captura_Busquedas_realizadas_completas
│               │       └── Captura web_12-1-2024_81937_serpapi.com.jpeg
│               ├── consola
│               │   ├── Consola_Mysql_01.png
│               │   ├── Consola_Mysql_02.png
│               │   ├── google_scholar_results_1.png
│               │   ├── google_scholar_results_2.png
│               │   ├── google_scholar_results_3.png
│               │   ├── google_scholar_results_4.png
│               │   └── google_scholar_results_5.png
│               │   ├── Segunda_ConsolaMysql_01.png
│               │   ├── Segunda_ConsolaMysql_02.png
│               │   ├── Segunda_ConsolaMysql_03.png
│               │   ├── Segunda_ConsolaMysql_04.png
│               │   ├── Segunda_ConsolaMysql_05.png
│               │   └── Tercera_Consola-GradleBuild-Run.png
│               ├── google_scholar_author
│               │   ├── Captura_GoogleScholarProfile_investigador_universidad_norte_mexico
│               │   │   └── Captura web_12-1-2024_882_serpapi.com.jpeg
│               │   └── Capturas_GoogleScholarAuthor_investigador_universidad_mexico_norte
│               │       ├── Captura web_12-1-2024_74726_serpapi.com.jpeg
│               │       ├── Captura web_12-1-2024_74830_serpapi.com.jpeg
│               │       ├── Captura web_12-1-2024_7483_serpapi.com.jpeg
│               │       ├── Captura web_12-1-2024_7533_serpapi.com.jpeg
│               │       └── Captura web_12-1-2024_882_serpapi.com.jpeg
│               └── google_scholar_profile
│                   ├── Capturas_GoogleScholarProfile_investigador_universidad_mexico_norte
│                   ├── Captura web_11-1-2024_13209_scholar.google.com.jpeg
│                   ├── Captura web_11-1-2024_131624_serpapi.com.jpeg
│                   ├── Captura web_11-1-2024_131712_scholar.google.com.jpeg
│                   ├── Captura web_11-1-2024_131740_scholar.google.com.jpeg
│                   ├── Captura web_11-1-2024_131813_scholar.google.com.jpeg
│                   ├── Captura web_11-1-2024_131847_scholar.google.com.jpeg
│                   ├── Captura web_11-1-2024_131925_scholar.google.com.jpeg
│                   └── Captura web_11-1-2024_132045_scholar.google.com.jpeg
├── .gitignore
├── LICENSE.md
└── README.md

  
```
## Archivo .gitignore

Este proyecto incluye un archivo `.gitignore` que está configurado para ignorar los archivos y directorios generados durante el desarrollo y construcción del proyecto. Asegúrate de revisar y no incluir en el repositorio archivos sensibles como claves de API o configuraciones específicas para tu entorno local.

Si necesitas agregar más reglas al `.gitignore`, puedes hacerlo según las necesidades específicas del desarrollo.

## Comandos Gradle
Para ejecutar la aplicación, utiliza el siguiente comando:

```bash

gradle run

```

Para construir el proyecto, puedes usar:

```bash

gradle build


```

## Licencia

Este proyecto está bajo la Licencia (Versión Limitada) - ver el archivo LICENSE.md para más detalles.

## Impacto Institucional

Este proyecto no solo contribuye al desarrollo de una herramienta eficiente para la recopilación de información académica, sino que también sienta las bases para futuras investigaciones y análisis en el ámbito institucional. La conexión a SerpApi asegura la obtención de datos confiables, mientras que la arquitectura MVC facilita la mantenibilidad y escalabilidad del sistema. En resumen, este proyecto marca un paso significativo hacia la optimización de procesos académicos y la mejora continua en la calidad de la información recopilada.

## Captura de Google Scholar Profile y Author

![Perfil de Google Scholar](/src/main/resources/capturas/google_scholar_profile/Capturas_GoogleScholarProfile_investigador-universidad-mexico/Captura%20web_11-1-2024_131712_scholar.google.com.jpeg) 

![Autor de Google Scholar](/src/main/resources/capturas/google_scholar_author/Capturas_GoogleScholarAuthor_investigador_universidad_mexico_norte/Captura%20web_12-1-2024_7533_serpapi.com.jpeg)

