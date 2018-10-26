# Testausdokumentti

## Mitä on testattu, miten tämä tehtiin

## PrimObjectHeap.java
Tärkeimmät testit liittyvät keon testaamiseen. Testaus tapahtuu lisäämällä ja poistamalla keosta alkioita. Tämän lisäksi kekoa testaan askel askeleelta `strictOverallTest` metodissa. Askeleissa testaan keon sisäistä listaa (`array`) ja siihen liittyvää, hajautustaulun kaltaisesti käyttäytyvää, listaa (`heapLocations`). Listan `heapLocations` indeksissä `i` on Prim olion, jonka id on `i`, sijainti listassa `array`. 

### Room.java
Huoneistoista testattiin etäisyydet ja päällekkäisyydet. Esimerkiksi euklidinen etäisyys kokeiltiin asettamalla huoneita erilleen toisistaan ja mittaalla niiden etäisyyden.

### PrimObject.java
Prim olioita testattiin vertailulla, sillä tätä käytetään primmin algoritmin yhteydessä.

### CommandLineParser.java
Komentorivitulkista testattiin argumenttien tulkinta ja mahdolliset virhetilanteet, jotka johtuvat vääränlaisista syötteistä.

### Muuta

Luokat kuten `Edge.java` ja `Dungeon.java` ovat jätetty testaamatta siitä syystä, että niissä ei ole toimintoja vaan niiden tarkoitus on varastoida tietoa. Luokka `RoomFactory.java` ei testata siitä syystä, että sen tuottamat tulokset ovat lähinnä satunnaisia.

## Miten testit voidaan toistaa

Testit voidaan toistaa suorittamalla `JUnit`-testit.

## Ohjelman toiminnan empiirisen testauksen tulosten esittäminen graaffisessa muodossa

Ohjelman empiiriset testaukset eivät tuota uutta tietoa kyseiseen algoritmiin liittyen. Toisaalta esimerkiksi saman kokoisten huonneitten sijoittaminen tietyn kokoiseen tilaan voisi olla empiirisen testauksen aihe, mutta siihen liittyy vahvasti javan `Random`-luokan sisäinen toteutus.