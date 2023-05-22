package Service.impl;

import Exceptions.BlindatNotFoundDenumire;
import Exceptions.BlindatNotFoundId;
import Exceptions.BlindateNotFoundException;
import Model.Blindat;
import Repository.BlindatRepository;
import Service.BlindateServiceDB;

import java.sql.SQLException;
import java.util.List;

public class BlindateServiceDBimpl implements BlindateServiceDB {

    private final BlindatRepository blindatRepository;

    public BlindateServiceDBimpl(BlindatRepository blindatRepository) {
        this.blindatRepository = blindatRepository;
    }

    @Override
    public List<Blindat> getAllBlindate() {
        try {
            List<Blindat> listBlindate = blindatRepository.getAllBlindate();
            if (listBlindate.size() == 0)
                throw new BlindateNotFoundException("Lista de blindate este goala!");
            return listBlindate;
        } catch (SQLException | BlindateNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Blindat> getBlindatByDenumire(String denumire) {
        try {
            List<Blindat> listBlindate = blindatRepository.getBlindatByDenumire(denumire);
            if (listBlindate.size() == 0)
                throw new BlindatNotFoundDenumire("Nu exista niciun blindat cu denumirea data!");
            return listBlindate;
        } catch (SQLException | BlindatNotFoundDenumire e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

        @Override
    public Blindat getBlindatById(int id) {
        try {
            Blindat blindat = blindatRepository.getBlindatById(id);
            if (blindat == null)
                throw new BlindatNotFoundId("Nu exista niciun blindat cu id-ul dat!");
            return blindat;
        } catch (BlindatNotFoundId | SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteBlindatById(int id) {
        try {
            blindatRepository.deleteBlindatById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteBlindatByDenumire(String denumire) {
        try {
            blindatRepository.deleteBlindatByDenumire(denumire);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteAllBlindate() {
        try {
            blindatRepository.deleteAllBlindate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insertBlindat(String denumire, String utilizare, String taraProvenienta, boolean blindat, int nrLocuri,
                              int autonomie, int vitezaMaxima, boolean suportRemorca, boolean suportArma, String arma) {
        try {
            blindatRepository.insertBlindat(denumire, utilizare, taraProvenienta, blindat, nrLocuri, autonomie,
                    vitezaMaxima, suportRemorca, suportArma, arma);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void editBlindat(String editCrit, String newValue, String condition) {
        try {
            Blindat blindat = blindatRepository.getBlindatById(Integer.parseInt(condition));
            if (blindat == null)
                throw new BlindatNotFoundId("Nu exista niciun blindat cu id-ul dat!");
            blindatRepository.editBlindat(editCrit, newValue, condition);
        } catch (SQLException | BlindatNotFoundId e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteGestionarBlindat(int id) {
        try {
            blindatRepository.deleteGestionarBlindat(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
