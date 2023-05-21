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
            int id = Integer.parseInt(line[0]);
            int idGestionar = Integer.parseInt(line[1]);
            String denumire = line[2];
            UtilizareVehicul utilizareVehicul = UtilizareVehicul.valueOf(line[3]);
            String taraProvenienta = line[4];
            boolean blindat = Boolean.parseBoolean(line[5]);
            int nrLocuri = Integer.parseInt(line[6]);
            int autonomie = Integer.parseInt(line[7]);
            int vitezaMaxima = Integer.parseInt(line[8]);
            CategorieAutovehicule categorieAutovehicule = CategorieAutovehicule.valueOf(line[9]);
            boolean suportRemorca = Boolean.parseBoolean(line[10]);
            TipAutovehicul tipAutovehicul = TipAutovehicul.valueOf(line[11]);

            Autovehicul autovehicul = new Autovehicul(id, idGestionar,denumire, utilizareVehicul, taraProvenienta, blindat, nrLocuri,
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