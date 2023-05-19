package Service;

import Model.Angajat;

import java.io.File;
import java.util.List;

public interface AngajatiService {
    void addAngajat(Angajat angajat) throws Exception;
    List<Angajat> getAngajati() throws Exception;
    List<Angajat> getAngajatiAdd() throws Exception;
}
