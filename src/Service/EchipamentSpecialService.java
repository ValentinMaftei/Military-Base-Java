package Service;

import Model.EchipamentSpecial;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface EchipamentSpecialService {
    void addLogisticaEchipamentS(EchipamentSpecial echipamentSpecial);
    List<EchipamentSpecial> getLogisticaEchipamentSpecial();
    void addLogisticaEchipamentS(List<String[]> data) throws IOException;
    List<EchipamentSpecial> getLogisticaEchipamentSpecialAdd();

}
