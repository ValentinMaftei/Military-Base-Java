package Service;

import Model.EchipamentSpecial;

import java.util.List;

public interface EchipamentSpecialServiceDB {
    public List<EchipamentSpecial> getAllEchipamentSpecial();
    public List<EchipamentSpecial> getEchipamentSpecialByModel(String model);
    public EchipamentSpecial getEchipamentSpecialById(int id);
    public void deleteEchipamentSpecialById(int id);
    public void deleteEchipamentSpecialByModel(String model);
    public void deleteAllSpeciale();
    public void insertEchipamentSpecial(String tip, String model, String taraProvenienta);
    public void editEchipamentSpecial(String editCrit, String newValue, String condition);
    public void deleteGestionarEchipamentSpecial(int id);
}
