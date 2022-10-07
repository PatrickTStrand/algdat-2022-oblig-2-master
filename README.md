# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Patrick Tufte Strand, s364577, s364577@oslomet.no

# Arbeidsfordeling

Ikke relevant siden jeg er 1 person

# Oppgavebeskrivelse

Oppgave 1)

Ble løst ved å først finne første verdi som ikke var null. Så setter den det
som hode. Så vil den løkke gjennom listen og finne flere som ikke er null. Den
vil da sette en peker fra det som blir halen til den nye noden. Den sørger for
å oppdatere variabelen antall til enhver tid.

Passerer alt på sjekklisten.

Oppgave 2)

Ble løst ved å traversere gjennom listen og legge til de ulike verdiene.
På omvendtString reverserte man gjennom listen.

Når man skalø legge til en verdi vil jeg først sjekke om listen er tom.
Om den er tom setter jeg hode og halen til den samme verdien med nullpekere
begge veier. Om listen ikke er tom legger jeg til den nye noden på slutten av listen.
Jeg vil uansett inkrementere endringer og antall.

Passerer alt på sjekklisten.

Oppgave 3)

FinnNode ble løst ved å først ta å sjekke om vi skal
lete forrest eller bakerst i listen.
Så traveserer man gjennom listen, fra først indeks
eller siste indeks. Når man har riktig returnerer man
Noden.

For å løse hent returnerte jeg verdien til noden
som blir hentet med finnNode.

For å løse oppdater brukte jeg først indeksKontroll
og requireNonNull. Så tok jeg finnNode,
lagret den gamle verdien, endret så til den nye verdienl.
Jeg måtte også huske å inkrementere endringer, før 
jeg returnerte den gamle verdien.

For å løse subliste måtte jeg legge til fratilKontroll
fra kompendiet. Jeg laget så en ny liste,
satte antall til 0,
og så lenge fra og til ikke var lik la jeg til
Nodene fra superlisten ved å finne førsete noden
og legge til Nodene etterpå. Sørget også for at
antall ble inkrementert.

Oppgave 4)

For å løse indeksTil traverserte jeg gjennom
listen og brukte equals() for å sjekke om 
listen inneholdt verdien. Om man kommer 
gjennom hele listen uten å finne verdien returneres
-1.

For å løse inneholder sjekket jeg om indeksen
man fikk retuernert fra indeksTil var høyere
enn -1. Om det er det betyr det at listen
inneholder verdien, og det skal derfor returneres
true.

På denne oppgaven ble det bare én commit, men
det var fordi den ble så utrolig rask å kode.

Oppgave 5)

Jeg løste oppgave leggInn(indeks, verdi)
ved å først ta test om verdi er null eller
om indeks er lavere enn 0 eller høyere enn antall.
Det neste jeg sjekker er om listen er tom,
for da kan jeg bare kjøre leggInn(verdi).
Så sjekker jeg om den skal bli plassert først i listen.
Visst den skal bli først setter jeg hode som den nye noden.
Så må jeg sette hod.neste.forrige til hode, slik at det funker begge veier.
Så må jeg inkrementer antall og endringer.
Videre sjekker jeg om den skal bli plassert sist i listen.
Om den skal det kan jeg bare kjøre leggInn(verdi).
Om den ikke treffer de andre checkene vet jeg at den
skal bli plassert et sted inne i listen, og jeg må
da bare sørge for at pekerene går begge veier.
Jeg trenger da ikke å forholde meg til hode og hale.

Oppgave 6)

Løst fjern(indeks) ved å ta forbehold for de fire scenarioene:

1. Skal fjerne det eneste elementet i en liste
2. Skal fjerne det siste elementet i en liste
3. Skal fjerne det første elementet i en liste
4. Skal fjerne et element i midten av listen

Da var det bare å sørge for at pekerene gikk til riktig
element, og at hode/hale eventuelt ble endret.

For å løse fjern(verdi) traverserer man gjennom
listen og ser om man finner verdien. Om man finner verdien
fjerner man Noden, på samme måte som i finn(int).
Om man ikke finner verdien returnerer man false