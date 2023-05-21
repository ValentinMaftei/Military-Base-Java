package Service.impl;

import Model.Transportor;
import Service.TransportoareService;
import Utile.AuditActionsSingleton;
import Utile.TipTransportor;
import Utile.UtilizareVehicul;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransportoareServiceimpl implements TransportoareService {
    List<Transportor> listaTransportoare;
    @Override
    public void addTransportoare(List<String[]> transportoare) throws IOException {
        if (listaTransportoare == null)
            listaTransportoare = new ArrayList<>();

        for (String[] line : transportoare){
            int id = Integer.parseInt(line[0]);
            int idGestionar = Integer.parseInt(line[1]);
            String denumire = line[2];
            UtilizareVehicul utilizareVehicul = UtilizareVehicul.valueOf(line[3]);
            String taraProvenienta = line[4];
            boolean blindat = Boolean.parseBoolean(line[5]);
            int nrLocuri = Integer.parseInt(line[6]);
            int autonomie = Integer.parseInt(line[7]);
            int vitezaMaxima = Integer.parseInt(line[8]);
            String armamentPrincipal = line[9];
            String armamentSecundar = line[10];
            TipTransportor tipTransportor = TipTransportor.valueOf(line[11]);

            Transportor transportorNou = new Transportor(id, idGestionar,denumire, utilizareVehicul, taraProvenienta, blindat, nrLocuri,
                    autonomie, vitezaMaxima, armamentPrincipal, armamentSecundar, tipTransportor);
            AuditActionsSingleton.INSTANCE.Action("Adăugare transportor");
            listaTransportoare.add(transportorNou);
        }
    }

    @Override
    public List<Transportor> getTransportoare() {
        return listaTransportoare;
    }
}