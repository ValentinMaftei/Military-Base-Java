package Service;

import Model.Autovehicul;

import java.io.IOException;
import java.util.List;

public interface AutovehiculeService {
    void addAutovehicule(List<String[]> autovehicule) throws IOException;
    List<Autovehicul> getAutovehicule();
}
