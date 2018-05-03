// Aaron Li
// APCS2 pd8
// HW44 -- Prune Your Tree
// 2018-05-02

/*****************************************************
* class BST - v1:partial
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

          if ( _root == null ) {
               _root = newNode;
               return;
          }
          insert( _root, newNode );
     }
     //recursive helper for insert(int)
     public void insert( TreeNode stRoot, TreeNode newNode )
     {
          if ( newNode.getValue() < stRoot.getValue() ) {
               //if no left child, make newNode the left child
               if ( stRoot.getLeft() == null )
               stRoot.setLeft( newNode );
               else //recurse down left subtree
               insert( stRoot.getLeft(), newNode );
               return;
          }
          else { // new val >= curr, so look down right subtree
               //if no right child, make newNode the right child
               if ( stRoot.getRight() == null )
               stRoot.setRight( newNode );
               else //recurse down right subtree
               insert( stRoot.getRight(), newNode );
               return;
          }
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
          if ( currNode == null ) //stepped beyond leaf
          return;
          System.out.print( currNode.getValue() + " " );
          preOrderTrav( currNode.getLeft() );
          preOrderTrav( currNode.getRight() );
     }

     //recurse left, process root, recurse right
     public void inOrderTrav()
     {
          inOrderTrav( _root );
     }
     public void inOrderTrav( TreeNode currNode )
     {
          if ( currNode == null ) //stepped beyond leaf
          return;
          inOrderTrav( currNode.getLeft() );
          System.out.print( currNode.getValue() + " " );
          inOrderTrav( currNode.getRight() );
     }

     //recurse left, recurse right, process root
     public void postOrderTrav()
     {
          postOrderTrav( _root );
     }
     public void postOrderTrav( TreeNode currNode )
     {
          if ( currNode == null ) //stepped beyond leaf
          return;
          postOrderTrav( currNode.getLeft() );
          postOrderTrav( currNode.getRight() );
          System.out.print( currNode.getValue() + " "  );
     }

     //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
     //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


     /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
     TreeNode search( int target )
     {
          return search(_root, target);
     }

     TreeNode search(TreeNode currNode, int target) {
          if (currNode != null && currNode.getValue() == target) return currNode;
          else if(currNode == null) return null;

          if (target < currNode.getValue()) {
               if (currNode.getLeft() != null) return search(currNode.getLeft(), target);
               else return null;
          } else {
               if (target >= currNode.getValue()) {
                    if (currNode.getRight() != null) return search(currNode.getRight(), target);
                    else return null;
               }
          } return currNode;
     }

     /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 0
     *****************************************************/
     public int height()
     {
          return height(_root);
     }

     public int height(TreeNode currNode) {
          if (currNode == null) return -1;
          if (height(currNode.getLeft()) > height(currNode.getRight())) return height(currNode.getLeft()) + 1;
          else return height(currNode.getRight()) + 1;
     }


     /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
     public int numLeaves()
     {
          return numLeaves(this._root);
     }

     public int numLeaves(TreeNode currNode) {
          // base case: if node is null, return 0
          if (currNode == null) return 0;
          // base case: node is a leaf, return 1
          if (currNode.getLeft() == null && currNode.getRight() == null) return 1;
          // otherwise, return the recursive calls of the left and right subtrees
          return numLeaves(currNode.getLeft()) + numLeaves(currNode.getRight());
     }

     public void remove(int val) {
          remove(_root, val);
     }

     public void remove(TreeNode currNode, int val) {
          if (numLeaves(currNode) == 1 && currNode.getLeft().getValue() == val) {
               currNode.setLeft(null);
               return;
          } else if (numLeaves(currNode) == 1 && currNode.getRight().getValue() == val) {
               currNode.setRight(null);
               return;
          } else if (currNode.getLeft().getLeft() != null && currNode.getLeft().getRight() == null && currNode.getLeft().getValue() == val) {
               currNode.setLeft(currNode.getLeft().getLeft());
               return;
          } else if (currNode.getLeft().getRight() != null && currNode.getLeft().getLeft() == null && currNode.getRight().getValue() == val) {
               currNode.setLeft(currNode.getLeft().getRight());
               return;
          } else if (currNode.getLeft().getLeft() != null && currNode.getLeft().getRight() != null && currNode.getLeft().getValue() == val) {
               TreeNode temp = new TreeNode();
               temp = currNode;
               while (numLeaves(temp.getRight()) == 0) {
                    temp = temp.getRight();
               } _root = temp.getRight();
               _root.setLeft(temp.getLeft());
               _root.setRight(null);
          } else if (currNode.getLeft().getLeft() != null && currNode.getLeft().getRight() != null && currNode.getRight().getValue() == val) {
               TreeNode temp = new TreeNode();
               temp = currNode;
               while (numLeaves(temp.getRight()) == 0) {
                    temp = temp.getRight();
               } _root = temp.getRight();
               _root.setLeft(temp.getLeft());
               _root.setRight(null);
          } remove(currNode.getLeft(), val);
          remove(currNode.getRight(), val);
     }


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

          System.out.println(arbol.search(6).getValue()); // should be 6
          System.out.println(arbol.numLeaves()); // should be 3
          System.out.println(arbol.height()); // shoud be 3

     }

}//end class
