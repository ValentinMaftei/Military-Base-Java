package Service;

import Model.Artilerie;

import java.io.IOException;
import java.util.List;

public interface ArtilerieService {
    void addLogisticaArtilerie(Artilerie artilerie);
    List<Artilerie> getLogisticaArtilerie();
    void addLogisticaArtilerie(List<String[]> artilerie) throws IOException;
    List<Artilerie> getLogisticaArtilerieAdd();
}
