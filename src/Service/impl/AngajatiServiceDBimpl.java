package Service.impl;

import Exceptions.AngajatNotFoundId;
import Exceptions.AngajatNotFoundNumePrenume;
import Exceptions.AngajatVarsaInvalidaException;
import Exceptions.AngajatiNotFoundException;
import Model.*;
import Repository.*;
import Service.AngajatiServiceDB;
import Validari.ValidareAngajat;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class AngajatiServiceDBimpl implements AngajatiServiceDB {

    private AngajatRepository angajatRepository;

    public AngajatiServiceDBimpl(AngajatRepository angajatRepository){
        this.angajatRepository = angajatRepository;
    }

    public AngajatiServiceDBimpl(){}

    @Override
    public List<Angajat> getAllAngajati() {
        try {
            List<Angajat> listAngajati = angajatRepository.getAllAngajati();
            if (listAngajati.size() == 0)
                throw new AngajatiNotFoundException("Lista de angajati este goala!");
            return listAngajati;
        } catch (SQLException | AngajatiNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Angajat> getAngajatiByName(String lastName, String firstName) {
        try {
            List<Angajat> listAngajati = angajatRepository.getAngajatiByName(lastName, firstName);
            if (listAngajati.size() == 0)
                throw new AngajatNotFoundNumePrenume("Nu exista niciun angajat cu numele si prenumele dat!");
            return listAngajati;
        } catch (SQLException | AngajatNotFoundNumePrenume e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Angajat getAngajatById(int id) {
        try {
            Angajat angajat = angajatRepository.getAngajatById(id);
            if(angajat == null)
                throw new AngajatNotFoundId("Nu exista niciun angajat cu id-ul dat!");
            return angajat;
        } catch (SQLException | AngajatNotFoundId e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteAngajatById(int id) {
        try {
            angajatRepository.deleteAngajatById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteAngajatByName(String lastName, String firstName) {
        try {
            angajatRepository.deleteAngajatByName(lastName, firstName);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteAllAngajati() {
        try {
            angajatRepository.deleteAllAngajati();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insertAngajat(String nume, String prenume, Date dataNastere, String grad, String functie) {
        try {
            if (!ValidareAngajat.valideazaVarsta(dataNastere)) {
                throw new AngajatVarsaInvalidaException("Angajatul trebuie sa aiba cel putin 18 ani!");
            }
            angajatRepository.insertAngajat(nume, prenume, dataNastere, grad, functie);
        } catch (SQLException | AngajatVarsaInvalidaException e ) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void editAngajat(String editCrit, String newValue, String condition) {
        try {
            Angajat angajat = angajatRepository.getAngajatById(Integer.parseInt(condition));
            if (angajat == null)
                throw new AngajatNotFoundId("Nu exista angajatul cu id-ul dat!");
            angajatRepository.editAngajat(editCrit, newValue, condition);
        } catch (SQLException | AngajatNotFoundId e) {
            System.out.println(e.getMessage());
        }
    }

}
