package br.com.rr.datastructure.domain;

import br.com.rr.datastructure.domain.domain.Tree;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TreeTest {

	@Test
	public void findTest() {
		Tree tree = new Tree(4);
		tree.add(5);
		tree.add(6);
		tree.add(3);

		assertNotNull(tree.find(4));
		assertNotNull(tree.find(5));
		assertNotNull(tree.find(6));
		assertNotNull(tree.find(3));
		assertNull(tree.find(7));
	}

	@Test
	public void sizeTest_balanced() {

		Tree tree = new Tree(4);
		tree.add(2); tree.add(1); tree.add(3);
		tree.add(6); tree.add(5); tree.add(7);

		assertEquals(3, tree.getSize());
	}

	@Test
	public void sizeTest_unbalanced() {

		Tree tree = new Tree(4);
		tree.add(2); tree.add(1); tree.add(3);
		tree.add(6);

		assertEquals(3, tree.getSize());
	}

	@Test
	public void sizeTest_allInOneSide() {

		Tree tree = new Tree(4);
		tree.add(3); tree.add(2); tree.add(1);

		assertEquals(4, tree.getSize());
	}

	@Test
	public void getMinTest_root() {
		Tree tree = new Tree(4);
		assertEquals(4, tree.getMin());
	}

	@Test
	public void getMinTest_balanced() {
		Tree tree = new Tree(4);
		tree.add(2); tree.add(1); tree.add(3);
		tree.add(6); tree.add(5); tree.add(7);
		assertEquals(1, tree.getMin());
	}

	@Test
	public void removeTest_root() {
		Tree tree = new Tree(4);
		tree.add(2); tree.add(1); tree.add(3);
		tree.add(6); tree.add(5); tree.add(7);

		tree.remove(4);
		assertEquals(5, tree.getRoot().getValue());
		assertNull(tree.find(4));
	}

	@Test
	public void removeTest_left() {
		Tree tree = new Tree(4);
		tree.add(2); tree.add(1); tree.add(3);
		tree.add(6); tree.add(5); tree.add(7);

		tree.remove(1);
		assertEquals(4, tree.getRoot().getValue());
		assertNull(tree.find(1));
	}

	@Test
	public void removeTest_leftSubTreeWithParentAndChildren() {
		Tree tree = new Tree(4);
		tree.add(2); tree.add(1); tree.add(3);
		tree.add(6); tree.add(5); tree.add(7);

		tree.remove(2);
		assertEquals(4, tree.getRoot().getValue());
		assertEquals(3, tree.getRoot().getLeft().getValue());
		assertNull(tree.find(2));
	}

	@Test
	public void removeTest_rightSubTreeWithParentAndChildren() {
		Tree tree = new Tree(4);
		tree.add(2); tree.add(1); tree.add(3);
		tree.add(6); tree.add(5); tree.add(7);

		assertEquals("1 3 2 5 7 6 4", tree.printPostOrder());

		tree.remove(6);
		assertEquals(4, tree.getRoot().getValue());
		assertEquals(7, tree.getRoot().getRight().getValue());
		assertNull(tree.find(6));

		assertEquals("1 3 2 5 7 4", tree.printPostOrder());
	}

	@Test
	public void printTest() {
		Tree tree = new Tree(4);
		tree.add(2); tree.add(1); tree.add(3);
		tree.add(6); tree.add(5); tree.add(7);

		assertEquals("1 2 3 4 5 6 7", tree.print());
	}

}
