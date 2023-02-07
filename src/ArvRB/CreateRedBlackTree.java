package ArvRB;

public class CreateRedBlackTree {
    private static RedBlackNode nullNode;
    private RedBlackNode current;
    private RedBlackNode parent;
    private RedBlackNode header;
    private RedBlackNode grand;
    private RedBlackNode great;


    static final int RED   = 0;
    static final int BLACK = 1;

    // usar iniciador static para inicializar no nulo
    static {
        nullNode = new RedBlackNode(0);
        nullNode.leftChild = nullNode;
        nullNode.rightChild = nullNode;
    }


    // Construtor para criar no raiz
    public CreateRedBlackTree(int header) {
        this.header = new RedBlackNode(header);
        this.header.leftChild = nullNode;
        this.header.rightChild = nullNode;
    }

    public void removeAll() {
        header.rightChild = nullNode;
    }

    //checar se a arvore esta vazia ou nao
    public boolean checkEmpty() {
        return header.rightChild == nullNode;
    }

    //adicionar novo no na arvore
    public void insertNewNode(int newElement ) {
        current = parent = grand = header;      //setar valor da raiz para current, parent, e grand node
        nullNode.element = newElement;          //setar newElement para o elemento do no nulo

        //repetir ate que o elemento do no atual nao seja igual ao valor de newElement
        while (current.element != newElement) {
            great = grand;
            grand = parent;
            parent = current;

            //se o valor do newElement for menor do que elemento do no atual, o no atual apontara para o filho esquerdo atual. Se nao, apontara para o direito
            current = newElement < current.element ? current.leftChild : current.rightChild;

            //Checar se ambos os filhos sao vermelho ou nao. Se forem, trocar usando metodo hadndleColors()
            if (current.leftChild.color == RED && current.rightChild.color == RED)
                handleColors( newElement );
        }

        //insercao falhara se ja estiver presente na arvore
        if (current != nullNode)
            return;

        //criar no nao tendo filhos e passa-lo para o no atual
        current = new RedBlackNode(newElement, nullNode, nullNode);

        //conectar o no atual com seu pai
        if (newElement < parent.element)
            parent.leftChild = current;
        else
            parent.rightChild = current;
        handleColors( newElement );
    }

    //realizar manuntencao das cores dos nos da arvore
    private void handleColors(int newElement) {
        // trocar cores dos nos
        current.color = RED;    //no atual ficar vermelho
        current.leftChild.color = BLACK;    //fazer filho esquerdo do no ficar preto
        current.rightChild.color = BLACK;   //fazer filho direito do no ficar preto

        //checar cor do no pai
        if (parent.color == RED) {

            //performar rotacao caso a cor do no pai for vermelho
            grand.color = RED;

            if (newElement < grand.element && grand.element != newElement && newElement < parent.element)
                parent = performRotation( newElement, grand );  // Start dbl rotate
            current = performRotation(newElement, great );
            current.color = BLACK;
        }

        header.rightChild.color = BLACK;
    }

    //performar rotacao dupla
    private RedBlackNode performRotation(int newElement, RedBlackNode parent) {
        //checar se o valor de newElement for menor que o elemento do no pai
        if(newElement < parent.element)
            //se for, performar rotacao com filho esquerdo e direito baseado na condicao e setar valor de retorno para a crianca esquerda do no pai
            return parent.leftChild = newElement < parent.leftChild.element ? rotationWithLeftChild(parent.leftChild) : rotationWithRightChild(parent.leftChild) ;
        else
            //se nao, performar rotacao com o filho esquerdo e direito baseado na condicao e setar valor de retorno para a crianca direita do no pai
            return parent.rightChild = newElement < parent.rightChild.element ? rotationWithLeftChild(parent.rightChild) : rotationWithRightChild(parent.rightChild);
    }

    //rotacionar no com filho esquerdo
    private RedBlackNode rotationWithLeftChild(RedBlackNode node2) {
        RedBlackNode node1 = node2.leftChild;
        node2.leftChild = node1.rightChild;
        node1.rightChild = node2;
        return node1;
    }

    //rotacionar no com filho direito
    private RedBlackNode rotationWithRightChild(RedBlackNode node1) {
        RedBlackNode node2 = node1.rightChild;
        node1.rightChild = node2.leftChild;
        node2.leftChild = node1.leftChild;
        return node2;
    }

    //pegar numero total de nos na arvore
    public int nodesInTree() {
        return nodesInTree(header.rightChild);
    }
    private int nodesInTree(RedBlackNode node) {
        if (node == nullNode)
            return 0;
        else
        {
            int size = 1;
            size = size + nodesInTree(node.leftChild);
            size = size + nodesInTree(node.rightChild);
            return size;
        }
    }

    //buscar no desejado na arvore
    public boolean searchNode(int value) {
        return searchNode(header.rightChild, value);
    }
    private boolean searchNode(RedBlackNode node, int value) {
        boolean check = false;
        while ((node != nullNode) && check != true)
        {
            int nodeValue = node.element;
            if (value < nodeValue)
                node = node.leftChild;
            else if (value > nodeValue)
                node = node.rightChild;
            else
            {
                check = true;
                break;
            }
            check = searchNode(node, value);
        }
        return check;
    }

    //pre ordem
    public void preorderTraversal() {
        preorderTraversal(header.rightChild);
    }
    private void preorderTraversal(RedBlackNode node) {
        if (node != nullNode)
        {
            char c = 'R';
            if (node.color == 1)
                c = 'B';
            System.out.print(node.element +""+c+" ");
            preorderTraversal(node.leftChild);
            preorderTraversal(node.rightChild);
        }
    }

    //em ordem
    public void inorderTraversal() {
        inorderTraversal(header.rightChild);
    }
    private void inorderTraversal(RedBlackNode node) {
        if (node != nullNode)
        {
            inorderTraversal(node.leftChild);
            char c = 'R';
            if (node.color == 1)
                c = 'B';
            System.out.print(node.element +""+c+" ");
            inorderTraversal(node.rightChild);
        }
    }

    //pos ordem
    public void postorderTraversal() {
        postorderTraversal(header.rightChild);
    }
    private void postorderTraversal(RedBlackNode node) {
        if (node != nullNode)
        {
            postorderTraversal(node.leftChild);
            postorderTraversal(node.rightChild);
            char c = 'R';
            if (node.color == 1)
                c = 'B';
            System.out.print(node.element +""+c+" ");
        }
    }
}

