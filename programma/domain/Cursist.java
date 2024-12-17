package programma.domain;

import java.sql.Date;

public class Cursist {
    // Attributes

    private String Email;
    private String naam;
    private Date geboorteDatum;
    private String geslacht;
    private String adres;
    private String stad;
    private String land;
    private String postcode;
    private int cursistID;
    // constructor
    public Cursist(String Email, String name, Date geboorteDatum, String geslacht, String adres, String stad, String land, String postcode) {
        this.Email = Email;
        this.naam = name;
        this.geboorteDatum = geboorteDatum;
        this.geslacht = geslacht;
        this.adres = adres;
        this.stad = stad;
        this.land = land;
        this.postcode = postcode;
        this.cursistID = 0;
    }

    public int getCursistID() {
        return cursistID;
    }

    public void setCursistID(int cursistID) {
        this.cursistID = cursistID;
    }

    // getters and setters
    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNaam() {
        return this.naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Date getGeboorteDatum() {
        return this.geboorteDatum;
    }

    public void setGeboorteDatum(Date geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public String getGeslacht() {
        return this.geslacht;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public String getAdres() {
        return this.adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getStad() {
        return this.stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public String getLand() {
        return this.land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return
                " Email='" + getEmail() + "'" +
                        ", name='" + getNaam() + "'" +
                        ", dayOfBirth='" + getGeboorteDatum() + "'" +
                        ", gender='" + getGeslacht() + "'" +
                        ", adress='" + getAdres() + "'" +
                        ", city='" + getStad() + "'" +
                        ", country='" + getLand() + "'" +
                        ", postalCode='" + getPostcode() + "'";
    }

}