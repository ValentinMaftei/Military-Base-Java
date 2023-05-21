package Service.impl;

import Model.Infanterie;
import Service.InfanterieService;
import Utile.AuditActionsSingleton;
import Utile.CategorieInfanterie;

import java.io.IOException;
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

    @Override
    public void addLogisticaInfanterie(List<String[]> infanterie) throws IOException {
        if (logisticaInfanterie == null)
            logisticaInfanterie = new ArrayList<>();
        for (String[] line : infanterie){
            int id = Integer.parseInt(line[0]);
            int idGestionar = Integer.parseInt(line[1]);
            String model = line[2];
            CategorieInfanterie categorieInfanterie = CategorieInfanterie.valueOf(line[3]);
            String taraProvenienta = line[4];
            float calibru = Float.parseFloat(line[5]);
            boolean suportLuneta = Boolean.parseBoolean(line[6]);

            Infanterie infanterieNou = new Infanterie(id, idGestionar, model, categorieInfanterie, taraProvenienta, calibru, suportLuneta);
            AuditActionsSingleton.INSTANCE.Action("Adăugare element infanterie");
            logisticaInfanterie.add(infanterieNou);
        }
    }

    @Override
    public List<Infanterie> getLogisticaInfanterieAdd() {
        return logisticaInfanterie;
    }
}