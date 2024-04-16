public class MATCARREE {
    private int taille; 
    private double[][] val; 

    public MATCARREE(int taille) {
        this.taille = taille;
        this.val = new double[taille][taille];
    }

    public int getTaille() {
        return taille;
    }

    public void setVal(int i, int j, double valeur) {
        if (i >= 0 && i < taille && j >= 0 && j < taille) {
            val[i][j] = valeur;
        } else {
            System.out.println("Indice invalide !");
        }
    }

    public double getElement(int i, int j) {
        if (i >= 0 && i < taille && j >= 0 && j < taille) {
            return val[i][j];
        } else {
            System.out.println("Indice invalide !");
        }
        return 0;
    }

    public boolean symetrique() {
        if (taille != val.length || taille != val[0].length) {
            System.out.println("La matrice n'est pas carrée.");
            return false;
        }
    
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if (val[i][j] != val[j][i]) {
                    return false; 
                }
            }
        }
        return true;
    }
    
    public static int nombreElements(int n) {
        return (n * (n + 1)) / 2; 
    }

    public static double[] symCompacte(MATCARREE m, int n) {
        if (!m.symetrique()) {
            System.out.println("La matrice n'est pas symétrique.");
            return null;
        }

        double[] representationCompacte = new double[nombreElements(n)];
        int index = 0; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                representationCompacte[index++] = m.val[i][j];
            }
        }
        return representationCompacte;
    }
    
    public void afficher() {
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                System.out.print(val[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public double aces(double[] c, int i, int j) {
        if (i < j) {
            int temp = i;
            i = j;
            j = temp;
        }
        int index = i * (i + 1) / 2 + j;
        return c[index];
    }
    void traiterLigne(double[] c, int n, int i) {
        for (int j = 0; j < n; j++) {
            double x = aces(c, i, j);
            traiterCoef(x);
        }
    }
    void afficher(double[] c, int n) {
        for (int i = 0; i < n; i++) {
            traiterLigne(c, n, i);
            System.out.println();
        }
    }

    static void traiterCoef(double x) {
        System.out.print(x + "\t");
    }

    public static void main(String[] args) {
        
        MATCARREE matrice_symetrique = new MATCARREE(3);
        matrice_symetrique.setVal(0, 0, 1);
        matrice_symetrique.setVal(0, 1, 2);
        matrice_symetrique.setVal(0, 2, 3);
        matrice_symetrique.setVal(1, 0, 2);
        matrice_symetrique.setVal(1, 1, 4);
        matrice_symetrique.setVal(1, 2, 5);
        matrice_symetrique.setVal(2, 0, 3);
        matrice_symetrique.setVal(2, 1, 5);
        matrice_symetrique.setVal(2, 2, 6);

        double[] representationCompacte = MATCARREE.symCompacte(matrice_symetrique, matrice_symetrique.getTaille());
        if (representationCompacte != null) {

            System.out.println("\nNombre d'éléments d'une matrice symétriques : " + nombreElements(matrice_symetrique.getTaille()));

            System.out.println("\nReprésentation compacte de la matrice symétrique : ");
            for (double element : representationCompacte) {
                System.out.print(element + " ");
            }
            System.out.println();

            System.out.println("\nTest de la méthode acces : ");
            for (int i = 0; i < matrice_symetrique.getTaille(); i++) {
                for (int j = 0; j < matrice_symetrique.getTaille(); j++) {
                    System.out.printf("Coefficient (%d,%d) = %f\n", i, j, matrice_symetrique.aces(representationCompacte, i, j));
                }
            }

            System.out.println("\nTest de la methode afficher() :\n");
            matrice_symetrique.afficher(representationCompacte, matrice_symetrique.getTaille());

            System.out.println("\nTest de la méthode traiterLigne() :");

            for (int i = 0; i < matrice_symetrique.getTaille(); i++) {
                matrice_symetrique.traiterLigne(representationCompacte, matrice_symetrique.getTaille(), i);
                System.out.println();
            }

            representationCompacte = null;
        }
    } 
}
