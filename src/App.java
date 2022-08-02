import impl.BinaryNode;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Binary Tree find the difference");
        BinaryNode bTree = new BinaryNode(100);
        bTree.AddNode(new BinaryNode(50));
        bTree.AddNode(new BinaryNode(60));
        bTree.AddNode(new BinaryNode(98));
        bTree.AddNode(new BinaryNode(120));
        bTree.AddNode(new BinaryNode(110));
        bTree.AddNode(new BinaryNode(101));
        
        int difference = bTree.FindDifference(true, true);

        System.out.println("Min Difference: " + difference);
    }
}
