package Model;

import Utile.Functie;
import Utile.Grad;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public final class Angajat implements Comparable<Angajat>{
    private int codIdentificare;
    private String nume;
    private String prenume;
    private Date dataNastere;
    private Grad grad;
    private Functie titlu;
    private List<Infanterie> gestiuneInfanterie;
    private List<Artilerie> gestiuneArtilerie;
    private List<EchipamentSpecial> gestiuneEchipamentS;
    private List<Vehicul> gestiuneVehicule;

    public Angajat(){}

    public Angajat(int codIdentificare, String nume, String prenume, Date dataNastere, Grad grad, Functie titlu) {
        this.codIdentificare = codIdentificare;
        this.nume = nume;
        this.prenume = prenume;
        this.dataNastere = dataNastere;
        this.grad = grad;
        this.titlu = titlu;
    }

    public int getCodIdentificare(){
        return codIdentificare;
    }
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Date getDataNastere() {
        return dataNastere;
    }

    public void setDataNastere(Date dataNastere) {
        this.dataNastere = dataNastere;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    public Functie getTitlu() {
        return titlu;
    }

    public void setTitlu(Functie titlu) {
        this.titlu = titlu;
    }

    public void setCodIdentificare(int codIdentificare) {
        this.codIdentificare = codIdentificare;
    }


    public List<Infanterie> getGestiuneInfanterie() {
        return gestiuneInfanterie;
    }

    public void addInfanterie(Infanterie infanterie){
        if (this.gestiuneInfanterie == null)
            this.gestiuneInfanterie = new ArrayList<>();
        gestiuneInfanterie.add(infanterie);
    }

    public List<Artilerie> getGestiuneArtilerie() {
        return gestiuneArtilerie;
    }

    public void addArtilerie(Artilerie artilerie){
        if (this.gestiuneArtilerie == null)
            this.gestiuneArtilerie = new ArrayList<>();
        gestiuneArtilerie.add(artilerie);
    }

    public List<EchipamentSpecial> getGestiuneEchipamentS() {
        return gestiuneEchipamentS;
    }
    public void addEchipamentS(EchipamentSpecial echipamentSpecial){
        if (this.gestiuneEchipamentS == null)
            this.gestiuneEchipamentS = new ArrayList<>();
        gestiuneEchipamentS.add(echipamentSpecial);
    }

    public List<Vehicul> getGestiuneVehicul() {
        return gestiuneVehicule;
    }

    public void addVehicul(Vehicul vehicul){
        if (this.gestiuneVehicule == null)
            this.gestiuneVehicule = new ArrayList<>();
        gestiuneVehicule.add(vehicul);
    }

    public int compareTo(Angajat angajat){
        if (nume.compareTo(angajat.nume) == 0)
            return prenume.compareTo(angajat.prenume);
        else
            return nume.compareTo(angajat.nume);
    }

    public String getDetaliiAngajat() {
        return "\n " + nume + " " + prenume + '\n' +
                "Cod identificare: " + codIdentificare + '\n' +
                "Grad: " + grad + '\n' +
                "Titlu: " + titlu + '\n' +
                "Data nasterii: " + dataNastere + '\n' +
                "Gestiune artilerie: \n" + this.getGestiuneArtilerie() + '\n' +
                "Gestiune infanterie: \n" + this.getGestiuneInfanterie() + '\n' +
                "Gestiune echipament special: \n" + this.getGestiuneEchipamentS() + '\n' +
                "Gestiune vehicule: \n" + this.getGestiuneVehicul() + '\n';
    }

    @Override
    public String toString() {
        return "\n" + nume + " " + prenume + '\n' +
                "Cod identificare: " + codIdentificare + '\n' +
                "Grad: " + grad + '\n' +
                "Titlu: " + titlu + '\n' +
                "Data nasterii: " + dataNastere + '\n';
    }
}