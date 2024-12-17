package programma.DB;

import programma.domain.Cursist;
import programma.domain.Inschrijving;
import programma.domain.Webcast;

import java.sql.ResultSet;
import java.util.ArrayList;

public class InschrijvingRepo {


    public void create(Inschrijving params) {
        int inschrijvingID = params.getInschrijvingID();
        String cursistEmail = params.getCursistEmail();
        String cursusNaam = params.getCursusNaam();
        String registratieDatum = String.valueOf(params.getRegistratieDatum());


        boolean rs = DatabaseConnection.executeQuery(String.format(
                "INSERT INTO Inschrijvingen(CursistEmail,CursusNaam, RegistratieDatum) VALUES ('%s','%s','%s')",
                cursistEmail,cursusNaam, registratieDatum));

    }

    public ArrayList<Inschrijving> get() {
        ResultSet rs = DatabaseConnection
                .execute("SELECT * FROM Inschrijvingen");
        ArrayList<Inschrijving> inschrijvingsList = new ArrayList<>();

        try {
            while (rs.next()) {

                Inschrijving inschrijving = new Inschrijving(null,null,null);
                inschrijving.setInschrijvingID(rs.getInt("InschrijvingID"));
                inschrijving.setCursistEmail(rs.getString("CursistEmail"));
                inschrijving.setCursusNaam(rs.getString("CursusNaam"));
                inschrijving.setRegistratieDatum(rs.getDate("RegistratieDatum"));
                inschrijvingsList.add(inschrijving);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return inschrijvingsList;
    }
    public Inschrijving getInschrijving(int id) {
        ResultSet rs = DatabaseConnection
                .execute(String.format("SELECT * FROM Inschrijvingen WHERE InschrijvingID = %d",id));
        Inschrijving inschrijving = new Inschrijving(null,null,null);

        try {
            while (rs.next()) {

                inschrijving.setInschrijvingID(rs.getInt("InschrijvingID"));
                inschrijving.setCursistEmail(rs.getString("CursistEmail"));
                inschrijving.setCursusNaam(rs.getString("CursusNaam"));
                inschrijving.setRegistratieDatum(rs.getDate("RegistratieDatum"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return inschrijving;
    }

    public void update(int id, Cursist params) {
        int cursistID = params.getCursistID();
        String adres = params.getAdres();
        String naam = params.getNaam();
        String email = params.getEmail();
        String geboortedatum = String.valueOf(params.getGeboorteDatum());
        String geslacht = params.getGeslacht();
        String stad = params.getStad();
        String land = params.getLand();
        String postcode = params.getPostcode();

        boolean rs = DatabaseConnection.executeQuery(String.format(
                "UPDATE Cursist SET CursistEmail = '%s', Naam = '%s', Geboortedatum = '%s', Geslacht = '%s', Adres = '%s',Stad = '%s', Land = '%s', postcode = '%s' WHERE CursistID = %d;",
                email,naam, geboortedatum, geslacht, adres, stad, land, postcode, id));


    }

    public void delete(int id) {
        ResultSet rs = DatabaseConnection.execute(String.format("DELETE FROM Inschrijvingen WHERE InschrijvingID = %d; SELECT * FROM Inschrijvingen;", id));
    }
}