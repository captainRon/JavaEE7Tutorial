package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.model.Spende;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class GeldSpendenController implements Serializable {
    private static final long serialVersionUID = 492756331494863028L;
    private Spende spende;
    private String textColor = "000000";
    private String bgColor = "FFFFFF";
    private Long aktionId;

    public GeldSpendenController() {
        spende = new Spende();
    }

    public String doSpende() {
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Vielen Danke für die Spende", null);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        spende = new Spende();
        return Pages.GELD_SPENDEN;
    }

    public Spende getSpende() {
        return spende;
    }

    public void setSpende(Spende spende) {
        this.spende = spende;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public Long getAktionId() {
        return aktionId;
    }

    public void setAktionId(Long aktionId) {
        this.aktionId = aktionId;
    }
}
