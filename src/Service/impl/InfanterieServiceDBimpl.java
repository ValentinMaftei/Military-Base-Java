package Service.impl;

import Exceptions.InfanterieNotFoundException;
import Exceptions.InfanterieNotFoundId;
import Exceptions.InfanterieNotFoundModel;
import Model.Infanterie;
import Repository.InfanterieRepository;
import Service.InfanterieServiceDB;

import java.sql.SQLException;
import java.util.List;

public class InfanterieServiceDBimpl implements InfanterieServiceDB {
    private final InfanterieRepository infanterieRepository;

    public InfanterieServiceDBimpl(InfanterieRepository infanterieRepository) {
        this.infanterieRepository = infanterieRepository;
    }

    @Override
    public List<Infanterie> getAllInfanterie() {
        try {
            List<Infanterie> listInfanterie = infanterieRepository.getAllInfanterie();
            if (listInfanterie.size() == 0)
                throw new InfanterieNotFoundException("Lista de elemente de infanterie este goala!");
            return listInfanterie;
        } catch (InfanterieNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Infanterie> getInfanterieByModel(String model) {
        try {
            List<Infanterie> listInfanterie = infanterieRepository.getInfanterieByModel(model);
            if (listInfanterie.size() == 0)
                throw new InfanterieNotFoundModel("Nu a fost gasit niciun element de infanterie avand modelul dat!");
            return listInfanterie;
        } catch (SQLException | InfanterieNotFoundModel e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Infanterie getInfanterieById(int id) {
        try {
            Infanterie infanterie = infanterieRepository.getInfanterieById(id);
            if (infanterie == null)
                throw new InfanterieNotFoundId("Nu a fost gasit niciun element de infanterie cu id-ul dat!");
            return infanterie;
        } catch (InfanterieNotFoundId | SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteInfanterieById(int id) {
        try {
            infanterieRepository.deleteInfanterieById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteInfanterieByModel(String model) {
        try {
            infanterieRepository.deleteInfanterieByModel(model);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteAllInfanterie() {
        try {
            infanterieRepository.deleteAllInfanterie();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insertInfanterie(String model, String categorie, String taraProvenienta, float calibru, boolean suportLuneta) {
        try {
            infanterieRepository.insertInfanterie(model, categorie, taraProvenienta, calibru, suportLuneta);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void editInfanterie(String editCrit, String newValue, String condition) {
        try {
            Infanterie infanterie = infanterieRepository.getInfanterieById(Integer.parseInt(condition));
            if (infanterie == null)
                throw new InfanterieNotFoundId("Nu exista niciun element de infanterie cu id-ul dat!");
            infanterieRepository.editInfanterie(editCrit, newValue, condition);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteGestionarInfanterie(int id) {
        try {
            infanterieRepository.deleteGestionarInfanterie(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
