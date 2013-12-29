package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.model.Aktion;
import de.dpunkt.myaktion.model.Spende;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class SpendeListController implements Serializable {
    private static final long serialVersionUID = 2459195467747180771L;
    private Aktion aktion;

    public Aktion getAktion() {
        return aktion;
    }

    public void setAktion(Aktion aktion) {
        this.aktion = aktion;
    }

    public String doOk() {
        return Pages.AKTION_LIST;
    }

    public String statusAsString(Spende.Status status) {
        switch (status) {
            case UEBERWIESEN: return "überwiesen";
            case IN_BEARBEITUNG: return "in Bearbeitung";
        }
        throw new IllegalStateException("Konnte keinen String für Status " + status.name() + " finden!");
    }
}
