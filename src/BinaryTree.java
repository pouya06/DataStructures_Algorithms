public class BinaryTree<T extends Number> {
    private Node<T> root;

    public BinaryTree() {
        root = null;
    }

    public void insert(T data) {
        if (root == null) {
            Node<T> newNode = new Node<>(null, data, null);
            root = newNode;
            return;
        }

        Node<T> temp = root;
        while (temp != null) {
            if (data.intValue() < temp.data.intValue()) {
                // go to left
                if (temp.left == null) {
                    Node<T> newNode = new Node<>(data);
                    temp.left = newNode;
                    break;
                }
                temp = temp.left;
            }

            if (data.intValue() >= temp.data.intValue()) {
                // go to left

                if (temp.right == null) {
                    Node<T> newNode = new Node<>(data);
                    temp.right = newNode;
                    break;
                }
                temp = temp.right;
            }
        }
    }

    private void inOrderTraversal(Node<T> node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private static class Node<T extends Number> {
        private Node<T> left;
        private T data;
        private Node<T> right;

        public Node(T data) {
            this.left = null;
            this.data = data;
            this.right = null;
        }

        public Node(Node<T> left, T data, Node<T> right) {
            this.left = left;
            this.data = data;
            this.right = right;
        }
    }
}
