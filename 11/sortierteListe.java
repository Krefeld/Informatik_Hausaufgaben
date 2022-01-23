package Dynamische_Datenstrukturen.List;
import java.util.Random;

// funktionieren wie Arrays
class List3
{
    private class IntNode{
        IntNode next;
        int value;

        public IntNode(int value){
            next = null;
            this.value = value;
        }
    }
    IntNode first, last;
    
    public List3()
    {
        first = last = null;
    }
    
    public void insert (int x)
    {
       IntNode neu = new IntNode(x);
    
    // Liste noch leer?
       if (empty())
       {
          first = neu;
          last  = neu;
       }
       
    // eventuell vorne einfuegen?
       else if (x < first.value)
       {
          neu.next = first;
          first = neu;
       }
       
    // oder hinten anhaengen?
       else if (x >= last.value)
       {
          last.next = neu;
          last = neu;
       }
       
    // oder mitten drin einfuegen
       else 
       {
           IntNode pos = first;
           while (pos.next.value < x) pos = pos.next;
           neu.next = pos.next;
           pos.next = neu;
       }
    }

    public boolean empty()
    {
       return first == null;
    }
    
    public void show()
    {
       IntNode pos = first;
       while (pos != null)
       {
          System.out.println(pos.value);
          pos = pos.next;
       }
    }
}

public class sortierendeListe
{
    static List3 testList;
    static Random rand = new Random();

    public static void main(String[] args) {
        testList = new List3();
       
        for (int i=0; i<30; i++)
            testList.insert(rand.nextInt(100));
        testList.show();
    }
}
