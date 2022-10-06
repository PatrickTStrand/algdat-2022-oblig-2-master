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