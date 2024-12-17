package programma.domain;

import java.util.Date;

public class Webcast {
    // Attributes
    private String sprekerNaam;
    private String organisatieNaam;
    private int tijdsduur;
    private Date publicatieDatum;
    private String url;
    private String titel;
    private String beschrijving;
    private int webcastID;

    // Constructor
    public Webcast(String sprekerNaam, String organisatieNaam, int tijdsduur, Date publicatieDatum, String url, String titel, String beschrijving) {

        this.sprekerNaam = sprekerNaam;
        this.organisatieNaam = organisatieNaam;
        this.tijdsduur = tijdsduur;
        this.publicatieDatum = publicatieDatum;
        this.url = url;
        this.titel = titel;
        this.webcastID = 0;
        this.beschrijving = beschrijving;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public Webcast(String sprekerNaam, String titel) {

        this.sprekerNaam = sprekerNaam;

        this.titel = titel;
    }
    // Getters and Setters


    public Date getPublicatieDatum() {
        return publicatieDatum;
    }

    public void setPublicatieDatum(Date publicatieDatum) {
        this.publicatieDatum = publicatieDatum;
    }

    public int getWebcastID() {
        return webcastID;
    }

    public void setWebcastID(int webcastID) {
        this.webcastID = webcastID;
    }

    public String getSprekerNaam() {
        return sprekerNaam;
    }

    public void setSprekerNaam(String sprekerNaam) {
        this.sprekerNaam = sprekerNaam;
    }

    public String getOrganisatieNaam() {
        return organisatieNaam;
    }

    public void setOrganisatieNaam(String organisatieNaam) {
        this.organisatieNaam = organisatieNaam;
    }

    public int getTijdsduur() {
        return tijdsduur;
    }

    public void setTijdsduur(int tijdsduur) {
        this.tijdsduur = tijdsduur;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    @Override
    public String toString() {
        return
                        ", name speaker='" + getSprekerNaam() + "'" +
                        ", org. name='" + getOrganisatieNaam() + "'" +
                        ", time='" + getTijdsduur() + "'" +
                        ", publication date='" + getPublicatieDatum() + "'" +
                        ", url='" + getUrl() + "'";
    }

}