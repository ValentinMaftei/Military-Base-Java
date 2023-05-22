package Repository;

import Config.DataBaseConfiguration;
import Model.Autovehicul;
import Utile.CategorieAutovehicule;
import Utile.TipAutovehicul;
import Utile.UtilizareVehicul;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static Constants.Constants.*;

public class AutovehiculRepository {
    private final DataBaseConfiguration dataBaseConfiguration;

    public AutovehiculRepository(DataBaseConfiguration dataBaseConfiguration){
        this.dataBaseConfiguration = dataBaseConfiguration;
    }

    public List<Autovehicul> getAllAutovehicule() throws SQLException{
        Statement statement = dataBaseConfiguration.getDatabaseConnection().createStatement();
        List<Autovehicul> listAutovehicule = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(QUERY_GET_ALL_AUTOVEHICULE);
        while (resultSet.next()){
            Autovehicul autovehicul = new Autovehicul(resultSet.getInt("codIdentificare"),
            resultSet.getInt("idGestionarAutovehicul"),
            resultSet.getString("denumire"),
            UtilizareVehicul.valueOf(resultSet.getString("utilizare")),
            resultSet.getString("taraProvenienta"),
            resultSet.getBoolean("blindat"),
            resultSet.getInt("nrLocuri"),
            resultSet.getInt("autonomie"),
            resultSet.getInt("vitezaMaxima"),
            CategorieAutovehicule.valueOf(resultSet.getString("categorie")),
            resultSet.getBoolean("suportRemorca"),
            TipAutovehicul.valueOf(resultSet.getString("tip"))
            );

            listAutovehicule.add(autovehicul);
        }
        return listAutovehicule;
    }

    public List<Autovehicul> getAutovehiculByModel(String model) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_GET_AUTOVEHICULE_BY_DENUMIRE);
        List<Autovehicul> listAutovehicule = new ArrayList<>();
        preparedStatement.setString(1, model);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Autovehicul autovehicul = new Autovehicul(resultSet.getInt("codIdentificare"),
                    resultSet.getInt("idGestionarAutovehicul"),
                    resultSet.getString("denumire"),
                    UtilizareVehicul.valueOf(resultSet.getString("utilizare")),
                    resultSet.getString("taraProvenienta"),
                    resultSet.getBoolean("blindat"),
                    resultSet.getInt("nrLocuri"),
                    resultSet.getInt("autonomie"),
                    resultSet.getInt("vitezaMaxima"),
                    CategorieAutovehicule.valueOf(resultSet.getString("categorie")),
                    resultSet.getBoolean("suportRemorca"),
                    TipAutovehicul.valueOf(resultSet.getString("tip"))
            );

            listAutovehicule.add(autovehicul);
        }
        return listAutovehicule;
    }

    public Autovehicul getAutovehiculById(int id) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_GET_AUTOVEHICUL_BY_ID);
        preparedStatement.setInt(1, id);
        Autovehicul autovehicul = new Autovehicul();
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean ok = false;
        while (resultSet.next()){
            ok = true;
            autovehicul.setCodIdentificare(resultSet.getInt("codIdentificare"));
            autovehicul.setIdGestionar(resultSet.getInt("idGestionarAutovehicul"));
            autovehicul.setDenumire(resultSet.getString("denumire"));
            autovehicul.setUtilizare(UtilizareVehicul.valueOf(resultSet.getString("utilizare")));
            autovehicul.setTaraProvenienta(resultSet.getString("taraProvenienta"));
            autovehicul.setBlindat(resultSet.getBoolean("blindat"));
            autovehicul.setNrLocuri(resultSet.getInt("nrLocuri"));
            autovehicul.setAutonomie(resultSet.getInt("autonomie"));
            autovehicul.setVitezaMaxima(resultSet.getInt("vitezaMaxima"));
            autovehicul.setCategoriePermis(CategorieAutovehicule.valueOf(resultSet.getString("categorie")));
            autovehicul.setSuportRemorca(resultSet.getBoolean("suportRemorca"));
            autovehicul.setTip(TipAutovehicul.valueOf(resultSet.getString("tip")));
        }
        if (!ok)
            return null;
        else
            return autovehicul;
    }

    public void deleteAutovehiculById(int id) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_AUTOVEHICUL_BY_ID);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public void deleteAutovehiculByDenumire(String denumire) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_AUTOVEHICULE_BY_DENUMIRE);
        preparedStatement.setString(1, denumire);
        preparedStatement.executeUpdate();
    }

    public void deleteAllAutovehicule() throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_ALL_AUTOVEHICULE);
        preparedStatement.executeUpdate();
    }

    public void insertAutovehicul(String denumire, String utilizare, String taraProvenienta, boolean blindat, int nrLocuri,
                                  int autonomie, int vitezaMaxima, String categorie, boolean suportRemorca, String tip) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_INSERT_AUTOVEHICUL);
        preparedStatement.setString(1, denumire);
        preparedStatement.setString(2, utilizare);
        preparedStatement.setString(3, taraProvenienta);
        preparedStatement.setBoolean(4, blindat);
        preparedStatement.setInt(5, nrLocuri);
        preparedStatement.setInt(6, autonomie);
        preparedStatement.setInt(7, vitezaMaxima);
        preparedStatement.setString(8, categorie);
        preparedStatement.setBoolean(9, suportRemorca);
        preparedStatement.setString(10, tip);
        preparedStatement.executeUpdate();
    }

    public void editAutovehicul(String editCrit, String newValue, String condition) throws SQLException {
        String query = "update unitatemilitara.autovehicul set " + editCrit + " = ";
        if (editCrit.equals("denumire") || editCrit.equals("taraProvenienta") || editCrit.equals("categorie") || editCrit.equals("tip") || editCrit.equals("utilizare")) {
            query += "'" + newValue + "'" + "where autovehicul.codIdentificare = " + Integer.parseInt(condition);
        } else if (editCrit.equals("autonomie") || editCrit.equals("idGestionarAutovehicul") || editCrit.equals("nrLocuri") || editCrit.equals("vitezaMaxima")) {
            query += Integer.parseInt(newValue) + " where autovehicul.codIdentificare = " + Integer.parseInt(condition);
        } else if (editCrit.equals("blindat") || editCrit.equals("suportRemorca")) {
            query += Boolean.parseBoolean(newValue) + " where autovehicul.codIdentificare = " + Integer.parseInt(condition);
        }

        Statement statement = dataBaseConfiguration.getDatabaseConnection().createStatement();
        statement.executeUpdate(query);
    }

    public void deleteGestionarAutovehicul(int id) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_GESTIONAR_AUTOVEHICUL);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
