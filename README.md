[Română :romania:](#unitate-militară)

[English :eu:](#military-base)

# Unitate militară

##### Proiect realizat in Java, utilizând concepte de „Programare orientată pe obiecte”.
Proiectul ajută la gestiunea oricărei unități militare din România. Implementarea a fost făcută ținând cont de logistica militară de care dispune „Armata Română” și
de gradele/funcțiile pe care le pot avea militarii români.

Programul permite introducerea, stocarea și afișarea datelor despre echipamentele militare pe care le poate deține o unitate militară.

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

###### Afișarea listei de angajați și adăugarea unui angajat în listă.
```
void addAngajat(Angajat angajat)
List<Angajat> getAngajati()
```

###### Afișarea listei de Echipament Special și adăugarea unui element de acest tip în listă.
```
void addLogisticaArtilerie(Artilerie artilerie)
List<Artilerie> getLogisticaArtilerie()
```
###### Afișarea listei de Logistică Echipament Special și adăugarea unui element de acest tip în listă.
```
void addLogisticaEchipamentS(EchipamentSpecial echipamentSpecial)
Set<EchipamentSpecial> getLogisticaEchipamentSpecial()
```
###### Afișarea listei de Logistică Infanterie și adăugarea unui element de acest tip în listă.
```
void addLogisticaInfanterie(Infanterie infanterie)
List<Infanterie> getLogisticaInfanterie()
```
###### Afișarea listei de Logistică Vehicule și adăugarea unui angajat în listă.
```
void addLogisticaVehicul(Vehicul vehicul)
List<Vehicul> getLogisticaVehicule()
```
###### Afișarea detaliată a unui angajat.
```
public String getDetaliiAngajat()
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
