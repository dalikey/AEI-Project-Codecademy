package programma.DB;

import programma.domain.Cursist;
import programma.domain.Module;
import programma.domain.Webcast;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ModuleRepo {


    public void create(Module params) {
        int moduleID = params.getModuleID();
        String beschrijving = params.getBeschrijving();
        String titel = params.getTitel();
        String versie = params.getVersie();
        String contactNaam = params.getContactNaam();
        String contactEmail = params.getContactEmail();


        boolean rs = DatabaseConnection.executeQuery(String.format(
                "INSERT INTO Modules(Titel,Versie, Beschrijving, ContactNaam, ContactEmail) VALUES ('%s', '%s', '%s','%s','%s')",
                titel,versie, beschrijving, contactNaam, contactEmail));

    }

    public ArrayList<Module> get() {
        ResultSet rs = DatabaseConnection
                .execute("SELECT * FROM Modules");
        ArrayList<Module> moduleList = new ArrayList<>();

        try {
            while (rs.next()) {

                Module module = new Module(null,null,null,null,null);
                module.setModuleID(rs.getInt("ContentItemID"));
                module.setVersie(rs.getString("Versie"));
                module.setBeschrijving(rs.getString("Beschrijving"));
                module.setContactNaam(rs.getString("ContactNaam"));
                module.setTitel(rs.getString("Titel"));
                module.setContactEmail(rs.getString("ContactEmail"));
                moduleList.add(module);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return moduleList;
    }
    public ArrayList<String> getTitels() {
        ResultSet rs = DatabaseConnection
                .execute("SELECT * FROM Modules");
        ArrayList<String> modulesList = new ArrayList<>();

        try {
            while (rs.next()) {
                Module module = new Module(null,null,null,null,null);
                module.setModuleID(rs.getInt("ContentItemID"));
                module.setVersie(rs.getString("Versie"));
                module.setBeschrijving(rs.getString("Beschrijving"));
                module.setContactNaam(rs.getString("ContactNaam"));
                module.setTitel(rs.getString("Titel"));
                module.setContactEmail(rs.getString("ContactEmail"));
                modulesList.add(module.getTitel());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("FAILED TO LOAD");
            return null;
        }
        return modulesList;
    }
    public Module getModule(int id) {
        ResultSet rs = DatabaseConnection
                .execute(String.format("SELECT * FROM Modules WHERE ContentItemID = %d",id));
        Module module = new Module(null,null,null,null,null);

        try {
            while (rs.next()) {

                module.setModuleID(rs.getInt("ContentItemID"));
                module.setVersie(rs.getString("Versie"));
                module.setBeschrijving(rs.getString("Beschrijving"));
                module.setContactNaam(rs.getString("ContactNaam"));
                module.setTitel(rs.getString("Titel"));
                module.setContactEmail(rs.getString("ContactEmail"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return module;
    }
    public void update(int id, Module params) {
        int moduleID = params.getModuleID();
        String beschrijving = params.getBeschrijving();
        String titel = params.getTitel();
        String versie = params.getVersie();
        String contactNaam = params.getContactNaam();
        String contactEmail = params.getContactEmail();

        boolean rs = DatabaseConnection.executeQuery(String.format(
                "UPDATE Modules SET Titel = '%s', Versie = '%s', Beschrijving = '%s', ContactNaam = '%s', ContactEmail = '%s' WHERE ContentItemID = %d;",
                titel,versie, beschrijving, contactNaam, contactEmail,id));


    }

    public void delete(int id) {
        ResultSet rs = DatabaseConnection.execute(String.format("DELETE FROM Modules WHERE ContentItemID = %d; SELECT * FROM Modules;", id));
    }
}