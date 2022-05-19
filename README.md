# OOPprojekt

Autorid: Laura Koobas, Liisi Voitra

Projekti eesmärk: Inimene VS Loodus

...
####Programmist natuke: 
Kasutaja valib oma karakterile nime ja seejärel asub võitlema vastastega.
Edasi tegelased võitlevad, kui võidab kasutaja saab mängija elupunkte või tugevust juurde, 
kui kasutaja kaotab, siis muutub 'HP' madalamaks.
Mängida saab nii kaua kuni kõik vastased on alistatud või 'HP' kukub miinustesse.



###Iga klassi kohta eraldi selle eesmärk ja olulisemad meetodid
Klassi kirjeldused ja nende eesmärgid on välja toodud nende failide kommentaarides.



####Projekti protsessi kirjeldus:
1. Teema valimine[mõlemad]- arendasime eelmist rühmatööd edasi.
2. Aluspõhi[mõlemad] - Aluspõhjaks oli meil juba eelmine rühmatöö olemas.
3. Põhja ümber tegemine graafiliseks[mõlemad] - Programmi ülevaatamine, eelnevalt olemasoleva ümberkirjutamine graafiliseks
4. Koodi lihvimine, lisadetailide lisamine[Laura] - Lisasin mõningaid detaile juurde, nt vastaste piltide kuvamine võitluse ajal. Tegin ümber paar ebavajalikku tsükklit.


####Tööjaotus:
Liisi - M2ng, Damage, README, KirjutaLogi, Veebileht (AEG 7h)

Laura - M2ng, Karakter, Vastane, Graafika, README (AEG 8h)



####Raskused:
Üpriski raske oli eelnevat koodi ümber teha graafiliseks. Pidime end rohkem kurssi viima
JavaFX Timeline klassiga, mis mängis suurt rolli mängu struktuuri loomisel. Kõige raskem
oli nö alguse ja mängulevelite omavahel ühendamine - ainus meetod, mille tööle sain, oli
peale iga mängutsükli läbimist uue mängu loomine, kuhu oli lihtsalt uus informatsioon antud.
See pole just eriti hea lahendus, kuna võtab palju resursse.




####Hinnang lõpptulemusele: 
Projekti lõpptulemus võiks parem olla, hetkel on graafiline osa siiski väga algeline,
ning ka mängulevelite ühendamie on kohmakalt tehtud. Siiski oleme sellega rahul, sest projekt
on täitsa päris mäng, mis töötab.




####Testimise selgitus:
Alustasime Graafika klassi testimisest, kuna see on rohkem eraldatud. Karakteri ja Vastase klassid olid juba eelnevalt testitud.
Graafika klassis sai jälile erinevatele JavaFX Timeline iseärasustele, mis aitas kaasa ka 
M2ngu klassi testimisel. M2ngu klassi testides testisin iga tsüklit eraldi, ning lõpuks ka koos,
et näha kas Timeline töötas korrektselt. KirjutaLogi klassi sai testida M2ngu testimise käigus, kuna
see lõi alati logi. Logifail kajastas ka M2ngu klassi kulgu.