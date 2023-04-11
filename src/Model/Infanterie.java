package Model;

import Utile.CategorieInfanterie;

import java.util.UUID;

public final class Infanterie {
    private UUID codIdentificare;
    private String model;
    private CategorieInfanterie categorie;
    private String taraProvenienta;
    private float calibru;
    private boolean suportLuneta;

    public Infanterie(){}

    public Infanterie(String model, CategorieInfanterie categorie, String taraProvenienta, float calibru, boolean suportLuneta) {
        this.codIdentificare = UUID.randomUUID();
        this.model = model;
        this.categorie = categorie;
        this.taraProvenienta = taraProvenienta;
        this.calibru = calibru;
        this.suportLuneta = suportLuneta;
    }

    public UUID getCodIdentificare(){
        return codIdentificare;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public CategorieInfanterie getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieInfanterie categorie) {
        this.categorie = categorie;
    }

    public String getTaraProvenienta() {
        return taraProvenienta;
    }

    public void setTaraProvenienta(String taraProvenienta) {
        this.taraProvenienta = taraProvenienta;
    }

    public float getCalibru() {
        return calibru;
    }

    public void setCalibru(float calibru) {
        this.calibru = calibru;
    }

    public boolean isSuportLuneta() {
        return suportLuneta;
    }

    public void setSuportLuneta(boolean suportLuneta) {
        this.suportLuneta = suportLuneta;
    }

    @Override
    public String toString() {
        return "\n Infanterie " + model + '\n' +
                "Cod identificare: " + codIdentificare + '\n' +
                "Categorie: " + categorie + '\n' +
                "Calibru (mm): " + calibru + '\n' +
                "Suport luneta: " + suportLuneta + '\n' +
                "Tara de provenienta: " + taraProvenienta + '\n';
    }
}
