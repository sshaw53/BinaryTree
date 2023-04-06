import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */
// BINARY TREE PROBLEM SET
// BY: SIERRA SHAW, APRIL 21, 2023
public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */

    // Searches the binary tree to see if the value is in the tree, returns true if found
    // and false if not found.
    public boolean search(int val) {
        return binarySearch(getRoot(), val);
    }

    // Helper method to perform the recursion
    public boolean binarySearch(BSTNode node, int val) {
        // Base cases are when there is no node left, which would return false
        // and when the node's value is the value that is being looked for, which returns true
        if (node == null)
            return false;
        if (node.getVal() == val)
            return true;

        // Recursive step, if the value is less that the current node, it calls the algorithm
        // with the node to the left, and calls to the right when the value is larger than the current node
        if (node.getVal() > val)
            return binarySearch(node.getLeft(), val);
        else
            return binarySearch(node.getRight(), val);
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    // Return an ArrayList that represents the Inorder Traversal of the tree (visits each node from Left → Root → Right)
    // Calls a helper traversal function
    public ArrayList<BSTNode> getInorder() {
        // Creates an ArrayList, then calls the recursive method to add to the ArrayList and return the complete ArrayList
        ArrayList<BSTNode> sorted = new ArrayList<BSTNode>();
        inorderTraverse(getRoot(), sorted);
        return sorted;
    }

    public void inorderTraverse(BSTNode node, ArrayList<BSTNode> array) {
        // Recursive step going to the left
        if (node.getLeft() != null && array.indexOf(node.getLeft()) == -1)
            inorderTraverse(node.getLeft(), array);

        // Adding the root
        array.add(node);

        // Recursive step going to the right
        if (node.getRight() != null && array.indexOf(node.getRight()) == -1)
            inorderTraverse(node.getRight(), array);
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    // Return an ArrayList that represents the Preorder Traversal of the tree (visits each node from Root → Left → Right)
    // Calls a helper traversal function.
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> sorted = new ArrayList<BSTNode>();
        preorderTraverse(getRoot(), sorted);
        return sorted;
    }

    public void preorderTraverse(BSTNode node, ArrayList<BSTNode> array) {
        // Add node (root), known that it will not be null
        array.add(node);

        // Recursive step going to the left
        if (node.getLeft() != null && array.indexOf(node.getLeft()) == -1)
            inorderTraverse(node.getLeft(), array);

        // Recursively go to the right
        if (node.getRight() != null && array.indexOf(node.getRight()) == -1)
            inorderTraverse(node.getRight(), array);
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    // Return an ArrayList that represents the Postorder Traversal of the tree (visits each node from Left → Right → Root)
    // Calls a helper traversal function.
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> sorted = new ArrayList<BSTNode>();
        postorderTraverse(getRoot(), sorted);
        return sorted;
    }

    public void postorderTraverse(BSTNode node, ArrayList<BSTNode> array) {
        // Recursive step going to the left
        if (node.getLeft() != null && array.indexOf(node.getLeft()) == -1)
            inorderTraverse(node.getLeft(), array);

        // Recursively go to the right
        if (node.getRight() != null && array.indexOf(node.getRight()) == -1)
            inorderTraverse(node.getRight(), array);

        // Add node (root), known that it will not be null
        array.add(node);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    // Uses similar idea to the find method, then sets it as a left or right to the final case that it's at.
    public void insert(int val) {
        insertSearch(getRoot(), val);
    }

    public void insertSearch(BSTNode node, int val) {
        // Base cases are when there is no node left to move to, which is where the new node will be added.
        if (node.getVal() == val)
            return;

        // Setting the node in place when the node has nothing further to go to.
        // If the chosen value is less than the node value, adds it to the left, and opposite for the right.
        if (node.getLeft() == null && node.getVal() >= val)
            node.setLeft(new BSTNode(val));
        if (node.getRight() == null && node.getVal() <= val)
            node.setRight(new BSTNode(val));

        // Recursive step, if the value is less that the current node, it calls the algorithm
        // with the node to the left, and calls to the right when the value is larger than the current node.
        if (node.getVal() > val)
            insertSearch(node.getLeft(), val);
        else
            insertSearch(node.getRight(), val);
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
