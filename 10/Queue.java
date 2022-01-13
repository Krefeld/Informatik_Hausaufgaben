public class Queue {
    public class Knoten {
        Object wert;
        Knoten next;

        public Knoten(Object w) {
            wert = w;
            next = null;
        }
    }

    private Knoten tos;
    private Knoten last;

    public Queue() {
        tos = null;
        last = null;
    }
    	
    public static int co = 0;
    public void enqueue(Object x){
        Knoten ne = new Knoten(x);
        if(tos == null){
            tos = ne;
            last = ne;
           // System.out.println(ne + " last: " + last + " last.next: " + last.next + " tos: " + tos);
            ++co;
        }else{
            //System.out.println(ne + " last: " + last + " last.next: " + last.next + " tos: " + tos);
            last.next = ne;
            last = ne;
            ne.next = null;
            //System.out.println(ne + " last: " + last + " last.next: " + last.next + " tos: " + tos);
            ++co;
        }
    }

    public int size(){
        if (isEmpty())
            return 0;
        Knoten tos_temp;
        tos_temp = tos;
        int counter = 0;
        do {
            tos = tos.next;
           ++counter;
        } while (tos != null);
        tos = tos_temp;
        return counter;
    }

    public void ausgabeAdressen(){
        Knoten temp;
        temp = tos;
        for(int i = 0; i < co; ++i){
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public boolean isEmpty() {
        return (tos == null);
    }

    public void dequeue() {
        if (!isEmpty())
            tos = tos.next;
    }

    public Object front() {
        if (!isEmpty())
            return tos.wert;
        else
            return null;
    }

    public void show() {
        int size = size();
        Knoten temp;
        temp = tos;
        for(int i = 0; i < size; ++i){
            System.out.print(temp.wert + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Object get(int Index) {
        if (Index > size()) {
            System.out.println("Test");
            return null;
        }
        Knoten tos_temp;
        tos_temp = tos;
        for (int i = 0; i < Index; ++i) {
            tos = tos.next;
        }
        Knoten temp;
        temp = tos;
        tos = tos_temp;
        return temp.wert;
    }
}
