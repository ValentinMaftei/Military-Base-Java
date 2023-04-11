package Service.impl;

import Model.Artilerie;
import Service.ArtilerieService;

import java.util.ArrayList;
import java.util.List;

public class ArtilerieServiceimpl implements ArtilerieService {

    List<Artilerie> logisticaArtilerie;
    @Override
    public void addLogisticaArtilerie(Artilerie artilerie) {
        if (logisticaArtilerie == null)
            logisticaArtilerie = new ArrayList<>();
        logisticaArtilerie.add(artilerie);
    }

    @Override
    public List<Artilerie> getLogisticaArtilerie() {
        if (logisticaArtilerie.size() > 19)
            System.out.println("Batalionul detine " + logisticaArtilerie.size() + " de elemente de artilerie.");
        else
            System.out.println("Batalionul detine " + logisticaArtilerie.size() + " elemente de artilerie.");
        return logisticaArtilerie;
    }
}
