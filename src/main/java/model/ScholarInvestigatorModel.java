package model;

import com.fasterxml.jackson.databind.JsonNode;
import utils.SerpApiRequest;
import view.Author;
import baseDatos.BDConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScholarInvestigatorModel {

    public List<Author> buscarEImprimirAutoresPremiados() {
        List<Author> autores = new ArrayList<>();

        // Parámetros para Google Scholar Profiles
        Map<String, String> paramsProfiles = new HashMap<>();
        paramsProfiles.put("mauthors", "investigador universidad mexico");
        paramsProfiles.put("hl", "es");

        SerpApiRequest serpApiRequest = new SerpApiRequest();
        JsonNode profilesResponse = serpApiRequest.realizarSolicitud("", "profile", paramsProfiles);

        // Verificar si la respuesta es exitosa
        if (profilesResponse != null && profilesResponse.has("profiles") && profilesResponse.get("profiles").isArray()) {
            JsonNode profilesNode = profilesResponse.get("profiles");

            // Obtener detalles de cada autor
            for (JsonNode item : profilesNode) {
                String authorId = item.get("author_id").asText();
                int citations = item.get("cited_by").asInt();

                Author author = new Author();
                author.setAuthorId(authorId);
                author.setCitedBy(citations);
                author.setName(item.get("name").asText());

                // Parámetros para Google Scholar Author
                Map<String, String> paramsAuthor = new HashMap<>();
                paramsAuthor.put("author_id", authorId);
                paramsAuthor.put("hl", "es");

                // Realizar solicitud a Google Scholar Author
                JsonNode authorResponse = serpApiRequest.realizarSolicitud("", "author", paramsAuthor);

                // Verificar si la respuesta del autor es exitosa
                if (authorResponse != null) {
                    if (authorResponse.has("affiliation")) {
                        author.setEmail(authorResponse.get("email").asText());
                    }

                    // Modificar para incluir todos los artículos sin especificar el año
                    int totalArticles = getTotalArticles(authorResponse);
                    author.setTotalArticles(totalArticles);

                    // Guardar el autor en la base de datos
                    guardarAutorEnBaseDeDatos(author);

                    autores.add(author);
                } else {
                    System.out.println("La respuesta del autor no contiene la información esperada o la afiliación no está disponible.");
                    // Crear un autor con la información disponible
                    autores.add(author);
                }
            }
        } else {
            System.out.println("La respuesta de la API no contiene el nodo 'profiles' o no es un array.");
        }

        return autores;
    }

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

    private void guardarAutorEnBaseDeDatos(Author author) {
        try (Connection connection = BDConnect.getConnection()) {
            String query = "INSERT INTO Author (author_id, affiliation, cited_by, email, total_articles, name) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, author.getAuthorId());
                preparedStatement.setString(2, author.getAffiliation());
                preparedStatement.setInt(3, author.getCitedBy());
                preparedStatement.setString(4, author.getEmail());
                preparedStatement.setInt(5, author.getTotalArticles());
                preparedStatement.setString(6, author.getName());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al guardar el autor en la base de datos.");
        }
    }
}
