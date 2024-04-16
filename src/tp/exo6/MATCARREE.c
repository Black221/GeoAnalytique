#include <stdio.h>
#include <stdlib.h>

#define NMAX 100
/*
    Déclarer un type MATCARREE permettant de représenter de telles matrices au moyen
    d’un tableau.
*/
typedef struct {
    int taille;
    double val[NMAX][NMAX];
} MATCARREE;

//Prototypes des fonctions
int symetrique(MATCARREE m);
double* symCompacte(MATCARREE m, int taille);
double acces(double *c, int i, int j);
void traiterLigne(double *c, int taille, int i);
void traiterCoef(double x);
void afficher(double *c, int taille);

int main() {
    MATCARREE matrice = {
        .taille = 3, 
        .val = {
            {1, 2, 3},
            {2, 4, 5},
            {3, 5, 6}
        }
    };

    int nombreElements = matrice.taille * (matrice.taille + 1) / 2;

    /*
        Combien faut-il de nombres réels pour représenter sans redondance une matrice
        symétrique à n lignes et n colonnes ?
    */
    printf("\nNombre d'éléments d'une matrice symétriques : %d \n", nombreElements);

    double* representationCompacte = symCompacte(matrice, matrice.taille);
    if (representationCompacte != NULL) {

        printf("\nReprésentation compacte de la matrice symétrique : \n");
        for (int i = 0; i < nombreElements; i++) {
            printf("%lf ", representationCompacte[i]);
        }
        printf("\n");

        printf("\nTest de la fonction acces() :\n");
        for (int i = 0; i < matrice.taille; i++) {
            for (int j = 0; j < matrice.taille; j++) {
                printf("Coefficient (%d,%d) = %lf\n", i, j, acces(representationCompacte, i, j));
            }
        }

        printf("\nTest de la fonction afficher() :\n");
        afficher(representationCompacte, matrice.taille);

        printf("\nTest de la fonction traiterLigne() :\n");
        for (int i = 0; i < matrice.taille; i++) {
            traiterLigne(representationCompacte, matrice.taille, i);
            printf("\n");
        }

        free(representationCompacte);//libère la mémoire
    }

    return 0;
}

/*
    Ecrire une fonction symetrique qui permet de vérifier qu’une matrice m de type
    MATCARREE, représentant une matrice carrée nx n est symétrique.
*/
int symetrique(MATCARREE m) {
    int taille = m.taille;
    double val[NMAX][NMAX];

    for (int i = 0; i < taille; i++) {
        for (int j = 0; j < taille; j++) {
            if (val[i][j] != val[j][i]) {
                return 0; 
            }
        }
    }

    return 1; 
}

/*
    Ecrire la fonction double *symCompacte(MATCARREE m, int n) qui reçoit une
    matrice carrée à n lignes et n colonnes et qui construit et renvoie la représentation compacte de m par un tableau dynamiquement alloué. Cette fonction renvoie NULL si
    m n’est pas symétrique.
*/
double* symCompacte(MATCARREE m, int n) {

    if (!symetrique(m)) {
        printf("La matrice n'est pas symétrique.\n");
        return NULL;
    }


    double* representationCompacte = (double*)malloc(n * (n + 1) / 2 * sizeof(double));
    if (representationCompacte == NULL) {
        printf("Erreur lors de l'allocation mémoire.\n");
        return NULL;
    }

    int index = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j <= i; j++) {
            representationCompacte[index++] = m.val[i][j];
        }
    }

    return representationCompacte;
}

/*
    Ecrire la fonction double acces(double *c, int i, int j) qui reçoit c, la représentation compacte de m, une matrice symétrique n x n, et deux indices i et j, tels que 0 ≤ i,j ≤ n, et qui renvoie le coefficient mi,j.
*/
double acces(double *c, int i, int j) {
    if(i < j) {
        int tempon = i;
        i = j;
        j = tempon;
    }
    int index = i*(i+1)/2 + j;
    return c[index];
}

void traiterCoef(double x){
    printf("%d\t",x);
}

/*
    En supposant qu’on dispose par ailleurs d’une fonction traiterCoef(double x), écrire la fonction void traiterLigne(double *c, int n, int i) qui parcourt la ieme ligne de la matrice symétrique n x n, dont c est la représentation compacte, en effectuant sur chaque coefficient le traitement exprimé par traiterCoef.
*/
void traiterLigne(double *c, int n, int i){
    for(int j=0; j<n; j++){
        double x = acces(c, i, j);
        traiterCoef(x);
    }
}

/*
    Ecrire la fonction void afficher(double *c, int n) qui affiche normalement (c-à-d sous une forme matricielle) la matrice symétrique n x n dont c est la représentation
    compacte. On pourra se servir des fonctions traiterLigne et traiterCoef (écrire une version utile de cette fonction).
*/

void afficher(double *c, int n){
    for(int i=0; i<n; i++){
        traiterLigne(c, n, i);
        printf("\n");
    }
}



