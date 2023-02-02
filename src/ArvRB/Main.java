package ArvRB;

public class Main {

    public static void main(String[] args) {
        Arvore arvoreRB = new Arvore();

        arvoreRB.adiciona(13);
        arvoreRB.adiciona(67);
        arvoreRB.adiciona(91);
        arvoreRB.adiciona(38);
        arvoreRB.adiciona(7);
        arvoreRB.adiciona(1);

        //arvoreRB.grafico();

        System.out.println( "O menor valor da arvore e: " + arvoreRB.menorValor());

        System.out.println( "O maior valor da arvore e: " + arvoreRB.maiorValor());

//        arvoreRB.remove(38);
//
//        arvoreRB.grafico();
//
//        arvoreRB.inorderWalk();

    }
}
