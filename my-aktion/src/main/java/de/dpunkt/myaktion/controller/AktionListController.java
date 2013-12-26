package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.model.Aktion;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class AktionListController implements Serializable {
    private static final long serialVersionUID = 1389774465124782156L;
    
    @Inject
    private AktionEditController aktionEditController;

    public String doAddAktion() {
        aktionEditController.setAktionToEdit(AktionEditController.Mode.ADD);
        return Pages.AKTION_EDIT;
    }

    public String doEditAktion(Aktion aktion) {
        aktionEditController.setAktionToEdit(AktionEditController.Mode.EDIT, aktion);
        return Pages.AKTION_EDIT;
    }

    public String doEditSpendeForm(Aktion aktion) {
        System.out.printf("Edit Spende form %s%n", aktion); //NON-NLS
        return Pages.SPENDE_FORM_EDIT;
    }

    public String doListSpende(Aktion aktion) {
        System.out.printf("List Spende %s%n", aktion); //NON-NLS
        return Pages.SPENDE_LIST;
    }

    public void doDeleteAktion(Aktion aktion) {
        System.out.printf("Aktion löschen noch nicht implementiert!%n"); //NON-NLS
    }
}
