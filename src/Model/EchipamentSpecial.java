package Model;

import Utile.TipSpeciale;

import java.util.UUID;

public final class EchipamentSpecial {
    private int codIdentificare;
    private int idGestionar;
    private TipSpeciale tip;
    private String model;
    private String taraProvenienta;

    public EchipamentSpecial(){}
    public EchipamentSpecial(int codIdentificare, int idGestionar, TipSpeciale tip, String model, String taraProvenienta) {
        this.codIdentificare = codIdentificare;
        this.idGestionar = idGestionar;
        this.tip = tip;
        this.model = model;
        this.taraProvenienta = taraProvenienta;
    }

    public int getCodIdentificare() {
        return codIdentificare;
    }

    public TipSpeciale getTip() {
        return tip;
    }

    public void setTip(TipSpeciale tip) {
        this.tip = tip;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
                "Tara de provenienta: " + taraProvenienta + '\n';
    }
}