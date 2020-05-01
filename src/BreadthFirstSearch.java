import java.util.List;

public class BreadthFirstSearch<T> {
    private BFSNode<T> root;

    private void search(BFSNode<T> root) {
        if (root == null) {
            return;
        }

        Queue<BFSNode<T>> queue = new Queue<>();
        root.marked = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            BFSNode<T> node = queue.remove();

            System.out.println(node.data);

            for (BFSNode<T> adj : node.children) {
                if (adj.marked == false) {
                    adj.marked = true;
                    queue.add(adj);
                }
            }
        }
    }

    private static class BFSNode<T> {
        private T data;
        private List<BFSNode<T>> children;
        private boolean marked;

        public BFSNode(T data) {
            this.data = data;
        }
    }
}
