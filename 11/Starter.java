package Dynamische_Datenstrukturen.List;
public class Starter {
    public static void main(String[] args) {
        List a = new List();
        int arr[] = {1,3,4,5,6,7,8};
        for(int i : arr){
            a.append(i);
        }
        a.show();
        System.out.println();
        //a.testerr();
        a.next();
        //System.out.println(a.act);
        System.out.println();
        a.insert(2);
        a.show();
        System.out.println();
        a.append(9);
        a.show();
        System.out.println();
        System.out.println(a.getContent() + " at Index: " + a.index() + ", Position: " + (a.index()+1));
        System.out.println();
        a.setContent(13);
        a.show();
        System.out.println();
 
        List b = new List();
        List c = new List();
        int barr[] = {1,2,3,4,5};
        int carr[] = {5,6,7,8,9};
        for(int i : barr){
            b.append(i);
        }

        for(int i : carr){
            c.append(i);
        }

        b.show();
        c.show();

        b.concat(c);

        System.out.println();

        b.show();
        c.show();
        // c wird nicht mehr ausgegeben, weil die Liste leer ist.
    }
}
