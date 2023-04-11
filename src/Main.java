import Model.*;
import Service.ArtilerieService;
import Service.VehiculeService;
import Service.impl.*;
import Utile.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Transportor transportor1 = new Transportor("MLVM", UtilizareVehicul.TRANSPORT, "Romania",
                true, 7, 700, 48, "mitralieră grea KPVT 14,5 mm",
                "mitralieră PKT 7,62 mm", TipTransportor.SENILATA);
        Transportor transportor2 = new Transportor("TAB B33 Zimbru", UtilizareVehicul.TRANSPORT, "Romania",
                true, 10, 700, 85, "mitralieră grea KPVT 14,5 mm",
                "mitralieră PKT 7,62 mm", TipTransportor.ROTI);
        Transportor transportor3 = new Transportor("TAB-77", UtilizareVehicul.TRANSPORT, "Romania",
                true, 11, 550, 80, "mitralieră grea MTB cal. 14,5 mm ",
                "mitralieră PKT 7,62 mm", TipTransportor.ROTI);
        Transportor transportor4 = new Transportor("TABC-79", UtilizareVehicul.TRANSPORT, "Romania",
                true, 11, 700, 85, "mitralieră grea KPVT 14,5 mm",
                "mitralieră PKT 7,62 mm", TipTransportor.ROTI);
        Transportor transportor5 = new Transportor("MOWAG Piranha", UtilizareVehicul.TRANSPORT, "Elvetia",
                true, 11, 700, 85, "stație de luptă FNNH Arrows cu mitralieră grea M2HB",
                "mortiere 120 mm", TipTransportor.ROTI);

        Blindat blindat1 = new Blindat("URO VAMTAC", UtilizareVehicul.TRANSPORT, "Spania",
                true, 4, 600, 135, true,
                true, "M240");
        Blindat blindat2 = new Blindat("HUMVEE", UtilizareVehicul.TRANSPORT, "Statele Unite ale Americii",
                true, 4, 443, 125, true,
                false, "-");
        Blindat blindat3 = new Blindat("WOLF", UtilizareVehicul.TRANSPORT, "Israel",
                true, 12, 500, 120, true,
                true, "Turela RCWS");

        Autovehicul autovehicul1 = new Autovehicul("Land Rover Defender", UtilizareVehicul.TRANSPORT,
                "Regatul Unit", false, 5, 400,
                140, CategorieAutovehicule.B, true, TipAutovehicul.VEHICUL_4X4);
        Autovehicul autovehicul2 = new Autovehicul("Volkswagen Transporter", UtilizareVehicul.TRANSPORT,
                "Germania", false, 9, 600,
                160, CategorieAutovehicule.B, false, TipAutovehicul.FURGONETA);
        Autovehicul autovehicul3 = new Autovehicul("Mercedes-Benz Sprinter", UtilizareVehicul.TRANSPORT,
                "Germania", false, 3, 700,
                170, CategorieAutovehicule.CE, true, TipAutovehicul.FURGONETA);
        Autovehicul autovehicul4 = new Autovehicul("Dacia Duster", UtilizareVehicul.TRANSPORT,
                "Romania", false, 5, 400,
                140, CategorieAutovehicule.B, false, TipAutovehicul.VEHICUL_4X4);
        Autovehicul autovehicul5 = new Autovehicul("Polaris ATV", UtilizareVehicul.TRANSPORT,
                "Statele Unite ale Americii", false, 4, 100,
                90, CategorieAutovehicule.A, true, TipAutovehicul.ATV);
        Autovehicul autovehicul6 = new Autovehicul("IVECO", UtilizareVehicul.TRANSPORT,
                "Italia", true, 3, 500,
                110, CategorieAutovehicule.DE, true, TipAutovehicul.AUTOCAMION);


        EchipamentSpecial echipamentSpecial1 = new EchipamentSpecial(TipSpeciale.BARCA_ASALT,
                "BP-10", "Romania");
        EchipamentSpecial echipamentSpecial2 = new EchipamentSpecial(TipSpeciale.PLANTATOR_MINE,
                "DPM_4", "Romania");
        EchipamentSpecial echipamentSpecial3 = new EchipamentSpecial(TipSpeciale.BARCA_ASALT,
                "Zodiac MK3", "Franta");
        EchipamentSpecial echipamentSpecial4 = new EchipamentSpecial(TipSpeciale.POD_PONTOANE,
                "PR-71", "Romania");
        EchipamentSpecial echipamentSpecial5 = new EchipamentSpecial(TipSpeciale.SALUPA_BLINDATA,
                "ST 140", "Romania");
        EchipamentSpecial echipamentSpecial6 = new EchipamentSpecial(TipSpeciale.BARJA_AUTOPROPULSANTA,
                "MLC 240", "Romania");
        EchipamentSpecial echipamentSpecial7 = new EchipamentSpecial(TipSpeciale.FERIBOT,
                "MLC 300", "Romania");


        Artilerie artilerie1 = new Artilerie("M 1988", CategorieArtilerie.MORTIERE, TipArtilerie.STABIL, 60,
                8, "Romania");
        Artilerie artilerie2 = new Artilerie("M 1982", CategorieArtilerie.MORTIERE, TipArtilerie.STABIL, 82,
                7, "Romania");
        Artilerie artilerie3 = new Artilerie("HIMARS", CategorieArtilerie.LANSATOR, TipArtilerie.MOBIL, 227,
                480, "Statele Unite ale Americii");
        Artilerie artilerie4 = new Artilerie("LAROM", CategorieArtilerie.LANSATOR, TipArtilerie.MOBIL, 160,
                45, "Israel");
        Artilerie artilerie5 = new Artilerie("Spike", CategorieArtilerie.ANTITANC, TipArtilerie.MOBIL, 30,
                1, "Israel");
        Artilerie artilerie6 = new Artilerie("Gepard SPAAG", CategorieArtilerie.ANTIAERIANA, TipArtilerie.MOBIL,
                35, 5, "Romania");
        Artilerie artilerie7 = new Artilerie("Mim-104 Patriot", CategorieArtilerie.ANTIAERIANA, TipArtilerie.MOBIL,
                90, 12, "Statele Unite ale Americii");


        Infanterie infanterie1 = new Infanterie("M4A1", CategorieInfanterie.ARME_ASALT,
                "Statele Unite ale Americii", 5.56F, true);
        Infanterie infanterie2 = new Infanterie("Pistol MD 2000", CategorieInfanterie.PISTOALE,
                "Romania", 9, false);
        Infanterie infanterie3 = new Infanterie("Glock 17", CategorieInfanterie.PISTOALE,
                "Austria", 9, false);
        Infanterie infanterie4 = new Infanterie("Pistol TT-Cugir", CategorieInfanterie.PISTOALE,
                "Romania", 7.65F, false);
        Infanterie infanterie5 = new Infanterie("Uzi", CategorieInfanterie.PISTOALE_MITRALIERA,
                "Israel", 9, false);
        Infanterie infanterie6 = new Infanterie("HK UMP9", CategorieInfanterie.PISTOALE_MITRALIERA,
                "Germania", 9, true);
        Infanterie infanterie7 = new Infanterie("PA md. 86", CategorieInfanterie.ARME_ASALT,
                "Romania", 5.45F, true);
        Infanterie infanterie8 = new Infanterie("Heckler G63", CategorieInfanterie.ARME_ASALT,
                "Germania", 5.56F, true);
        Infanterie infanterie9 = new Infanterie("Steyr AUG", CategorieInfanterie.ARME_ASALT,
                "Austria", 7.65F, false);
        Infanterie infanterie10 = new Infanterie("PM md. 64", CategorieInfanterie.PUSTI_MITRALIERE,
                "Romania", 7.62F, true);
        Infanterie infanterie11 = new Infanterie("M249", CategorieInfanterie.PUSTI_MITRALIERE,
                "Statele Unite ale Americii", 5.56F, true);
        Infanterie infanterie12 = new Infanterie("DSK", CategorieInfanterie.MITRALIERE_GRELE,
                "Romania", 12.7F, false);
        Infanterie infanterie13 = new Infanterie("PSL", CategorieInfanterie.PUSTI_LUNETA,
                "Romania", 7.62F, true);
        Infanterie infanterie14 = new Infanterie("Barrett M82", CategorieInfanterie.PUSTI_LUNETA,
                "Statele Unite ale Americii", .50F, true);
        Infanterie infanterie15 = new Infanterie("RKG-3", CategorieInfanterie.GRENADE,
                "Romania", 0, false);

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

        angajat1.addVehicul(autovehicul1);
        angajat1.addVehicul(autovehicul3);
        angajat1.addInfanterie(infanterie5);
        angajat1.addInfanterie(infanterie6);
        angajat2.addVehicul(autovehicul2);
        angajat2.addVehicul(autovehicul4);
        angajat2.addArtilerie(artilerie1);
        angajat2.addArtilerie(artilerie2);
        angajat2.addArtilerie(artilerie7);
        angajat3.addEchipamentS(echipamentSpecial1);
        angajat3.addEchipamentS(echipamentSpecial3);
        angajat3.addVehicul(transportor1);
        angajat3.addVehicul(transportor3);
        angajat3.addEchipamentS(echipamentSpecial3);
        angajat3.addVehicul(autovehicul5);
        angajat4.addEchipamentS(echipamentSpecial5);
        angajat4.addVehicul(autovehicul6);
        angajat4.addArtilerie(artilerie6);
        angajat4.addArtilerie(artilerie3);
        angajat4.addArtilerie(artilerie4);
        angajat5.addVehicul(transportor5);
        angajat5.addInfanterie(infanterie7);
        angajat5.addInfanterie(infanterie8);
        angajat5.addVehicul(transportor2);
        angajat6.addVehicul(blindat1);
        angajat6.addArtilerie(artilerie5);
        angajat6.addVehicul(blindat3);
        angajat6.addInfanterie(infanterie13);
        angajat6.addEchipamentS(echipamentSpecial2);
        angajat7.addVehicul(transportor4);
        angajat7.addVehicul(blindat2);
        angajat8.addEchipamentS(echipamentSpecial7);
        angajat8.addInfanterie(infanterie12);
        angajat8.addEchipamentS(echipamentSpecial6);
        angajat9.addInfanterie(infanterie9);
        angajat10.addInfanterie(infanterie11);
        angajat10.addInfanterie(infanterie4);
        angajat10.addInfanterie(infanterie14);


        VehiculeServiceimpl vehiculeService = new VehiculeServiceimpl();
        vehiculeService.addLogisticaVehicul(transportor1);
        vehiculeService.addLogisticaVehicul(transportor2);
        vehiculeService.addLogisticaVehicul(transportor3);
        vehiculeService.addLogisticaVehicul(transportor4);
        vehiculeService.addLogisticaVehicul(transportor5);

        vehiculeService.addLogisticaVehicul(autovehicul1);
        vehiculeService.addLogisticaVehicul(autovehicul2);
        vehiculeService.addLogisticaVehicul(autovehicul3);
        vehiculeService.addLogisticaVehicul(autovehicul4);
        vehiculeService.addLogisticaVehicul(autovehicul5);
        vehiculeService.addLogisticaVehicul(autovehicul6);

        vehiculeService.addLogisticaVehicul(blindat1);
        vehiculeService.addLogisticaVehicul(blindat2);
        vehiculeService.addLogisticaVehicul(blindat3);

        System.out.println("Lista logistica vehicule: ");
        System.out.println(vehiculeService.getLogisticaVehicule());
        System.out.println();
        System.out.println();


        ArtilerieServiceimpl artilerieService = new ArtilerieServiceimpl();
        artilerieService.addLogisticaArtilerie(artilerie1);
        artilerieService.addLogisticaArtilerie(artilerie2);
        artilerieService.addLogisticaArtilerie(artilerie3);
        artilerieService.addLogisticaArtilerie(artilerie4);
        artilerieService.addLogisticaArtilerie(artilerie5);
        artilerieService.addLogisticaArtilerie(artilerie6);
        artilerieService.addLogisticaArtilerie(artilerie7);

        System.out.println("Lista logistica artilerie: ");
        System.out.println(artilerieService.getLogisticaArtilerie());
        System.out.println();
        System.out.println();


        EchipamentSpecialServiceimpl echipamentSpecialService = new EchipamentSpecialServiceimpl();
        echipamentSpecialService.addLogisticaEchipamentS(echipamentSpecial1);
        echipamentSpecialService.addLogisticaEchipamentS(echipamentSpecial2);
        echipamentSpecialService.addLogisticaEchipamentS(echipamentSpecial3);
        echipamentSpecialService.addLogisticaEchipamentS(echipamentSpecial4);
        echipamentSpecialService.addLogisticaEchipamentS(echipamentSpecial5);
        echipamentSpecialService.addLogisticaEchipamentS(echipamentSpecial6);
        echipamentSpecialService.addLogisticaEchipamentS(echipamentSpecial7);

        System.out.println("Lista logistica echipament special: ");
        System.out.println(echipamentSpecialService.getLogisticaEchipamentSpecial());
        System.out.println();
        System.out.println();


        InfanterieServiceimpl infanterieService = new InfanterieServiceimpl();
        infanterieService.addLogisticaInfanterie(infanterie1);
        infanterieService.addLogisticaInfanterie(infanterie2);
        infanterieService.addLogisticaInfanterie(infanterie3);
        infanterieService.addLogisticaInfanterie(infanterie4);
        infanterieService.addLogisticaInfanterie(infanterie5);
        infanterieService.addLogisticaInfanterie(infanterie6);
        infanterieService.addLogisticaInfanterie(infanterie7);
        infanterieService.addLogisticaInfanterie(infanterie8);
        infanterieService.addLogisticaInfanterie(infanterie9);
        infanterieService.addLogisticaInfanterie(infanterie10);
        infanterieService.addLogisticaInfanterie(infanterie11);
        infanterieService.addLogisticaInfanterie(infanterie12);
        infanterieService.addLogisticaInfanterie(infanterie13);
        infanterieService.addLogisticaInfanterie(infanterie14);
        infanterieService.addLogisticaInfanterie(infanterie15);

        System.out.println("Lista logistica infanterie: ");
        System.out.println(infanterieService.getLogisticaInfanterie());
        System.out.println();
        System.out.println();

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

        // Afisam lista sumara a angajatilor.
        System.out.println("Lista angajati batalion: ");
        System.out.println(angajatiServiceimpl.getAngajati());


        // In caz ca vrem sa afisam detaliat informatii despre angajat
        System.out.println(angajat1.getDetaliiAngajat());
        System.out.println(angajat1.getDetaliiAngajat());

    }
}