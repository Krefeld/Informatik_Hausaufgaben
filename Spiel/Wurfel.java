package Spiel;

import java.util.Random;

public class Wurfel 
{
    public int[] W = new int[6];
    
    public void erzeugen(){
        Random R = new Random();
        for(int i = 0; i < 6; ++i)
        {
            W[i] = R.nextInt(6)+1;
        }
    }

    public void ausgeben(){
        for(int i = 0; i < W.length; ++i)
        {
            System.out.print(W[i] + " ");
        }
        System.out.println();
    }

    public void setter(){
        for(int i = 0; i < W.length; ++i){
            W[i] = 5;
        }
        W[5] = 6;
    }
}
