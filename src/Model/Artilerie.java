package Model;

import Utile.CategorieArtilerie;
import Utile.TipArtilerie;

import java.util.UUID;

public final class Artilerie {
    private int codIdentificare;
    private int idGestionar;
    private String model;
    private CategorieArtilerie categorie;
    private TipArtilerie tip;
    private float calibru;
    private int bataieMaxima;
    private String taraProvenienta;

    public Artilerie(){}
    public Artilerie(int codIdentificare, int idGestionar, String model, CategorieArtilerie categorie, TipArtilerie tip, float calibru, int bataieMaxima, String taraProvenienta) {
        this.codIdentificare = codIdentificare;
        this.idGestionar = idGestionar;
        this.model = model;
        this.categorie = categorie;
        this.tip = tip;
        this.calibru = calibru;
        this.bataieMaxima = bataieMaxima;
        this.taraProvenienta = taraProvenienta;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public CategorieArtilerie getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieArtilerie categorie) {
        this.categorie = categorie;
    }

    public TipArtilerie getTip() {
        return tip;
    }

    public void setTip(TipArtilerie tip) {
        this.tip = tip;
    }

    public float getCalibru() {
        return calibru;
    }

    public void setCalibru(float calibru) {
        this.calibru = calibru;
    }

    public int getBataieMaxima() {
        return bataieMaxima;
    }

    public void setBataieMaxima(int bataieMaxima) {
        this.bataieMaxima = bataieMaxima;
    }

    public String getTaraProvenienta() {
        return taraProvenienta;
    }

    public void setTaraProvenienta(String taraProvenienta) {
        this.taraProvenienta = taraProvenienta;
    }

    @Override
    public String toString() {
        return "\n" + model + '\n' +
                "Cod identificare: " + codIdentificare + '\n' +
                "Tip: " + tip + '\n' +
                "Categorie: " + categorie + '\n' +
                "Calibru (mm): " + calibru + '\n' +
                "Bataie maxima (km): " + bataieMaxima + '\n' +
                "Tara de provenienta: " + taraProvenienta + '\n';
    }
}