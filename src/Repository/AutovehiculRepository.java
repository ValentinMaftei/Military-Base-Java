package Repository;

import Config.DataBaseConfiguration;
import Model.Autovehicul;
import Utile.CategorieAutovehicule;
import Utile.TipAutovehicul;
import Utile.UtilizareVehicul;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static Constants.Constants.QUERY_GET_ALL_AUTOVEHICULE;

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


}
