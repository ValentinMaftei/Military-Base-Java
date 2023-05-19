package Service.impl;

import Model.Artilerie;
import Service.ArtilerieService;
import Utile.AuditActionsSingleton;
import Utile.CategorieArtilerie;
import Utile.TipArtilerie;

import java.io.IOException;
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

    @Override
    public void addLogisticaArtilerie(List<String[]> artilerie) throws IOException {
        if (logisticaArtilerie == null)
            logisticaArtilerie = new ArrayList<>();
        for (String[] line : artilerie){
            String model = line[0];
            CategorieArtilerie categorie = CategorieArtilerie.valueOf(line[1]);
            TipArtilerie tip = TipArtilerie.valueOf(line[2]);
            int calibru = Integer.parseInt(line[3]);
            int bataieMaxima = Integer.parseInt(line[4]);
            String taraProvenienta = line[5];

            Artilerie artilerieNou = new Artilerie(model, categorie, tip, calibru, bataieMaxima, taraProvenienta);
            AuditActionsSingleton.INSTANCE.Action("Adăugare element artilerie");
            logisticaArtilerie.add(artilerieNou);
        }
    }

    @Override
    public List<Artilerie> getLogisticaArtilerieAdd() {
        return logisticaArtilerie;
    }
}
