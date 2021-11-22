package negocio;

/**
 *
 * @author WillyVargasMendez
 */
public class Monomio {

    private int coef, exp;

    public Monomio(char signo, int coef, int exp) {
        if (coef != 0) {
            this.coef = Math.abs(coef);
            if (signo == '-') {
                this.coef *= -1;
            }
            this.exp = exp;
        }
    }

    public int getCoef() {
        return coef;
    }
    
    public void setCoef(int coef) {
        if (coef != 0) {
            if (coef > 0) {
                this.coef = Math.abs(coef);
            } else {
                this.coef = -Math.abs(coef);
            }

        } else {
            System.err.println("Error: Coeficiente no valido");
            //System.exit(1);
        }
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public char getSigno() {
        if (this.coef > 0) {
            return '+';
        } else {
            return '-';
        }
    }

    public void setSigno(char signo) {
        if (signo == '+') {
            this.coef = Math.abs(coef);
        } else {
            this.coef = -Math.abs(coef);
        }
    }

    public void suma(Monomio a, Monomio b) {
        if (a.getExp() == b.getExp()) {
            this.coef = a.getCoef() + b.getCoef();
            this.exp = a.getExp();
        }
    }

    public void derivar() {
        if (this.exp == 0) {
            this.coef = 0;
            this.exp = 1;
        } else {
            this.coef = this.coef * this.exp;
            this.exp--;
        }
    }

    public float evaluar(float x){
        return (float)(this.coef * Math.pow(x, this.exp));
    }
    
    @Override
    public String toString() {
        String s = "";
        s += getSigno() + " " + Math.abs(getCoef()) + "x^" + getExp();
        return s;
    }

    public static void main(String[] args) {
        Monomio a = new Monomio('+', 100, 4);
        Monomio b = new Monomio('-', 100, 4);
        
        Monomio c = new Monomio('+', 999, 999);
        System.out.println(a);
        System.out.println(b);
        c.suma(a, b);
        System.out.println(c);
    }
    
}
