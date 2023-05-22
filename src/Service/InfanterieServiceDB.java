package Service;

import Model.Infanterie;

import java.util.List;

public interface InfanterieServiceDB {
    public List<Infanterie> getAllInfanterie();
    public List<Infanterie> getInfanterieByModel(String model);
    public Infanterie getInfanterieById(int id);
    public void deleteInfanterieById(int id);
    public void deleteInfanterieByModel(String model);
    public void deleteAllInfanterie();
    public void insertInfanterie(String model, String categorie, String taraProvenienta, float calibru, boolean suportLuneta);
    public void editInfanterie(String editCrit, String newValue, String condition);
    public void deleteGestionarInfanterie(int id);
}
