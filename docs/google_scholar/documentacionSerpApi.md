# Documentación del Proceso de Integración del programa Java con Google Scholar API - Ciclo N° 1 – Reto N° 2

Tomando en consideración el contenido de la consigna que surge del Reto N° 2 propuesto por Digital NAO, donde se relata que el Departamento de Data Science de una Universidad de México, conformado por Renata y Sandra, y posteriormente integrado por Elizabeth en el rol de Desarrolladora Web, se propone implementar la creación de una Revista Digital que destaque a los investigadores más notorios y talentosos de las Universidades del Norte de México. Se procederá a plasmar y documentar por este medio, toda la información recolectada, mediante la investigación realizada por esta parte - simulando el actuar de Elizabeth (Desarrolladora Web) en Ciclo N° 1 – Reto N° 2 - especialmente obtenida de la página oficial de SerpApi - [https://serpapi.com/](https://serpapi.com/) - ("evidencia_2_c1_r2.jpeg" -Notion), de los pasos y procesos para alcanzar la integración y conexión con la API de Google Scholar o Google Académico, que será realizada a través de peticiones de búsqueda del tipo GET con la implementación de un programa que se desarrollará en Lenguaje Java a requerimiento de la Universidad de México, por parte de Elizabeth (Ciclo N° 2 – Reto N° 2).

## Objetivo

El objetivo es lograr la automatización y agilización de todo el proceso de recopilación y guardado de esos datos obtenidos de las búsquedas efectuadas, en una Base de Datos (Ciclo N° 3 – Reto N° 2), cuya tarea antes fuera realizada manualmente por parte de Sandra.

### 1) Registro en SerpApi:

Esta parte simulará el actuar de Renata, Gestora de éxito del Departamento de Data Science, la cual será responsable de registrar una cuenta en SerpApi y obtener la clave API privada necesaria para poder interactuar con la API. ("evidencia_1_c1_r2.jpeg" - Notion). Este proceso se seguirá de acuerdo con la guía y documentación proporcionada en la página oficial de SerpApi - [https://serpapi.com/](https://serpapi.com/) - ("evidencia_2_c1_r2.jpeg" -Notion). La información, especialmente de la clave API, se pondrá a disposición de Elizabeth - siendo simulado su papel por esta parte en el Ciclo N° 2 – Reto N° 2, para conectar el programa Java con el servicio de API suministrado por Google Scholar.

### 2) Acceso al Dashboard de SerpApi:

Elizabeth, la Desarrolladora Web del proyecto, utilizará la clave API (Ciclo N° 1 – Reto N° 2) proporcionada por parte de Renata para explorar el panel de la API de SerpApi. – [https://serpapi.com/dashboard](https://serpapi.com/dashboard) - ("evidencia_1_c1_r2.jpeg" - Notion). En este panel, se abordarán las distintas funcionalidades disponibles, incluyendo una demostración en vivo e interactiva del motor de búsqueda de Google Scholar (consultar "evidencia_3_c1_r2.jpeg" en Notion). En este entorno, se destaca la capacidad de utilizar un código uule para obtener la ubicación geográfica de un lugar específico, aplicable en las consultas de Google Scholar API. Es importante tener precaución en esta etapa, ya que las consultas de demostración aparentemente se contabilizan dentro del límite de 100 consultas establecido en el plan gratuito.

Para generar el código uule, existen herramientas en línea, como [https://www.indexguru.io/uule-generator](https://www.indexguru.io/uule-generator). A modo de ejemplo, al emplear la ubicación geográfica de Monterrey, México, donde se encuentra el Tecnológico de Monterrey (una universidad ubicada en la Zona Norte de México), el código uule generado sería: `w+CAIQICIQTW9udGVycmV5IE1leGljbw` (consultar "evidencia_4_c1_r2.jpeg").

Cabe señalar que, en relación a este punto, se busca establecer un criterio rector de búsqueda general. Dado que la narrativa del Reto 2 no proporciona detalles sobre campos académicos, áreas de investigaciones específicas, ni información detallada sobre la Universidad de México encargada de la Revista Digital, se ha optado por investigar y determinar algunas de las universidades que podrían considerarse en la Zona Norte. Se ha utilizado Monterrey como ejemplo, siendo el Tecnológico de Monterrey un referente conocido. Otras universidades relevantes en la Zona Norte podrían incluir la Universidad Autónoma de Nuevo León (UANL), la Universidad de Sonora (UNISON) y la Universidad Autónoma de Coahuila (UAdeC), que, aunque no se ubica en el extremo norte, es destacada en la región, con sede en Hermosillo, Sonora. Elizabeth procederá a explorar las opciones disponibles en el panel, identificando las herramientas necesarias para la integración efectiva con Google Scholar API.

### 3) Documentación de Google Scholar API:

#### 3.1 Investigación de Parámetros de Búsqueda:

Elizabeth llevará a cabo una investigación exhaustiva en la documentación de Google Scholar API, orientada específicamente a la búsqueda de investigadores destacados en las Universidades del Norte de México. Se enfocará en identificar y documentar los parámetros clave que optimizarán las consultas para este caso particular. Identificará parámetros fundamentales como "q" para la consulta de búsqueda y explorará el uso de "cites" para activar búsquedas dentro de los artículos que citan.

#### 3.2 Ejemplos de Parámetros:

En la búsqueda de investigadores destacados en las Universidades del Norte de México, Elizabeth incorporará ejemplos prácticos de la documentación. Un caso relevante consistirá en emplear el parámetro "hl" para especificar el idioma de búsqueda. Además, se explorarán otros parámetros avanzados, como "location" o "uule", que puedan ser pertinentes y aplicables al contexto de la búsqueda. Esta adaptación de parámetros permitirá una configuración precisa y eficiente, ajustada a los requisitos del proyecto de la Revista Digital.

### 4) Integración con Java:

#### 4.1 Desarrollo del Programa:

Elizabeth utilizará la documentación de integración con Java proporcionada por SerpApi para desarrollar un programa en Java que se conecte a Google Scholar API. Implementará la lógica de búsqueda utilizando los parámetros identificados y el Lenguaje Java.

#### 4.2 Uso de la Clave API:

La clave API obtenida de SerpApi será esencial para autenticar las consultas y asegurar la conexión con Google Scholar API en el programa Java. Elizabeth integrará la clave API en el programa Java para realizar consultas autorizadas. Este ciclo inicial establece las bases para la automatización de la recopilación de datos de Google Scholar API, resaltando la importancia de comprender y aplicar los parámetros adecuados en el contexto de la integración con Java.
