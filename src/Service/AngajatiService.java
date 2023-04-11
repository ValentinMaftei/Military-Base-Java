package Service;

import Model.Angajat;

import java.util.List;

public interface AngajatiService {
    void addAngajat(Angajat angajat) throws Exception;
    List<Angajat> getAngajati() throws Exception;
}
