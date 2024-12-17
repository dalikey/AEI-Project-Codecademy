package programma.domain;

import java.sql.Date;

public class Certificaat {
    // Attributes
    private int certificaatID;
    private int beoordeling; // ten hoogste 100
    private String ondertekenaar;
    private String cursist;
    private String cursus;
    private String geslachtCursist;

    // constructor


    public Certificaat( int beoordeling, String ondertekenaar, String cursist, String cursus, String geslachtCursist) {
        this.certificaatID = 0;
        this.beoordeling = beoordeling;
        this.ondertekenaar = ondertekenaar;
        this.cursist = cursist;
        this.cursus = cursus;
        this.geslachtCursist = geslachtCursist;
    }

    public Certificaat(int beoordeling, String ondertekenaar) {
        this.certificaatID = 0;
        this.beoordeling = beoordeling;
        this.ondertekenaar = ondertekenaar;
    }

    public int getCertificaatID() {
        return certificaatID;
    }

    public void setCertificaatID(int certificaatID) {
        this.certificaatID = certificaatID;
    }

    public int getBeoordeling() {
        return beoordeling;
    }

    public void setBeoordeling(int beoordeling) {
        this.beoordeling = beoordeling;
    }

    public String getOndertekenaar() {
        return ondertekenaar;
    }

    public void setOndertekenaar(String ondertekenaar) {
        this.ondertekenaar = ondertekenaar;
    }

    public String getCursist() {
        return cursist;
    }

    public void setCursist(String cursist) {
        this.cursist = cursist;
    }

    public String getCursus() {
        return cursus;
    }

    public void setCursus(String cursus) {
        this.cursus = cursus;
    }

    public String getGeslachtCursist() {
        return geslachtCursist;
    }

    public void setGeslachtCursist(String geslachtCursist) {
        this.geslachtCursist = geslachtCursist;
    }

    @Override
    public String toString() {
        return "Certificaat{" +
                "certificaatID=" + certificaatID +
                ", beoordeling=" + beoordeling +
                ", ondertekenaar='" + ondertekenaar + '\'' +
                ", cursist='" + cursist + '\'' +
                ", cursus='" + cursus + '\'' +
                ", geslachtCursist='" + geslachtCursist + '\'' +
                '}';
    }
}
