package Repository;

import Config.DataBaseConfiguration;
import Model.Artilerie;
import Utile.CategorieArtilerie;
import Utile.TipArtilerie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static Constants.Constants.*;

public class ArtilerieRepository {
    private final DataBaseConfiguration dataBaseConfiguration;
    public ArtilerieRepository(DataBaseConfiguration dataBaseConfiguration){
        this.dataBaseConfiguration = dataBaseConfiguration;
    }

    public List<Artilerie> getAllArtilerie() throws SQLException{
        Statement statement = dataBaseConfiguration.getDatabaseConnection().createStatement();
        List<Artilerie> listArtilerie = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(QUERY_GET_ALL_ARTILERIE);
        while (resultSet.next()){
            Artilerie artilerie = new Artilerie(resultSet.getInt("codIdentificare"),
                    resultSet.getInt("idGestionarArtilerie"),
                    resultSet.getString("model"),
                    CategorieArtilerie.valueOf(resultSet.getString("categorie")),
                    TipArtilerie.valueOf(resultSet.getString("tip")),
                    resultSet.getFloat("calibru"),
                    resultSet.getInt("bataieMaxima"),
                    resultSet.getString("taraProvenienta")
                    );

            listArtilerie.add(artilerie);
        }
        return listArtilerie;
    }

    public List<Artilerie> getArtilerieByModel(String model) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_GET_ARTILERIE_BY_MODEL);
        preparedStatement.setString(1, model);
        List<Artilerie> listaArtilerie = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Artilerie artilerie = new Artilerie(resultSet.getInt("codIdentificare"),
                    resultSet.getInt("idGestionarArtilerie"),
                    resultSet.getString("model"),
                    CategorieArtilerie.valueOf(resultSet.getString("categorie")),
                    TipArtilerie.valueOf(resultSet.getString("tip")),
                    resultSet.getFloat("calibru"),
                    resultSet.getInt("bataieMaxima"),
                    resultSet.getString("taraProvenienta")
            );

            listaArtilerie.add(artilerie);
        }
        return listaArtilerie;
    }

    public Artilerie getArtilerieById(int id) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_GET_ARTILERIE_BY_ID);
        preparedStatement.setInt(1, id);
        Artilerie artilerie = new Artilerie();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            artilerie.setCodIdentificare(resultSet.getInt("codIdentificare"));
            artilerie.setIdGestionar(resultSet.getInt("idGestionarArtilerie"));
            artilerie.setModel(resultSet.getString("model"));
            artilerie.setCategorie(CategorieArtilerie.valueOf(resultSet.getString("categorie")));
            artilerie.setTip(TipArtilerie.valueOf(resultSet.getString("tip")));
            artilerie.setCalibru(resultSet.getFloat("calibru"));
            artilerie.setBataieMaxima(resultSet.getInt("bataieMaxima"));
            artilerie.setTaraProvenienta(resultSet.getString("taraProvenienta"));
        }
        return artilerie;
    }

    public void deleteArtilerieById(int id) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_ARTILERIE_BY_ID);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        System.out.println("Elementul de artilerie a fost sters!");
    }

    public void deleteArtilerieByModel(String model) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_ARTILERIE_BY_MODEL);
        preparedStatement.setString(1, model);
        preparedStatement.executeUpdate();
        System.out.println("Elementul de artilerie a fost sters!");
    }
}
