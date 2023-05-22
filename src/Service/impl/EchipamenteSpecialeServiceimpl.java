package Service.impl;

import Model.EchipamentSpecial;
import Service.EchipamentSpecialService;
import Utile.AuditActionsSingleton;
import Utile.TipSpeciale;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EchipamenteSpecialeServiceimpl implements EchipamentSpecialService {

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
            int id = Integer.parseInt(line[0]);
            int idGestionar = Integer.parseInt(line[1]);
            TipSpeciale tip = TipSpeciale.valueOf(line[2]);
            String model = line[3];
            String taraProvenienta = line[4];

            EchipamentSpecial echipamentSpecial = new EchipamentSpecial(id, idGestionar,tip, model, taraProvenienta);
            AuditActionsSingleton.INSTANCE.Action("Adăugare echipament special");
            logisticaEchipamentSpecial.add(echipamentSpecial);
        }
    }

    @Override
    public List<EchipamentSpecial> getLogisticaEchipamentSpecialAdd() {
        return logisticaEchipamentSpecial;
    }
}