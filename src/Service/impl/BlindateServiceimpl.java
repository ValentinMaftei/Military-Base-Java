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
            String model = line[0];
            UtilizareVehicul utilizareVehicul = UtilizareVehicul.valueOf(line[1]);
            String taraProvenienta = line[2];
            boolean blindat = Boolean.parseBoolean(line[3]);
            int nrLocuri = Integer.parseInt(line[4]);
            int autonomie = Integer.parseInt(line[5]);
            int vitezaMaxima = Integer.parseInt(line[6]);
            boolean suportRemorca = Boolean.parseBoolean(line[7]);
            boolean suportArma = Boolean.parseBoolean(line[8]);
            String arma = line[9];

            Blindat blindatNou = new Blindat(model, utilizareVehicul, taraProvenienta, blindat, nrLocuri, autonomie,
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
