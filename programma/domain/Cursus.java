package programma.domain;

import java.util.ArrayList;

public class Cursus {
    // Attributes
    private int volgnummer;
    private String cursusNaam;
    private String onderwerp;
    private String introductieTekst;
    private String niveau;
    private String moduleTitel;
    private String webcastTitel;
    // Constructor
    public Cursus(String cursusNaam, String onderwerp, String introductieTekst, String niveau, String moduleTitel, String webcastTitel) {
        this.volgnummer = 0;
        this.cursusNaam = cursusNaam;
        this.onderwerp = onderwerp;
        this.introductieTekst = introductieTekst;
        this.niveau = niveau;
        this.moduleTitel = moduleTitel;
        this.webcastTitel = webcastTitel;
    }

    public Cursus( String cursusNaam, String niveau) {
        this.volgnummer = 0;
        this.cursusNaam = cursusNaam;
        this.niveau = niveau;
    }

    public String getModuleTitel() {
        return moduleTitel;
    }

    public void setModuleTitel(String moduleTitel) {
        this.moduleTitel = moduleTitel;
    }

    public String getWebcastTitel() {
        return webcastTitel;
    }

    public void setWebcastTitel(String webcastTitel) {
        this.webcastTitel = webcastTitel;
    }

    public int getVolgnummer() {
        return volgnummer;
    }

    public void setVolgnummer(int volgnummer) {
        this.volgnummer = volgnummer;
    }

    public String getCursusNaam() {
        return cursusNaam;
    }

    public void setCursusNaam(String cursusNaam) {
        this.cursusNaam = cursusNaam;
    }

    public String getOnderwerp() {
        return onderwerp;
    }

    public void setOnderwerp(String onderwerp) {
        this.onderwerp = onderwerp;
    }

    public String getIntroductieTekst() {
        return introductieTekst;
    }

    public void setIntroductieTekst(String introductieTekst) {
        this.introductieTekst = introductieTekst;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }




    @Override
    public String toString() {
        return " Cursus='" + getCursusNaam() + "'" +
                ", number='" + getVolgnummer() + "'" +
                ", subject='" + getOnderwerp() + "'" +
                ", level='" + getNiveau() + "'" +
                ", introduction='" + getIntroductieTekst() + "'" ;
    }
}
