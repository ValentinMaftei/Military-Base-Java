package Model;

import Utile.UtilizareVehicul;
import jdk.jshell.execution.Util;

import java.util.UUID;

public abstract class Vehicul {
    private int codIdentificare;

    private int idGestionar;
    private String denumire;
    private UtilizareVehicul utilizare;
    private String taraProvenienta;
    private boolean blindat;
    private int nrLocuri;
    private int autonomie;
    private int vitezaMaxima;

    public Vehicul(){}
    public Vehicul(int codIdentificare, int idGestionar, String denumire, UtilizareVehicul utilizare, String taraProvenienta, boolean blindat,
                   int nrLocuri, int autonomie, int vitezaMaxima) {
        this.codIdentificare = codIdentificare;
        this.idGestionar = idGestionar;
        this.denumire = denumire;
        this.utilizare = utilizare;
        this.taraProvenienta = taraProvenienta;
        this.blindat = blindat;
        this.nrLocuri = nrLocuri;
        this.autonomie = autonomie;
        this.vitezaMaxima = vitezaMaxima;
    }

    public void setCodIdentificare(int codIdentificare) {
        this.codIdentificare = codIdentificare;
    }

    public int getIdGestionar() {
        return idGestionar;
    }

    public void setIdGestionar(int idGestionar) {
        this.idGestionar = idGestionar;
    }

    public int getCodIdentificare(){
        return codIdentificare;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public UtilizareVehicul getUtilizare() {
        return utilizare;
    }

    public void setUtilizare(UtilizareVehicul utilizare) {
        this.utilizare = utilizare;
    }

    public String getTaraProvenienta() {
        return taraProvenienta;
    }

    public void setTaraProvenienta(String taraProvenienta) {
        this.taraProvenienta = taraProvenienta;
    }

    public boolean isBlindat() {
        return blindat;
    }

    public void setBlindat(boolean blindat) {
        this.blindat = blindat;
    }

    public int getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    public int getAutonomie() {
        return autonomie;
    }

    public void setAutonomie(int autonomie) {
        this.autonomie = autonomie;
    }

    public int getVitezaMaxima() {
        return vitezaMaxima;
    }

    public void setVitezaMaxima(int vitezaMaxima) {
        this.vitezaMaxima = vitezaMaxima;
    }

    @Override
    public String toString() {
        return "Vehicul{" +
                "codIdentificare=" + codIdentificare +
                ", denumire='" + denumire + '\'' +
                ", utilizare='" + utilizare + '\'' +
                ", taraProvenienta='" + taraProvenienta + '\'' +
                ", blindat=" + blindat +
                ", nrLocuri=" + nrLocuri +
                ", autonomie=" + autonomie +
                ", vitezaMaxima=" + vitezaMaxima +
                '}';
    }
}