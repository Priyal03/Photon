package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFS {

	private int V;
	private LinkedList<Integer> adj[];
	
	public DFS(int v) {
		
		V=v;
		adj=new LinkedList[v]; //Creating rows
		
		for(int i=0;i<v;i++) {
			adj[i]=new LinkedList<>();
		}
	}
	
	public static void main(String[] args) {

		DFS g = new DFS(4);
		
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        
        g.dfs(2);
        System.out.println();
        g.bfs(2);
	}


	private void bfs(int v) {
		
		LinkedList<Integer> stack = new LinkedList<Integer>(); 
		boolean visited[]=new boolean[V];
		
		stack.add(v);
		visited[v]=true;
		
		while(stack.size()!=0) {
			
			int now = stack.remove();
			System.out.print(now+" ");
			
			Iterator<Integer> it = adj[now].listIterator();
			
			while(it.hasNext()) {
				
				int n=it.next();
				
				if(!visited[n]) {
					
					stack.add(n);
					visited[n]=true;
				}
			}
		}
		
	}

	private void dfs(int v) {

		boolean visited[]=new boolean[V];
		
		DFSUtil(v,visited);
	}


	private void DFSUtil(int v, boolean[] visited) {
		
		visited[v]=true;
		System.out.print(v+" ");

		Iterator<Integer> it = adj[v].listIterator();
		
		while(it.hasNext()) {
			
			int n=it.next();
			
			if(!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}



	private void addEdge(int v, int w) {
		adj[v].add(w);
	}

}
