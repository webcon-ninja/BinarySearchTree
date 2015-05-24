import static org.junit.Assert.assertEquals;

public class BinarySearchTree<E extends Comparable<E>> {

  private class TreeNode {
    private E data;
    private TreeNode left;
    private TreeNode right;

    TreeNode(E theData) {
      data = theData;
      left = null;
      right = null;
    }

  }

  private TreeNode root;

  /**
   * Construct an empty tree
   */
  public BinarySearchTree() {
    // TODO 1: Rick hard codes the BST shown in presentation. With your help of course
    //    root = new TreeNode((E) new Integer(50));
    //    root.left = new TreeNode((E) new Integer(25));
    //    root.left.left = new TreeNode((E) new Integer(12));
    //    root.left.right = new TreeNode((E) new Integer(36));
    //    root.right = new TreeNode((E) new Integer(75));
    //    root.right.left = new TreeNode((E) new Integer(65));
    //    root.right.right = new TreeNode((E) new Integer(90));
  }

  /**
   * Return a textual representation of this BST where the toString version of
   * all elements concatenated into one string with blank separators.
   * 
   * @return A textual representation of this BST with elements in order.
   */
  public String toString() {
    if (root == null)
      return "";
    else
      return toString(root).trim();
  }

  private String toString(TreeNode t) {
    if (t == null)
      return "";
    else
      return toString(t.left) + t.data + " " + toString(t.right);
  }

  /**
   * Return true if the element is in this BST or false if element is not in
   * this BST.
   */
  public boolean exists(E element) {
    TreeNode currentNode = root;
    while (currentNode != null) {
      if (currentNode.data.equals(element))
        return true;
      else if (element.compareTo(currentNode.data) < 0)
        currentNode = currentNode.left;
      else
        currentNode = currentNode.right;
    }
    return false;
  }

  // A long solution that follows Rick's algorithm on the slides
  public void insert(E newElement) {
    root = insert(newElement, root);
    // root -->  50
    //          /  \
    //        25   65
    //        /
    //      12
  }

  private TreeNode insert(E newElement, TreeNode t) {
    if (t == null)
      return new TreeNode(newElement);
    else if (newElement.compareTo(t.data) < 0) {
      t.left = insert(newElement, t.left);
    } else {
      t.right = insert(newElement, t.right);
    }
    return t;
  }

  public BinarySearchTree<E> allThoseLessThan(E value) {
    BinarySearchTree<E> result = new BinarySearchTree<E>();
    gatherAll(root, value, result);
    return result;
  }

  private void gatherAll(TreeNode t, E value, BinarySearchTree<E> result) {
    if (t == null)
      return;
    else {
      gatherAll(t.left, value, result);
      // process the node
      if (t.data.compareTo(value) < 0)
        result.insert(t.data);
      gatherAll(t.right, value, result);
    }

  }
  public boolean remove(E element) {
	  TreeNode curr = root;
	  TreeNode prev = root;
	  return remove(element, curr, prev);
  }
  private boolean remove (E element, TreeNode curr, TreeNode prev){
	  if(curr == null) // (1)
		  return false;
	  if(curr.data.equals(element)) {//(2) 
		//Case 1: If current is a leaf
		  if(curr.left == null && curr.right == null) { 
			  if(curr == prev.left) 
				  prev.left = null;
		  
		  	  else if(curr == prev.left)
		  		  prev.right = null;
		  }
		//Case 2: If current has one child
		  if(curr.right == null && curr.left != null) //Only a left child
			  prev.left = curr.left;
		  else if(curr == prev.right)
			  prev.right = curr.left;
		  if(curr.left == null && curr.right != null){
			  if(curr == prev.left)
				  prev.left = curr.right;
			  else if(curr == prev.right)
				  prev.right = curr.right;
		  }
		//Case 3: If current has 2 children
		  if(curr.left != null && curr.right != null){ 
			  TreeNode leftSubtree = curr.left;
			  TreeNode max;
				if(leftSubtree.left.data.compareTo(leftSubtree.right.data) < 0)
					max = leftSubtree.left;
				else //if(leftSubtree.left.data.compareTo(leftSubtree.right.data) > 0)
					max = leftSubtree.right;
				curr = max;
				remove(leftSubtree.data, curr, prev);	  
		  }
	  }
	  //(3)
		  if(curr.data.compareTo(element) != 0){
			  if(element.compareTo(curr.data) < 0){
				  prev = curr;
			  curr = curr.left;
			  }
			  else if(element.compareTo(curr.data) > 0){
				  prev = curr;
				  curr = curr.right;
			  }
		  }
	 //(4)
		  if(curr.equals(root) && curr.data.equals(element)){
			  if(root.left == null && root.right == null){
				  root = null;
			  }
			  else if(root.left == null || root.right == null){
				  if(root.left == null)
					  root = root.right;
				  else
					  root = root.left;
			  }
			  else if(root.left != null && root.right!= null){
				  TreeNode leftSubtree = curr.left;
				  TreeNode max;
					if(leftSubtree.left.data.compareTo(leftSubtree.right.data) < 0)
						max = leftSubtree.left;
					else //if(leftSubtree.left.data.compareTo(leftSubtree.right.data) > 0)
						max = leftSubtree.right;
					curr = max;
					remove(leftSubtree.data, curr, prev);	
			  }
		  }
		return true;  
  }
}
































