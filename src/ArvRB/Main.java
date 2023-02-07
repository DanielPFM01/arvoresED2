package ArvRB;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //criar instancia da classe createRedBlackTree e passar o minimo valor inteiro para o construtor para faze-lo no raiz
        CreateRedBlackTree obj = new CreateRedBlackTree(Integer.MIN_VALUE);
        char choice;

        do
        {
            System.out.println("\nSelecione uma operacao:\n");
            System.out.println("1. Inserir no ");
            System.out.println("2. Buscar no");
            System.out.println("3. Numero total de nos da arvore");
            System.out.println("4. A arvore esta vazia?");
            System.out.println("5. Remover todos os nos da arvore ");
            System.out.println("6. Mostrar arvore pos-ordem");
            System.out.println("7. Mostrar arvore pre-ordem");
            System.out.println("8. Mostrar arvore em ordem");

            int ch = scan.nextInt();
            switch (ch)
            {
                case 1 :
                    System.out.println("Insira um elemento para colocar na arvore");
                    obj.insertNewNode( scan.nextInt() );
                    break;
                case 2 :
                    System.out.println("Insira o elemento a ser buscado");
                    System.out.println(obj.searchNode( scan.nextInt() ));
                    break;
                case 3 :
                    System.out.println(obj.nodesInTree());
                    break;
                case 4 :
                    System.out.println(obj.checkEmpty());
                    break;
                case 5 :
                    obj.removeAll();
                    System.out.println("\nArvore limpada com sucesso");
                    break;
                case 6 :
                    System.out.println("\nMostrar arvore pos-ordem");
                    obj.postorderTraversal();
                    break;
                case 7 :
                    System.out.println("\nMostrar arvore pre-ordem");
                    obj.preorderTraversal();
                    break;
                case 8 :
                    System.out.println("\nMostrar arvore em ordem");
                    obj.inorderTraversal();
                    break;
                default :
                    System.out.println("\n ");
                    break;
            }
            System.out.println("\nPressione 'y' ou 'Y' para continuar \n");
            choice = scan.next().charAt(0);
        } while (choice == 'Y'|| choice == 'y');
    }
}
