package com.someteststuff;

import java.util.ArrayList;

public class GraphNode implements GNode {

	private String name;
	private ArrayList<GNode> children;

	public GraphNode(String name) {
		this.name = name;
		this.children = new ArrayList<GNode>();
	}

	public void addChild(GNode node) {
		this.children.add(node);
	}

	public String getName() {
		return this.name;
	}

	public GNode[] getChildren() {
		GNode[] neighbors = new GNode[this.children.size()];
		neighbors = this.children.toArray(neighbors);
		return neighbors;
	}
}