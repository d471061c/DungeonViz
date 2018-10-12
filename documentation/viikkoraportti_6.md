# Viikkoraportti 6

## Mitä olen tehnyt tällä viikolla

Olen korjannut `PrimHeap` luokkaa sen bugeista ja lisännyt entistä enemmän testejä.
Tämän lisäksi olen refaktoroinnut eri osia koodista. Sekä tehnyt vertaispalautteen.

## Miten ohjelma on edistynyt

Ohjelma toimii paremmin verrattuna siihen, miten se ennen toimi.

## Mitä opin tällä viikolla / tänään

Luokan `PrimHeap` ongelma ei ollut suoranaisesti vain metodin `update` syytä vaan ongelmana oli 
prim-olioiden kirjassapito luokan sisällä. Tämän korjaaminen vaati käytännössä sitä, että muokkaisi
`PrimHeap` luokan koodia alusta asti uudestaan. `update` metodi sinällään oli toteutettu väärin, sillä
`heapify` käsittelee annetun indeksin lapset, ei vanhempia. Ja siitä syystä `update` metodi ei 
toiminut aina halutulla tavalla.

## Mikä jäi epäselväksi tai tuottanut vaikeuksia

`PrimHeap` luokan korjailut kaikkine pulmineen.

## Mitä teen seuraavaksi

Teen testejä ja dokumentaation loppuun. Pyrin tekemään myös Kurskalin algoritmin jos jää aikaa.

## Käytetyt työtunnit

Käytin noin kahdeksan tuntia.