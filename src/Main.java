import Config.DataBaseConfiguration;
import Model.*;
import Repository.*;
import Service.BlindateService;
import Service.TransportoareService;
import Service.VehiculeService;
import Service.impl.*;
import Utile.*;

import javax.xml.crypto.Data;
import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        SingletonFileReaderWriter singletonFileReaderWriter = SingletonFileReaderWriter.INSTANCE;
        /*
        Calendar calendar = Calendar.getInstance();
        calendar.set(2002, Calendar.JANUARY, 23);
        Date dataNastere = calendar.getTime();
        Angajat angajat1 = new Angajat("Maftei", "Valentin", dataNastere, Grad.SUBOFITER,
                Functie.PLUTONIER_ADJUTANT);

        calendar.set(2000, Calendar.FEBRUARY, 22);
        dataNastere = calendar.getTime();
        Angajat angajat2 = new Angajat("Maftei", "Matei", dataNastere, Grad.OFITER,
                Functie.LOCOTENENT_COLONEL);

        calendar.set(1998, Calendar.NOVEMBER, 5);
        dataNastere = calendar.getTime();
        Angajat angajat3 = new Angajat("Brinzac", "Teodor", dataNastere, Grad.SOLDAT_GRADAT_PROFESIONIST,
                Functie.SUBLOCOTENENT);

        calendar.set(1990, Calendar.JUNE, 30);
        dataNastere = calendar.getTime();
        Angajat angajat4 = new Angajat("Jitareanu", "Stefan", dataNastere, Grad.OFITER, Functie.LOCOTENENT);

        calendar.set(1995, Calendar.AUGUST, 4);
        dataNastere = calendar.getTime();
        Angajat angajat5 = new Angajat("Ursaciuc", "Denis", dataNastere, Grad.MAISTRU_MILITAR, Functie.SERGENT);

        calendar.set(1975, Calendar.OCTOBER, 23);
        dataNastere = calendar.getTime();
        Angajat angajat6 = new Angajat("Mihai", "Romica", dataNastere, Grad.OFITER, Functie.GENERAL_DE_BRIGADA);

        calendar.set(1987, Calendar.MARCH, 15);
        dataNastere = calendar.getTime();
        Angajat angajat7 = new Angajat("Ciobanu", "Mircea", dataNastere, Grad.SUBOFITER, Functie.SERGENT);

        calendar.set(1998, Calendar.NOVEMBER, 10);
        dataNastere = calendar.getTime();
        Angajat angajat8 = new Angajat("Andreica", "Radu", dataNastere, Grad.SUBOFITER, Functie.SUBLOCOTENENT);

        calendar.set(1982, Calendar.JANUARY, 14);
        dataNastere = calendar.getTime();
        Angajat angajat9 = new Angajat("Mihailescu", "Darius", dataNastere, Grad.OFITER, Functie.CAPITAN);

        calendar.set(1993, Calendar.OCTOBER, 27);
        dataNastere = calendar.getTime();
        Angajat angajat10 = new Angajat("Alexa", "Marin", dataNastere, Grad.SOLDAT_GRADAT_PROFESIONIST,
                Functie.SOLDAT);


        VehiculeServiceimpl vehiculeService = new VehiculeServiceimpl();

        BlindateServiceimpl blindateServiceimpl = new BlindateServiceimpl();
        String csvFileBlindate = "D:\\Facultate\\JavaLab\\ProiectPAOUnitateMilitara\\fisiere\\fisierBlindate.csv";
        List<String[]> fisierBlindate = singletonFileReaderWriter.read(csvFileBlindate);
        blindateServiceimpl.addBlindate(fisierBlindate);
        List<Blindat> blindate = blindateServiceimpl.getBlindate();
        for (Blindat blindat : blindate){
            vehiculeService.addLogisticaVehicul(blindat);
        }

        TransportoareServiceimpl transportoareServiceimpl = new TransportoareServiceimpl();
        String csvFileTransportoare = "D:\\Facultate\\JavaLab\\ProiectPAOUnitateMilitara\\fisiere\\fisierTransportoare.csv";
        List<String[]> fisierTransportoare = singletonFileReaderWriter.read(csvFileTransportoare);
        transportoareServiceimpl.addTransportoare(fisierTransportoare);
        List<Transportor> transportoare = transportoareServiceimpl.getTransportoare();
        for (Transportor transportor : transportoare){
            vehiculeService.addLogisticaVehicul(transportor);
        }

        AutovehiculeServiceimpl autovehiculeServiceimpl = new AutovehiculeServiceimpl();
        String csvFileAutovehicule = "D:\\Facultate\\JavaLab\\ProiectPAOUnitateMilitara\\fisiere\\fisierAutovehicule.csv";
        List<String[]> fisierAutovehicule = singletonFileReaderWriter.read(csvFileAutovehicule);
        autovehiculeServiceimpl.addAutovehicule(fisierAutovehicule);
        List<Autovehicul> autovehicule = autovehiculeServiceimpl.getAutovehicule();
        for (Autovehicul autovehicul : autovehicule){
            vehiculeService.addLogisticaVehicul(autovehicul);
        }

        *//*System.out.println("Lista logistică vehicule: ");
        System.out.println(vehiculeService.getLogisticaVehicule());
        System.out.println();
        System.out.println();*//*


        ArtilerieServiceimpl artilerieServiceimpl = new ArtilerieServiceimpl();
        String csvFileArtilerie = "D:\\Facultate\\JavaLab\\ProiectPAOUnitateMilitara\\fisiere\\fisierArtilerie.csv";
        List<String[]> fisierArtilerie = singletonFileReaderWriter.read(csvFileArtilerie);
        artilerieServiceimpl.addLogisticaArtilerie(fisierArtilerie);

        *//*System.out.println("Lista logistică artilerie: ");
        System.out.println(artilerieServiceimpl.getLogisticaArtilerie());
        System.out.println();
        System.out.println();*//*


        EchipamentSpecialServiceimpl echipamentSpecialServiceimpl = new EchipamentSpecialServiceimpl();
        String csvFileSpecial = "D:\\Facultate\\JavaLab\\ProiectPAOUnitateMilitara\\fisiere\\fisierEchipamentSpecial.csv";
        List<String[]> fisierEchipamentSpecial = SingletonFileReaderWriter.INSTANCE.read(csvFileSpecial);
        echipamentSpecialServiceimpl.addLogisticaEchipamentS(fisierEchipamentSpecial);

        *//*System.out.println("Lista logistica echipament special: ");
        System.out.println(echipamentSpecialServiceimpl.getLogisticaEchipamentSpecial());
        System.out.println();
        System.out.println();*//*


        InfanterieServiceimpl infanterieServiceimpl = new InfanterieServiceimpl();
        String csvFileInfanterie = "D:\\Facultate\\JavaLab\\ProiectPAOUnitateMilitara\\fisiere\\fisierInfanterie.csv";
        List<String[]> fisierInfanterie = SingletonFileReaderWriter.INSTANCE.read(csvFileInfanterie);
        infanterieServiceimpl.addLogisticaInfanterie(fisierInfanterie);


        *//*System.out.println("Lista logistica infanterie: ");
        System.out.println(infanterieServiceimpl.getLogisticaInfanterie());
        System.out.println();
        System.out.println();*//*

        AngajatiServiceimpl angajatiServiceimpl = new AngajatiServiceimpl();
        angajatiServiceimpl.addAngajat(angajat1);
        angajatiServiceimpl.addAngajat(angajat2);
        angajatiServiceimpl.addAngajat(angajat3);
        angajatiServiceimpl.addAngajat(angajat4);
        angajatiServiceimpl.addAngajat(angajat5);
        angajatiServiceimpl.addAngajat(angajat6);
        angajatiServiceimpl.addAngajat(angajat7);
        angajatiServiceimpl.addAngajat(angajat8);
        angajatiServiceimpl.addAngajat(angajat9);
        angajatiServiceimpl.addAngajat(angajat10);

        angajat1.addVehicul(autovehiculeServiceimpl.getAutovehicule().get(0));
        angajat1.addVehicul(autovehiculeServiceimpl.getAutovehicule().get(3));
        angajat1.addInfanterie(infanterieServiceimpl.getLogisticaInfanterieAdd().get(5));
        angajat1.addInfanterie(infanterieServiceimpl.getLogisticaInfanterieAdd().get(6));
        angajat2.addVehicul(autovehiculeServiceimpl.getAutovehicule().get(2));
        angajat2.addVehicul(autovehiculeServiceimpl.getAutovehicule().get(4));
        angajat2.addArtilerie(artilerieServiceimpl.getLogisticaArtilerieAdd().get(1));
        angajat2.addArtilerie(artilerieServiceimpl.getLogisticaArtilerieAdd().get(2));
        angajat3.addEchipamentS(echipamentSpecialServiceimpl.getLogisticaEchipamentSpecialAdd().get(1));
        angajat3.addEchipamentS(echipamentSpecialServiceimpl.getLogisticaEchipamentSpecialAdd().get(3));
        angajat3.addVehicul(transportoareServiceimpl.getTransportoare().get(1));
        angajat3.addVehicul(transportoareServiceimpl.getTransportoare().get(3));
        angajat3.addVehicul(autovehiculeServiceimpl.getAutovehicule().get(5));
        angajat4.addEchipamentS(echipamentSpecialServiceimpl.getLogisticaEchipamentSpecialAdd().get(5));
        angajat4.addArtilerie(artilerieServiceimpl.getLogisticaArtilerieAdd().get(6));
        angajat4.addArtilerie(artilerieServiceimpl.getLogisticaArtilerieAdd().get(3));
        angajat5.addInfanterie(infanterieServiceimpl.getLogisticaInfanterieAdd().get(7));
        angajat5.addInfanterie(infanterieServiceimpl.getLogisticaInfanterieAdd().get(8));
        angajat5.addVehicul(transportoareServiceimpl.getTransportoare().get(2));
        angajat6.addVehicul(blindateServiceimpl.getBlindate().get(1));
        angajat6.addArtilerie(artilerieServiceimpl.getLogisticaArtilerieAdd().get(5));
        angajat6.addInfanterie(infanterieServiceimpl.getLogisticaInfanterieAdd().get(13));
        angajat6.addEchipamentS(echipamentSpecialServiceimpl.getLogisticaEchipamentSpecialAdd().get(2));
        angajat7.addVehicul(transportoareServiceimpl.getTransportoare().get(4));
        angajat7.addVehicul(blindateServiceimpl.getBlindate().get(2));
        angajat8.addInfanterie(infanterieServiceimpl.getLogisticaInfanterieAdd().get(12));
        angajat8.addEchipamentS(echipamentSpecialServiceimpl.getLogisticaEchipamentSpecialAdd().get(6));
        angajat9.addInfanterie(infanterieServiceimpl.getLogisticaInfanterieAdd().get(9));
        angajat10.addInfanterie(infanterieServiceimpl.getLogisticaInfanterieAdd().get(11));
        angajat10.addInfanterie(infanterieServiceimpl.getLogisticaInfanterieAdd().get(4));
        angajat10.addInfanterie(infanterieServiceimpl.getLogisticaInfanterieAdd().get(14));


        // Afisam lista sumara a angajatilor.
        *//*System.out.println("Lista angajati batalion: ");
        System.out.println(angajatiServiceimpl.getAngajati());*//*

        // In caz ca vrem sa afisam detaliat informatii despre angajat
        // System.out.println(angajat1.getDetaliiAngajat());

        singletonFileReaderWriter.writeToCSV("fisiere/fisierBatalion.csv", "Lista logistică artilerie: " +
                "\nBatalionul detine " + artilerieServiceimpl.getLogisticaArtilerieAdd().size() + " elemente de artilerie.\n"
                + artilerieServiceimpl.getLogisticaArtilerieAdd().toString() + "\n\n" + "Lista logistică vehicule: " +
                "\nBatalionul detine " + vehiculeService.getLogisticaVehiculeAdd().size() + " vehicule.\n"
                + vehiculeService.getLogisticaVehiculeAdd().toString() + "\n\n" + "Lista logistică echipament special: " +
                "\nBatalionul detine " + echipamentSpecialServiceimpl.getLogisticaEchipamentSpecialAdd().size()
                + " echipamente speciale." + "\n"
                + echipamentSpecialServiceimpl.getLogisticaEchipamentSpecialAdd().toString() + "\n\n"
                + "Lista logistică infanterie:\n" + "Batalionul detine "
                + infanterieServiceimpl.getLogisticaInfanterieAdd().size() + " elemente de infanterie."
                + "\n" + infanterieServiceimpl.getLogisticaInfanterieAdd().toString() + "\n\n" + "Listă angajați batalion:\n"
                + "Batalionul este format din " + angajatiServiceimpl.getAngajatiAdd().size() + " cadre militare.\n"
                + angajatiServiceimpl.getAngajatiAdd());

        String angajatiDetaliat = "";
        List<Angajat> angajati = angajatiServiceimpl.getAngajatiAdd();
        for (Angajat angajat : angajati){
            angajatiDetaliat = angajatiDetaliat + angajat.getDetaliiAngajat();
        }

        singletonFileReaderWriter.writeToCSV("fisiere/fisierAngajatiDetaliat.csv", angajatiDetaliat);
        */

        DataBaseConfiguration dataBaseConfiguration = new DataBaseConfiguration();
        AngajatRepository angajatRepository = new AngajatRepository(dataBaseConfiguration);
        //System.out.println("Lista angajati: ");
        //System.out.println(angajatRepository.getAllAngajati() + "\n\n");
        //System.out.println(angajatRepository.getAngajatiByName("Maftei", "Valentin"));
        //System.out.println(angajatRepository.getAngajatById(1));
        //angajatRepository.deleteAngajatById(12);
        //angajatRepository.deleteAngajatByName("Alexa", "Marin");

        ArtilerieRepository artilerieRepository = new ArtilerieRepository(dataBaseConfiguration);
        //System.out.println("Lista elemente de artilerie: ");
        //System.out.println(artilerieRepository.getAllArtilerie() + "\n\n");
        //System.out.println(artilerieRepository.getArtilerieByModel("M 1988"));
        //System.out.println(artilerieRepository.getArtilerieById(1));
        //artilerieRepository.deleteArtilerieById(7);
        //artilerieRepository.deleteArtilerieByModel("M 1988");

        InfanterieRepository infanterieRepository = new InfanterieRepository(dataBaseConfiguration);
        //System.out.println("Lista elemente de infanterie: ");
        //System.out.println(infanterieRepository.getAllInfanterie() + "\n\n");
        //System.out.println(infanterieRepository.getInfanterieByModel("M4A1"));
        //System.out.println(infanterieRepository.getInfanterieById(1));
        //infanterieRepository.deleteInfanterieByModel("RKG-3");
        //infanterieRepository.deleteInfanterieById(17);

        EchipamentSpecialRepository echipamentSpecialRepository = new EchipamentSpecialRepository(dataBaseConfiguration);
        //System.out.println("Lista echipament special:");
        //System.out.println(echipamentSpecialRepository.getAllEchipamentSpecial() + "\n\n");
        //System.out.println(echipamentSpecialRepository.getEchipamentSpecialByModel("BP-10"));
        //System.out.println(echipamentSpecialRepository.getEchipamentSpecialById(1));
        //echipamentSpecialRepository.deleteEchipamentSpecialById(3);
        //echipamentSpecialRepository.deleteEchipamentSpecialByModel("Zodiac MK3");

        TransportorRepository transportorRepository = new TransportorRepository(dataBaseConfiguration);
        //System.out.println("Lista transportoare: ");
        //System.out.println(transportorRepository.getAllTransportoare() + "\n\n");
        //System.out.println(transportorRepository.getTransportorById(1));
        //System.out.println(transportorRepository.getTransportorByModel("TAB-77"));
        //transportorRepository.deleteTransportorById(1);
        //transportorRepository.deleteTransportorByDenumire("MLVM");

        BlindatRepository blindatRepository = new BlindatRepository(dataBaseConfiguration);
        //System.out.println("Lista blindate: ");
        //System.out.println(blindatRepository.getAllBlindate() + "\n\n");


        AutovehiculRepository autovehiculRepository = new AutovehiculRepository(dataBaseConfiguration);
        //System.out.println("Lista autovehicule: ");
        //System.out.println(autovehiculRepository.getAllAutovehicule() + "\n\n");*/


    }
}