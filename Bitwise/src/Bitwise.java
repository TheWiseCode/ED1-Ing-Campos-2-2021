/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WillyVargasMendez
 */
public class Bitwise {

    int x;

    public Bitwise() {
        this.x = 0;
    }

    public void encender(int pos) {
        if (pos <= 32) {
            int mask = 1;
            mask = mask << pos - 1;
            x = x | mask;
        }
    }

    public void apagar(int pos) {
        if (pos <= 32) {
            int mask = 1;
            mask = mask << pos - 1;
            mask = ~mask;
            x = x & mask;
        }
    }

    public int getbit(int pos) {
        int mask = 1;
        mask = mask << pos - 1;
        mask = mask & x;
        mask = mask >>> pos - 1;
        return mask;
    }

    @Override
    public String toString() {
        String S = "X= ";
        for (int i = 32; i >= 1; i--) {
            S = S + " " + getbit(i);
        }
        return (S);
    }
    
    public static void main(String[] args) {
        Bitwise x = new Bitwise();
        System.out.println(x.toString());
        x.encender(1);
        System.out.println(x.toString());
        x.encender(20);
        System.out.println(x.toString());
    }
}
