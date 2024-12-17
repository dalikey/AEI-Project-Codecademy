package programma.domain;

import java.util.Date;

public class Inschrijving {
    // Attributes
    private int inschrijvingID;
    private String cursusNaam;
    private String cursistEmail;
    private Date registratieDatum;
    // Constructor


    public Inschrijving(String cursusNaam, String cursistEmail, Date registratieDatum) {
        this.inschrijvingID = 0;
        this.cursusNaam = cursusNaam;
        this.cursistEmail = cursistEmail;
        this.registratieDatum = registratieDatum;
    }

    public int getInschrijvingID() {
        return inschrijvingID;
    }

    public void setInschrijvingID(int inschrijvingID) {
        this.inschrijvingID = inschrijvingID;
    }

    public String getCursusNaam() {
        return cursusNaam;
    }

    public void setCursusNaam(String cursusNaam) {
        this.cursusNaam = cursusNaam;
    }

    public String getCursistEmail() {
        return cursistEmail;
    }

    public void setCursistEmail(String cursistEmail) {
        this.cursistEmail = cursistEmail;
    }

    public Date getRegistratieDatum() {
        return registratieDatum;
    }

    public void setRegistratieDatum(Date registratieDatum) {
        this.registratieDatum = registratieDatum;
    }

    @Override
    public String toString() {
        return "Inschrijving{" +
                "inschrijvingID=" + inschrijvingID +
                ", cursusNaam='" + cursusNaam + '\'' +
                ", cursistEmail='" + cursistEmail + '\'' +
                ", registratieDatum=" + registratieDatum +
                '}';
    }
}
