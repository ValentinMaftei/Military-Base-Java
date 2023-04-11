[Română :romania:](#unitate-militara)

[English :eu:](#military-base)

# Unitate militara

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
```
void addAngajat(Angajat angajat)
List<Angajat> getAngajati()

void addLogisticaArtilerie(Artilerie artilerie)
List<Artilerie> getLogisticaArtilerie()

void addLogisticaEchipamentS(EchipamentSpecial echipamentSpecial)
Set<EchipamentSpecial> getLogisticaEchipamentSpecial()

void addLogisticaInfanterie(Infanterie infanterie)
List<Infanterie> getLogisticaInfanterie()

void addLogisticaVehicul(Vehicul vehicul)
List<Vehicul> getLogisticaVehicule()

public String getDetaliiAngajat()
```

```
Input valid Vehicul : - Autovehicul -> denumire, utilizare (OFENSIVA, DEFENSIVA, TRANSPORT), țară de proveniență, blindat (DA/NU), număr de locuri, autonomie (în km), 
                                       viteză maximă (în km), categorie permis (A1, A, B, BE, etc.), tip (VEHICUL 4x4, VEHICUL TRANSPORT USOR, FURGONETA, ATV, AUTOCAMION);
                      - Transportor -> denumire, utilizare (OFENSIVA, DEFENSIVA, TRANSPORT), țară de proveniență, blindat (DA/NU), număr de locuri, autonomie (în km), 
                                       viteză maximă (în km), armament principal, armament secundar, tip (SENILATA, ROTI)
                      - Blindat -> denumire, utilizare (OFENSIVA, DEFENSIVA, TRANSPORT), țară de proveniență, blindat (DA/NU), numar de locuri, autonomie (în km), 
                                   viteză maximă (în km), suport remorcă (DA/NU), suport armă (DA/NU), armă
                                   
Input valid Artilerie -> model, categorie (MORTIERE, OBUZIERE, LANSATOR, TUNURI, ANTITANC, ANTIAERIANA, SOL_AER), tip artilerie (STABIL, MOBIL, REMORCABIL, AUTO),
                         calibru, bătaie maximă, țară de proveniență.
                         
