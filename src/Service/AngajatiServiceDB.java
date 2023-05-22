package Service;

import Model.*;

import java.sql.Date;
import java.util.List;


public interface AngajatiServiceDB {
    public List<Angajat> getAllAngajati();
    public List<Angajat> getAngajatiByName(String lastName, String firstName);
    public Angajat getAngajatById(int id);
    public void deleteAngajatById(int id);
    public void deleteAngajatByName(String lastName, String firstName);
    public void deleteAllAngajati();
    public void insertAngajat(String nume, String prenume, Date dataNastere, String grad, String functie);
    public void editAngajat(String editCrit, String newValue, String condition);

}
