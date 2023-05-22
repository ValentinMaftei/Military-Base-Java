package Service.impl;

import Exceptions.EchipamentSpecialNotFoundException;
import Exceptions.EchipamentSpecialNotFoundId;
import Exceptions.EchipamentSpecialNotFoundModel;
import Model.EchipamentSpecial;
import Repository.EchipamentSpecialRepository;
import Service.EchipamentSpecialServiceDB;

import java.sql.SQLException;
import java.util.List;

public class EchipamentSpecialServiceDBimpl implements EchipamentSpecialServiceDB {

    private final EchipamentSpecialRepository echipamentSpecialRepository;

    public EchipamentSpecialServiceDBimpl(EchipamentSpecialRepository echipamentSpecialRepository) {
        this.echipamentSpecialRepository = echipamentSpecialRepository;
    }

    @Override
    public List<EchipamentSpecial> getAllEchipamentSpecial() {
        try {
            List<EchipamentSpecial> listEchipament = echipamentSpecialRepository.getAllEchipamentSpecial();
            if (listEchipament.size() == 0)
                throw new EchipamentSpecialNotFoundException("Lista de echipamente speciale este goala!");
            return listEchipament;
        } catch (EchipamentSpecialNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<EchipamentSpecial> getEchipamentSpecialByModel(String model) {
        try {
            List<EchipamentSpecial> listEchipament = echipamentSpecialRepository.getEchipamentSpecialByModel(model);
            if (listEchipament.size() == 0)
                throw new EchipamentSpecialNotFoundModel("Nu exista niciun echipament special avand modelul dat!");
            return listEchipament;
        } catch (SQLException | EchipamentSpecialNotFoundModel e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public EchipamentSpecial getEchipamentSpecialById(int id) {
        try {
            EchipamentSpecial echipamentSpecial = echipamentSpecialRepository.getEchipamentSpecialById(id);
            if (echipamentSpecial == null)
                throw new EchipamentSpecialNotFoundId("Nu exista niciun echipament special cu id-ul dat!");
            return echipamentSpecial;
        } catch (SQLException | EchipamentSpecialNotFoundId e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteEchipamentSpecialById(int id) {
        try {
            echipamentSpecialRepository.deleteEchipamentSpecialById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteEchipamentSpecialByModel(String model) {
        try {
            echipamentSpecialRepository.deleteEchipamentSpecialByModel(model);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteAllSpeciale() {
        try {
            echipamentSpecialRepository.deleteAllSpeciale();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insertEchipamentSpecial(String tip, String model, String taraProvenienta) {
        try {
            echipamentSpecialRepository.insertEchipamentSpecial(tip, model, taraProvenienta);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void editEchipamentSpecial(String editCrit, String newValue, String condition) {
        try {
            EchipamentSpecial echipamentSpecial = echipamentSpecialRepository.getEchipamentSpecialById(Integer.parseInt(condition));
            if (echipamentSpecial == null)
                throw new EchipamentSpecialNotFoundId("Nu exista niciun echipament special cu id-ul dat!");
            echipamentSpecialRepository.editEchipamentSpecial(editCrit, newValue, condition);
        } catch (SQLException | EchipamentSpecialNotFoundId e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteGestionarEchipamentSpecial(int id) {
        try {
            echipamentSpecialRepository.deleteGestionarEchipamentSpecial(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
