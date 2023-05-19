package Service.impl;

import Model.EchipamentSpecial;
import Service.EchipamentSpecialService;
import Utile.TipSpeciale;

import java.io.File;
import java.util.HashSet;
import java.util.List;
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

    @Override
    public void addLogisticaEchipamentS(List<String[]> data) {
        if (logisticaEchipamentSpecial == null)
            logisticaEchipamentSpecial = new HashSet<>();

        for (String[] line : data){
            TipSpeciale tip = TipSpeciale.valueOf(line[0]);
            String model = line[1];
            String taraProvenienta = line[2];

            EchipamentSpecial echipamentSpecial = new EchipamentSpecial(tip, model, taraProvenienta);
            logisticaEchipamentSpecial.add(echipamentSpecial);
        }
    }
}
