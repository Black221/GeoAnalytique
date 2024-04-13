package tp.src.exo8;

public class Main {
    
    /*
     * - Fatou  110, 250, 300
     * - Mamadou  3, 14, 101
     * - Oussenou  11, 50
     * - Pierre  3, 7, 100, 287
     * - Soda  6, 10, 34, 66, 98
     */
    public static void main(String[] args) {
        ABR a = new ABR("Fatou");
        a = ABR.ajout_nompropre("Mamadou", new int[]{3, 14, 101}, 3, a);
        a = ABR.ajout_nompropre("Oussenou", new int[]{11, 50}, 2, a);
        a = ABR.ajout_nompropre("Pierre", new int[]{3, 7, 100, 287}, 4, a);
        a = ABR.ajout_nompropre("Soda", new int[]{6, 10, 34, 66, 98}, 5, a);

        ABR.afficher_index(a);

        System.out.println(a);

    }
}
