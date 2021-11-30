package datos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author WillyVargasMendez
 */
public class ConjuntoBit {

    private Bitwise[] c;
    private int cant;

    public ConjuntoBit(int cant) {
        int nbw = cant / 32;
        if (cant % 32 != 0) {
            nbw++;
        }
        c = new Bitwise[nbw];
        this.cant = cant;
        for (int i = 0; i < nbw; i++) {
            c[i] = new Bitwise();
        }
    }

    public boolean vacio() {
        return cant == 0;
    }

    private int calNbw(int pos) {
        return (pos - 1) / 32;
    }

    private int calNBit(int pos) {
        return ((pos - 1) % 32) + 1;
    }

    public void insertar(int ele) {
        if (ele > 0 && ele <= cant) {
            int nbw = calNbw(ele);
            int nbit = calNBit(ele);
            c[nbw].encender(nbit);
        }
    }

    public void eliminar(int ele) {
        if (ele > 0 && ele <= cant) {
            int nbw = calNbw(ele);
            int nbit = calNBit(ele);
            c[nbw].apagar(nbit);
        }
    }

    public boolean pertenece(int ele) {
        if (ele > 0 && ele <= cant) {
            int nbw = calNbw(ele);
            int nbit = calNBit(ele);
            int bit = c[nbw].getbit(nbit);
            return bit == 1;
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "{";
        for (int i = 1; i < cant; i++) {
            if(pertenece(i)){
                s += i + ",";
            }
        }
        s = s.substring(0, s.length() - 1);
        return s + "}";
    }

    public static void main(String[] args) {
        ConjuntoBit c = new ConjuntoBit(124);
        System.out.println(c.toString());
        c.insertar(4);
        c.insertar(37);
        c.insertar(70);
        System.out.println(c.toString());
        c.eliminar(37);
        System.out.println(c.toString());
    }
}
