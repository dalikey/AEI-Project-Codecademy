package programma.DB;

import java.sql.ResultSet;
import java.util.ArrayList;

import programma.domain.Cursus;
import programma.domain.Inschrijving;
import programma.domain.Webcast;

public class CursusRepo {


    public void create(Cursus params) {
        int cursusID = params.getVolgnummer();
        String naam = params.getCursusNaam();
        String onderwerp = params.getOnderwerp();
        String introductieTekst = params.getIntroductieTekst();
        String niveau = params.getNiveau();
        String webcastTitel = params.getWebcastTitel();
        String moduleTitel = params.getModuleTitel();
        boolean rs = DatabaseConnection.executeQuery(String.format(
                "INSERT INTO Cursussen(CursusNaam, Onderwerp, IntroductieTekst, Niveau, WebCastTitel,ModuleTitel ) VALUES ('%s', '%s', '%s','%s','%s','%s')",
                naam, onderwerp, introductieTekst, niveau,webcastTitel,moduleTitel));

    }

    public ArrayList<Cursus> get() {
        ResultSet rs = DatabaseConnection
                .execute("SELECT * FROM Cursussen");
        ArrayList<Cursus> cursusList = new ArrayList<>();

        try {
            while (rs.next()) {

                Cursus cursus = new Cursus(null,null,null,null,null,null);
                cursus.setVolgnummer(rs.getInt("VolgNummer"));
                cursus.setCursusNaam(rs.getString("CursusNaam"));
                cursus.setOnderwerp(rs.getString("Onderwerp"));
                cursus.setIntroductieTekst(rs.getString("IntroductieTekst"));
                cursus.setNiveau(rs.getString("Niveau"));
                cursus.setModuleTitel(rs.getString("ModuleTitel"));
                cursus.setWebcastTitel(rs.getString("WebcastTitel"));

                cursusList.add(cursus);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return cursusList;
    }
    public ArrayList<Cursus> getTop3() {
        ResultSet rs = DatabaseConnection
                .execute("SELECT TOP 3 CursusNaam, Niveau FROM Cursussen");
        ArrayList<Cursus> cursusList = new ArrayList<>();

        try {
            while (rs.next()) {
                Cursus cursus = new Cursus(null,null);
                cursus.setCursusNaam(rs.getString("CursusNaam"));
                cursus.setNiveau(rs.getString("Niveau"));
                cursusList.add(cursus);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("FAILED TO LOAD");
            return null;
        }
        return cursusList;
    }
    public ArrayList<String> getTitels() {
        ResultSet rs = DatabaseConnection
                .execute("SELECT * FROM Cursussen");
        ArrayList<String> cursusList = new ArrayList<>();

        try {
            while (rs.next()) {
                Cursus cursus = new Cursus(null,null,null,null,null,null);
                cursus.setVolgnummer(rs.getInt("VolgNummer"));
                cursus.setCursusNaam(rs.getString("CursusNaam"));
                cursus.setOnderwerp(rs.getString("Onderwerp"));
                cursus.setIntroductieTekst(rs.getString("IntroductieTekst"));
                cursus.setNiveau(rs.getString("Niveau"));
                cursus.setModuleTitel(rs.getString("ModuleTitel"));
                cursus.setWebcastTitel(rs.getString("WebcastTitel"));

                cursusList.add(cursus.getCursusNaam());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("FAILED TO LOAD");
            return null;
        }
        return cursusList;
    }
    public Cursus getCursus(int id) {
        ResultSet rs = DatabaseConnection
                .execute(String.format("SELECT * FROM Cursussen WHERE VolgNummer = %d",id));
        Cursus cursus = new Cursus(null,null,null,null,null,null);

        try {
            while (rs.next()) {

                cursus.setVolgnummer(rs.getInt("VolgNummer"));
                cursus.setCursusNaam(rs.getString("CursusNaam"));
                cursus.setOnderwerp(rs.getString("Onderwerp"));
                cursus.setIntroductieTekst(rs.getString("IntroductieTekst"));
                cursus.setNiveau(rs.getString("Niveau"));
                cursus.setModuleTitel(rs.getString("ModuleTitel"));
                cursus.setWebcastTitel(rs.getString("WebcastTitel"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return cursus;
    }
    public void update(int id, Cursus params) {
        int cursusID = params.getVolgnummer();
        String naam = params.getCursusNaam();
        String onderwerp = params.getOnderwerp();
        String introductieTekst = params.getIntroductieTekst();
        String niveau = params.getNiveau();
        String webcastTitel = params.getWebcastTitel();
        String moduleTitel = params.getModuleTitel();
        boolean rs = DatabaseConnection.executeQuery(String.format(
                "UPDATE Cursussen SET CursusNaam = '%s', IntroductieTekst = '%s', Niveau = '%s', WebcastTitel = '%s', ModuleTitel = '%s', Onderwerp = '%s' WHERE VolgNummer = %d;",
                naam, introductieTekst, niveau, webcastTitel,moduleTitel,onderwerp, id));
    }

    public void delete(int id) {
        ResultSet rs = DatabaseConnection.execute(String.format("DELETE FROM Cursussen WHERE Volgnummer = %d; SELECT * FROM Cursussen;", id));
    }
}