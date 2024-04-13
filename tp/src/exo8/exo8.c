#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/*
    On souhaite construire l’index alphabétique des noms propres cités dans un livre.
    Pour cela, on se propose d’utiliser la structure d’un Arbre Binaire de Recherche (ABR).
    Le contenu de chaque noeud de l’arbre représente une ligne dans l’index et est composé d’un
    nom propre et des numéros des pages où il apparaît dans le livre. Ces numéros de page sont
    chaînés entre eux dans une Liste Chaînée Bidirectionnelle (LCB), dans l’ordre croissant, sans
    répétition. Les pointeurs de tête et de queue de la LCB sont stockés dans le noeud de l’ABR.
*/

typedef struct maillon {
    int numero ;
    struct maillon * suiv, *prec ;
} MAILLON, *PTR ;

typedef struct lcb {
    PTR tete, queue;
} LCB ;

// En déduire la définition d’un type ABR permettant de représenter un index.

typedef struct noeud {
    char * nom ;
    LCB pages ;
    struct noeud * gauche, * droite ;
} NOEUD, *ABR ;

/*
    Ecrire la fonction LCB ajout_numero (int num, LCB numeros) qui insère un numéro
    dans une LCB et retourne la LCB résultante. La fonction doit exploiter le double chaînage
    afin de simplifier le parcours de la liste.
*/

LCB ajout_numero (int num, LCB numeros) {
    PTR p, q, r ;
    p = (PTR) malloc (sizeof (MAILLON)) ; // Allocation dynamique de la mémoire pour le maillon p
    p->numero = num ;
    p->suiv = NULL ;
    if (numeros.tete == NULL) { // Si la liste est vide on insère le maillon p en tête de liste
        numeros.tete = numeros.queue = p ;
        p->prec = NULL ;
    } else { // Sinon on insère le maillon p à sa place dans la liste
        q = numeros.tete ; // q pointe sur le premier maillon de la liste
        while (q != NULL && q->numero < num) { // On cherche la position d'insertion du maillon p
            r = q ; // r pointe sur le maillon précédent à q
            q = q->suiv ; // q pointe sur le maillon suivant à q
        }
        if (q == NULL) { // Si q est NULL alors le maillon p est inséré en queue de liste
            numeros.queue->suiv = p ;
            p->prec = numeros.queue ;
            numeros.queue = p ;
        } else { // Sinon le maillon p est inséré à sa place dans la liste (respect de l'ordre croissant des numéros de page)
            p->suiv = q ;
            p->prec = q->prec ;
            q->prec = p ;
            if (q == numeros.tete) { // Si q est la tête de liste alors le maillon p est inséré en tête de liste
                numeros.tete = p ;
            } else { // Sinon le maillon p est inséré entre deux maillons de la liste
                p->prec->suiv = p ;
            }
        }
    }
    return numeros ;
}

/*
    Ecrire une fonction ABR ajout_nompropre (char* nom, int t[], int nombre, ABR
    a) qui insère, dans un ABR, un nouveau nom et les numéros des pages dans lesquelles il
    apparaît. Les numéros de pages sont supposées déjà saisies dans un tableau dont le nombre
    d’éléments est fourni en argument. La fonction renvoie l’ABR modifié.
*/

ABR ajout_nompropre (char* nom, int t[], int nombre, ABR a) {
    NOEUD * p, * q, * r ;
    int i ;
    p = (NOEUD *) malloc (sizeof (NOEUD)) ;
    p->nom = nom ;
    p->gauche = p->droite = NULL ;
    p->pages.tete = p->pages.queue = NULL ;
    for (i = 0 ; i < nombre ; i++) {
        p->pages = ajout_numero (t[i], p->pages) ;
    }
    if (a == NULL) {
        return p ;
    } else {
        q = a ;
        while (q != NULL) {
            r = q ;
            if (strcmp (nom, q->nom) < 0) {
                q = q->gauche ;
            } else {
                q = q->droite ;
            }
        }
        if (strcmp (nom, r->nom) < 0) {
            r->gauche = p ;
        } else {
            r->droite = p ;
        }
    }
    return a ;
}

/*
    Ecrire une fonction ABR supprimer_numero (char *nom, int numero, ABR a) qui
    supprime un numéro de page pour un nom donné et renvoie l’ABR modifié. La fonction doit
    exploiter le double chaînage afin de simplifier le parcours de la liste.
*/

ABR supprimer_numero (char *nom, int numero, ABR a) {
    NOEUD * p, * q, * r ;
    PTR s, t ;
    p = a ;
    while (p != NULL && strcmp (nom, p->nom) != 0) {
        q = p ;
        if (strcmp (nom, p->nom) < 0) {
            p = p->gauche ;
        } else {
            p = p->droite ;
        }
    }
    if (p != NULL) {
        s = p->pages.tete ;
        while (s != NULL && s->numero != numero) {
            t = s ;
            s = s->suiv ;
        }
        if (s != NULL) {
            if (s == p->pages.tete) {
                p->pages.tete = s->suiv ;
                if (s->suiv != NULL) {
                    s->suiv->prec = NULL ;
                }
            } else {
                t->suiv = s->suiv ;
                if (s->suiv != NULL) {
                    s->suiv->prec = t ;
                }
            }
            free (s) ;
        }
    }
    return a ;
}

/*
    Proposer une représentation graphique de l’ABR représentant le petit index fourni
    précédemmant en exemple. On suppose que les noms sont insérés dans l’ABR selon l’ordre
    suivant : Fatou, Mamadou, Oussenou, Pierre, Soda.
    - Fatou  110, 250, 300
    - Mamadou  3, 14, 101
    - Oussenou  11, 50
    - Pierre  3, 7, 100, 287
    - Soda  6, 10, 34, 66, 98
*/

/*
    Arbre Binaire de Recherche (ABR) :
    - Fatou
        - 110, 250, 300
        - Mamadou
            - 3, 14, 101
            - Oussenou
                - 11, 50
                - Pierre
                    - 3, 7, 100, 287
                    - Soda
                        - 6, 10, 34, 66, 98
*/


/*
    Ecrire une fonction void afficher_index (ABR a) qui affiche l’index selon l’ordre
    alphabétique des noms (comme montré dans l’exemple).
*/

void afficher_index (ABR a) {
    if (a != NULL) {
        afficher_index (a->gauche) ;
        printf ("%s : ", a->nom) ;
        PTR p = a->pages.tete ;
        while (p != NULL) {
            printf ("%d ", p->numero) ;
            p = p->suiv ;
        }
        printf ("\n") ;
        afficher_index (a->droite) ;
    }
}

/*
    Les performances de la recherche dans l’ABR de l’exemple ne sont pas meilleures que
    celles qu’on obtiendrait si on s’était servi d’une liste chaînée simple à la place de l’ABR.
    Pourquoi ? Proposer une solution à ce problème.
*/

/*
    Les performances de la recherche dans l’ABR de l’exemple ne sont pas meilleures que
    celles qu’on obtiendrait si on s’était servi d’une liste chaînée simple à la place de l’ABR
    car l’ABR est déséquilibré. Pour résoudre ce problème, on peut équilibrer l’ABR en
    effectuant une rotation droite ou gauche sur les sous-arbres de l’ABR.
*/

/*
    ABR equilibrer (ABR a) qui équilibre l’ABR a et renvoie l’ABR
    équilibré. On suppose que l’ABR est déséquilibré.
*/

int hauteur (ABR a) {
    if (a == NULL) {
        return 0 ;
    } else {
        int hg = hauteur (a->gauche) ;
        int hd = hauteur (a->droite) ;
        return 1 + (hg > hd ? hg : hd) ;
    }
}

ABR rotation_droite (ABR a) {
    ABR b = a->gauche ;
    a->gauche = b->droite ;
    b->droite = a ;
    return b ;
}

ABR rotation_gauche (ABR a) {
    ABR b = a->droite ;
    a->droite = b->gauche ;
    b->gauche = a ;
    return b ;
}

ABR equilibrer (ABR a) {
    if (a != NULL) {
        int hg = hauteur (a->gauche) ;
        int hd = hauteur (a->droite) ;
        if (hg - hd > 1) {
            if (hauteur (a->gauche->gauche) < hauteur (a->gauche->droite)) {
                a->gauche = rotation_gauche (a->gauche) ;
            }
            a = rotation_droite (a) ;
        } else if (hd - hg > 1) {
            if (hauteur (a->droite->gauche) > hauteur (a->droite->droite)) {
                a->droite = rotation_droite (a->droite) ;
            }
            a = rotation_gauche (a) ;
        }
        a->gauche = equilibrer (a->gauche) ;
        a->droite = equilibrer (a->droite) ;
    }
    return a ;
}

// main

int main (void) {
    ABR a = NULL ;
    int t1[] = {110, 250, 300} ;
    int t2[] = {3, 14, 101} ;
    int t3[] = {11, 50} ;
    int t4[] = {3, 7, 100, 287} ;
    int t5[] = {6, 10, 34, 66, 98} ;
    a = ajout_nompropre ("Fatou", t1, 3, a) ;
    a = ajout_nompropre ("Pierre", t4, 4, a) ;
    a = ajout_nompropre ("Oussenou", t3, 2, a) ;
    a = ajout_nompropre ("Mamadou", t2, 3, a) ;
    a = ajout_nompropre ("Soda", t5, 5, a) ;
    afficher_index (a) ;
    return 0 ;
}