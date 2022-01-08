package negocio;

/**
 *
 * @author willy
 */
public class PilaN {
    
    private Nodo cima;
    
    public PilaN(){
        cima = null;
    }
    
    public void push(int e){
        Nodo nuevo = new Nodo();
        nuevo.dato = e;
        nuevo.sig = cima;
        cima = nuevo;
    }
    
    public int pop(){
        if(!vacia()){
           int e = cima.dato;
           cima = cima.sig;
           return e;
        }
        else{
            System.err.println("Pila vacia");
            return 0;
        }
    }
    
    public int peek(){
        if(!vacia()){
            return cima.dato;
        }
        else{
            System.err.println("Pila vacia");
            return 0;
        }
    }
    
    public boolean vacia(){
        return cima == null;
    }
    
    @Override
    public String toString(){
        String s = "";
        Nodo aux = cima;
        while(aux != null){
            int e = aux.dato;
            s += "| " + e +" |\n";
            aux = aux.sig;
        }
        s += "|---|";
        return s;
    }
    
    public static void main(String[] args) {
        PilaN p = new PilaN();
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
