package datos;

public class VectorNBits {
    int V[];
    int cant;
    int numBits;

    public VectorNBits(int cantE, int Ncantbits) {//int numbits
        int cantbits = cantE * Ncantbits;  //int cantbits=cantE*numbits
        int NE = cantbits / 32;
        if ((cantbits % 32) != 0) {
            NE++;
        }
        V = new int[NE];
        this.cant = cantE;
        numBits = Ncantbits;
    }

    public int cantidad() {
        return cant;
    }

    public void insertar(int ele, int pos) {
        int mask = (int) Math.pow(2, numBits) - 1;
        int nbits = posBit(pos);
        int Nent = posVector(pos);
        int ele1 = ele;
        mask = mask << nbits;
        mask = ~mask;
        V[Nent] = V[Nent] & mask;
        ele = ele << nbits;
        V[Nent] = V[Nent] | ele;
        if ((nbits + numBits) > 32) {//faltan bits por insertar
            int mask1 = (int) ((Math.pow(2, numBits) - 1));
            mask1 = mask1 >>> (32 - nbits);
            mask1 = ~mask1;
            V[Nent + 1] = V[Nent + 1] & mask1;
            ele1 = ele1 >>> (32 - nbits);
            V[Nent + 1] = V[Nent + 1] | ele1;
        }
    }

    public int sacar(int pos) {
        int mask = (int) ((Math.pow(2, numBits) - 1));
        int nbits = posBit(pos);
        int Nent = posVector(pos);
        mask = mask << nbits;
        mask = mask & V[Nent];
        mask = mask >>> nbits;
        if (nbits + numBits > 32) {//faltan bits por sacar 
            int mask1 = (int) ((Math.pow(2, numBits) - 1));
            mask1 = mask1 >>> (32 - nbits);
            mask1 = mask1 & V[Nent + 1];
            mask1 = mask1 << (32 - nbits);
            mask = mask | mask1;
        }
        return mask;
    }

    private int posBit(int pos) {
        return (pos - 1) * numBits % 32;

    }

    private int posVector(int pos) {
        return (pos - 1) * numBits / 32;
    }

    @Override
    public String toString() {
        String S = "V=[ ";
        for (int i = 1; i <= cant; i++) {
            S = S + sacar(i) + " , ";
        }
        S = S + "]";
        return (S);
    }
    
    public String bits() {
        String S = "";
        for(int i = 0;i < V.length;i++){
            String bin = Integer.toBinaryString(V[i]);
            String bin32 = String.format("%32s", bin).replaceAll(" ", "0");
            S += bin32 + "\n";
        }
        return S;
    }
    
    public static void main(String[] args) {
        VectorNBits v = new VectorNBits(10, 6);
        System.out.println(v.bits());
        for(int i = 1;i <= 10;i++){
            v.insertar(i, i);
        }
        System.out.println("------------");
        System.out.println(v.bits());
    }
}
