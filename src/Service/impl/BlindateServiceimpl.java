package Service.impl;

import Model.Blindat;
import Service.BlindateService;
import Utile.AuditActionsSingleton;
import Utile.UtilizareVehicul;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BlindateServiceimpl implements BlindateService {
    List<Blindat> listaBlindate;
    @Override
    public void addBlindate(List<String[]> blindate) throws IOException {
        if (listaBlindate == null)
            listaBlindate = new ArrayList<>();

        for (String[] line : blindate){
            int id = Integer.parseInt(line[0]);
            int idGestionar = Integer.parseInt(line[1]);
            String model = line[2];
            UtilizareVehicul utilizareVehicul = UtilizareVehicul.valueOf(line[3]);
            String taraProvenienta = line[4];
            boolean blindat = Boolean.parseBoolean(line[5]);
            int nrLocuri = Integer.parseInt(line[6]);
            int autonomie = Integer.parseInt(line[7]);
            int vitezaMaxima = Integer.parseInt(line[8]);
            boolean suportRemorca = Boolean.parseBoolean(line[9]);
            boolean suportArma = Boolean.parseBoolean(line[10]);
            String arma = line[11];

            Blindat blindatNou = new Blindat(id, idGestionar,model, utilizareVehicul, taraProvenienta, blindat, nrLocuri, autonomie,
                    vitezaMaxima, suportRemorca, suportArma, arma);

            AuditActionsSingleton.INSTANCE.Action("Adăugare blindat");
            listaBlindate.add(blindatNou);
        }
    }

    @Override
    public List<Blindat> getBlindate() {
        return listaBlindate;
    }
}