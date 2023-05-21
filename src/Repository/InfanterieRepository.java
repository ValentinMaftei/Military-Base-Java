package Repository;

import Config.DataBaseConfiguration;
import Model.Infanterie;
import Utile.CategorieInfanterie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static Constants.Constants.*;

public class InfanterieRepository {
    private final DataBaseConfiguration dataBaseConfiguration;
    public InfanterieRepository(DataBaseConfiguration dataBaseConfiguration){
        this.dataBaseConfiguration = dataBaseConfiguration;
    }

    public List<Infanterie> getAllInfanterie() throws SQLException{
        Statement statement = dataBaseConfiguration.getDatabaseConnection().createStatement();
        List<Infanterie> listInfanterie = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(QUERY_GET_ALL_INFANTERIE);
        while (resultSet.next()){
            Infanterie infanterie = new Infanterie(resultSet.getInt("codIdentificare"),
                    resultSet.getInt("idGestionarInfanterie"),
                    resultSet.getString("model"),
                    CategorieInfanterie.valueOf(resultSet.getString("categorie")),
                    resultSet.getString("taraProvenienta"),
                    resultSet.getFloat("calibru"),
                    resultSet.getBoolean("suportLuneta")
                    );

            listInfanterie.add(infanterie);
        }
        return listInfanterie;
    }

    public List<Infanterie> getInfanterieByModel(String model) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_GET_INFANTERIE_BY_MODEL);
        preparedStatement.setString(1, model);
        List<Infanterie> listInfanterie = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Infanterie infanterie = new Infanterie(resultSet.getInt("codIdentificare"),
                    resultSet.getInt("idGestionarInfanterie"),
                    resultSet.getString("model"),
                    CategorieInfanterie.valueOf(resultSet.getString("categorie")),
                    resultSet.getString("taraProvenienta"),
                    resultSet.getFloat("calibru"),
                    resultSet.getBoolean("suportLuneta")
            );

            listInfanterie.add(infanterie);
        }
        return listInfanterie;
    }

    public Infanterie getInfanterieById(int id) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_GET_INFANTERIE_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Infanterie infanterie = new Infanterie();
        while (resultSet.next()){
            infanterie.setCodIdentificare(resultSet.getInt("codIdentificare"));
            infanterie.setIdGestionar(resultSet.getInt("idGestionarInfanterie"));
            infanterie.setModel(resultSet.getString("model"));
            infanterie.setCategorie(CategorieInfanterie.valueOf(resultSet.getString("categorie")));
            infanterie.setTaraProvenienta(resultSet.getString("taraProvenienta"));
            infanterie.setCalibru(resultSet.getFloat("calibru"));
            infanterie.setSuportLuneta(resultSet.getBoolean("suportLuneta"));
        }

        return infanterie;
    }

    public void deleteInfanterieById(int id) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_INFANTERIE_BY_ID);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public void deleteInfanterieByModel(String model) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_INFANTERIE_BY_NAME);
        preparedStatement.setString(1, model);
        preparedStatement.executeUpdate();
    }

    public void deleteAllInfanterie() throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_ALL_INFANTERIE);
        preparedStatement.executeUpdate();
    }

    public void insertInfanterie(String model, String categorie, String taraProvenienta, float calibru, boolean suportLuneta) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_INSERT_INFANTERIE);
        preparedStatement.setString(1, model);
        preparedStatement.setString(2, categorie);
        preparedStatement.setString(3, taraProvenienta);
        preparedStatement.setFloat(4, calibru);
        preparedStatement.setBoolean(5, suportLuneta);
        preparedStatement.executeUpdate();
    }
}
