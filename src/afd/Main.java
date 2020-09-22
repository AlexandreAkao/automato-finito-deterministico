package afd;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
         * L1 = { w in Σ^* | w possui tamanho ou |w| par, bem como pode ser vazia }
         */

//        String alfabeto1 = "ab";
//        int [][] ML1 = { //Matriz de transisão
//            {1, 1},
//            {0, 0}
//        };
//
//        int [] FL1 = {0}; //Estados finais
//        String w1 = "abba";
//        AFD afdL1 = new AFD(2, alfabeto1, FL1, ML1);
//
//        validate(afdL1.run(w1), w1);
//
//
//        String alfabeto2 = "xy";
//
//        int [][] ML2 = { //Matriz de transisão
//            {1, 2},
//            {1, 1},
//            {3, 2},
//            {3, 2}
//        };
//        int [] FL2 = {3}; //Estados finais
//        String w2 = "yyxyy";
//        AFD afdL2 = new AFD(4, alfabeto2, FL2, ML2);
//
//        validate(afdL2.run(w2), w2);

        String alfabeto2 = "01";

        int [][] ML2 = { //Matriz de transisão
            {1, 0},
            {1, 2},
            {1, 0},
        };
        int [] FL2 = {2}; //Estados finais
        String w2 = "1001001";
        AFD afdL2 = new AFD(3, alfabeto2, FL2, ML2);

        validate(afdL2.run(w2), w2);

    }

    private static void validate(boolean flag, String w) {
        if (flag) {
            System.out.println("Reconheceu: " + w);
        } else {
            System.out.println("Nao reconheceu: " + w);
        }
    }
}
