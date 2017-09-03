package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.model.Aktion;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@SessionScoped
@Named
public class SpendeFormEditController implements Serializable {
    private static final long serialVersionUID = 6924779805686843885L;
    private String textColor = "000000";
    private String bgColor = "ffffff";
    private Aktion aktion;

    public String doOk() {
        return Pages.AKTION_LIST;
    }

    public String getUrl() {
        return String.format("%s/%s.jsf?bgColor=%s&textColor=%s&aktionId=%d",
                getAppUrl(), Pages.GELD_SPENDEN, bgColor, textColor, aktion.getId());
    }

    private String getAppUrl() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String scheme = req.getScheme();
        String serverName = req.getServerName();
        int serverPort = req.getServerPort();
        String contextPath = req.getContextPath();

        return scheme + "://" + serverName + ":" + serverPort + contextPath;
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
