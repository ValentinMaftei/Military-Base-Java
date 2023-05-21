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
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_AUTOVEHICUL_BY_ID);
        preparedStatement.setInt(1, id);
        Autovehicul autovehicul = new Autovehicul();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            autovehicul.setCodIdentificare(resultSet.getInt("codIdentificare"));
            autovehicul.setIdGestionar(resultSet.getInt("idGestionarAutovehicul"));
            autovehicul.setDenumire(resultSet.getString("denumire"));
            autovehicul.setUtilizare(UtilizareVehicul.valueOf(resultSet.getString("utilizare"));
            autovehicul.setTaraProvenienta(resultSet.getString("taraProvenienta"));
            autovehicul.setBlindat(resultSet.getBoolean("blindat"));
            autovehicul.setNrLocuri(resultSet.getInt("nrLocuri"));
            autovehicul.setAutonomie(resultSet.getInt("autonomie"));
            autovehicul.setVitezaMaxima(resultSet.getInt("vitezaMaxima"));
            autovehicul.setCategoriePermis(CategorieAutovehicule.valueOf(resultSet.getString("categorie")));
            autovehicul.setSuportRemorca(resultSet.getBoolean("suportRemorca"));
            autovehicul.setTip(TipAutovehicul.valueOf(resultSet.getString("tip")));
        }
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
}
