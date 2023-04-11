package Model;

import Utile.TipSpeciale;

import java.util.UUID;

public final class EchipamentSpecial {
    private UUID codIdentificare;
    private TipSpeciale tip;
    private String model;
    private String taraProvenienta;

    public EchipamentSpecial(){}
    public EchipamentSpecial(TipSpeciale tip, String model, String taraProvenienta) {
        this.codIdentificare = UUID.randomUUID();
        this.tip = tip;
        this.model = model;
        this.taraProvenienta = taraProvenienta;
    }

    public UUID getCodIdentificare() {
        return codIdentificare;
    }

    public TipSpeciale getTip() {
        return tip;
    }

    public void setTip(TipSpeciale tip) {
        this.tip = tip;
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
        return "\n EchipamentSpecial " + model + '\n' +
                "Cod identificare: " + codIdentificare + '\n' +
                "Tip: " + tip + '\n' +
                "Model: " + model + '\n' +
                "Tara de provenienta: " + taraProvenienta + '\n';
    }
}
