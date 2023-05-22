package Service;

import Model.Artilerie;

import java.util.List;

public interface ArtilerieServiceDB {
    public List<Artilerie> getAllArtilerie();
    public List<Artilerie> getArtilerieByModel(String model);
    public Artilerie getArtilerieById(int id);
    public void deleteArtilerieById(int id);
    public void deleteArtilerieByModel(String model);
    public void deleteAllArtilerie();
    public void insertArtilerie(String model, String categorie, String tip, float calibru, int bataieMaxima, String taraProvenienta);
    public void editArtilerie(String editCrit, String newValue, String condition);
    public void deleteGestionarArtilerie(int id);
}
