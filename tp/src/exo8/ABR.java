package tp.src.exo8;

public class ABR {
    
    private String nom;
    private LCB pages;
    private ABR gauche;
    private ABR droit;

    public ABR(String nom, LCB pages, ABR gauche, ABR droit) {
        this.nom = nom;
        this.pages = pages;
        this.gauche = gauche;
        this.droit = droit;
    }

    public ABR(String nom, LCB pages, ABR gauche) {
        this.nom = nom;
        this.pages = pages;
        this.gauche = gauche;
    }

    public ABR(String nom, LCB pages) {
        this.nom = nom;
        this.pages = pages;
    }

    public ABR(String nom) {
        this.nom = nom;
    }

    /*
     * Ecrire une fonction public static ABR ajout_nompropre (String nom, int [] t, int nombre, ABR a) 
     * qui insère, dans un ABR, un nouveau nom et les numéros des pages dans lesquelles il
     * apparaît. Les numéros de pages sont supposées déjà saisies dans un tableau dont le nombre
     * d’éléments est fourni en argument. La fonction renvoie l’ABR modifié.
     */
    public static ABR ajout_nompropre(String nom, int[] t, int nombre, ABR a) {
        LCB pages = new LCB(); // liste chainée de numéros de pages pour l'arbre a
        for (int i = 0; i < nombre; i++) { // on ajoute les numeros de pages dans la liste chainée
            pages = LCB.ajout_numero(t[i], pages);
        }
        if (a == null) { // si l'arbre est vide on crée un nouveau noeud
            return new ABR(nom, pages);
        } else { // sinon on insère le nouveau noeud dans l'arbre
            if (nom.compareTo(a.getNom()) < 0) { // le nom vient avant a.getNom()
                return new ABR(
                    a.getNom(), 
                    a.getPages(), 
                    ajout_nompropre(nom, t, nombre, a.getGauche()), // on insère le nouveau noeud dans le sous-arbre gauche
                    a.getDroit()
                );
            } else { // le nom vient après a.getNom()
                return new ABR(
                    a.getNom(), 
                    a.getPages(), 
                    a.getGauche(), 
                    ajout_nompropre(nom, t, nombre, a.getDroit()) // on insère le nouveau noeud dans le sous-arbre droit
                );
            }
        }
    }

    /*
     * Ecrire une fonction public static ABR supprimer_numero (String nom, int numero, ABR a) qui 
     * supprime un numéro de page pour un nom donné et renvoie l’ABR modifié. La fonction doit
     * exploiter le double chaînage afin de simplifier le parcours de la liste.
     * la fonction LCB.supprimer_numero n'est pas encore implémentée
     */
    public static ABR supprimer_numero(String nom, int numero, ABR a) {
        if (a == null) {
            return null;
        } else if (nom.compareTo(a.getNom()) < 0) {
            return new ABR(
                a.getNom(), 
                a.getPages(), 
                supprimer_numero(nom, numero, a.getGauche()), 
                a.getDroit()
            );
        } else if (nom.compareTo(a.getNom()) > 0) {
            return new ABR(
                a.getNom(), 
                a.getPages(), 
                a.getGauche(), 
                supprimer_numero(nom, numero, a.getDroit())
            );
        } else {
            return new ABR(
                a.getNom(), 
                LCB.supprimer_numero(numero, a.getPages()), 
                a.getGauche(), 
                a.getDroit()
            );
        }
    }

    /*
     * Ecrire une fonction void afficher_index (ABR a) qui affiche l’index selon l’ordre
     * alphabétique des noms (comme montré dans l’exemple).
     */
    public static void afficher_index(ABR a) {
        if (a != null) {
            afficher_index(a.getGauche());
            System.out.println(a.getNom());
            LCB.afficher_numeros(a.getPages());
            afficher_index(a.getDroit());
        }
    }

    public String getNom() {
        return this.nom;
    }

    public LCB getPages() {
        return this.pages;
    }

    public ABR getGauche() {
        return this.gauche;
    }

    public ABR getDroit() {
        return this.droit;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPages(LCB pages) {
        this.pages = pages;
    }

    public void setGauche(ABR gauche) {
        this.gauche = gauche;
    }

    public void setDroit(ABR droit) {
        this.droit = droit;
    }
}
