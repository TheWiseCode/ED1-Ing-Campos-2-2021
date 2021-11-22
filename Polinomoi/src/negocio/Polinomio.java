package negocio;

/**
 *
 * @author WillyVargasMendez
 */
public class Polinomio {
    
    private static final int MAX = 10;
    private Monomio[] m;
    //private int[] coef;
    //private int[] exp;
    private int p;

    public Polinomio() {
        m = new Monomio[MAX];
        p = 0;
    }
    
    public void insertar(Monomio mo){
       if(p < MAX && mo.getCoef() != 0){
            int pos = posMonomio(mo);
            if(pos == -1){
                m[p] = mo;
                p++;
            }else{
                int nuevoCoef = m[pos].getCoef() + mo.getCoef();
                m[pos].setCoef(nuevoCoef);
                if(nuevoCoef == 0){
                    for(int i = pos;i < p;i++)
                        m[i] = m[i + 1];
                    p--;
                }
            }
       }
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0;i < p;i++){
            s += m[i].toString();
        }
        return s;
    }

    private int posMonomio(Monomio mo) {
        for(int i = 0;i < p;i++){
            if(m[i].getExp() == mo.getExp())
                return i;
        }
        return -1;
    }
    
    public void derivar(){
       for(int i = 0;i < p;i++){
            m[i].derivar();
        } 
    }
    
    public float evaluar(float x){
        float suma = 0;
        for(int i = 0;i < p;i++){
            suma += m[i].evaluar(x);
        }
        return suma;
    }
    
    public static void main(String[] args) {
        Polinomio p = new Polinomio();
        Monomio a = new Monomio('+', 100, 4);
        Monomio b = new Monomio('-', 100, 4);
        Monomio c = new Monomio('-', 63, 2);
        p.insertar(c);
        p.insertar(a);
        System.out.println(p);
        p.insertar(b);
        System.out.println(p);
    }
    
}
