# OOPprojekt

Autorid: Laura Koobas, Liisi Voitra

Projekti eesmärk: Inimene VS Loodus

...
####Programmist natuke: 
Kasutaja valib oma karakterile nime ja seejärel asub võitlema vastastega.
Edasi tegelased võitlevad, kui võidab kasutaja saab mängija elupunkte või tugevust juurde, 
kui kasutaja kaotab, siis muutub 'health' madalamaks.
Mängida saab nii kaua kuni kõik vastased on alistatud või 'health' kukub miinustesse.



###iga klassi kohta eraldi selle eesmärk ja olulisemad meetodid
Klassi kirjeldused ja nende eesmärgid on välja toodud nende failide kommentaarides.



####Projekti protsessi kirjeldus:
1. Teema valimine[mõlemad]- see võttis veidi aega, kuid leidsime ilma pikema viivituseta teema, mis mõlemale huvi pakkus
2. Aluspõhi[mõlemad] - Arutasime, mida täpsemalt teeme ja kuidas. Tegime ära enam-vähem töötava lahenduse.
3. Tööle panek ja kontroll[mõlemad] - Programmi ülevaatamine, kommentaaride lisamine, koodi lihvimine.


####Tööjaotus:
Liisi - M2ng, Damage, README, Alg (AEG 2h)

Laura - M2ng, Karakter,Vastane (AEG 2h)





####Raskused:
Teemavalikuga läks ilmselt kõige rohkem aega. Projekti enda teostamine oli suhteliselt arusaadav - viimastes
praktikumides ja loengutes õpitu (nt pärilus) tuli koodi optimiseerimisel kasuks.




####Hinnang lõpptulemusele: 
Projekti lõpptulemusega oleme rahul, edasiseks arenduseks võiks kasutada rohkem kasutaja sisendeid, et võitluste
tulemus ei oleks täiesti suvaline - see teeks mängu huvitavamaks ja kaasahaaravamaks.




####Testimise selgitus:
Testisime alguses dialoogi kasutajaga peaklassis, siis lisasime esimesed lisaklassid (Karakter ja Vastane) ning
vaatasime kas ülekatmised töötasid ning eemaldasime üleliigseid parameetreid (nt oli alguses määratud ka
baas STR ja HP, mille me lõpuks eemaldasime). Algselt kirjutasime klassi M2ng koodi peaklassis valmis testimiseesmärkidel,
pärast lõime sellest eraldi klassi M2ng. Lõpuks testisime kõiki klasse peaklassis ja vaatasime erijuhte (nt tekstiakna
sulgemine kasutaja poolt).