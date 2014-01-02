package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.model.Aktion;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class SpendeFormEditController implements Serializable {
    private static final long serialVersionUID = 6924779805686843885L;
    private String textColor;
    private String bgColor;
    private Aktion aktion;

    public String doOk() {
        return Pages.AKTION_LIST;
    }

    public String getUrl() {
        return "http://localhost:8080/my-aktion/geldSpenden.jsf?bgColor=" + bgColor + "&textColor=" + textColor
                + "&aktionId=" + aktion.getId();
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

    public Aktion getAktion() {
        return aktion;
    }

    public void setAktion(Aktion aktion) {
        this.aktion = aktion;
    }
}
