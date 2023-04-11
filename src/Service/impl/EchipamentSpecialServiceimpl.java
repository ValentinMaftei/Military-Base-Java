package Service.impl;

import Model.EchipamentSpecial;
import Service.EchipamentSpecialService;

import java.util.HashSet;
import java.util.Set;

public class EchipamentSpecialServiceimpl implements EchipamentSpecialService {

    Set<EchipamentSpecial> logisticaEchipamentSpecial;
    @Override
    public void addLogisticaEchipamentS(EchipamentSpecial echipamentSpecial) {
        if (logisticaEchipamentSpecial == null)
            logisticaEchipamentSpecial = new HashSet<>();
        logisticaEchipamentSpecial.add(echipamentSpecial);
    }

    @Override
    public Set<EchipamentSpecial> getLogisticaEchipamentSpecial() {
        if (logisticaEchipamentSpecial.size() > 19)
            System.out.println("Batalionul detine " + logisticaEchipamentSpecial.size() + " de echipamente speciale.");
        else
            System.out.println("Batalionul detine " + logisticaEchipamentSpecial.size() + " echipamente speciale.");
        return logisticaEchipamentSpecial;
    }
}
