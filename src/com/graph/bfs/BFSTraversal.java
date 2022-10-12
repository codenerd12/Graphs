package com.graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {
	
	public static void add(List<List<Integer>> adj, int u, int v) {
		adj.get(v).add(u);
		adj.get(u).add(v);
	}
	
	private static List<Integer> bfs(List<List<Integer>> adj, int source, boolean[] visited) {
		List<Integer> list = new ArrayList<Integer>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		
		visited[source] = true;
		
		while(!queue.isEmpty()) {
			
			Integer node = queue.poll();
			list.add(node);
			
			for(int u:adj.get(node)) {
				
				if(!visited[u]) {
					visited[u] = true;
					queue.add(u);
				}
				
			}
			
		}

		return list;
	}
	
	private static void bfsTraversal() {
		
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
		
		
		
		System.out.println(bfs(adj, source, visited));
		
	}

	public static void main(String[] args) {
		
		bfsTraversal();

	}

}
