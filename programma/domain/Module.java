package programma.domain;

import java.util.Date;

public class Module {
    // Attributes

    private String contactEmail;
    private String contactNaam;
    private String beschrijving;
    private String versie;
    private String titel;
    private int moduleID;

    // Constructor

    public Module(String contactEmail, String contactNaam, String beschrijving, String versie, String titel) {
        this.contactEmail = contactEmail;
        this.contactNaam = contactNaam;
        this.beschrijving = beschrijving;
        this.versie = versie;
        this.titel = titel;
        this.moduleID = 0;
    }


    // Getters and Setters


    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactNaam() {
        return contactNaam;
    }

    public void setContactNaam(String contactNaam) {
        this.contactNaam = contactNaam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getVersie() {
        return versie;
    }

    public void setVersie(String versie) {
        this.versie = versie;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getModuleID() {
        return moduleID;
    }

    public void setModuleID(int moduleID) {
        this.moduleID = moduleID;
    }


    @Override
    public String toString() {
        return "Module{" +
                "contactEmail='" + contactEmail + '\'' +
                ", contactNaam='" + contactNaam + '\'' +
                ", beschrijving='" + beschrijving + '\'' +
                ", versie='" + versie + '\'' +
                ", titel='" + titel + '\'' +
                ", moduleID=" + moduleID +
                '}';
    }
}