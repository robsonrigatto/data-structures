package br.com.rr.datastructure.domain;

import br.com.rr.datastructure.domain.domain.Tree;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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
	void addTest() {


	}

}
