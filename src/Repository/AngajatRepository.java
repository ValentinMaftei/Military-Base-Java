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
        while (resultSet.next()) {
            angajat.setCodIdentificare(resultSet.getInt("codIdentificare"));
            angajat.setNume(resultSet.getString("nume"));
            angajat.setPrenume(resultSet.getString("prenume"));
            angajat.setDataNastere(resultSet.getDate("dataNastere"));
            angajat.setGrad(Grad.valueOf(resultSet.getString("grad")));
            angajat.setTitlu(Functie.valueOf(resultSet.getString("functie")));
        }
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
}
