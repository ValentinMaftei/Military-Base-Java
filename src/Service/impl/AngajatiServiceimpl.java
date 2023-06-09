package Service.impl;

import Model.Angajat;
import Service.AngajatiService;

import Exception.*;
import Validari.ValidareAngajat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Validari.ValidareAngajat.valideazaVarsta;

public class AngajatiServiceimpl implements AngajatiService{
    List<Angajat> angajati;

    @Override
    public void addAngajat(Angajat angajat) {
        boolean angajatValid = true;
        try{
            if (!valideazaVarsta(angajat.getDataNastere()))
                throw new VarstaInvalida("Militarul trebuie sa aiba minim 18 ani!");
        }
        catch (VarstaInvalida exception){
            angajatValid = false;
            System.out.println(exception.getMessage());
        }

        if (angajatValid) {
            if (angajati == null)
                angajati = new ArrayList<>();
            angajati.add(angajat);
        }
    }

    @Override
    public List<Angajat> getAngajati() throws Exception{
        try{
            if(angajati == null)
                throw new FaraAngajati("Lista de angajati este goala.");

            Collections.sort(angajati);
        }
        catch (FaraAngajati exception){
            System.out.println(exception.getMessage());
        }
        if (angajati.size() > 19)
            System.out.println("Batalionul este format din " + angajati.size() + " de cadre militare.");
        else
            System.out.println("Batalionul este format din " + angajati.size() + " cadre militare.");
        return angajati;
    }
}
