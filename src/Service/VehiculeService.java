package Service;

import Model.Vehicul;

import java.util.List;

public interface VehiculeService {
    void addLogisticaVehicul(Vehicul vehicul);
    List<Vehicul> getLogisticaVehicule();
}
