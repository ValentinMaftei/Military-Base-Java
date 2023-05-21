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
            int id = Integer.parseInt(line[0]);
            int idGestionar = Integer.parseInt(line[1]);
            String model = line[2];
            CategorieArtilerie categorie = CategorieArtilerie.valueOf(line[3]);
            TipArtilerie tip = TipArtilerie.valueOf(line[4]);
            int calibru = Integer.parseInt(line[5]);
            int bataieMaxima = Integer.parseInt(line[6]);
            String taraProvenienta = line[7];

            Artilerie artilerieNou = new Artilerie(id, idGestionar, model, categorie, tip, calibru, bataieMaxima, taraProvenienta);
            AuditActionsSingleton.INSTANCE.Action("Adăugare element artilerie");
            logisticaArtilerie.add(artilerieNou);
        }
    }

    @Override
    public List<Artilerie> getLogisticaArtilerieAdd() {
        return logisticaArtilerie;
    }
}