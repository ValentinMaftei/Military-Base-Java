package Repository;

import Config.DataBaseConfiguration;
import Model.Angajat;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Utile.Functie;
import Utile.Grad;

import static Constants.Constants.*;

public class AngajatRepository {

    private final DataBaseConfiguration dataBaseConfiguration;

    public AngajatRepository(DataBaseConfiguration dataBaseConfiguration) {
        this.dataBaseConfiguration = dataBaseConfiguration;
    }

    public List<Angajat> getAllAngajati() throws SQLException {
        Statement statement = dataBaseConfiguration.getDatabaseConnection().createStatement();
        List<Angajat> angajati = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(QUERY_GET_ALL_ANGAJATI);
        while (resultSet.next()){

            Angajat angajat = new Angajat(resultSet.getInt("codIdentificare"),
                    resultSet.getString("nume"),
                    resultSet.getString("prenume"),
                    resultSet.getDate("dataNastere"),
                    Grad.valueOf(resultSet.getString("grad")),
                    Functie.valueOf(resultSet.getString("functie")));
            angajati.add(angajat);
        }
        return angajati;
    }

    public List<Angajat> getAngajatiByName(String lastName, String firstName) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_GET_ANGAJATI_BY_NAME);
        preparedStatement.setString(2, firstName);
        preparedStatement.setString(1, lastName);
        List<Angajat> listaAngajati = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Angajat angajat = new Angajat(resultSet.getInt("codIdentificare"),
                    resultSet.getString("nume"),
                    resultSet.getString("prenume"),
                    resultSet.getDate("dataNastere"),
                    Grad.valueOf(resultSet.getString("grad")),
                    Functie.valueOf(resultSet.getString("functie")));
            listaAngajati.add(angajat);
        }
        return listaAngajati;
    }

    public Angajat getAngajatById(int id) throws SQLException {
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_GET_ANGAJAT_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Angajat angajat = new Angajat();
        boolean ok = false;
        while (resultSet.next()) {
            ok = true;
            angajat.setCodIdentificare(resultSet.getInt("codIdentificare"));
            angajat.setNume(resultSet.getString("nume"));
            angajat.setPrenume(resultSet.getString("prenume"));
            angajat.setDataNastere(resultSet.getDate("dataNastere"));
            angajat.setGrad(Grad.valueOf(resultSet.getString("grad")));
            angajat.setTitlu(Functie.valueOf(resultSet.getString("functie")));
        }
        if (!ok)
            return null;
        else
            return angajat;
    }

    public void deleteAngajatById(int id) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_ANGAJAT_BY_ID);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public void deleteAngajatByName(String lastName, String firstName) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_ANGAJAT_BY_NUME_PRENUME);
        preparedStatement.setString(1, lastName);
        preparedStatement.setString(2, firstName);
        preparedStatement.executeUpdate();
    }

    public void deleteAllAngajati() throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_ALL_ANGAJATI);
        preparedStatement.executeUpdate();
    }

    public void insertAngajat(String nume, String prenume, Date dataNastere, String grad, String functie) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_INSERT_ANGAJAT);
        preparedStatement.setString(1, nume);
        preparedStatement.setString(2, prenume);
        preparedStatement.setDate(3, dataNastere);
        preparedStatement.setString(4, grad);
        preparedStatement.setString(5, functie);
        preparedStatement.executeUpdate();
    }

    public void editAngajat(String editCrit, String newValue, String condition) throws SQLException{
        String query = "update unitatemilitara.angajat set " + editCrit + " = ";
        query += "'" + newValue + "'" + " where angajat.codIdentificare = " + Integer.parseInt(condition);

        Statement statement = dataBaseConfiguration.getDatabaseConnection().createStatement();
        statement.executeUpdate(query);
    }
}
