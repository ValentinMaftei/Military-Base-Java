package Service.impl;

import Exceptions.ArtilerieNotFoundException;
import Exceptions.ArtilerieNotFoundId;
import Exceptions.ArtilerieNotFoundModel;
import Model.Artilerie;
import Repository.ArtilerieRepository;
import Service.ArtilerieServiceDB;

import java.sql.SQLException;
import java.util.List;

public class ArtilerieServiceDBimpl implements ArtilerieServiceDB {
    private final ArtilerieRepository artilerieRepository;

    public ArtilerieServiceDBimpl(ArtilerieRepository artilerieRepository){
        this.artilerieRepository = artilerieRepository;
    }

    @Override
    public List<Artilerie> getAllArtilerie() {
        try{
            List<Artilerie> listArtilerie = artilerieRepository.getAllArtilerie();
            if (listArtilerie.size() == 0)
                throw new ArtilerieNotFoundException("Lista de elemente de artilerie este goala!");
            return listArtilerie;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Artilerie> getArtilerieByModel(String model) {
        try {
            List<Artilerie> listArtilerie = artilerieRepository.getArtilerieByModel(model);
            if (listArtilerie.size() == 0)
                throw new ArtilerieNotFoundModel("Nu exista niciun element de artilerile avand modelul dat!");
            return listArtilerie;
        } catch (SQLException | ArtilerieNotFoundModel e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Artilerie getArtilerieById(int id) {
        try {
            Artilerie artilerie = artilerieRepository.getArtilerieById(id);
            if (artilerie == null)
                throw new ArtilerieNotFoundId("Nu exista niciun element de artilerie cu id-ul dat!");
            return artilerie;
        } catch (SQLException | ArtilerieNotFoundId e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteArtilerieById(int id) {
        try {
            artilerieRepository.deleteArtilerieById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteArtilerieByModel(String model) {
        try {
            artilerieRepository.deleteArtilerieByModel(model);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteAllArtilerie() {
        try {
            artilerieRepository.deleteAllArtilerie();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insertArtilerie(String model, String categorie, String tip, float calibru, int bataieMaxima, String taraProvenienta) {
        try {
            artilerieRepository.insertArtilerie(model, categorie, tip, calibru, bataieMaxima, taraProvenienta);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void editArtilerie(String editCrit, String newValue, String condition) {
        try {
            Artilerie artilerie = artilerieRepository.getArtilerieById(Integer.parseInt(condition));
            if (artilerie == null)
                throw new ArtilerieNotFoundId("Nu exista niciun element de artilerie cu id-ul dat!");
            artilerieRepository.editArtilerie(editCrit, newValue, condition);
        } catch (SQLException | ArtilerieNotFoundId e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteGestionarArtilerie(int id) {
        try {
            artilerieRepository.deleteGestionarArtilerie(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
