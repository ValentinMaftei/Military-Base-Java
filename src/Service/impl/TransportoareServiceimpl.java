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
            String denumire = line[0];
            UtilizareVehicul utilizareVehicul = UtilizareVehicul.valueOf(line[1]);
            String taraProvenienta = line[2];
            boolean blindat = Boolean.parseBoolean(line[3]);
            int nrLocuri = Integer.parseInt(line[4]);
            int autonomie = Integer.parseInt(line[5]);
            int vitezaMaxima = Integer.parseInt(line[6]);
            String armamentPrincipal = line[7];
            String armamentSecundar = line[8];
            TipTransportor tipTransportor = TipTransportor.valueOf(line[9]);

            Transportor transportorNou = new Transportor(denumire, utilizareVehicul, taraProvenienta, blindat, nrLocuri,
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
