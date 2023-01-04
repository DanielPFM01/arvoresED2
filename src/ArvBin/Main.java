package ArvBin;

public class Main {
    public static void main(String args[]){
        ArvBinBuscaSChave<Integer> arvoreBinaria = new ArvBinBuscaSChave<>();

        arvoreBinaria.insere(10);
        arvoreBinaria.insere(20);
        arvoreBinaria.insere(5);
        arvoreBinaria.insere(2);
        arvoreBinaria.insere(4);
        arvoreBinaria.insere(18);
        arvoreBinaria.insere(22);

        //Imprimindo a árvore em ordem
        arvoreBinaria.mostra();

        //Pulando uma linha
        System.out.println("\n");

        //Retornando o menor no da arvore - O (log n)
        System.out.println("A menor valor da arvore e: " + arvoreBinaria.min());

        //Verificando se a arvore contem um valor x - O (log n)
        if(arvoreBinaria.contem(18))
            System.out.println("O no de valor 18 esta contido na arvore.");
        else
            System.out.println("O no de valor 18 nao esta contido na arvore.");

        //Verificando se a arvore contem um valor x - O(log n)
        if(arvoreBinaria.contem(23))
            System.out.println("O no de valor 23 esta contido na arvore.");
        else
            System.out.println("O no de valor 23 nao esta contido na arvore.");

        //Removendo o no 20 da arvore - O(log n)
        arvoreBinaria.delete(20);

        //Reimprimindo a arvore apos a remocao do no 20 - O(n)
        System.out.println("\n");
        System.out.println("Impressao da arvore apos remover o no de valor 20:");
        arvoreBinaria.mostra();
    }
}
