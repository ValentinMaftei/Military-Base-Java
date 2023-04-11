package Service;

import Model.Artilerie;
import Model.Infanterie;

import java.util.List;

public interface InfanterieService {
    void addLogisticaInfanterie(Infanterie infanterie);
    List<Infanterie> getLogisticaInfanterie();
}
