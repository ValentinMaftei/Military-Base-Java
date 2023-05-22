package Service;

import Model.Blindat;

import java.util.List;

public interface BlindateServiceDB {
    public List<Blindat> getAllBlindate();
    public List<Blindat> getBlindatByDenumire(String denumire);
    public Blindat getBlindatById(int id);
    public void deleteBlindatById(int id);
    public void deleteBlindatByDenumire(String denumire);
    public void deleteAllBlindate();
    public void insertBlindat(String denumire, String utilizare, String taraProvenienta, boolean blindat, int nrLocuri,
                              int autonomie, int vitezaMaxima, boolean suportRemorca, boolean suportArma, String arma);
    public void editBlindat(String editCrit, String newValue, String condition);
    public void deleteGestionarBlindat(int id);
}
