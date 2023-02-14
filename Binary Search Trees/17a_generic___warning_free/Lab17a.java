import static java.lang.System.*;

public class Lab17a 
{
   private static final class TestValue implements Comparable<TestValue> {
      String str;
      int num;

      TestValue(String str, int num) {
         this.str = str;
         this.num = num;
      }

      @Override
      public int compareTo(TestValue other) {
         return str.compareTo(other.str) + num - other.num;
      }

      @Override
      public boolean equals(Object other) {
         return other instanceof TestValue && 
            compareTo((TestValue) other) == 0;
      }
   }

   public static void main(String args[]) 
   {
      //Create a BST and add the nodes from the directions in
      //the correct order to form the tree shown in the directions!!!
      BinarySearchTree tree = new BinarySearchTree();

      ArrayList<TestValue> values = new ArrayList(Arrays.asList(new TestValue[] {
         new TestValue("a", 1),
         new TestValue("b", 2),
         new TestValue("c", 3),
         new TestValue("d", 4),
         new TestValue("e", 5),
         new TestValue("f", 6),
         new TestValue("g", 7),
      }));

      // Randomly Scramble
      Collections.shuffle(values)

      for (int value: values)
         tree.add(value);

      out.println("LEVEL ORDER");
      tree.levelOrder();

      out.println("\nIN ORDER");
      tree.inOrder();
      
      out.println("\nPRE ORDER");
      tree.preOrder();

      out.println("\nPOST ORDER");
      tree.postOrder();

      out.println("\nREVERSE ORDER");
      tree.reverseOrder();

      out.println("\nTree as a string  " + tree.toString());
      out.println(tree.isFull() ? "\nThe tree is full." : "\nThe tree is not full.");
      out.println(tree.search(new TreeNode("f", 6)) ? "The tree contains f6!" : "The does not contain f6!");
      out.println(tree.search(new TreeNode("e", 1)) ? "The tree contains e1!" : "The does not contain e1!");

      out.println("\nNumber of nodes is " + tree.getNumNodes());
      out.println("Number of leaves is " + tree.getNumLeaves());
      out.println("Number of levels is " + tree.getNumLevels());
      out.println("Tree height is " + tree.getHeight());
      out.println("The smallest tree node " + tree.getSmallest());
      out.println("The largest tree node " + tree.getLargest());
      out.println("\nTree width / diameter is " + tree.getWidth());
      
      out.println("\nLevel order traversal is extra credit, but removal is not:");
      out.println("\nTree before removing any nodes - using level order traversal.");
      tree.levelOrder();

      tree.remove(values.get(0));
      out.println("\nTree after removing a1.");
      tree.levelOrder();

      tree.remove(values.get(1));
      out.println("\nTree after removing b2.");
      tree.levelOrder();

      tree.remove(values.get(2));
      out.println("\nTree after removing c3.");
      tree.levelOrder();

      tree.remove(values.get(3));
      out.println("\nTree after removing 98.");
      tree.levelOrder();

      tree.remove(values.get(4));
      out.println("\nTree after removing 80.");
      tree.levelOrder();

      tree.remove(values.get(5));
      out.println("\nTree after removing 120.");
      tree.levelOrder();

      tree.remove(values.get(6));
      out.println("\nTree after removing 100.");
      tree.levelOrder();

      tree.clear();
      tree.levelOrder();
   }
}
