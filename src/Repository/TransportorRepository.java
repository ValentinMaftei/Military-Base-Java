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
        while (resultSet.next()){
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
}