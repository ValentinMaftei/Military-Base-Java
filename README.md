[Română :romania:](#unitate-militară)

[English :eu:](#military-base)

# Unitate militară

##### Etapa a 3-a constă în intregrarea unei baze de date de locale (MySQL Server) pentru Input/Output și stocarea datelor.
##### Proiect realizat in Java, utilizând concepte de „Programare orientată pe obiecte”.
Proiectul ajută la gestiunea oricărei unități militare din România. Implementarea a fost făcută ținând cont de logistica militară de care dispune „Armata Română” și
de gradele/funcțiile pe care le pot avea militarii români.

Programul permite introducerea, stocarea și afișarea datelor despre echipamentele militare pe care le poate deține o unitate militară.

![diagramaPAO](https://github.com/ValentinMaftei/Proiect-PAO-234-Maftei-Valentin/assets/91968875/cbf297d6-bcfd-46ef-9ee3-722b903735e4)

##### Concepte POO utilizate

Clasa Vehicul - clasă de bază -> clasa Transportor, clasa Autovehicul, clasa Blindat
###### De la clasa Vehicul, datorită atributelor care apar în plus, a fost nevoie să fie definite alte 3 clase care să moștenească clasa Vehicul.

Clasa EchipamentSpecial,
Clasa Artilerie,
Clasa Infanterie,
###### Ajută la crearea obiectelor care fac parte din componența logisticii militare ce aparține unității.

Clasa Angajat 
###### Reprezintă personalul militar angajat în cadrul unității.

Clasa VehiculeServiceimpl,
Clasa EchipamentSpecialServiceimpl,
Clasa ArtilerieServiceimpl,
Clasa InfanterieServiceimpl,
Clasa AngajatiServiceimpl
###### Clase service implementate pentru adăugarea în liste a obiectelor fiecare în funcție de tipurile acestora și afișarea lor. 
Funcții utilizate în clase:

###### Afișarea angajaților din baza de date, inserarea, ștergerea și editarea.
```
public List<Angajat> getAllAngajati();
public List<Angajat> getAngajatiByName(String lastName, String firstName);
public Angajat getAngajatById(int id);
public void deleteAngajatById(int id);
public void deleteAngajatByName(String lastName, String firstName);
public void deleteAllAngajati();
public void insertAngajat(String nume, String prenume, Date dataNastere, String grad, String functie);
public void editAngajat(String editCrit, String newValue, String condition);
```

###### Afișarea elementelor de artilerie din baza de date, inserarea, ștergea și editarea.
```
public List<Artilerie> getAllArtilerie();
public List<Artilerie> getArtilerieByModel(String model);
public Artilerie getArtilerieById(int id);
public void deleteArtilerieById(int id);
public void deleteArtilerieByModel(String model);
public void deleteAllArtilerie();
public void insertArtilerie(String model, String categorie, String tip, float calibru, int bataieMaxima, String taraProvenienta);
public void editArtilerie(String editCrit, String newValue, String condition);
public void deleteGestionarArtilerie(int id);
```
###### Afișarea echipamentului special din baza de date, inserarea, ștergerea și editarea.
```
public List<EchipamentSpecial> getAllEchipamentSpecial();
public List<EchipamentSpecial> getEchipamentSpecialByModel(String model);
public EchipamentSpecial getEchipamentSpecialById(int id);
public void deleteEchipamentSpecialById(int id);
public void deleteEchipamentSpecialByModel(String model);
public void deleteAllSpeciale();
public void insertEchipamentSpecial(String tip, String model, String taraProvenienta);
public void editEchipamentSpecial(String editCrit, String newValue, String condition);
public void deleteGestionarEchipamentSpecial(int id);
```
###### Afișarea elementelor de infanterie din baza de date, inserarea, ștergerea și editarea.
```
public List<Infanterie> getAllInfanterie();
public List<Infanterie> getInfanterieByModel(String model);
public Infanterie getInfanterieById(int id);
public void deleteInfanterieById(int id);
public void deleteInfanterieByModel(String model);
public void deleteAllInfanterie();
public void insertInfanterie(String model, String categorie, String taraProvenienta, float calibru, boolean suportLuneta);
public void editInfanterie(String editCrit, String newValue, String condition);
public void deleteGestionarInfanterie(int id);
```
###### Afișarea autovehiculelor din baza de date, inserarea, ștergerea și editarea.
```
public List<Autovehicul> getAllAutovehicule();
public List<Autovehicul> getAutovehiculByDenumire(String model);
public Autovehicul getAutovehiculById(int id);
public void deleteAutovehiculById(int id);
public void deleteAutovehiculByDenumire(String denumire);
public void deleteAllAutovehicule();
public void insertAutovehicul(String denumire, String utilizare, String taraProvenienta, boolean blindat, int nrLocuri,
                                  int autonomie, int vitezaMaxima, String categorie, boolean suportRemorca, String tip);
public void editAutovehicul(String editCrit, String newValue, String condition);
public void deleteGestionarAutovehicul(int id);
```
###### Afișarea blindatelor din baza de date, inserarea, ștergerea și editarea.
```
public List<Blindat> getAllBlindate();
public List<Blindat> getBlindatByDenumire(String denumire);
public Blindat getBlindatById(int id);
public void deleteBlindatById(int id);
public void deleteBlindatByDenumire(String denumire);
public void deleteAllBlindate();
public void insertBlindat(String denumire, String utilizare, String taraProvenienta, boolean blindat, int nrLocuri,
                          int autonomie, int vitezaMaxima, boolean suportRemorca, boolean suportArma, String arma);
public void editBlindat(String editCrit, String newValue, String condition);
public void deleteGestionarBlindat(int id);
```
###### Afișarea transportoarelor din baza de date, inserarea, ștergerea și editarea.
```
public List<Transportor> getAllTransportoare();
public List<Transportor> getTransportorByDenumire(String model);
public Transportor getTransportorById(int id);
public void deleteTransportorById(int id);
public void deleteTransportorByDenumire(String denumire);
public void deleteAllTransportoare();
public void insertTransportor(String denumire, String utilizare, String taraProvenienta, boolean blinat, int nrLocuri,
                              int autonomie, int vitezaMaxima, String armamentPrincipal, String armamentSecundar, String tip);
public void editTransportor(String editCrit, String newValue, String condition);
public void deleteGestionarTransportor(int id);
```

Inputurile pentru fiecare tip de obiect
```
Input valid Vehicul : - Autovehicul -> denumire, utilizare (OFENSIVA, DEFENSIVA, TRANSPORT), țară de proveniență, blindat (DA/NU), număr de locuri, autonomie (în km), 
                                       viteză maximă (în km), categorie permis (A1, A, B, BE, etc.), tip (VEHICUL 4x4, VEHICUL TRANSPORT USOR, FURGONETA, ATV, AUTOCAMION);
                      - Transportor -> denumire, utilizare (OFENSIVA, DEFENSIVA, TRANSPORT), țară de proveniență, blindat (DA/NU), număr de locuri, autonomie (în km), 
                                       viteză maximă (în km), armament principal, armament secundar, tip (SENILATA, ROTI)
                      - Blindat -> denumire, utilizare (OFENSIVA, DEFENSIVA, TRANSPORT), țară de proveniență, blindat (DA/NU), numar de locuri, autonomie (în km), 
                                   viteză maximă (în km), suport remorcă (DA/NU), suport armă (DA/NU), armă
                                   
Input valid Artilerie -> model, categorie (MORTIERE, OBUZIERE, LANSATOR, TUNURI, ANTITANC, ANTIAERIANA, SOL_AER), tip artilerie (STABIL, MOBIL, REMORCABIL, AUTO),
                         calibru, bătaie maximă, țară de proveniență
                         
Input valid Infanterie -> model, categorie (PISTOALE, PISTOALE_MITRALIERA, ARME_ASALT, PUSTI_MITRALIERE, MITRALIERE, MITRALIERE_GRELE, PUSTI_LUNETA, GRENADE), țară de 
                          proveniență, calibru, suport lunetă (DA/NU)

Input valid Echipament Special -> tip, model, țară de proveniență

Input valid Angajat -> nume, prenume, data nasterii, grad (OFITER, SUBOFITER, SOLDAT_GRADAT_PROFESIONIST, MAISTRU_MILITAR), funcție (SUBLOCOTENENT, LOCOTENENT,
                       CAPITAN, MAIOR, LOCOTENENT_COLONEL, COLONEL, GENERAL_DE_BRIGADA, GENERAL_MAIOR, GENERAL_LOCOTENENT, GENERAL_MARESAL, SOLDAT, FRUNTAS, CAPORAL,
                       SERGENT, SERGENT_MAJOR, PLUTONIER, PLUTONIER, PLUTONIER_ADJUTANT, PLUTONIER_ADJUTANT_PRINCIPAL)
```

# Military base
