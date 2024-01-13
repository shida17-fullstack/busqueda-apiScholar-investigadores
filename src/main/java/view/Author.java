package view;

import java.util.List;

public class Author {
    private String authorId;
    private String affiliation;
    private int citedBy;
    private String email;
    private int totalArticles;  // Se cambió de articlesByYear2023 a totalArticles
    private String name;

    // Constructores, getters y setters...

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public int getCitedBy() {
        return citedBy;
    }

    public void setCitedBy(int citedBy) {
        this.citedBy = citedBy;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTotalArticles() {
        return totalArticles;
    }

    public void setTotalArticles(int totalArticles) {
        this.totalArticles = totalArticles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Método para obtener los detalles del autor como una cadena de texto
    public String obtenerDetalles() {
        return "ID: " + authorId + "\n" +
                //"Afiliación: " + affiliation + "\n" +
                "Citas: " + citedBy + "\n" +
                "Email: " + email + "\n" +
                "Total de Artículos: " + totalArticles + "\n" +  // Se cambió de articlesByYear2023 a totalArticles
                "Nombre: " + name + "\n" +
                "-----------";
    }

    // Método para imprimir detalles de autores
    public static void imprimirDetallesAutores(List<Author> autores) {
        // ORDENAR LA LISTA POR CITAS DESCENDENTES
        autores.sort((a1, a2) -> Integer.compare(a2.getCitedBy(), a1.getCitedBy()));

        // IMPRIMIR DETALLES
        for (Author autor : autores) {
            System.out.println("Detalles para el autor " + autor.getAuthorId() + ":");
            System.out.println(autor.obtenerDetalles());
        }
    }
}

