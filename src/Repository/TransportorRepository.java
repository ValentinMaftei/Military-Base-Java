package Repository;

import Config.DataBaseConfiguration;
import Model.Transportor;
import Utile.TipTransportor;
import Utile.UtilizareVehicul;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static Constants.Constants.QUERY_GET_ALL_TRANSPORTOARE;

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
}
