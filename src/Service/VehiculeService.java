package Service;

import Model.Autovehicul;
import Model.Blindat;
import Model.Vehicul;

import java.io.IOException;
import java.util.List;

public interface VehiculeService {
    void addLogisticaVehicul(Vehicul vehicul) throws IOException;
    List<Vehicul> getLogisticaVehicule();
    List<Vehicul> getLogisticaVehiculeAdd();
}
