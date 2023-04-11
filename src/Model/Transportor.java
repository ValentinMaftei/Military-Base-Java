package Model;

import Utile.TipTransportor;
import Utile.UtilizareVehicul;

public final class Transportor extends Vehicul{
    private String armamentPrincipal;
    private String armamentSecundar;
    private TipTransportor tipVehicul;

    public Transportor(){}
    public Transportor(String denumire, UtilizareVehicul utilizare, String taraProvenienta, boolean blindat,
                       int nrLocuri, int autonomie, int vitezaMaxima, String armamentPrincipal,
                       String armamentSecundar, TipTransportor tipVehicul) {
        super(denumire, utilizare, taraProvenienta, blindat, nrLocuri, autonomie, vitezaMaxima);
        this.armamentPrincipal = armamentPrincipal;
        this.armamentSecundar = armamentSecundar;
        this.tipVehicul = tipVehicul;
    }

    public String getArmamentPrincipal() {
        return armamentPrincipal;
    }

    public void setArmamentPrincipal(String armamentPrincipal) {
        this.armamentPrincipal = armamentPrincipal;
    }

    public String getArmamentSecundar() {
        return armamentSecundar;
    }

    public void setArmamentSecundar(String armamentSecundar) {
        this.armamentSecundar = armamentSecundar;
    }

    public TipTransportor getTipVehicul() {
        return tipVehicul;
    }

    public void setTipVehicul(TipTransportor tipVehicul) {
        this.tipVehicul = tipVehicul;
    }

    @Override
    public String toString(){
        return "\n Transportor " + getDenumire() + '\n' +
                "Cod identificare: " + getCodIdentificare() + '\n' +
                "Utilizare: " + getUtilizare() + '\n' +
                "Tara de provenienta: " + getTaraProvenienta() + '\n' +
                "Blindat: " + isBlindat() + '\n' +
                "Numar locuri: " + getNrLocuri() + '\n' +
                "Autonomie: " + getAutonomie() + '\n' +
                "Viteza maxima: " + getVitezaMaxima() + '\n' +
                "Armament principal: " + armamentPrincipal + '\n' +
                "Armament secundar: " + armamentSecundar + '\n' +
                "Tip vehicul: " + tipVehicul + '\n' ;
    }

}

