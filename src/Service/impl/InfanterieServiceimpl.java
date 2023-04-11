package Service.impl;

import Model.Infanterie;
import Service.InfanterieService;

import java.util.ArrayList;
import java.util.List;

public class InfanterieServiceimpl implements InfanterieService {
    List<Infanterie> logisticaInfanterie;
    @Override
    public void addLogisticaInfanterie(Infanterie infanterie) {
        if (logisticaInfanterie == null)
            logisticaInfanterie = new ArrayList<>();
        logisticaInfanterie.add(infanterie);
    }

    @Override
    public List<Infanterie> getLogisticaInfanterie() {
        if (logisticaInfanterie.size() > 19)
            System.out.println("Batalionul detine " + logisticaInfanterie.size() + " de elemente de infanterie.");
        else
            System.out.println("Batalionul detine " + logisticaInfanterie.size() + " elemente de infanterie.");
        return logisticaInfanterie;
    }
}
