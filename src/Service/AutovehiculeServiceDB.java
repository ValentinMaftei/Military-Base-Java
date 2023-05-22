package Service;

import Model.Autovehicul;

import java.util.List;

public interface AutovehiculeServiceDB {
    public List<Autovehicul> getAllAutovehicule();
    public List<Autovehicul> getAutovehiculByDenumire(String model);
    public Autovehicul getAutovehiculById(int id);
    public void deleteAutovehiculById(int id);
    public void deleteAutovehiculByDenumire(String denumire);
    public void deleteAllAutovehicule();
    public void insertAutovehicul(String denumire, String utilizare, String taraProvenienta, boolean blindat, int nrLocuri,
                                  int autonomie, int vitezaMaxima, String categorie, boolean suportRemorca, String tip);
    public void editAutovehicul(String editCrit, String newValue, String condition);
    public void deleteGestionarAutovehicul(int id);
}
