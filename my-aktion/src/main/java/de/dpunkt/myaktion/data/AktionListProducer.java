package de.dpunkt.myaktion.data;

import de.dpunkt.myaktion.model.Aktion;
import de.dpunkt.myaktion.model.Konto;
import de.dpunkt.myaktion.model.Spende;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@SessionScoped
@Named
public class AktionListProducer implements Serializable {
    private static final long serialVersionUID = 3307596445605019126L;
    // TODO Liste in eigene Klasse einpacken (Law of demeter)
    private List<Aktion> aktionen;

    public AktionListProducer() {
        aktionen = createMockAktionen();
    }

    public List<Aktion> getAktionen() {
        return aktionen;
    }

    private List<Aktion> createMockAktionen() {
        Spende spende1 = new Spende();
        spende1.setSpenderName("Heinz Schmidt"); //NON-NLS
        spende1.setBetrag(20.0d);
        spende1.setQuittung(true);
        spende1.setStatus(Spende.Status.UEBERWIESEN);
        spende1.setKonto(new Konto(spende1.getSpenderName(), "XXX Bank", "123456", "87654321"));

        Spende spende2 = new Spende();
        spende2.setSpenderName("Karl Meier"); //NON-NLS
        spende2.setBetrag(30.0d);
        spende2.setQuittung(false);
        spende2.setStatus(Spende.Status.IN_BEARBEITUNG);
        spende2.setKonto(new Konto(spende2.getSpenderName(), "YYY Bank", "654321", "12345678")); //NON-NLS

        List<Spende> spenden = new LinkedList<Spende>();
        spenden.add(spende1);
        spenden.add(spende2);

        Aktion aktion1 = new Aktion();
        aktion1.setName("Trikots für A-Jugend"); //NON-NLS
        aktion1.setSpendenZiel(1000.0d);
        aktion1.setBisherGespendet(258.0d);
        aktion1.setSpendenBetrag(20.0d);
        aktion1.setId(1L);
        Konto ekto = new Konto("Max Mustermann", "ABC Bank", "100200300", "87654321");
        aktion1.setKonto(ekto);
        aktion1.setSpenden(spenden);
        
        Aktion aktion2 = new Aktion();
        aktion2.setName("Rollstuhl für Maria"); //NON-NLS
        aktion2.setSpendenZiel(2500.0d);
        aktion2.setBisherGespendet(742.0d);
        aktion2.setSpendenBetrag(25.0d);
        aktion2.setId(2L);
        aktion2.setKonto(ekto);
        aktion2.setSpenden(spenden);

        List<Aktion> ret = new LinkedList<Aktion>();
        ret.add(aktion1);
        ret.add(aktion2);
        return ret;
    }
}
