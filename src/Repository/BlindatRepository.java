package Repository;

import Config.DataBaseConfiguration;
import Model.Blindat;
import Utile.UtilizareVehicul;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static Constants.Constants.QUERY_GET_ALL_BLINDATE;

public class BlindatRepository {
    private final DataBaseConfiguration dataBaseConfiguration;

    public BlindatRepository(DataBaseConfiguration dataBaseConfiguration){
        this.dataBaseConfiguration = dataBaseConfiguration;
    }

    public List<Blindat> getAllBlindate() throws SQLException{
        Statement statement = dataBaseConfiguration.getDatabaseConnection().createStatement();
        List<Blindat> listBlidante = new ArrayList<>();
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

            listBlidante.add(blindat);
        }
        return listBlidante;
    }
}
