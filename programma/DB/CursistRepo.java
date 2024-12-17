package programma.DB;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import programma.DB.Crud;
import programma.domain.Cursist;
import programma.domain.Inschrijving;

public class CursistRepo {


    public void create(Cursist params) {
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
                "INSERT INTO Cursist(CursistEmail,Naam, Geboortedatum, Geslacht, Adres,Stad, Land, postcode) VALUES ('%s', '%s', '%s','%s','%s','%s','%s','%s')",
                email,naam, geboortedatum, geslacht, adres, stad, land, postcode));

    }

    public ArrayList<Cursist> get() {
        ResultSet rs = DatabaseConnection
                .execute("SELECT * FROM Cursist");
        ArrayList<Cursist> cursistsList = new ArrayList<>();

        try {
            while (rs.next()) {

                Cursist cursist = new Cursist(null,null,null,null,null,null,null,null);
                cursist.setCursistID(rs.getInt("CursistID"));
                cursist.setEmail(rs.getString("CursistEmail"));
                cursist.setAdres(rs.getString("Adres"));
                cursist.setNaam(rs.getString("Naam"));
                cursist.setGeboorteDatum(rs.getDate("Geboortedatum"));
                cursist.setGeslacht(rs.getString("Geslacht"));
                cursist.setStad(rs.getString("Stad"));
                cursist.setLand(rs.getString("Land"));
                cursist.setPostcode(rs.getString("postcode"));
                cursistsList.add(cursist);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return cursistsList;
    }
    public String getCursistGeslacht(String email) {
        ResultSet rs = DatabaseConnection
                .execute(String.format("SELECT * FROM Cursist WHERE CursistEmail = '%s'",email));
        Cursist cursist = new Cursist(null,null,null,null,null,null,null,null);

        try {
            while (rs.next()) {

                cursist.setCursistID(rs.getInt("CursistID"));
                cursist.setEmail(rs.getString("CursistEmail"));
                cursist.setAdres(rs.getString("Adres"));
                cursist.setNaam(rs.getString("Naam"));
                cursist.setGeboorteDatum(rs.getDate("Geboortedatum"));
                cursist.setGeslacht(rs.getString("Geslacht"));
                cursist.setStad(rs.getString("Stad"));
                cursist.setLand(rs.getString("Land"));
                cursist.setPostcode(rs.getString("postcode"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return cursist.getGeslacht();
    }
    public Cursist getCursist(int id) {
        ResultSet rs = DatabaseConnection
                .execute(String.format("SELECT * FROM Cursist WHERE CursistID = %d",id));
        Cursist cursist = new Cursist(null,null,null,null,null,null,null,null);

        try {
            while (rs.next()) {

                cursist.setCursistID(rs.getInt("CursistID"));
                cursist.setEmail(rs.getString("CursistEmail"));
                cursist.setAdres(rs.getString("Adres"));
                cursist.setNaam(rs.getString("Naam"));
                cursist.setGeboorteDatum(rs.getDate("Geboortedatum"));
                cursist.setGeslacht(rs.getString("Geslacht"));
                cursist.setStad(rs.getString("Stad"));
                cursist.setLand(rs.getString("Land"));
                cursist.setPostcode(rs.getString("postcode"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return cursist;
    }
    public boolean getByEmailValidation(String email) {
        ResultSet rs = DatabaseConnection
                .execute(String.format("SELECT * FROM Cursist WHERE CursistEmail = '%s'",email));
        ArrayList<String> cursistenList = new ArrayList<>();

        try {
           if(!rs.next()){
               return true;
           }else {
               return false;
           }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
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
                email,naam, geboortedatum, geslacht, adres, stad, land, postcode,id));


    }

    public void delete(int id) {
        ResultSet rs = DatabaseConnection.execute(String.format("DELETE FROM Cursist WHERE CursistID = %d; SELECT * FROM Cursist;", id));
    }
}