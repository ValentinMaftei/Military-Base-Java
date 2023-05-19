package Model;

import Utile.CategorieAutovehicule;
import Utile.TipAutovehicul;
import Utile.UtilizareVehicul;
import jdk.jshell.execution.Util;

public final class Autovehicul extends Vehicul{
    private CategorieAutovehicule categoriePermis;
    private boolean suportRemorca;
    private TipAutovehicul tip;

    public Autovehicul(String denumire, UtilizareVehicul utilizare, String taraProvenienta, boolean blindat,
                       int nrLocuri, int autonomie, int vitezaMaxima, CategorieAutovehicule categoriePermis,
                       boolean suportRemorca, TipAutovehicul tip) {
        super(denumire, utilizare, taraProvenienta, blindat, nrLocuri, autonomie, vitezaMaxima);
        this.categoriePermis = categoriePermis;
        this.suportRemorca = suportRemorca;
        this.tip = tip;
    }

    public CategorieAutovehicule getCategoriePermis() {
        return categoriePermis;
    }

    public void setCategoriePermis(CategorieAutovehicule categoriePermis) {
        this.categoriePermis = categoriePermis;
    }

    public boolean isSuportRemorca() {
        return suportRemorca;
    }

    public void setSuportRemorca(boolean suportRemorca) {
        this.suportRemorca = suportRemorca;
    }

    public TipAutovehicul getTip() {
        return tip;
    }

    public void setTip(TipAutovehicul tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "\n Autovehicul " + getDenumire() + '\n' +
                "Cod identificare: " + getCodIdentificare() + '\n' +
                "Utilizare: " + getUtilizare() + '\n' +
                "Tara de provenienta: " + getTaraProvenienta() + '\n' +
                "Blindat: " + isBlindat() + '\n' +
                "Numar locuri: " + getNrLocuri() + '\n' +
                "Autonomie (km): " + getAutonomie() + '\n' +
                "Viteza maxima (km/h): " + getVitezaMaxima() + '\n' +
                "Categorie: " + categoriePermis + '\n' +
                "Suport remorca: " + suportRemorca + '\n' +
                "Tip autovehicul: " + tip + '\n';
    }
}
