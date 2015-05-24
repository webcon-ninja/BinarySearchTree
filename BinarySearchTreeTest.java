import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest {

  @Test
  public void testGetWhenFound() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
    bst.insert(12);
    bst.insert(25);
    bst.insert(36);
    bst.insert(50);
    bst.insert(65);
    bst.insert(75);
    bst.insert(90);
    assertEquals("12 25 36 50 65 75 90", bst.toString());
  }

  @Test
  public void testExistsWhenFound() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
    bst.insert(12);
    bst.insert(25);
    bst.insert(36);
    bst.insert(50);
    bst.insert(65);
    bst.insert(75);
    bst.insert(90);
    assertTrue(bst.exists(12));
    assertTrue(bst.exists(25));
    assertTrue(bst.exists(36));
    assertTrue(bst.exists(50));
    assertTrue(bst.exists(65));
    assertTrue(bst.exists(75));
    assertTrue(bst.exists(90));
  }

  @Test
  public void testExistsWhenNotFound() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
    bst.insert(12);
    bst.insert(25);
    bst.insert(36);
    bst.insert(50);
    bst.insert(65);
    bst.insert(75);
    bst.insert(90);
    assertFalse(bst.exists(7));
    assertFalse(bst.exists(48));
    assertFalse(bst.exists(91));
  }

  @Test
  public void testAllThoseLessThan() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
    bst.insert(6);
    bst.insert(3);
    bst.insert(4);
    bst.insert(1);
    bst.insert(2);
    bst.insert(5);
    assertEquals("1 2 3 4 5 6", bst.toString());

    BinarySearchTree<Integer> result = bst.allThoseLessThan(4);
    assertEquals("1 2 3", result.toString());

    BinarySearchTree<Integer> result2 = bst.allThoseLessThan(7);
    assertEquals("1 2 3 4 5 6", result2.toString());

    BinarySearchTree<Integer> result3 = bst.allThoseLessThan(2);
    assertEquals("1", result3.toString());

    BinarySearchTree<Integer> result4 = bst.allThoseLessThan(1);
    assertEquals("", result4.toString());

  }
}