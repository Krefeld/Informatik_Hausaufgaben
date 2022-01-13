public class Stack {
   public class Knoten {
      Object wert;
      Knoten next;

      public Knoten(Object w) {
         wert = w;
         next = null;
      }
   }

   private Knoten tos;

   public Stack() {
      tos = null;
   }

   public boolean isEmpty() {
      return (tos == null);
   }

   public void push(Object x) {
      Knoten neu = new Knoten(x);
      neu.next = tos;
      tos = neu;
   }

   public void pop() {
      if (!isEmpty())
         tos = tos.next;
   }

   public Object top() {
      if (!isEmpty())
         return tos.wert;
      else
         return null;
   }


   public int size() {
      if(isEmpty())
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
   
   public void show(){
      int size = size();
      Knoten tos_temp;
      tos_temp = tos;
      for(int i = 0; i < size; ++i){
         System.out.print(tos.wert + " ");
         tos = tos.next;
      }
      tos = tos_temp;
      System.out.println();
   }

   public Object get(int Index){
      if(Index > size()){
         System.out.println("Test");
         return null;
      }
      Knoten tos_temp;
      tos_temp = tos;
      for(int i = 0; i < Index; ++i){
         tos = tos.next;
      }
      Knoten temp;
      temp = tos;
      tos = tos_temp;
      return temp.wert;
   }
}
