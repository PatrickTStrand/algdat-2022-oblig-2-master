package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class DobbeltLenketListe<T> implements Liste<T> {
    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {
        // Tom liste, setter derfor hode og hale til null
        hode = hale = null;
        antall = 0;
    }

    public DobbeltLenketListe(T[] a) {
        Objects.requireNonNull(a, "Tabellen a er null!");

        // Finner første som ikke er null. Inspirert av kompendiet
        int i = 0; for(; i < a.length && a[i] == null; i++);

        // Kjøres visst alt i listen er null. Setter da antall til 0 og returnerer.
        if(i==a.length){
            antall = 0;
            return;
        }

        // Setter hode
        Node current = hode = new Node(a[i], null, null);
        antall++;

        // Går gjennom listen, fra elementet etter hode i listen
        for(i++; i<a.length; i++){
            // Lager en ny node. Setter peker fra halen (current) til nyopprettet node. Setter halen (current)
            // til nyopprettet Node
            if(a[i] != null){
                current = current.neste = new Node(a[i], current, null);
                antall++;
            }
        }

        hale = current;
    }

    public Liste<T> subliste(int fra, int til) {
        // Fra kompendiet
        fratilKontroll(fra, til);

        DobbeltLenketListe<T> ut = new DobbeltLenketListe<>();

        ut.antall = 0;

        if(fra != til) {
            Node current = finnNode(fra);
            ut.leggInn((T) current.verdi);
            ut.antall++;

            for (int i = fra+1; i < til; i++) {
                current = current.neste;
                ut.leggInn((T) current.verdi);        
                ut.antall++;
            }
        }

        ut.endringer = 0;
        return ut;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return (hode == null);
    }

    @Override
    public boolean leggInn(T verdi) {
        // Kaster NullPointerException om man forsøker å leggge til null
        Objects.requireNonNull(verdi, "Du kan ikke legge til NULL");

        if(tom()){
            // Om den er tom setter man hode og hale til en node med verdien og nullpekere begge veier
            hode = hale = new Node(verdi, null, null);
        }else{
            // Oppretter den nye noden, og setter nestepeker fra halen til den nye noden. Setter så halen til den nye noden
            hale = hale.neste = new Node(verdi, hale, null);
        }

        endringer++;
        antall++;
        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean inneholder(T verdi) {
        throw new UnsupportedOperationException();
    }

    private Node<T> finnNode(int indeks){
        int i;
        Node current;
        // Sjekker om vi skal lete fra første eller siste indeks
        if(indeks < antall/2){
            current = hode;
            // Traverserer gjennom listen til man finner riktig
             for(i = 0; i<indeks; i++){
                current = current.neste;
             }
        }else{
            current = hale;
            for(i = antall-1; i>indeks; i--){
                current = current.forrige;
            }
        }
        // Returnerer Noden
        return current;
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);

        return finnNode(indeks).verdi;
    }

    private void fratilKontroll(int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new IndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > antall)                          // til er utenfor tabellen
            throw new IndexOutOfBoundsException
                    ("til(" + til + ") > antall(" + antall + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }


    @Override
    public int indeksTil(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        indeksKontroll(indeks, false);
        Objects.requireNonNull(nyverdi, "Kan ikke legge til null som verdi");

        Node node = finnNode(indeks);
        T gammelVerdi = (T) node.verdi;
        node.verdi = nyverdi;
        endringer++;

        return gammelVerdi;
    }

    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        // Bruker klassen StringBuilder til å lage strengen
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        // Om tom returner []
        if(tom()) return "[]";

        // Setter current til hode og legger så til verdien i strengen
        Node current = hode;
        sb.append(current.verdi);

        // Traveserer gjennom løkken og legger til verdiene
        for(int i = 1; i < antall; i++){
            if(current.neste == null){
                break;
            }
            current = current.neste;
            sb.append(", " + current.verdi);
        }
        sb.append(']');

        return sb.toString();
    }

    public String omvendtString() {
        // Bruker klassen StringBuilder til å lage strengen
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        // Om tom returner []
        if(tom()) return "[]";

        // Setter current til hode og legger så til verdien i strengen
        Node current = hale;
        sb.append(hale.verdi);

        // Traveserer gjennom løkken og legger til verdiene
        for(int i = antall; i > 1; i--){
            current = current.forrige;
            sb.append(", " + current.verdi);
        }
        sb.append(']');

        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


