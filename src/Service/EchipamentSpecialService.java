package Service;

import Model.EchipamentSpecial;

import java.io.File;
import java.util.List;
import java.util.Set;

public interface EchipamentSpecialService {
    void addLogisticaEchipamentS(EchipamentSpecial echipamentSpecial);
    Set<EchipamentSpecial> getLogisticaEchipamentSpecial();
    void addLogisticaEchipamentS(List<String[]> data);

}
