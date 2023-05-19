package Service.impl;

import Model.Autovehicul;
import Service.AutovehiculeService;
import Utile.AuditActionsSingleton;
import Utile.CategorieAutovehicule;
import Utile.TipAutovehicul;
import Utile.UtilizareVehicul;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AutovehiculeServiceimpl implements AutovehiculeService {

    List<Autovehicul> listaAutovehicule;
    @Override
    public void addAutovehicule(List<String[]> autovehicule) throws IOException {
        if (listaAutovehicule == null)
            listaAutovehicule = new ArrayList<>();

        for (String[] line : autovehicule){
            String denumire = line[0];
            UtilizareVehicul utilizareVehicul = UtilizareVehicul.valueOf(line[1]);
            String taraProvenienta = line[2];
            boolean blindat = Boolean.parseBoolean(line[3]);
            int nrLocuri = Integer.parseInt(line[4]);
            int autonomie = Integer.parseInt(line[5]);
            int vitezaMaxima = Integer.parseInt(line[6]);
            CategorieAutovehicule categorieAutovehicule = CategorieAutovehicule.valueOf(line[7]);
            boolean suportRemorca = Boolean.parseBoolean(line[8]);
            TipAutovehicul tipAutovehicul = TipAutovehicul.valueOf(line[9]);

            Autovehicul autovehicul = new Autovehicul(denumire, utilizareVehicul, taraProvenienta, blindat, nrLocuri,
                    autonomie, vitezaMaxima, categorieAutovehicule, suportRemorca, tipAutovehicul);

            AuditActionsSingleton.INSTANCE.Action("Adăugare autovehicul");
            listaAutovehicule.add(autovehicul);
        }
    }

    @Override
    public List<Autovehicul> getAutovehicule() {
        return listaAutovehicule;
    }
}
