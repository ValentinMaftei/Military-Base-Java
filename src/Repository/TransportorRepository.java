package Repository;

import Config.DataBaseConfiguration;
import Model.Transportor;
import Utile.TipTransportor;
import Utile.UtilizareVehicul;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static Constants.Constants.*;

public class TransportorRepository {

    private final DataBaseConfiguration dataBaseConfiguration;
    public TransportorRepository(DataBaseConfiguration dataBaseConfiguration){
        this.dataBaseConfiguration = dataBaseConfiguration;
    }

    public List<Transportor> getAllTransportoare() throws SQLException{
        Statement statement = dataBaseConfiguration.getDatabaseConnection().createStatement();
        List<Transportor> listTransportoare = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(QUERY_GET_ALL_TRANSPORTOARE);
        while (resultSet.next()){
            Transportor transportor = new Transportor(resultSet.getInt("codIdentificare"),
                    resultSet.getInt("idGestionarTransportor"),
                    resultSet.getString("denumire"),
                    UtilizareVehicul.valueOf(resultSet.getString("utilizare")),
                    resultSet.getString("taraProvenienta"),
                    resultSet.getBoolean("blindat"),
                    resultSet.getInt("nrLocuri"),
                    resultSet.getInt("autonomie"),
                    resultSet.getInt("vitezaMaxima"),
                    resultSet.getString("armamentPrincipal"),
                    resultSet.getString("armamentSecundar"),
                    TipTransportor.valueOf(resultSet.getString("tip")));

            listTransportoare.add(transportor);
        }
        return listTransportoare;
    }

    public List<Transportor> getTransportorByModel(String model) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_GET_TRANSPORTOARE_BY_DENUMIRE);
        preparedStatement.setString(1, model);
        List<Transportor> listTransportoare = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Transportor transportor = new Transportor(resultSet.getInt("codIdentificare"),
                    resultSet.getInt("idGestionarTransportor"),
                    resultSet.getString("denumire"),
                    UtilizareVehicul.valueOf(resultSet.getString("utilizare")),
                    resultSet.getString("taraProvenienta"),
                    resultSet.getBoolean("blindat"),
                    resultSet.getInt("nrLocuri"),
                    resultSet.getInt("autonomie"),
                    resultSet.getInt("vitezaMaxima"),
                    resultSet.getString("armamentPrincipal"),
                    resultSet.getString("armamentSecundar"),
                    TipTransportor.valueOf(resultSet.getString("tip")));

            listTransportoare.add(transportor);
        }
        return listTransportoare;
    }

    public Transportor getTransportorById(int id) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_GET_TRANSPORTOR_BY_ID);
        preparedStatement.setInt(1, id);
        Transportor transportor = new Transportor();
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean ok = false;
        while (resultSet.next()){
            ok = true;
            transportor.setCodIdentificare(resultSet.getInt("codIdentificare"));
            transportor.setIdGestionar(resultSet.getInt("idGestionarTransportor"));
            transportor.setDenumire(resultSet.getString("denumire"));
            transportor.setUtilizare(UtilizareVehicul.valueOf(resultSet.getString("utilizare")));
            transportor.setTaraProvenienta(resultSet.getString("taraProvenienta"));
            transportor.setBlindat(resultSet.getBoolean("blindat"));
            transportor.setNrLocuri(resultSet.getInt("nrLocuri"));
            transportor.setAutonomie(resultSet.getInt("autonomie"));
            transportor.setVitezaMaxima(resultSet.getInt("vitezaMaxima"));
            transportor.setArmamentPrincipal(resultSet.getString("armamentPrincipal"));
            transportor.setArmamentSecundar(resultSet.getString("armamentSecundar"));
            transportor.setTipVehicul(TipTransportor.valueOf(resultSet.getString("tip")));
        }
        if (!ok)
            return null;
        else
            return transportor;
    }

    public void deleteTransportorById(int id) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_TRANSPORTOR_BY_ID);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public void deleteTransportorByDenumire(String denumire) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_TRANSPORTOARE_BY_DENUMIRE);
        preparedStatement.setString(1, denumire);
        preparedStatement.executeUpdate();
    }

    public void deleteAllTransportoare() throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_ALL_TRANSPORTOARE);
        preparedStatement.executeUpdate();
    }

    public void insertTransportor(String denumire, String utilizare, String taraProvenienta, boolean blinat, int nrLocuri,
                                  int autonomie, int vitezaMaxima, String armamentPrincipal, String armamentSecundar,
                                  String tip) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_INSERT_TRANSPORTOR);
        preparedStatement.setString(1, denumire);
        preparedStatement.setString(2, utilizare);
        preparedStatement.setString(3, taraProvenienta);
        preparedStatement.setBoolean(4, blinat);
        preparedStatement.setInt(5, nrLocuri);
        preparedStatement.setInt(6, autonomie);
        preparedStatement.setInt(7, vitezaMaxima);
        preparedStatement.setString(8, armamentPrincipal);
        preparedStatement.setString(9, armamentSecundar);
        preparedStatement.setString(10, tip);
        preparedStatement.executeUpdate();
    }

    public void editTransportor(String editCrit, String newValue, String condition) throws SQLException {
        String query = "update unitatemilitara.transportor set " + editCrit + " = ";
        if (editCrit.equals("armamentSecundar") || editCrit.equals("armamentPrinciapl") || editCrit.equals("denumire") ||
                editCrit.equals("tip") || editCrit.equals("utilizare") || editCrit.equals("taraProvenienta")){
            query += "'" + newValue + "'" + " where transportor.codIdentificare = " + Integer.parseInt(condition);
        }
        else if (editCrit.equals("autonomie") || editCrit.equals("idGestionarTransportor") || editCrit.equals("nrLocuri") ||
                editCrit.equals("vitezaMaxima")){
            query += Integer.parseInt(newValue) + " where transportor.codIdentificare = " + Integer.parseInt(condition);
        }
        else if (editCrit.equals("blindat")){
            query += Boolean.parseBoolean(newValue) + " where transportor.codIdentificare = " + Integer.parseInt(condition);
        }
        Statement statement = dataBaseConfiguration.getDatabaseConnection().createStatement();
        statement.executeUpdate(query);

    }

    public void deleteGestionarTransportor(int id) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_GESTIONAR_TRANSPORTOR);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
