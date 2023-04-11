package Service.impl;

import Model.Vehicul;
import Model.Autovehicul;
import Model.Transportor;
import Model.Blindat;
import Service.VehiculeService;

import java.util.ArrayList;
import java.util.List;

public class VehiculeServiceimpl implements VehiculeService {

    List<Vehicul> logisticaVehicule;
    @Override
    public void addLogisticaVehicul(Vehicul vehicul) {
        if (logisticaVehicule == null)
            logisticaVehicule = new ArrayList<>();
        logisticaVehicule.add(vehicul);
    }

    @Override
    public List<Vehicul> getLogisticaVehicule() {
        if (logisticaVehicule.size() > 19)
            System.out.println("Batalionul detine " + logisticaVehicule.size() + " de vehicule.");
        else
            System.out.println("Batalionul detine " + logisticaVehicule.size() + " vehicule.");
        return logisticaVehicule;
    }
}
