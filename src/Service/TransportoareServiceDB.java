package Service;

import Model.Transportor;

import java.util.List;

public interface TransportoareServiceDB {
    public List<Transportor> getAllTransportoare();
    public List<Transportor> getTransportorByDenumire(String model);
    public Transportor getTransportorById(int id);
    public void deleteTransportorById(int id);
    public void deleteTransportorByDenumire(String denumire);
    public void deleteAllTransportoare();
    public void insertTransportor(String denumire, String utilizare, String taraProvenienta, boolean blinat, int nrLocuri,
                                  int autonomie, int vitezaMaxima, String armamentPrincipal, String armamentSecundar,
                                  String tip);
    public void editTransportor(String editCrit, String newValue, String condition);
    public void deleteGestionarTransportor(int id);
}
