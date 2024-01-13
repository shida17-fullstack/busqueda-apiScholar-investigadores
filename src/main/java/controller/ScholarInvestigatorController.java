// ScholarInvestigatorController.java

package controller;

import model.ScholarInvestigatorModel;
import view.ScholarInvestigatorView;
import view.Author;

import java.util.List;

public class ScholarInvestigatorController {
    public static void buscarTopInvestigadores(String[] args) {
        ScholarInvestigatorModel model = new ScholarInvestigatorModel();
        List<Author> autores = model.buscarEImprimirAutoresPremiados(); 

        ScholarInvestigatorView view = new ScholarInvestigatorView();
        view.imprimirDetalles(autores);
    }
}
