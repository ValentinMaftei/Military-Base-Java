package Service.impl;

import Exceptions.TransportoareNotFoundDenumire;
import Exceptions.TransportoareNotFoundException;
import Exceptions.TransportorNotFoundId;
import Model.Transportor;
import Repository.TransportorRepository;
import Service.TransportoareServiceDB;

import java.sql.SQLException;
import java.util.List;

public class TransportoareServiceDBimpl implements TransportoareServiceDB {
    private final TransportorRepository transportorRepository;

    public TransportoareServiceDBimpl(TransportorRepository transportorRepository) {
        this.transportorRepository = transportorRepository;
    }

    @Override
    public List<Transportor> getAllTransportoare() {
        try{
            List<Transportor> listTransportor = transportorRepository.getAllTransportoare();
            if (listTransportor.size() == 0)
                throw new TransportoareNotFoundException("Lista de transportoare este goala!");
            return listTransportor;
        } catch (SQLException | TransportoareNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Transportor> getTransportorByDenumire(String model) {
        try {
            List<Transportor> listTransportor = transportorRepository.getTransportorByModel(model);
            if (listTransportor.size() == 0)
                throw new TransportoareNotFoundDenumire("Nu exista niciun blindat cu denumirea data!");
            return listTransportor;
        } catch (TransportoareNotFoundDenumire | SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Transportor getTransportorById(int id) {
        try {
            Transportor transportor = transportorRepository.getTransportorById(id);
            if (transportor == null)
                throw new TransportorNotFoundId("Nu exista niciun transportor cu id-ul dat!");
            return transportor;
        } catch (SQLException | TransportorNotFoundId e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteTransportorById(int id) {
        try {
            transportorRepository.deleteTransportorById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteTransportorByDenumire(String denumire) {
        try {
            transportorRepository.deleteTransportorByDenumire(denumire);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteAllTransportoare() {
        try {
            transportorRepository.deleteAllTransportoare();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insertTransportor(String denumire, String utilizare, String taraProvenienta, boolean blinat, int nrLocuri,
                                  int autonomie, int vitezaMaxima, String armamentPrincipal, String armamentSecundar, String tip) {
        try {
            transportorRepository.insertTransportor(denumire, utilizare, taraProvenienta, blinat, nrLocuri, autonomie,
                    vitezaMaxima, armamentPrincipal, armamentSecundar, tip);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void editTransportor(String editCrit, String newValue, String condition) {
        try {
            Transportor transportor = transportorRepository.getTransportorById(Integer.parseInt(condition));
            if (transportor == null)
                throw new TransportorNotFoundId("Nu exista niciun transportor cu id-ul dat!");
            transportorRepository.editTransportor(editCrit, newValue, condition);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteGestionarTransportor(int id) {
        try {
            transportorRepository.deleteGestionarTransportor(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
