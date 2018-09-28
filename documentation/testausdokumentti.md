# Testausdokumentti

## Mitä on testattu, miten tämä tehtiin

Tärkeimmät tesit liittyvät keon testaamiseen. Testaus tapahtuu lisäämällä ja poistamalla keosta alkioita.

## Minkälaisilla syötteillä testaus tehtiin

Testaus tehtiin kasvavilla ja vähenevillä taulukoilla, joilla oli arvoina yhdestä sataan. Riippuen keon tyypistä käytettiin joko numeroita (`int`) tai Primmin algoritmiin suunnattuja olioita (`PrimObject`).

## Miten testit voidaan toistaa

Suorittamalla `JUnit`-testit

## Ohjelman toiminnan empiirisen testauksen tulosten esittäminen graafisessa muodossa.

Ohjelma piirtää ASCII-kuvan luolastosta. ASCII-kuvausta ei testata, vaan sen korkeampi abstraktio-taso, eli huone-luokka (`Room.java`) ja siihen liittyvä tehdas-luokka joka tuottaa kyseisiä luokkia (`RoomFactory.java`). Testauksilla testataan huoneitten etäisyyttä toisistaan ja niiden mahdolliset päälekkäisyydet.

