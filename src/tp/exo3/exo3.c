/*
On considère des listes chaînees d'entiers.
Faire les declarations necessaires, et ecrire en C, les procedures et fonctions permettant
d'effectuer les operations suivantes :
1. Creer une liste avec dix valeurs saisies au clavier.
2. Tester l'egalite de deux listes.
3. Concatener deux listes :
a) Dans une troisième liste.
b) Sans creer une troisième liste.
*/

#include <stdio.h>
#include <stdlib.h>

typedef struct maillon {
    int info;
    struct maillon *suiv;
} MAILLON, *PTR;

const int N = 5;
// Creer une liste avec dix valeurs saisies au clavier
PTR creer_liste() {
    PTR premier = NULL, p;
    int i, x;
    for (i = 0; i < N; i++) { // on cree une liste de taille N
        printf("Donner la valeur %d : ", i + 1);
        scanf("%d", &x);
        p = (PTR) malloc(sizeof(MAILLON));
        p->info = x;
        p->suiv = premier;
        premier = p;
    }
    return premier;
}

// Tester l'egalite de deux listes
int egalite(PTR p1, PTR p2) {
    while (p1 != NULL && p2 != NULL) { // tant que les deux listes ne sont pas vides
        if (p1->info != p2->info) { // on compare les informations des maillons
            return 0; // si elles sont differentes, on retourne 0
        }
        p1 = p1->suiv;
        p2 = p2->suiv;
    }
    return p1 == NULL && p2 == NULL; // si les deux listes sont vides, on retourne 1 (meme taille) sinon 0 (elles sont differentes)
}

// Concatener deux listes dans une troisième liste
PTR concatenation(PTR p1, PTR p2) {
    PTR p, q, premier = NULL; // p: liste 1, q: liste 2, premier: liste 3
    while (p1 != NULL) { // on parcourt la premiere liste
        p = (PTR) malloc(sizeof(MAILLON)); // on cree un nouveau maillon
        p->info = p1->info; // on copie l'information du maillon de la premiere liste
        p->suiv = NULL; // on initialise le suivant du nouveau maillon a NULL
        if (premier == NULL) { // si premier est NULL
            premier = p;//  on initialise premier avec le maillon recupere de la premiere liste   
        } else {
            q->suiv = p; // sinon, on ajoute le maillon a la fin de la liste
        }
        q = p; // on avance le pointeur q 
        p1 = p1->suiv;// on avance le pointeur p1
    }
    while (p2 != NULL) { // meme procedure par rapport a la deuxieme liste
        p = (PTR) malloc(sizeof(MAILLON));
        p->info = p2->info;
        p->suiv = NULL;
        if (premier == NULL) {
            premier = p;
        } else {
            q->suiv = p;
        }
        q = p;
        p2 = p2->suiv;
    }
    return premier; // on retourne la liste concatenee
}

// Concatener deux listes sans creer une troisième liste
void concatenation_sans_troisieme(PTR *p1, PTR p2) {
    PTR p = *p1;
    if (p == NULL) { // verifier si la premiere liste est vide
        *p1 = p2; // si elle est vide, on la remplace par la deuxieme liste
    } else {
        while (p->suiv != NULL) { // sinon, on parcourt la premiere liste jusqu'a la fin
            p = p->suiv;
        }
        p->suiv = p2; // on ajoute la deuxieme liste a la fin de la premiere liste
    }
}

int main(int argc, char const *argv[]) {
    PTR p1 = creer_liste();
    PTR p2 = creer_liste();
    PTR p3 = concatenation(p1, p2);
    printf("Les deux listes sont %s\n", egalite(p1, p2) ? "egales" : "differentes");
    printf("La concatenation des deux listes dans une troisième liste : ");
    while (p3 != NULL) {
        printf("%d ", p3->info);
        p3 = p3->suiv;
    }
    printf("\n");
    concatenation_sans_troisieme(&p1, p2);
    printf("La concatenation des deux listes sans creer une troisième liste : ");
    while (p1 != NULL) {
        printf("%d ", p1->info);
        p1 = p1->suiv;
    }
    printf("\n");
    return 0;
}