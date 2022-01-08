package negocio;

/**
 *
 * @author willy
 */
public class PilaVB {
 
    private VectorNBits v;
    private int num;
    private int cant;
    
    public PilaVB(int cantBits){
        cant = 0;
        num = 10;
        v = new VectorNBits(num, cantBits);
    }
    
    public void push(int e){
        if(cant < num){
            cant++;
            v.insertar(e, cant);
        }else{
            int n = num;
            num += 10;
            int vec[] = new int[n];
            for(int i = 0;i < n;i++){
                int el = v.sacar(i + 1);
                vec[i] = el;
            }
            int cantBits = v.numBits;
            v = new VectorNBits(num, cantBits);
            for(int i = 0;i < n;i++){
                int el = vec[i];
                v.insertar(el, i + 1);
            }
            cant++;
            v.insertar(e, cant);
        }
    }
    
    public int pop(){
        if(!vacia()){
            int e = v.sacar(cant);
            cant--;
            return e;
        }
        else{
            System.err.println("Pila vacia");
            return 0;
        }
    }
    
    public int peek(){
        if(!vacia()){
            return v.sacar(cant);
        }
        else{
            System.err.println("Pila vacia");
            return 0;
        }
    }
    
    public boolean vacia(){
        return cant == 0;
    }
    
    @Override
    public String toString(){
        String s = "";
        for(int i = cant;i >= 1;i--){
            int e = v.sacar(i);
            s += "| " + e + " |\n";
        }
        s += "|---|";
        return s;
    }
    
    public static void main(String[] args) {
        PilaVB p = new PilaVB(8);
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(20);
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(24);
        System.out.println(p.toString());
    }
}
