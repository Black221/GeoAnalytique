package tp.src.exo8;

public class Maillon {
    
    private int numero;
    private Maillon suiv;
    private Maillon prec;

    public Maillon(int numero, Maillon suiv, Maillon prec) {
        this.numero = numero;
        this.suiv = suiv;
        this.prec = prec;
    }

    public Maillon(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return this.numero;
    }

    public Maillon getSuiv() {
        return this.suiv;
    }

    public Maillon getPrec() {
        return this.prec;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSuiv(Maillon suiv) {
        this.suiv = suiv;
    }

    public void setPrec(Maillon prec) {
        this.prec = prec;
    }
}
