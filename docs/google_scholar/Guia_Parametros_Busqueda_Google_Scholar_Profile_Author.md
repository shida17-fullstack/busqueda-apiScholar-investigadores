
# Aclaración sobre las Búsquedas Realizadas y Guía Detallada de Parámetros de Búsqueda

  

Dada la limitación de parámetros específicos proporcionados por Google Scholar Profile y Author, se llevó a cabo una serie de búsquedas previas con el objetivo de identificar 10 investigadores reconocidos de universidades del norte de México. Sin embargo, los desafíos surgieron al intentar aplicar filtros precisos como la afiliación universitaria, ubicación geográfica específica, mayor número de citas o artículos recientes.

  

Se exploraron diversas estrategias, incluyendo la posibilidad de conectar con Google Search o Google Académico para realizar búsquedas más amplias, conforme a las evidencias ya aportadas en Notion, pero surgió la dificultad de filtrar la información relevante de los resultados orgánicos. La respuesta a estas búsquedas a menudo incluía resúmenes de URL, y la extracción precisa de nombres desde estos resúmenes se volvía compleja e inconsistente.

  

Se intentó aplicar filtros más específicos, como la afiliación a universidades del norte de México, pero los resultados no cumplían con las expectativas en términos de reconocimiento, número de citas o actualidad de los artículos. Incluso al buscar mediante entidades como el Sistema Nacional de Investigadores (SNI) o el Consejo Nacional de Ciencia y Tecnología (Conacyt) de México, no se obtuvieron resultados satisfactorios.

  

Además, se tuvo en cuenta la forma en que SerpApi y Google Académico contabilizan las conexiones a sus distintas APIs para no excederse de las 100 consultas gratuitas, ya que el uso del playground también es contabilizado dentro de estas consultas.

  

En una búsqueda más general, se logró identificar investigadores de México, pero la dificultad radicó en determinar si estos eran específicamente de universidades del norte del país. La información proporcionada por la API de Google Scholar Profile y Author no permitió asegurar este detalle ni evaluar adecuadamente el grado de reconocimiento de los investigadores.

  

Dada esta situación, se recomienda complementar la búsqueda utilizando otras herramientas, API públicas adicionales o métodos más detallados para obtener información específica sobre investigadores reconocidos de universidades del norte de México. La limitación de la API de Google Scholar en este contexto específico sugiere la necesidad de explorar fuentes de datos más especializadas para cumplir con los criterios establecidos.

  

## Guía Detallada de Parámetros de Búsqueda para Google Scholar Profile y Author

### Búsqueda de Google Scholar Profiles


**Parámetros Utilizados:**

-  `mauthors`: Lista de autores que se están buscando. En este caso, se utiliza "investigador universidad mexico".

-  `hl`: Idioma de la búsqueda, establecido en español (es).


**Ejemplo de Uso en el Código:**


```java


// Configurar los parámetros para Google Scholar Profiles

Map<String, String> paramsProfiles = new  HashMap<>();

paramsProfiles.put("mauthors", "investigador universidad mexico");////realizar cambios a investigador universidad mexico norte/investigador emerito universidad mexico norte/investigador universidad norte mexico

paramsProfiles.put("hl", "es");

  

// Realizar la solicitud a Google Scholar Profiles

JsonNode profilesResponse = serpApiRequest.realizarSolicitud("", "profile", paramsProfiles);

```

**Búsqueda de Google Scholar Author**   

**Parámetros Utilizados:**


 - author_id:

ID único del autor obtenido de la búsqueda de perfiles.

 - hl: I

dioma de la búsqueda, establecido en español (es).

  

**Ejemplo de Uso en el Código:**

  

```java

  

// Configurar los parámetros para Google Scholar Author

Map<String, String> paramsAuthor = new  HashMap<>();

paramsAuthor.put("author_id", authorId);

paramsAuthor.put("hl", "es");

  

// Realizar la solicitud a Google Scholar Author

JsonNode authorResponse = serpApiRequest.realizarSolicitud("", "author", paramsAuthor);

```

  

**Detalles Adicionales: Número Total de Artículos**

**Método Utilizado en el Código:**


```java


private int getTotalArticles(JsonNode authorResponse) {
        JsonNode articlesByYearNode = authorResponse.get("articles_by_year");
        if (articlesByYearNode != null && articlesByYearNode.isArray()) {
            int totalArticles = 0;

            // Sumar todos los artículos de todos los años disponibles
            for (JsonNode yearNode : articlesByYearNode) {
                totalArticles += yearNode.asInt();
            }

            return totalArticles;
        } else if (authorResponse.has("cited_by")) {
            // Si no hay datos para el campo articles_by_year, pero hay una cantidad total de citas, retornar esa cantidad
            return authorResponse.get("cited_by").asInt();
        } else {
            // Manejo de la situación en la que no hay datos para el campo articles_by_year ni para la cantidad total de citas
            return 0;  // O cualquier otro valor predeterminado
        }
    }

```