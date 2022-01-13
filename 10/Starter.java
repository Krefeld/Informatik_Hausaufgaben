package Dynamische_Datenstrukturen.Queue;
public class Starter {
    public static void main(String[] args) {
        Queue b = new Queue();
        int arr[] = {1,2,3};
        System.out.println("Input");
        for(int i : arr){
            System.out.print(i + " ");
            b.enqueue(i);
        }
        System.out.println();
        b.show();
        b.dequeue();
        b.show();
    }
}
