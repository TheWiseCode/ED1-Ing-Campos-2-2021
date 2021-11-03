package negocio;

import java.util.Random;

/**
 *
 * @author WillyVargasMendez
 */
public class Cinta {

    private char c[];
    private int cabezal;
    private boolean enPausa;
    private boolean repetir;
    private boolean aleatorio;

    public Cinta() {
        c = new char[256];
        cabezal = -1;
        enPausa = false;
        repetir = false;
        aleatorio = false;
    }

    private boolean vacia() {
        return cabezal == -1;
    }

    public boolean llena() {
        return cabezal == 256;
    }
    
    public void changePausa() {
        enPausa = !enPausa;
    }

    public void changeAleatorio() {
        aleatorio = !aleatorio;
    }

    public void changeRepetir() {
        repetir = !repetir;
    }

    public void stop() {
        cabezal = -1;
        enPausa = false;
    }

    public char cc() {
        return c[cabezal];
    }

    public void grabar(char car) {
        if (!llena()) {
            if (!enPausa) {
                avanzar();
                c[cabezal] = car;
            }
        }
    }

    public void avanzar() {
        if (!llena()) {
            if (!enPausa) {
                if(aleatorio){
                    Random r = new Random();
                    cabezal = r.nextInt(256);
                }else if(repetir){
                    if(cabezal == 255)
                        cabezal = 0;
                    else
                        cabezal++;
                }else{
                    cabezal++;   
                }
            }
        } else {
            System.out.println("Error: Avanzar la cinta esta llena");
            System.exit(1);
        }
    }

    public void atras() {
        if (!vacia()) {
            cabezal--;
            while (c[cabezal] != ' ' && cabezal >= 0) {
                cabezal--;
            }
            if (cabezal == 0) {
                cabezal = -1;
            }
        } else {
            System.out.println("Error: Avanzar la cinta esta llena");
            System.exit(1);
        }
    }

    public void adelantar() {
        if (!llena()) {
            avanzar();
            while (c[cabezal] != ' ') {
                avanzar();
            }
            if (cabezal == 0) {
                cabezal = -1;
            }
        }
    }

    public void reemplazar(char ca, char cr) {
        stop();
        avanzar();
        if (cc() != ' ') {
            while (!llena()) {
                if (cc() == ca) {
                    c[cabezal] = cr;
                }
                avanzar();
            }
        }
    }
    
    public String play(){
        String s = "";
        stop();
        while(!llena()){
            avanzar();
            if(cabezal < 256){
                s += cc();
                System.out.println("" + cc());
            }
        }
        return s;
    }
    
    public static void main(String[] args){
        Cinta c = new Cinta();
        Random r = new Random();
        String alf = "abcdefghtiklmnopqwssahdawAWHSQWAODGAAW213132032490834656";
        for(int i = 0;i < 100;i++){
            int pos = r.nextInt(alf.length());
            char cc = alf.charAt(pos);
            c.grabar(cc);
        }
        //System.out.println(c.play());
        c.play();
        System.out.println("");
        //c.changeAleatorio();
        //c.play();
        //System.out.println("");
        //System.out.println(c.play());
        //c.changeAleatorio();
        c.changeRepetir();
        c.play();
        //System.out.println(c.play());
    }

}
