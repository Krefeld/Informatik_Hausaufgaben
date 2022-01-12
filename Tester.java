public class Starter {
    public static void main(String[] args) {
        /*
        neue Methoden: 
        int size();
            gibt die Länge des Stacks wieder
        
        void show();
            gibt den Stack aus
        
        Object get(int Index);
            gibt das Element im Stack am Index aus.
        */
        
        Stack a = new Stack();
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        for(int i : arr){
            a.push(i);
        }
        a.show();
        System.out.println();
    }
}
