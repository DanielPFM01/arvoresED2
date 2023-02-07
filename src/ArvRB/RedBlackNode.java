package ArvRB;

public class RedBlackNode {

    RedBlackNode leftChild, rightChild;
    int element;
    int color;

    //construtor para setar o valor do no nao tendo nenhum filho, ou seja, ambos nulos
    public RedBlackNode(int element){
            this( element, null, null );
        }

    //construtor para setar valor do elemento, filho esquerdo, direito e cor
    public RedBlackNode(int element, RedBlackNode leftChild, RedBlackNode rightChild){
            this.element = element;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            color = 1;
        }
    }