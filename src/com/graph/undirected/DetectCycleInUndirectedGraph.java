package com.graph.undirected;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInUndirectedGraph {
	
	static class Pair {
		int node;
		int parent;
		
		Pair(int node, int parent) {
			this.node = node;
			this.parent = parent;
		}
	}
	
	public static void add(List<List<Integer>> adj, int u, int v) {
		adj.get(v).add(u);
		adj.get(u).add(v);
	}
	
	private static boolean detectCycle() {
		
		int V = 7;
		int source = 1;
		
		List<List<Integer>> adj = new ArrayList<>();
		
		for(int i=0;i<=V;i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		add(adj, 1, 2);
		add(adj, 1, 3);
		add(adj, 2, 5);
		add(adj, 3, 4);
		add(adj, 3, 6);
		add(adj, 5, 7);
		add(adj, 6, 7);
		
		boolean[] visited = new boolean[V+1];
		
		
		
		return bfs(adj, source, visited);
	}

	private static boolean bfs(List<List<Integer>> adj, int source, boolean[] visited) {
		
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(source, -1));
		visited[source] = true;
		
		while(!queue.isEmpty()) {
			
			Pair pair = queue.poll();
			int node = pair.node;
			int parent = pair.parent;
			
			for(int u:adj.get(node)) {
				
				if(!visited[u]) {
					visited[u] = true;
					queue.add(new Pair(u, node));
				} else if(visited[u] && parent != u) {
					
					return true;
				}
				
			}
			
		}
		
		
		return false;
	}

	public static void main(String[] args) {
		
		System.out.println(detectCycle());

	}

}
