package test;

import java.util.ArrayList;

import com.someteststuff.GNode;
import com.someteststuff.GraphNode;
import com.someteststuff.GraphNodeFunctions;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WalkGraphTest {

	String[] names = {
		"IAMBASE",
		"first",
		"second",
		"third",
		"fourth",
		"fifth",
		"sixth"
	};

	@Test
	public void testWalkGraphFunction() {
		String tempname = names[0];
		GraphNode base = new GraphNode(tempname);
		ArrayList<GNode> result = GraphNodeFunctions.walkGraph(base);
		assertTrue(result.size() == 1);
		assertTrue(result.get(0).getName().equals(tempname));

		//add 3 children to base
		GraphNode first = new GraphNode(names[1]);
		base.addChild(first);
		base.addChild(new GraphNode(names[2]));
		GraphNode third = new GraphNode(names[3]);
		base.addChild(third);
		result = GraphNodeFunctions.walkGraph(base);
		assertTrue(result.size() == 4);
		assertTrue(result.get(0).getName().equals(names[0]));
		assertTrue(result.get(1).getName().equals(names[1]));
		assertTrue(result.get(2).getName().equals(names[2]));
		assertTrue(result.get(3).getName().equals(names[3]));

		//add 2 children to first
		first.addChild(new GraphNode(names[4]));
		first.addChild(new GraphNode(names[5]));
		//add 1 child to third
		third.addChild(new GraphNode(names[6]));
		result = GraphNodeFunctions.walkGraph(base);
		assertTrue(result.size() == 7);
		assertTrue(result.get(0).getName().equals(names[0]));
		assertTrue(result.get(1).getName().equals(names[1]));
		assertTrue(result.get(2).getName().equals(names[4]));
		assertTrue(result.get(3).getName().equals(names[5]));
		assertTrue(result.get(4).getName().equals(names[2]));
		assertTrue(result.get(5).getName().equals(names[3]));
		assertTrue(result.get(6).getName().equals(names[6]));
	}
}