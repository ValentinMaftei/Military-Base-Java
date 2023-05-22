package Repository;

import Config.DataBaseConfiguration;
import Model.EchipamentSpecial;
import Utile.TipSpeciale;

import java.rmi.server.RemoteRef;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static Constants.Constants.*;

public class EchipamentSpecialRepository {
    private final DataBaseConfiguration dataBaseConfiguration;

    public EchipamentSpecialRepository(DataBaseConfiguration dataBaseConfiguration){
        this.dataBaseConfiguration = dataBaseConfiguration;
    }

    public List<EchipamentSpecial> getAllEchipamentSpecial() throws SQLException{
        Statement statement = dataBaseConfiguration.getDatabaseConnection().createStatement();
        List<EchipamentSpecial> listEchipamentSpecial = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(QUERY_GET_ALL_SPECIAL);
        while (resultSet.next()){
            EchipamentSpecial echipamentSpecial = new EchipamentSpecial(resultSet.getInt("codIdentificare"),
                    resultSet.getInt("idGestionarSpecial"),
                    TipSpeciale.valueOf(resultSet.getString("tip")),
                    resultSet.getString("model"),
                    resultSet.getString("taraProvenienta"));

            listEchipamentSpecial.add(echipamentSpecial);
        }
        return listEchipamentSpecial;
    }

    public List<EchipamentSpecial> getEchipamentSpecialByModel(String model) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_GET_SPECIAL_BY_MODEL);
        List<EchipamentSpecial> listEchipamentSpecial = new ArrayList<>();
        preparedStatement.setString(1, model);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            EchipamentSpecial echipamentSpecial = new EchipamentSpecial(resultSet.getInt("codIdentificare"),
                    resultSet.getInt("idGestionarSpecial"),
                    TipSpeciale.valueOf(resultSet.getString("tip")),
                    resultSet.getString("model"),
                    resultSet.getString("taraProvenienta"));

            listEchipamentSpecial.add(echipamentSpecial);
        }
        return listEchipamentSpecial;
    }

    public EchipamentSpecial getEchipamentSpecialById(int id) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_GET_SPECIAL_BY_ID);
        EchipamentSpecial echipamentSpecial = new EchipamentSpecial();
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean ok = false;
        while (resultSet.next()){
            ok = true;
            echipamentSpecial.setCodIdentificare(resultSet.getInt("codIdentificare"));
            echipamentSpecial.setIdGestionar(resultSet.getInt("idGestionarSpecial"));
            echipamentSpecial.setTip(TipSpeciale.valueOf(resultSet.getString("tip")));
            echipamentSpecial.setModel(resultSet.getString("model"));
            echipamentSpecial.setTaraProvenienta(resultSet.getString("taraProvenienta"));
        }
        if (!ok)
            return null;
        else
            return echipamentSpecial;
    }

    public void deleteEchipamentSpecialById(int id) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_SPECIAL_BY_ID);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public void deleteEchipamentSpecialByModel(String model) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_SPECIAL_BY_NAME);
        preparedStatement.setString(1, model);
        preparedStatement.executeUpdate();
    }

    public void deleteAllSpeciale() throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_ALL_SPECIAL);
        preparedStatement.executeUpdate();
    }
    public void insertEchipamentSpecial(String tip, String model, String taraProvenienta) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_INSERT_SPECIAL);
        preparedStatement.setString(1, tip);
        preparedStatement.setString(2, model);
        preparedStatement.setString(3, taraProvenienta);
        preparedStatement.executeUpdate();
    }

    public void editEchipamentSpecial(String editCrit, String newValue, String condition) throws SQLException {
        String query = "update unitatemilitara.special set " + editCrit + " = ";
        if (editCrit.equals("model") || editCrit.equals("taraProvenienta") || editCrit.equals("tip")){
            query += "'" + newValue + "'" + "where special.codIdentificare = " + Integer.parseInt(condition);
        }
        else if (editCrit.equals("idGestionarSpecial")){
            query += Integer.parseInt(newValue) + "where special.codIdentificare = " + Integer.parseInt(condition);
        }

        Statement statement = dataBaseConfiguration.getDatabaseConnection().createStatement();
        statement.executeUpdate(query);
    }


    public void deleteGestionarEchipamentSpecial(int id) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_GESTIONAR_SPECIAL);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
