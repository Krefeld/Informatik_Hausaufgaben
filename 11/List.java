package Dynamische_Datenstrukturen.List;

// funktionieren wie Arrays
public class List {
    public class Knoten {
        Object wert;
        Knoten next;

        public Knoten(Object w) {
            wert = w;
            next = null;
        }
    }

    Knoten act;
    Knoten first;
    Knoten last;

    public List() {
        act = null;
        last = null;
        first = null;
    }

    //check
    public boolean isEmpty() {
        return (last == null);
    }
    
    //check
    public boolean hasAccess() {
        return (act != null);
    }

    //check
    public void next() {
        if(act == null)
            toFirst();
        if (!isEmpty() && hasAccess() && act != last) {
            act = act.next;
        } else {
            act = null;
        }
    }

    //check
    public void toFirst() {
        if (!isEmpty())
            act = first;
    }

    //check
    public void toLast() {
        if (!isEmpty())
            act = last;
    }

    //check
    public Object getContent() {
        if (hasAccess())
            return act.wert;
        else
            return null;
    }

    //check
    public void setContent(Object x) {
        if ((hasAccess()) && (x != null))
            act.wert = x;
    }

    // check
    public void append(Object x) {
        if ((x != null)) {
            Knoten ne = new Knoten(x);
            if (first == null) {
                first = ne;
                last = ne;
            } else {
                last.next = ne;
                last = ne;
                ne.next = null;
            }
            last.wert = x;
        }
    }

    // check
    public void insert(Object x) {

        if (isEmpty() && !hasAccess()) {
            append(x);
            return;
        }

        if (!hasAccess() && !isEmpty() || x == null) {
            return;
        }

        Knoten neu = new Knoten(x);
        Knoten bact;
        bact = vorKnoten(act);
        // Knoten vor dem act Knoten 
        bact.next = neu;
        neu.next = act;
    }

    //check gibt den Knoten vor dem Parameter Knoten wieder
    public Knoten vorKnoten(Knoten to) {
        Knoten temp;
        int cou = 0;
        for (temp = first; temp != to; temp = temp.next) {
            ++cou;
        }
        --cou;
        temp = first;
        for(int i = 0; i < cou; ++i){
            temp = temp.next;
        }
        return temp;
    }

    /**
     * Die Liste pList wird an die Liste angehängt. Anschließend wird pList
     * eine leere Liste. Das aktuelle Objekt bleibt unverändert. Falls pList null
     * oder eine leere Liste ist, bleibt die Liste unverändert.
     */
    public void concat(List pList) {
        if(pList == null || pList.isEmpty()){
            return;
        }

        last.next = pList.first; 
        last = pList.last;
        pList.last = null;
    }

    public void remove() {
        if ((isEmpty()) || (!hasAccess()))
            return;

        if (act == last) {
            last = vorKnoten(last);
            act = null;
            return;
        }

        if (hasAccess()) {
            Knoten temp;
            temp = vorKnoten(act);
            temp.next = act.next;
            act = act.next;
        }
    }

    public int size() {
        int counter = 0;
        Knoten temp;
        for (temp = first; temp != last.next; temp = temp.next) {
            ++counter;
        }
        return counter;
    }

    public void show(){
        if(isEmpty()){
            return;
        }
        Knoten temp;
        temp = first;
        for(int i = 0; i < size(); ++i){
            System.out.print(temp.wert + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void testerr(){
        Knoten i;
        for(i = first; i != last.next; i = i.next){
            System.out.println(i);
        }
    }

    public int index(){
        int counter = 0;
        Knoten i;
        for(i = first; i != act; i = i.next){
            ++counter;
        }
        return counter;
    }
}
