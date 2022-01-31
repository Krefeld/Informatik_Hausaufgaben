package Spiel;

import java.util.ArrayList;
// import javax.print.attribute.standard.JobName;
import javax.swing.ImageIcon;
// import javax.swing.Action;
import javax.swing.JButton;
// import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
// import javax.swing.JOptionPane;
// import javax.swing.JTextField;
// import javax.swing.text.DefaultStyledDocument.ElementSpec;
// import javafx.scene.image.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import javax.swing.text.View;
//import javax.print.attribute.standard.RequestingUserName;

public class Start {
    static int zugC = 0;
    static int[] player1 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    static int[] player2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    static JFrame f;
    static JButton b;
    static JButton c;
    static JButton d;
    static JButton e;
    static JLabel l;
    static int tatik = 0;
    static JFrame ad = new JFrame("Auswahl");
    static JButton tatik1 = new JButton();
    static JButton tatik2 = new JButton();
    static boolean beforeGame = true;

    static public void main(String[] args) {
        // boolean stilPlay = true;
        // moveP2();
        f = new JFrame("Auswahl");
        if(tatik == 0){
            f = new JFrame("Auswahl");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setExtendedState(JFrame.MAXIMIZED_BOTH);
            f.pack();
            f.setLayout(null);
            tatik1 = new JButton("Tatik 1");
            tatik2 = new JButton("Tatik 2");
            tatik1.addActionListener(handler);
            tatik2.addActionListener(handler);
            tatik1.setBounds(600, 900, 100, 30);
            tatik2.setBounds(1000, 900, 100, 30);
            f.add(tatik1);
            f.add(tatik2);
            f.setVisible(true);
        }else{
            System.out.println(tatik);
            f.setTitle("Spiel");
            b = new JButton();
            c = new JButton();
            d = new JButton();
            l = new JLabel("");
            createFrame();
            if(gameOn()){
                game();
            }
            else{
                JLabel end = new JLabel("");
                if(winnerP1()){
                    end.setText("WINNER PLAYER 1");
                }
                else{
                    end.setText("WINNER PLAYER 2");
                }
                end.setBounds(1500, 1500, 500, 500);;
                f.removeAll();
                f.add(end);
            }
        }
        // f = new JFrame("Spiel");
    }

    static boolean gameStarted(){
        for(int i = 0; i < player1.length; ++i){
            if(player1[i] == 0 && player2[i] == 0){
                continue; 
            }else{
                return false;
            }
        }
        return true;
    }

    //return: true if the winner is P1 else: false
    static boolean winnerP1(){
        for(int i : player1){
            if(i != 7){
                return false;
            }
        }
        return true;
    }

    static void game(){
        Wurfel a = new Wurfel();
        a.erzeugen();
        
    }
    static but handler = new but();
    static void createFrame() {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.pack();
        f.setLayout(null);
        b = new JButton("Tabellen");
        c = new JButton("exit");
        d = new JButton("würfeln P1");
        // l.setBounds(100, 100, 10, 10);
        // l.setText("test");
        // l.setVisible(false);
        // l.setBounds(100, 100, 10, 10);
        // but handler = new but();
        b.addActionListener(handler);
        c.addActionListener(handler);
        d.addActionListener(handler);
        b.setBounds( 800, 900, 100, 30);
        c.setBounds( 600, 900, 100, 30);
        d.setBounds(1000, 900, 100, 30);
        f.add(b);
        f.add(c);
        f.add(d);
        // f.add(l);
        f.setVisible(true);
        // tabelleAusgeben();
    }

    static int counter = 0;

    static void moveP2(){
        // 1 => Tatik: nimmt immer die Nummer mit der höchsten Anzahl
        // 2 => Tatik: nimmt die Zahl mit der niedriegsten Wahr. und die höchsten Anzahl
        // int choose = 0;
        // int choose_index = 0;
        Wurfel a = new Wurfel();
        a.erzeugen();
        int arr[] = new int[12];
        arr = moves(a);
        double[] prop = {2.78, 5.56, 8.33, 11.11, 13.89, 16.67, 13.89, 11.11, 8.33, 5.56, 2.78};
        int big = 0;
        int indexO = 0;
        if(tatik == 1){
            for(int i : arr){
                if(i > arr[big]){
                    big = indexO;
                }
                ++indexO;
            }
            player2[big] += arr[big];
            if(player2[big] > 7)
                player2[big] = 7;
        }else {
            if(tatik == 2){
                for(int i = 0; i < arr.length; ++i){
                    if(arr[i] > arr[big] && prop[i] < prop[big]){
                        big = i;
                    }
                }   
                player2[big] += arr[big];
                if(player2[big] > 7)
                    player2[big] = 7;
            }
        }
        
        // int index = 0;
        // for(int i : arr){
        //     //i != 0 && player2[index] + i != 7
        //     if(i != 0 && player2[index] != 7){
        //         // choose_index = index+1;
        //         // choose = i;
        //         player2[index] += i;
        //         if(player2[index] > 7)
        //             player2[index] = 7;
        //         break;    
        //     }
        //     ++index;
        // }
        // index = 0;
        // for(int i : player2){
        //     ++index;
        //     System.out.println(index + "  " + i);
        // }
    }

    static void tabelleAusgeben() {
        // Player 1
        int x = 50;
        int y = 20;
        ArrayList<JLabel> arr = new ArrayList<>();
        int c = 0;
        for (int i = 0; i < 13; ++i) {
            JLabel temp = new JLabel();
            temp.setBounds(100, 100 + (y * i) + 1, x, y);
            if (i == 0)
                temp.setText("Spieler 1");
            else {
                if (i < 10)
                    temp.setText("  " + (i) + " : " + player1[c]);
                else
                    temp.setText((i) + " : " + player1[c]);
                ++c;
            }
            arr.add(temp);
        }

        for (int i = 0; i < arr.size(); ++i) {
            f.add(arr.get(i));
        }

        arr.clear();
        // Player 2
        x = 50;
        y = 20;
        c = 0;
        for (int i = 0; i < 13; ++i) {
            JLabel temp = new JLabel();
            temp.setBounds(151, 100 + (y * i) + 1, x, y);
            if (i == 0)
                temp.setText("Spieler 2");
            else {
                if (i < 10)
                    temp.setText("  " + (i) + " : " + player2[c]);
                else
                    temp.setText((i) + " : " + player2[c]);
                ++c;
            }
            arr.add(temp);
        }

        for (int i = 0; i < arr.size(); ++i) {
            f.add(arr.get(i));
        }
    }

    static int[] arrMoves = new  int[12];
    static void wuerfeln(){
        int arr[] = new int[12];
        Wurfel a = new Wurfel();
        a.erzeugen();
        ArrayList<JLabel> ent = new ArrayList<>();
        int x = 150;
        int y = 150;
        int c = 0;
        for(int i : a.W){
            JLabel temp = new JLabel();
            temp.setBounds(1000 + (x * c), 200, x, y);
            if(i == 1){
                ImageIcon image = new ImageIcon("Spiel/1.png");
                temp.setIcon(image);
            }
            if(i == 2){
                ImageIcon image = new ImageIcon("Spiel/2.png");
                temp.setIcon(image);
            }
            if(i == 3){
                ImageIcon image = new ImageIcon("Spiel/3.png");
                temp.setIcon(image);
            }
            if(i == 4){
                ImageIcon image = new ImageIcon("Spiel/4.png");
                temp.setIcon(image);
            }
            if(i == 5){
                ImageIcon image = new ImageIcon("Spiel/5.png");
                temp.setIcon(image);
            }
            if(i == 6){
                ImageIcon image = new ImageIcon("Spiel/6.png");
                temp.setIcon(image);
            }
            ent.add(temp);
            ++c;
        }
     
        for(JLabel i : ent){
            f.add(i);
        }
        arr = moves(a);
        for(int i = 0; i < arr.length; ++i){
            arrMoves[i] = arr[i];
        }
        x = 50;
        y = 20;
        ArrayList<JLabel> moves = new ArrayList<>();
        c = 0;
        for (int i = 0; i < 13; ++i) {
            JLabel temp = new JLabel();
            temp.setBounds(1000, 400 + (y * i) + 1, x, y);
            if (i == 0)
                temp.setText("moves");
            else {
                if (i < 10)
                    temp.setText("  " + (i) + " : " + arr[c]);
                else
                    temp.setText((i) + " : " + arr[c]);
                ++c;
            }
            moves.add(temp);
        }

        for (int i = 0; i < moves.size(); ++i) {
            f.add(moves.get(i));
        }
        buttonForMoves(arr);
    }
    
    static  ArrayList<JButton> moveButton = new ArrayList<>();
    static  ArrayList<Integer> moveNumber = new ArrayList<>();
    static  ArrayList<Integer> moveValue = new ArrayList<>();
    static void buttonForMoves(int arr[]){
        moveButton.clear();
        moveValue.clear();
        moveNumber.clear();
        int x = 50;
        int y = 20;
        int in = 0;
        int durch = 0;
        int ddurch = 0;
        // for(int i = 0; i < arr.length; ++i){
        //     if(arr[i] != 0 && player1[i] != 7){
        //         moveNumber.add(arr[i]);
        //         moveValue.add(in + 1);
        //         JButton temp = new JButton((in+1) + "");
        //         if(durch < 6){
        //             temp.setBounds(1300 + (x * durch) + 1, 400, x, y);
        //         }
        //         else{ 
        //             if(durch == 6)
        //                 ddurch = 0;
        //             temp.setBounds(1300 + (x * ddurch) + 1, 450, x, y);
        //         }
        //         System.out.println((in +1) + " hat den Wert: " + arr[i]);
        //         moveButton.add(temp);
        //         ++durch;
        //         ++ddurch;
        //         // System.out.println((in +1) + " hat den Wert: " + arr[i]);
        //     }
        //     ++in;
        // }


        for(int i : arr){
            if(i != 0 && setButton(in)){
                moveNumber.add(i);
                moveValue.add(in + 1);
                JButton temp = new JButton((in+1) + "");
                if(durch < 6){
                    temp.setBounds(1300 + (x * durch) + 1, 400, x, y);
                }
                else{
                    if(durch == 6)
                        ddurch = 0;
                    temp.setBounds(1300 + (x * ddurch) + 1, 450, x, y);
                }
                moveButton.add(temp);
                ++durch;
                ++ddurch;
                System.out.println((in +1) + " hat den Wert: " + i);
            }
            // System.out.println(in + " hat den Wert");
            ++in;
        }

        for(JButton i : moveButton){
            i.addActionListener(handler);
            f.add(i);
        }
    }

    //returns true if value at player1[index] != 7 
    static boolean setButton(int index){
        System.out.println(player1[index]);
        if(player1[index] == 7){
            return false;
        }
        return true;
    }

    static private class but implements ActionListener {
        boolean tabellenShow = false;
        // boolean tabellenWuerfel = false;
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == tatik1){
                tatik = 1;
                f.dispose();
                main(null);
            }else{
                if(e.getSource() == tatik2){
                    tatik = 2;
                    f.dispose();
                    main(null);
                }else{
                    if (e.getSource() == b && !tabellenShow) {
                        tabellenShow = true;
                        f.setVisible(false);
                        tabelleAusgeben();
                        f.setVisible(true);
                    } else {
                        if (e.getSource() == c) {
                            f.dispose();
                            System.out.println(counter);
                        }
                        else{
                            if(e.getSource() == d){
                                reset();
                                tabellenShow = false;
                                f.setVisible(false);
                                wuerfeln();
                                //tabelleAusgeben();
                                f.setVisible(true);
                            }else{
                                for(int i = 0; i < moveButton.size(); ++i){
                                    if(e.getSource() == moveButton.get(i)){
                                        TabellenUp(player1, moveValue.get(i)-1, moveNumber.get(i));
                                        System.out.println(moveNumber + "  " + moveValue + "\n" + moveNumber.get(i) + "   " + moveValue.get(i));
                                        moveP2();
                                        reset();
                                        tabellenShow = true;
                                        f.setVisible(false);
                                        tabelleAusgeben();
                                        f.setVisible(true);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static void reset(){
        f.dispose();
        main(null);
    }

    static void ausgeben() {
        System.out.println("Player1         Player2");
        for (int i = 0; i < player1.length; ++i) {
            if (i <= 8) {
                System.out.println(" " + (i + 1) + " : " + player1[i] + "          " + player2[i] + " :  " + (i + 1));
            } else {
                System.out.println((i + 1) + " : " + player1[i] + "          " + player2[i] + " : " + (i + 1));
            }
        }
    }

    static boolean gameOn() {
        boolean resP1 = true;
        boolean resP2 = true;
        for (int i : player1) {
            if (i != 7) {
                resP1 = false;
            }
        }

        for (int i : player2) {
            if (i != 7) {
                resP2 = false;
            }
        }
        
        if(resP2 == false || resP1 == false){
            return true;
        }
        return false;
    }

    static void Zug() {
        while(gameOn()){
            int arr[] = new int[12];
            Wurfel a = new Wurfel();
            a.erzeugen();
            a.ausgeben(); // hier muss noch was am Frame geaendert werden
            arr = moves(a); // gibt aus welche möglichkeiten da sind
            if (!skipMove(player1, arr)) {
                TabellenUp(player1, selectedMove(4), arr[selectedMove(4)-1]);
            }
            a.erzeugen();
            a.ausgeben(); // hier muss noch was am Frame geaendert werden
            arr = moves(a);// gibt aus welche möglichkeiten da sind
            if (!skipMove(player2, arr)) {
                TabellenUp(player2, selectedMove(4), arr[selectedMove(4)-1]);
            }
            ausgeben();
        }
    }

    static int selectedMove(int in) {
        // eingabe vom Button muss noch gemacht werden
        --in;
        TabellenUp(player1, in, arrMoves[in]);
        return 0;
    }

    static boolean skipMove(int arr[], int indexs[]) {
        boolean skip = false;
        for (int i = 0; i < indexs.length; ++i) {
            for (int index : indexs) {
                if (arr[index] == 7) {
                    skip = true;
                }
            }
        }
        return skip;
    }

    static void TabellenUp(int arr[], int Index, int value) {
        if (arr[Index] != 7) {
            arr[Index] += value;
            if (arr[Index] > 7)
                arr[Index] = 7;
        } else {
            System.out.println("Ungültige Eingabe");
        }
    }

    static int[] moves(Wurfel in) {
        int[] pos = new int[12];
        // loop for 1 <= numbers < 8
        for (int i = 0; i < in.W.length; ++i) {
            for (int x = 1; x < 7; ++x) {
                if (in.W[i] == x) {
                    ++pos[x - 1];
                }
            }
        }

        // loop for 8 <= numbers < 13
        for (int number = 7; number < 13; ++number) {
            pos[number - 1] = counter(in.W, number);
        }

        int asdasd = 1;
        for (int i : pos) {
            System.out.println(asdasd + " : " + i);
            ++asdasd;
        }
        return pos;
    }

    static int counter(int[] in, int key) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i : in) {
            arr.add(i);
        }
        int coutner = 0;
        // System.out.println(arr + "\n");
        for (int i = 0; i < arr.size(); ++i) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp = cop(arr);
            int toDelete = temp.get(i);
            temp.remove(i);
            // System.out.println(arr + " " + arr.size() + " key: " + key + " i: " + i + "
            // gesucht: " + (key - arr.get(i)) + " temp: " + temp);
            if (temp.contains(key - arr.get(i))) {
                // System.out.println("ist drin");
                ++coutner;
                // System.out.println(arr + "tempo arr before first delete" + " " +
                // arr.indexOf(key - arr.get(i)) + " number:" + (key - arr.get(i)));
                arr.remove(arr.indexOf(key - arr.get(i)));
                // System.out.println(arr + "tempo arr after first delete" + " " +
                // arr.indexOf(toDelete) + " number:" + toDelete);
                arr.remove(arr.indexOf(toDelete));
                i = -1;
                if (arr.size() == 0)
                    break;
            }
        }
        return coutner;
    }

    static ArrayList<Integer> cop(ArrayList<Integer> in) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i : in) {
            res.add(i);
        }
        return res;
    }
}
