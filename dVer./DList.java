package Dynamische_Datenstrukturen.List;

public class DList {
    class Knoten {
        Object wert;
        Knoten next, previous;

        public Knoten(Object wert, Knoten previous, Knoten next) {
            this.wert = wert;
            this.next = next;
            this.previous = previous;
        }
    }

    Knoten first, last, act;

    public DList() {
        first = last = act = null;
    }

    /**
     * Die Anfrage liefert den Wert true, wenn die Liste keine Objekte enthält,
     * sonst liefert sie den Wert false.
     */
    public boolean isEmpty() {
        return (first == null);
    }

    /**
     * Die Anfrage liefert den Wert true, wenn es ein aktuelles Objekt gibt, sonst
     * liefert sie den Wert false.
     */
    public boolean hasAccess() {
        return (act != null);
    }

    /**
     * Falls die Liste nicht leer ist, es ein aktuelles Objekt gibt und dieses nicht
     * das letzte Objekt der Liste ist, wird das dem aktuellen Objekt in der Liste
     * folgende Objekt zum aktuellen Objekt, andernfalls gibt es nach Ausführung
     * des Auftrags kein aktuelles Objekt, d. h., hasAccess() liefert den Wert
     * false.
     */
    public void next() {
        if ((!isEmpty()) && (hasAccess()) && (act != last))
            act = act.next;
        else
            act = null;
    }

    /**
     * Falls die Liste nicht leer ist, wird das erste Objekt der Liste aktuelles
     * Objekt. Ist die Liste leer, geschieht nichts.
     */
    public void toFirst() {
        if (!isEmpty())
            act = first;
    }

    /**
     * Falls die Liste nicht leer ist, wird das letzte Objekt der Liste aktuelles
     * Objekt. Ist die Liste leer, geschieht nichts.
     */
    public void toLast() {
        if (!isEmpty())
            act = last;
    }

    /**
     * Falls die Liste nicht leer ist, es ein aktuelles Objekt gibt und dieses nicht
     * das erste Objekt der Liste ist, wird das dem aktuellen Objekt in der Liste
     * vorhergehende Objekt zum aktuellen Objekt, andernfalls gibt es nach
     * Ausführung
     * des Auftrags kein aktuelles Objekt, d. h., hasAccess() liefert den Wert
     * false.
     */
    public void previous() {
        if ((!isEmpty()) && (hasAccess()) && (act != first))
            act = act.previous;
        else
            act = null;
    }

    /**
     * Falls es ein aktuelles Objekt gibt (hasAccess() == true), wird das
     * aktuelle Objekt zurückgegeben, andernfalls (hasAccess() == false)
     * gibt die Anfrage den Wert null zurück.
     */
    public Object getContent() {
        if (hasAccess())
            return act.wert;
        else
            return null;
    }

    /**
     * Falls es ein aktuelles Objekt gibt (hasAccess() == true) und pObject
     * ungleich null ist, wird das aktuelle Objekt durch pObject ersetzt. Sonst
     * bleibt die Liste unverändert.
     */
    public void setContent(Object x) {
        if ((hasAccess()) && (x != null))
            act.wert = x;
    }

    /**
     * Ein neues Objekt pObject wird am Ende der Liste eingefügt. Das aktuelle
     * Objekt bleibt unverändert. Wenn die Liste leer ist, wird das Objekt
     * pObject in die Liste eingefügt und es gibt weiterhin kein aktuelles Objekt
     * (hasAccess() == false). Falls pObject gleich null ist, bleibt die Liste
     * unverändert.
     */
    public void append(Object x) {
        if (x != null) {
            Knoten neu = new Knoten(x, last, null);

            if (isEmpty()) {
                first = last = neu;
            } else {
                last.next = neu;
                last = neu;
            }
        }
    }

    /**
     * Falls es ein aktuelles Objekt gibt (hasAccess() == true), wird ein neues
     * Objekt vor dem aktuellen Objekt in die Liste eingefügt. Das aktuelle Objekt
     * bleibt unverändert. Falls die Liste leer ist und es somit kein aktuelles
     * Objekt
     * gibt (hasAccess() == false), wird pObject in die Liste eingefügt und
     * es gibt weiterhin kein aktuelles Objekt. Falls es kein aktuelles Objekt gibt
     * (hasAccess() == false) und die Liste nicht leer ist oder pObject
     * gleich null ist, bleibt die Liste unverändert.
     */
    public void insert(Object x) {
        if (isEmpty()) {
            first = new Knoten(x, null, null);
            last = first;
            act = null;
        }

        else if (hasAccess()) {
            if (act == first) {
                Knoten neu = new Knoten(x, null, first);
                first.previous = neu;
                first = neu;
            } else {
                Knoten help = act.previous;
                help.next = new Knoten(x, help, act);
                act.previous = help.next;
            }
        }
    }

    /**
     * Die Liste pList wird an die Liste angehängt. Anschließend wird pList
     * eine leere Liste. Das aktuelle Objekt bleibt unverändert. Falls pList null
     * oder eine leere Liste ist, bleibt die Liste unverändert.
     */
    public void concat(DList pList) {
        last.next = pList.first;
        last = pList.last;
        pList.first = null;
        pList.last = null;
        pList = null;
    }

    /**
     * Falls es ein aktuelles Objekt gibt (hasAccess() == true), wird das aktuelle
     * Objekt gelöscht und das Objekt hinter dem gelöschten Objekt wird zum
     * aktuellen Objekt. Wird das Objekt, das am Ende der Liste steht, gelöscht,
     * gibt es kein aktuelles Objekt mehr (hasAccess() == false). Wenn die Liste
     * leer ist oder es kein aktuelles Objekt gibt (hasAccess() == false),
     * bleibt die Liste unverändert.
     */
    public void remove() {
        // Fall 0: Liste ist leer oder es gibt kein aktuelles Element
        if ((isEmpty()) || (!hasAccess()))
            return;

        // Fall 2: Liste besteht aus nur einem Element
        if (first == last) {
            first = last = act = null;
            return;
        }

        // Fall 3a: es soll vorne gelöscht werden
        if (act == first) {
            act = act.next;
            first = act;
            first.previous = null;
            return;
        }

        // Fall 3b: es soll hinten gelöscht werden
        if (act == last) {
            act = act.previous;
            last = act;
            last.next = null;
            act = null;
            return;
        }

        // Fall 4: es soll in der Mitte gelöscht werden
        act.previous.next = act.next;
        act.next.previous = act.previous;
        act = act.next;
    }

    /**
     * Eine rein interne show()-Methode, damit die Implementation der Liste
     * auf Herz und Nieren getestet werden kann.
     * Gehört nicht zu den offiziellen Methoden der Klasse Liste!
     * Diese Methode funktioniert nur in Zusammenarbeit mit der Klasse Bruch,
     * welche zum Testen der Liste erforderlich ist.
     */
    public void show() {
        for (Knoten temp = first; temp != null; temp = temp.next) {
            System.out.print(temp.wert + " ");
        }
        System.out.println();
    }
}
