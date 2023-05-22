package Service.impl;

import Exceptions.AutovehiculNotFoundId;
import Exceptions.AutovehiculeNotFoundException;
import Exceptions.AutovehiculeNotFoundModel;
import Model.Autovehicul;
import Repository.AutovehiculRepository;
import Service.AutovehiculeServiceDB;

import java.sql.SQLException;
import java.util.List;

public class AutovehiculeServiceDBimpl implements AutovehiculeServiceDB {
    private final AutovehiculRepository autovehiculRepository;

    public AutovehiculeServiceDBimpl(AutovehiculRepository autovehiculRepository) {
        this.autovehiculRepository = autovehiculRepository;
    }

    @Override
    public List<Autovehicul> getAllAutovehicule() {
        try {
            List<Autovehicul> listAutovehicule = autovehiculRepository.getAllAutovehicule();
            if (listAutovehicule.size() == 0)
                throw new AutovehiculeNotFoundException("Lista de autovehicule este goala!");
            return listAutovehicule;
        } catch (SQLException | AutovehiculeNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Autovehicul> getAutovehiculByDenumire(String model) {
        try {
            List<Autovehicul> listAutovehicule = autovehiculRepository.getAllAutovehicule();
            if (listAutovehicule.size() == 0)
                throw new AutovehiculeNotFoundModel("Nu exista niciun autovehicul cu denumirea data!");
            return listAutovehicule;
        } catch (SQLException | AutovehiculeNotFoundModel e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Autovehicul getAutovehiculById(int id) {
        try {
            Autovehicul autovehicul = autovehiculRepository.getAutovehiculById(id);
            if (autovehicul == null)
                throw new AutovehiculNotFoundId("Nu exista niciun autovehicul cu id-ul dat!");
            return autovehicul;
        } catch (SQLException | AutovehiculNotFoundId e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteAutovehiculById(int id) {
        try {
            autovehiculRepository.deleteAutovehiculById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteAutovehiculByDenumire(String denumire) {
        try {
            autovehiculRepository.deleteAutovehiculByDenumire(denumire);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteAllAutovehicule() {
        try {
            autovehiculRepository.deleteAllAutovehicule();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insertAutovehicul(String denumire, String utilizare, String taraProvenienta, boolean blindat, int nrLocuri,
                                  int autonomie, int vitezaMaxima, String categorie, boolean suportRemorca, String tip) {
        try {
            autovehiculRepository.insertAutovehicul(denumire, utilizare, taraProvenienta, blindat, nrLocuri, autonomie,
                    vitezaMaxima, categorie, suportRemorca, tip);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void editAutovehicul(String editCrit, String newValue, String condition) {
        try {
            Autovehicul autovehicul = autovehiculRepository.getAutovehiculById(Integer.parseInt(condition));
            if (autovehicul == null)
                throw new AutovehiculNotFoundId("Nu exista niciun autovehicul cu id-ul dat!");
            autovehiculRepository.editAutovehicul(editCrit, newValue, condition);
        } catch (SQLException | AutovehiculNotFoundId e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteGestionarAutovehicul(int id) {
        try {
            autovehiculRepository.deleteGestionarAutovehicul(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
