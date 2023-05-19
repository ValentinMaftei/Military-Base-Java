package Service.impl;

import Model.EchipamentSpecial;
import Service.EchipamentSpecialService;
import Utile.AuditActionsSingleton;
import Utile.TipSpeciale;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EchipamentSpecialServiceimpl implements EchipamentSpecialService {

    List<EchipamentSpecial> logisticaEchipamentSpecial;
    @Override
    public void addLogisticaEchipamentS(EchipamentSpecial echipamentSpecial) {
        if (logisticaEchipamentSpecial == null)
            logisticaEchipamentSpecial = new ArrayList<>();
        logisticaEchipamentSpecial.add(echipamentSpecial);
    }

    @Override
    public List<EchipamentSpecial> getLogisticaEchipamentSpecial() {
        if (logisticaEchipamentSpecial.size() > 19)
            System.out.println("Batalionul detine " + logisticaEchipamentSpecial.size() + " de echipamente speciale.");
        else
            System.out.println("Batalionul detine " + logisticaEchipamentSpecial.size() + " echipamente speciale.");
        return logisticaEchipamentSpecial;
    }

    @Override
    public void addLogisticaEchipamentS(List<String[]> data) throws IOException {
        if (logisticaEchipamentSpecial == null)
            logisticaEchipamentSpecial = new ArrayList<>();

        for (String[] line : data){
            TipSpeciale tip = TipSpeciale.valueOf(line[0]);
            String model = line[1];
            String taraProvenienta = line[2];

            EchipamentSpecial echipamentSpecial = new EchipamentSpecial(tip, model, taraProvenienta);
            AuditActionsSingleton.INSTANCE.Action("Adăugare echipament special");
            logisticaEchipamentSpecial.add(echipamentSpecial);
        }
    }

    @Override
    public List<EchipamentSpecial> getLogisticaEchipamentSpecialAdd() {
        return logisticaEchipamentSpecial;
    }
}
