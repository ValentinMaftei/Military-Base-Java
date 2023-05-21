package Constants;

public class Constants {

    // angajati
    public static final String QUERY_GET_ALL_ANGAJATI = "select * from UnitateMilitara.angajat";
    public static final String QUERY_GET_ANGAJATI_BY_NAME = "select * from angajat where (angajat.nume = ? and angajat.prenume = ?)";
    public static final String QUERY_GET_ANGAJAT_BY_ID = "select * from angajat where (angajat.codIdentificare = ?)";
    public static final String QUERY_DELETE_ANGAJAT_BY_ID = "delete from angajat where (angajat.codIdentificare = ?)";
    public static final String QUERY_DELETE_ANGAJAT_BY_NUME_PRENUME = "delete from angajat where (angajat.nume = ? and angajat.prenume =?)";
    public static final String QUERY_DELETE_ALL_ANGAJATI = "delete from angajat";
    public static final String QUERY_INSERT_ANGAJAT = "insert into angajat(nume, prenume, dataNastere, grad, functie) values (?,?,?,?,?)";

    // artilerie
    public static final String QUERY_GET_ALL_ARTILERIE = "select * from UnitateMilitara.artilerie";
    public static final String QUERY_GET_ARTILERIE_BY_MODEL = "select * from artilerie where (artilerie.model = ?)";
    public static final String QUERY_GET_ARTILERIE_BY_ID = "select * from artilerie where (artilerie.codIdentificare = ?)";
    public static final String QUERY_DELETE_ARTILERIE_BY_ID = "delete from artilerie where (artilerie.codIdentificare = ?)";
    public static final String QUERY_DELETE_ARTILERIE_BY_MODEL = "delete from artilerie where (artilerie.model = ?)";
    public static final String QUERY_DELETE_ALL_ARTILERIE = "delete from artilerie";
    public static final String QUERY_INSERT_ARTILERIE =
            "insert into artilerie(model, categorie, tip, calibru, bataieMaxima, taraProvenienta) values (?,?,?,?,?,?)";

    // infanterie
    public static final String QUERY_GET_ALL_INFANTERIE = "select * from UnitateMilitara.infanterie";
    public static final String QUERY_GET_INFANTERIE_BY_MODEL = "select * from infanterie where (infanterie.model = ?)";
    public static final String QUERY_GET_INFANTERIE_BY_ID = "select * from infanterie where (infanterie.codIdentificare = ?)";
    public static final String QUERY_DELETE_INFANTERIE_BY_ID = "delete from infanterie where (infanterie.codIdentificare = ?)";
    public static final String QUERY_DELETE_INFANTERIE_BY_NAME = "delete from infanterie where (infanterie.model = ?)";
    public static final String QUERY_DELETE_ALL_INFANTERIE = "delete from infanterie";
    public static final String QUERY_INSERT_INFANTERIE = "insert into infanterie(model, categorie, taraProvenienta, calibru, suportLuneta) values" +
            "(?, ?, ?, ?, ?)";

    // special
    public static final String QUERY_GET_ALL_SPECIAL = "select * from UnitateMilitara.special";
    public static final String QUERY_GET_SPECIAL_BY_MODEL = "select * from special where (special.model = ?)";
    public static final String QUERY_GET_SPECIAL_BY_ID = "select * from special where (special.codIdentificare = ?)";
    public static final String QUERY_DELETE_SPECIAL_BY_ID = "delete from special where (special.codIdentificare = ?)";
    public static final String QUERY_DELETE_SPECIAL_BY_NAME = "delete from special where (special.model = ?)";
    public static final String QUERY_DELETE_ALL_SPECIAL = "delete from special";
    public static final String QUERY_INSERT_SPECIAL = "insert into special(tip, model, taraProvenienta) values (?, ?, ?)";

    // transportoare
    public static final String QUERY_GET_ALL_TRANSPORTOARE = "select * from UnitateMilitara.transportor";
    public static final String QUERY_GET_TRANSPORTOARE_BY_DENUMIRE = "select * from transportor where (transportor.denumire = ?)";
    public static final String QUERY_GET_TRANSPORTOR_BY_ID = "select * from transportor where (transportor.codIdentificare = ?)";
    public static final String QUERY_DELETE_TRANSPORTOR_BY_ID = "delete from transportor where (transportor.codIdentificare = ?)";
    public static final String QUERY_DELETE_TRANSPORTOARE_BY_DENUMIRE = "delete from transportor where (transportor.denumire = ?)";
    public static final String QUERY_DELETE_ALL_TRANSPORTOARE = "delete from transportor";
    public static final String QUERY_INSERT_TRANSPORTOR = "INSERT INTO transportor(denumire, utilizare, taraProvenienta," +
            " blindat, nrLocuri, autonomie, vitezaMaxima, armamentPrincipal, armamentSecundar, tip) VALUES " +
            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    // blindate
    public static final String QUERY_GET_ALL_BLINDATE = "select * from UnitateMilitara.blindat";
    public static final String QUERY_GET_BLINDATE_BY_DENUMIRE = "select * from blindat where (blindat.denumire = ?)";
    public static final String QUERY_GET_BLINDAT_BY_ID = "select * from blindat where (blindat.codIdentificare = ?)";
    public static final String QUERY_DELETE_BLINDAT_BY_ID = "delete from blindat where (blindat.codIdentificare = ?)";
    public static final String QUERY_DELETE_BLINDATE_BY_DENUMIRE = "delete from blindat where (blindat.denumire = ?)";
    public static final String QUERY_DELETE_ALL_BLINDATE = "delete from blindat";
    public static final String QUERY_INSERT_BLINDAT = "INSERT INTO blindat(denumire, utilizare, taraProvenienta, " +
            "blindat, nrLocuri, autonomie, vitezaMaxima, suportRemorca, suportArma, arma) VALUES (?,?,?,?,?,?,?,?,?,?)";

    // autovehicule
    public static final String QUERY_GET_ALL_AUTOVEHICULE = "select * from UnitateMilitara.autovehicul";
    public static final String QUERY_GET_AUTOVEHICULE_BY_DENUMIRE = "select * from autovehicul where (autovehicul.denumire = ?)";
    public static final String QUERY_GET_AUTOVEHICUL_BY_ID = "select * from autovehicul where (autovehicul.codIdentificare = ?)";
    public static final String QUERY_DELETE_AUTOVEHICUL_BY_ID = "delete from autovehicul where (autovehicul.codIdentificare = ?)";
    public static final String QUERY_DELETE_AUTOVEHICULE_BY_DENUMIRE = "delete from autovehicul where (autovehicul.denumire = ?)";
    public static final String QUERY_DELETE_ALL_AUTOVEHICULE = "delete from autovehicul";
    public static final String QUERY_INSERT_AUTOVEHICUL = "INSERT INTO autovehicul(denumire, utilizare, taraProvenienta," +
            " blindat, nrLocuri, autonomie, vitezaMaxima, categorie, suportRemorca, tip) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
}
