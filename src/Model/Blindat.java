package Model;

import Utile.UtilizareVehicul;

public final class Blindat extends Vehicul{
    private boolean suportRemorca;
    private boolean suportArma;
    private String arma;

    public Blindat(){}
    public Blindat(int codIdentificare, int idGestionar, String denumire, UtilizareVehicul utilizare, String taraProvenienta, boolean blindat,
                   int nrLocuri, int autonomie, int vitezaMaxima, boolean suportRemorca,
                   boolean suportArma, String arma) {
        super(codIdentificare, idGestionar, denumire, utilizare, taraProvenienta, blindat, nrLocuri, autonomie, vitezaMaxima);
        this.suportRemorca = suportRemorca;
        this.suportArma = suportArma;
        this.arma = arma;
    }

    public boolean isSuportRemorca() {
        return suportRemorca;
    }

    public void setSuportRemorca(boolean suportRemorca) {
        this.suportRemorca = suportRemorca;
    }

    public boolean isSuportArma() {
        return suportArma;
    }

    public void setSuportArma(boolean suportArma) {
        this.suportArma = suportArma;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    @Override
    public String toString() {
        return "\n" + getDenumire() + '\n' +
                "Cod identificare: " + getCodIdentificare() + '\n' +
                "Utilizare: " + getUtilizare() + '\n' +
                "Tara de provenienta: " + getTaraProvenienta() + '\n' +
                "Blindat: " + isBlindat() + '\n' +
                "Numar locuri: " + getNrLocuri() + '\n' +
                "Autonomie (km): " + getAutonomie() + '\n' +
                "Viteza maxima (km/h): " + getVitezaMaxima() + '\n' +
                "Suport remorca: " + suportRemorca + '\n' +
                "Suport arma: " + suportArma + '\n' +
                "Tip arma: " + arma + '\n' ;
    }
}