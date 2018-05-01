// Aaron Li
// APCS2 pd8
// HW42 -- Algorithm as Data Structure
// 2018-04-30

/*****************************************************
* class BST - v1:partial
* SKELETON
* Implementation of the BINARY SEARCH TREE abstract data type (ADT)
*
* A BST maintains the invariant that, for any node N with value V,
* L<V && V<R, where L and R are node values in N's left and right
* subtrees, respectively.
* (Any value in a node's left subtree must be less than its value,
*  and any value in its right subtree must be greater.)
* This BST only holds ints (its nodes have int cargo)
*****************************************************/

public class BST
{

     //instance variables / attributes of a BST:
     TreeNode _root;

     /*****************************************************
     * default constructor
     *****************************************************/
     BST( )
     {
          _root = null;
     }


     /*****************************************************
     * void insert( int )
     * Adds a new data element to tree.
     *****************************************************/
     public void insert( int newVal )
     {
          TreeNode newNode = new TreeNode( newVal );
          if (_root == null) _root = newNode;
          else {
               insert(_root, newNode);
          }
     }
     //recursive helper for insert(int)
     public void insert( TreeNode stRoot, TreeNode newNode )
     {
          if (newNode.getValue() < stRoot.getValue() && stRoot.getLeft() == null) stRoot.setLeft(newNode);
          else if (newNode.getValue() < stRoot.getValue()) insert(stRoot.getLeft(), newNode);
          if (newNode.getValue() >= stRoot.getValue() && stRoot.getRight() == null) stRoot.setRight(newNode);
          else if (newNode.getValue() >= stRoot.getValue()) insert(stRoot.getRight(), newNode);
          return;
     }//end insert()




     //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

     // each traversal should simply print to standard out
     // the nodes visited, in order

     //process root, recurse left, recurse right
     public void preOrderTrav()
     {
          preOrderTrav( _root );
     }
     public void preOrderTrav( TreeNode currNode )
     {
          System.out.println(currNode.getValue() + "");
          if (currNode.getLeft() != null) preOrderTrav(currNode.getLeft());
          if (currNode.getRight() != null) preOrderTrav(currNode.getRight());
          return;
     }

     //recurse left, process root, recurse right
     public void inOrderTrav()
     {
          inOrderTrav( _root);
     }
     public void inOrderTrav( TreeNode currNode )
     {
          if (currNode.getLeft() != null) inOrderTrav(currNode.getLeft());
          else if (currNode.getRight() == null) System.out.println(currNode.getValue() + "");
          if (currNode.getRight() != null) {
               System.out.println(currNode.getValue() + "");
               inOrderTrav(currNode.getRight());
          } return;
     }

     //recurse left, recurse right, process root
     public void postOrderTrav()
     {
          postOrderTrav(_root);
     }
     public void postOrderTrav( TreeNode currNode )
     {
          if (currNode.getLeft() != null) inOrderTrav(currNode.getLeft());
          else if (currNode.getRight() == null) System.out.println(currNode.getValue() + "");
          inOrderTrav(currNode.getRight());
          if (currNode.getRight() != null) {
               System.out.println(currNode.getValue() + "");
          }
          return;
     }

     //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
     //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


     //main method for testing
     public static void main( String[] args )
     {

          BST arbol = new BST();

          //PROTIP: sketch state of tree after each insertion
          //        ...BEFORE executing these.
          arbol.insert( 4 );
          arbol.insert( 2 );
          arbol.insert( 5 );
          arbol.insert( 6 );
          arbol.insert( 1 );
          arbol.insert( 3 );

          System.out.println( "\n-----------------------------");
          System.out.println( "pre-order traversal:" );
          arbol.preOrderTrav();

          System.out.println( "\n-----------------------------");
          System.out.println( "in-order traversal:" );
          arbol.inOrderTrav();

          System.out.println( "\n-----------------------------");
          System.out.println( "post-order traversal:" );
          arbol.postOrderTrav();

          System.out.println( "\n-----------------------------");
     }

}//end class
