package tp.src.exo8;

public class LCB {
    
    private Maillon tete;
    private Maillon queue;

    public LCB() {
        this.tete = null;
        this.queue = null;
    }


    public LCB(Maillon tete, Maillon queue) {
        this.tete = tete;
        this.queue = queue;
    }
    // --- METHODES --- //

    /*
     * Ecrire la fonction public static LCB ajout_numero (int num, LCB numeros) qui insère un numéro
     * dans une LCB et retourne la LCB résultante. La fonction doit exploiter le double chaînage
     * afin de simplifier le parcours de la liste. en respectant l'ordre croissant des numéros.
     */
    public static LCB ajout_numero(int num, LCB numeros) {
        Maillon nouveau = new Maillon(num);
        if (numeros.getTete() == null) {
            numeros.setTete(nouveau);
            numeros.setQueue(nouveau);
        } else {
            Maillon courant = numeros.getTete();
            Maillon precedent = null;
            while (courant != null && courant.getNumero() < num) {
                precedent = courant;
                courant = courant.getSuiv();
            }
            if (precedent == null) {
                nouveau.setSuiv(numeros.getTete());
                numeros.getTete().setPrec(nouveau);
                numeros.setTete(nouveau);
            } else if (courant == null) {
                precedent.setSuiv(nouveau);
                nouveau.setPrec(precedent);
                numeros.setQueue(nouveau);
            } else {
                precedent.setSuiv(nouveau);
                nouveau.setPrec(precedent);
                nouveau.setSuiv(courant);
                courant.setPrec(nouveau);
            }
        }
        return numeros;
    }

    /*
     * Ecrire la fonction public static LCB supprimer_numero (int num, LCB numeros) qui supprime un
     * numéro de la LCB et retourne la LCB résultante. La fonction doit exploiter le double chaînage
     * afin de simplifier le parcours de la liste.
     */
    public static LCB supprimer_numero(int num, LCB numeros) {
        Maillon courant = numeros.getTete();
        Maillon precedent = null;
        while (courant != null && courant.getNumero() != num) {
            precedent = courant;
            courant = courant.getSuiv();
        }
        if (courant != null) {
            if (precedent == null) {
                numeros.setTete(courant.getSuiv());
                if (courant.getSuiv() != null) {
                    courant.getSuiv().setPrec(null);
                }
            } else {
                precedent.setSuiv(courant.getSuiv());
                if (courant.getSuiv() != null) {
                    courant.getSuiv().setPrec(precedent);
                } else {
                    numeros.setQueue(precedent);
                }
            }
        }
        return numeros;
    }

    public LCB ajout_numero(int num) {
        Maillon nouveau = new Maillon(num);
        if (this.getTete() == null) {
            this.setTete(nouveau);
            this.setQueue(nouveau);
        } else {
            Maillon courant = this.getTete();
            Maillon precedent = null;
            while (courant != null && courant.getNumero() < num) {
                precedent = courant;
                courant = courant.getSuiv();
            }
            if (precedent == null) {
                nouveau.setSuiv(this.getTete());
                this.getTete().setPrec(nouveau);
                this.setTete(nouveau);
            } else if (courant == null) {
                precedent.setSuiv(nouveau);
                nouveau.setPrec(precedent);
                this.setQueue(nouveau);
            } else {
                precedent.setSuiv(nouveau);
                nouveau.setPrec(precedent);
                nouveau.setSuiv(courant);
                courant.setPrec(nouveau);
            }
        }
        return this;
    }

    public LCB supprimer_numero(int num) {
        Maillon courant = this.getTete();
        Maillon precedent = null;
        while (courant != null && courant.getNumero() != num) {
            precedent = courant;
            courant = courant.getSuiv();
        }
        if (courant != null) {
            if (precedent == null) {
                this.setTete(courant.getSuiv());
                if (courant.getSuiv() != null) {
                    courant.getSuiv().setPrec(null);
                }
            } else {
                precedent.setSuiv(courant.getSuiv());
                if (courant.getSuiv() != null) {
                    courant.getSuiv().setPrec(precedent);
                } else {
                    this.setQueue(precedent);
                }
            }
        }
        return this;
    }

    /*
     * Ecrire la fonction public static void afficher_numeros (LCB numeros) qui affiche les numéros
     * de la LCB dans l’ordre croissant.
     */
    public static void afficher_numeros(LCB numeros) {

        Maillon courant = numeros.getTete();
        while (courant != null) {
            System.out.println(courant.getNumero());
            courant = courant.getSuiv();
        }
    }

    public void afficher_numeros() {
        Maillon courant = this.getTete();
        while (courant != null) {
            System.out.println(courant.getNumero());
            courant = courant.getSuiv();
        }
    }

    
    // --- GETTERS --- //
    public Maillon getTete() {
        return this.tete;
    }

    public Maillon getQueue() {
        return this.queue;
    }

    // --- SETTERS --- //
    public void setTete(Maillon tete) {
        this.tete = tete;
    }

    public void setQueue(Maillon queue) {
        this.queue = queue;
    }
}
