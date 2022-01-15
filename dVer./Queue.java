package Dynamische_Datenstrukturen.Queue;

public class Queue2 {
    public class Knoten {
        Object wert;
        Knoten next;
        Knoten previous;

        public Knoten(Object w) {
            wert = w;
            next = null;
            previous = null;
        }
    }

    private Knoten tos;
    private Knoten last;

    public Queue2() {
        tos = null;
        last = null;
    }
    	
    public static int co = 0;
    public void enqueue(Object x){
        Knoten ne = new Knoten(x);
        if(tos == null){
            tos = ne;
            last = ne;
            ++co;
        }else{
            ne.previous = last;
            last.next = ne;
            last = ne;
            ne.next = null;
            ++co;

        }
    }

    public void testerr(){
        Knoten i;
        for(i = tos; i != last.next; i = i.next){
            System.out.println(i);
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
        for(int i = 0; i < size(); ++i){
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

    public void test(){
        Knoten temp;
        temp = tos;
        for(int i = 0; i < size(); ++i){
            System.out.println("Knoten: " + temp + "  next: " + temp.next + "   prev: " + temp.previous);
            temp = temp.next;
        }
    }
}
