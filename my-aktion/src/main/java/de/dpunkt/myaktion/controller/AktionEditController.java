package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.data.AktionListProducer;
import de.dpunkt.myaktion.model.Aktion;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class AktionEditController implements Serializable {
    private static final long serialVersionUID = -6638274722642876150L;
    private Aktion aktion;
    private Mode mode;

    @Inject
    private AktionListProducer aktionListProducer;

    public enum Mode {
        EDIT, ADD
    }

    public Aktion getAktion() {
        return aktion;
    }

    public void setAktionToEdit(Mode operationMode) {
        setAktionToEdit(operationMode, new Aktion());
    }

    public void setAktionToEdit(Mode operationMode, Aktion aktionToEdit) {
        mode = operationMode;
        aktion = aktionToEdit;
    }

    public String doSave() {
        if (mode == Mode.ADD) {
            aktionListProducer.getAktionen().add(aktion);
        }
        return Pages.AKTION_LIST;
    }

    public String doCancel() {
        return Pages.AKTION_LIST;
    }

    public String getTitle() {
        String retVal;
        if (mode == Mode.EDIT) {
            retVal = "Aktion editieren";
        } else {
            retVal = "Neue Aktion anlegen";
        }
        return retVal;
    }
}
