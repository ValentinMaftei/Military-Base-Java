package Service;

import Model.Artilerie;

import java.util.List;

public interface ArtilerieService {
    void addLogisticaArtilerie(Artilerie artilerie);
    List<Artilerie> getLogisticaArtilerie();
}
