package Repository;

import Config.DataBaseConfiguration;
import Model.Blindat;
import Utile.UtilizareVehicul;

import javax.swing.plaf.nimbus.State;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static Constants.Constants.*;

public class BlindatRepository {
    private final DataBaseConfiguration dataBaseConfiguration;

    public BlindatRepository(DataBaseConfiguration dataBaseConfiguration){
        this.dataBaseConfiguration = dataBaseConfiguration;
    }

    public List<Blindat> getAllBlindate() throws SQLException{
        Statement statement = dataBaseConfiguration.getDatabaseConnection().createStatement();
        List<Blindat> listBlindate = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(QUERY_GET_ALL_BLINDATE);
        while (resultSet.next()){
            Blindat blindat = new Blindat(resultSet.getInt("codIdentificare"),
                    resultSet.getInt("idGestionarBlindat"),
                    resultSet.getString("denumire"),
                    UtilizareVehicul.valueOf(resultSet.getString("utilizare")),
                    resultSet.getString("taraProvenienta"),
                    resultSet.getBoolean("blindat"),
                    resultSet.getInt("nrLocuri"),
                    resultSet.getInt("autonomie"),
                    resultSet.getInt("vitezaMaxima"),
                    resultSet.getBoolean("suportRemorca"),
                    resultSet.getBoolean("suportArma"),
                    resultSet.getString("arma"));

            listBlindate.add(blindat);
        }
        return listBlindate;
    }

    public List<Blindat> getBlindatByDenumire(String denumire) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_GET_BLINDATE_BY_DENUMIRE);
        preparedStatement.setString(1, denumire);
        List<Blindat> listBlindate = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Blindat blindat = new Blindat(resultSet.getInt("codIdentificare"),
                    resultSet.getInt("idGestionarBlindat"),
                    resultSet.getString("denumire"),
                    UtilizareVehicul.valueOf(resultSet.getString("utilizare")),
                    resultSet.getString("taraProvenienta"),
                    resultSet.getBoolean("blindat"),
                    resultSet.getInt("nrLocuri"),
                    resultSet.getInt("autonomie"),
                    resultSet.getInt("vitezaMaxima"),
                    resultSet.getBoolean("suportRemorca"),
                    resultSet.getBoolean("suportArma"),
                    resultSet.getString("arma"));

            listBlindate.add(blindat);
        }
        return listBlindate;
    }

    public Blindat getBlindatById(int id) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_GET_BLINDAT_BY_ID);
        preparedStatement.setInt(1, id);
        Blindat blindat = new Blindat();
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean ok = false;
        while (resultSet.next()){
            ok = true;
            blindat.setCodIdentificare(resultSet.getInt("codIdentificare"));
            blindat.setIdGestionar(resultSet.getInt("idGestionarBlindat"));
            blindat.setDenumire(resultSet.getString("denumire"));
            blindat.setUtilizare(UtilizareVehicul.valueOf(resultSet.getString("utilizare")));
            blindat.setTaraProvenienta(resultSet.getString("taraProvenienta"));
            blindat.setBlindat(resultSet.getBoolean("blindat"));
            blindat.setNrLocuri(resultSet.getInt("nrLocuri"));
            blindat.setAutonomie(resultSet.getInt("autonomie"));
            blindat.setVitezaMaxima(resultSet.getInt("vitezaMaxima"));
            blindat.setSuportRemorca(resultSet.getBoolean("suportRemorca"));
            blindat.setSuportArma(resultSet.getBoolean("suportArma"));
            blindat.setArma(resultSet.getString("arma"));
        }
        if (!ok)
            return null;
        else
            return blindat;
    }

    public void deleteBlindatById(int id) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_BLINDAT_BY_ID);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public void deleteBlindatByDenumire(String denumire) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_BLINDATE_BY_DENUMIRE);
        preparedStatement.setString(1, denumire);
        preparedStatement.executeUpdate();
    }

    public void deleteAllBlindate() throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_ALL_BLINDATE);
        preparedStatement.executeUpdate();
    }

    public void insertBlindat(String denumire, String utilizare, String taraProvenienta, boolean blindat, int nrLocuri,
                              int autonomie, int vitezaMaxima, boolean suportRemorca, boolean suportArma, String arma) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_INSERT_BLINDAT);
        preparedStatement.setString(1, denumire);
        preparedStatement.setString(2, utilizare);
        preparedStatement.setString(3, taraProvenienta);
        preparedStatement.setBoolean(4, blindat);
        preparedStatement.setInt(5, nrLocuri);
        preparedStatement.setInt(6, autonomie);
        preparedStatement.setInt(7, vitezaMaxima);
        preparedStatement.setBoolean(8, suportRemorca);
        preparedStatement.setBoolean(9, suportArma);
        if (!suportArma){
            arma = null;
        }
        preparedStatement.setString(10, arma);
        preparedStatement.executeUpdate();
    }

    public void editBlindat(String editCrit, String newValue, String condition) throws SQLException {
        String query = "update unitatemilitara.blindat set " + editCrit + " = ";
        String query2 = "update unitatemilitara.blindat set arma = null where blindat.codIdentificare = " + condition;
        if (editCrit.equals("arma") || editCrit.equals("denumire") || editCrit.equals("taraProvenienta") || editCrit.equals("utilizare")){
            query += "'" + newValue + "'" + "where blindat.codIdentificare = " + Integer.parseInt(condition);
        }
        else if (editCrit.equals("autonomie") || editCrit.equals("idGestionarBlindat") || editCrit.equals("nrLocuri") || editCrit.equals("vitezaMaxima")){
            query += Integer.parseInt(newValue) + " where blindat.codIdentificare = " + Integer.parseInt(condition);
        }
        else if (editCrit.equals("blindat") || editCrit.equals("suportArma") || editCrit.equals("suportRemorca")){
            query += Boolean.parseBoolean(newValue) + " where blindat.codIdentificare = " + Integer.parseInt(condition);
        }
        if (editCrit.equals("suportArma") && (newValue.equals("false") || newValue.equals("0"))){
            Statement statement = dataBaseConfiguration.getDatabaseConnection().createStatement();
            statement.executeUpdate(query2);
        }

        Statement statement = dataBaseConfiguration.getDatabaseConnection().createStatement();
        statement.executeUpdate(query);
    }

    public void deleteGestionarBlindat(int id) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_GESTIONAR_BLINDAT);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
