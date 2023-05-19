package Service;

import Model.Artilerie;
import Model.Infanterie;

import java.io.IOException;
import java.util.List;

public interface InfanterieService {
    void addLogisticaInfanterie(Infanterie infanterie);
    List<Infanterie> getLogisticaInfanterie();
    void addLogisticaInfanterie(List<String[]> infanterie) throws IOException;
    List<Infanterie> getLogisticaInfanterieAdd();

}
