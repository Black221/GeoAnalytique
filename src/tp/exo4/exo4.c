/*
On veut représenter un polynôme par une liste chaînée dans laquelle on ne représente que les
coefficients non nuls.
1. Donner la structure permettant de faire cette représentation.
2. Donner une fonction DERIVEE(P) qui reçoit en entrée un polynôme et donne en sortie la
dérivée P’ de ce polynôme.
3. Donner une fonction DERIVEEKIEME(P,k) qui reçoit en entrée un polynôme P et donne
en sortie sa dérivée k-ième.
*/

#include <stdio.h>
#include <stdlib.h>


typedef struct maillon {
    int degre;
    float coef;
    struct maillon *suiv;
} MAILLON, *PTR;

// Fonction qui reçoit en entrée un polynôme et donne en sortie la dérivée P’ de ce polynôme
PTR DERIVEE(PTR p) {
    PTR q, r, premier = NULL;
    while (p != NULL) {
        if (p->degre > 0) {
            q = (PTR) malloc(sizeof(MAILLON));
            q->degre = p->degre - 1;
            q->coef = p->degre * p->coef;
            q->suiv = NULL;
            if (premier == NULL) {
                premier = q;
            } else {
                r->suiv = q;
            }
            r = q;
        }
        p = p->suiv;
    }
    return premier;
}

// Fonction qui reçoit en entrée un polynôme P et donne en sortie sa dérivée k-ième
PTR DERIVEEKIEME(PTR p, int k) {
    int i;
    for (i = 0; i < k; i++) {
        p = DERIVEE(p);
    }
    return p;
}


int main() {
    PTR p, q, r, premier, dexieme, troixieme = NULL;
    // 2x^3
    p = (PTR) malloc(sizeof(MAILLON));
    p->degre = 3;
    p->coef = 2;
    p->suiv = NULL;
    // 3x^2
    q = (PTR) malloc(sizeof(MAILLON));
    q->degre = 2;
    q->coef = 3;
    q->suiv = NULL;
    p->suiv = q;
    // 1
    r = (PTR) malloc(sizeof(MAILLON));
    r->degre = 0;
    r->coef = 1;
    r->suiv = NULL;
    q->suiv = r;
    
    premier = DERIVEE(p); // 6x^2 + 6x + 0
    while (premier != NULL) {
        printf("%g * x^%d\t", premier->coef, premier->degre);
        premier = premier->suiv;
    }
    printf("\n");

    dexieme = DERIVEEKIEME(p, 2); // 12x + 6
    while (dexieme != NULL) {
        printf("%g * x^%d\t", dexieme->coef, dexieme->degre);
        dexieme = dexieme->suiv;
    }
    printf("\n");

    troixieme = DERIVEEKIEME(p, 3); // 12
    while (troixieme != NULL) {
        printf("%g * x^%d\t", troixieme->coef, troixieme->degre);
        troixieme = troixieme->suiv;
    }
    printf("\n");


    return 0;
}