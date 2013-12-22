package de.dpunkt.myaktion.model;

public class Konto {
    private String name;
    private String nameDerBank;
    private String kontoNr;
    private String blz;

    public Konto() {
        // TODO Shouldn't the fields be filled with an empty String?
        this(null, null, null, null);
    }

    public Konto(String name, String nameDerBank, String kontoNr, String blz) {
        this.name = name;
        this.nameDerBank = nameDerBank;
        this.kontoNr = kontoNr;
        this.blz = blz;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getNameDerBank() {
        return nameDerBank;
    }

    public void setNameDerBank(String newNameDerBank) {
        this.nameDerBank = newNameDerBank;
    }

    public String getKontoNr() {
        return kontoNr;
    }

    public void setKontoNr(String newKontoNr) {
        this.kontoNr = newKontoNr;
    }

    public String getBlz() {
        return blz;
    }

    public void setBlz(String newBlz) {
        this.blz = newBlz;
    }

    // TODO implement toString()

    // TODO implement hashCode() and equals()
}
