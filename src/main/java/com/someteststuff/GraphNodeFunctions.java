package com.someteststuff;

import java.util.ArrayList;
import java.util.Stack;

public class GraphNodeFunctions {

	private GraphNodeFunctions() {} // do not allow instantiation

	public static ArrayList<GNode> walkGraph(GNode node) {
		ArrayList<GNode> nodelist = new ArrayList<GNode>();
		walkGraphImpl(node, nodelist);
		return nodelist;
	}

	private static ArrayList<GNode> walkGraphImpl(GNode node, ArrayList<GNode> nodelist) {
		nodelist.add(node);
		GNode[] children = node.getChildren();
		for (GNode child: children) {
			walkGraphImpl(child, nodelist);
		}
		return nodelist;
	}

	public static ArrayList<ArrayList<GNode>> paths(GNode node) {
		ArrayList<ArrayList<GNode>> graphpaths = new ArrayList<ArrayList<GNode>>();
		Stack<GNode> stackpath = new Stack<GNode>();
		pathsImpl(node, graphpaths, stackpath);
		return graphpaths;
	}

	private static ArrayList<ArrayList<GNode>> pathsImpl(GNode node, ArrayList<ArrayList<GNode>> graphpaths, Stack<GNode> stackpath) {
		stackpath.push(node);
		GNode[] children = node.getChildren();
		if (children.length == 0) {
			ArrayList<GNode> graphpath = new ArrayList<GNode>();
			for (GNode item: stackpath) {
				graphpath.add(item);
			}
			graphpaths.add(graphpath);
			stackpath.pop();
		} else {
			for (GNode child: children) {
				pathsImpl(child, graphpaths, stackpath);
			}
			stackpath.pop();
		}
		return graphpaths;
	}
}