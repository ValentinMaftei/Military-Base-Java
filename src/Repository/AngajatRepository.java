package Repository;

import Config.DataBaseConfiguration;
import Model.*;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Utile.*;

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
        boolean ok = false;
        while (resultSet.next()) {
            ok = true;
            angajat.setCodIdentificare(resultSet.getInt("codIdentificare"));
            angajat.setNume(resultSet.getString("nume"));
            angajat.setPrenume(resultSet.getString("prenume"));
            angajat.setDataNastere(resultSet.getDate("dataNastere"));
            angajat.setGrad(Grad.valueOf(resultSet.getString("grad")));
            angajat.setTitlu(Functie.valueOf(resultSet.getString("functie")));
        }
        if (!ok)
            return null;
        else
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

    public void deleteAllAngajati() throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_DELETE_ALL_ANGAJATI);
        preparedStatement.executeUpdate();
    }

    public void insertAngajat(String nume, String prenume, Date dataNastere, String grad, String functie) throws SQLException{
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_INSERT_ANGAJAT);
        preparedStatement.setString(1, nume);
        preparedStatement.setString(2, prenume);
        preparedStatement.setDate(3, dataNastere);
        preparedStatement.setString(4, grad);
        preparedStatement.setString(5, functie);
        preparedStatement.executeUpdate();
    }

    public void editAngajat(String editCrit, String newValue, String condition) throws SQLException{
        String query = "update unitatemilitara.angajat set " + editCrit + " = ";
        query += "'" + newValue + "'" + " where angajat.codIdentificare = " + Integer.parseInt(condition);

        Statement statement = dataBaseConfiguration.getDatabaseConnection().createStatement();
        statement.executeUpdate(query);
    }

   /* public List<Artilerie> getGestiuneArtilerieAngajatId(int id) throws SQLException{
        List<Artilerie> artilerieList = new ArrayList<>();
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_GET_GESTIONAR_ARTILERIE);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Artilerie artilerie = new Artilerie(resultSet.getInt("codIdentificare"),
                    resultSet.getInt("idGestionarArtilerie"),
                    resultSet.getString("model"),
                    CategorieArtilerie.valueOf(resultSet.getString("categorie")),
                    TipArtilerie.valueOf(resultSet.getString("tip")),
                    resultSet.getFloat("calibru"),
                    resultSet.getInt("bataieMaxima"),
                    resultSet.getString("taraProvenienta")
            );

            artilerieList.add(artilerie);
        }
        if (artilerieList.size() == 0)
            return null;
        else
            return artilerieList;
    }

    public List<Autovehicul> getGestiuneAutovehiculeAngajatId(int id) throws SQLException{
        List<Autovehicul> autovehiculList = new ArrayList<>();
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_GET_GESTIONAR_AUTOVEHICUL);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
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

            autovehiculList.add(autovehicul);
        }
        if (autovehiculList.size() == 0)
            return null;
        else
            return autovehiculList;
    }

    public List<Blindat> getGestiuneBlindateAngajatId(int id) throws SQLException {
        List<Blindat> blindatList = new ArrayList<>();
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_GET_GESTIONAR_BLINDAT);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
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

            blindatList.add(blindat);
        }
        if (blindatList.size() == 0)
            return null;
        else
            return blindatList;
    }

    public List<EchipamentSpecial> getGestionarEchipamentSpecialId(int id) throws SQLException {
        List<EchipamentSpecial> echipamentSpecialList = new ArrayList<>();
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_GET_GESTIONAR_SPECIAL);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            EchipamentSpecial echipamentSpecial = new EchipamentSpecial(resultSet.getInt("codIdentificare"),
                    resultSet.getInt("idGestionarSpecial"),
                    TipSpeciale.valueOf(resultSet.getString("tip")),
                    resultSet.getString("model"),
                    resultSet.getString("taraProvenienta"));

            echipamentSpecialList.add(echipamentSpecial);
        }
        if (echipamentSpecialList.size() == 0)
            return null;
        else
            return echipamentSpecialList;
    }

    public List<Infanterie> getGestionarInfanterieId(int id) throws SQLException {
        List<Infanterie> infanterieList = new ArrayList<>();
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_GET_GESTIONAR_INFANTERIE);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Infanterie infanterie = new Infanterie(resultSet.getInt("codIdentificare"),
                    resultSet.getInt("idGestionarInfanterie"),
                    resultSet.getString("model"),
                    CategorieInfanterie.valueOf(resultSet.getString("categorie")),
                    resultSet.getString("taraProvenienta"),
                    resultSet.getFloat("calibru"),
                    resultSet.getBoolean("suportLuneta")
            );
            infanterieList.add(infanterie);
        }
        if (infanterieList.size() == 0)
            return null;
        else
            return infanterieList;
    }

    public List<Transportor> getGestionarTransportorId(int id) throws SQLException {
        List<Transportor> transportorList = new ArrayList<>();
        PreparedStatement preparedStatement = dataBaseConfiguration.getDatabaseConnection().prepareStatement(QUERY_GET_GESTIONAR_TRANSPORTOR);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
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

            transportorList.add(transportor);
        }
        if (transportorList.size() == 0)
            return null;
        else
            return transportorList;
    }
    */
}
