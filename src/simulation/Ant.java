package simulation;

import java.util.Random;

import graph.Graphs;
import graph.Path;
import graph.Paths;

public class Ant {
	
	private static float alpha;
	private static float beta;
	
	private int id;
	Paths path;
	
	public Ant(int id, int nest, Graphs graph) {
		super();
		this.id = id;
		this.path = new Path(graph);
		path.insertWaypoint(nest);
	}
	
	public int returnID() {
		return id;
	}
	
	public int chooseNext(Paths path, Graphs graph) {
		
		Random r =	new Random();
		double f = r.nextDouble();
		double comul = 0;
		
		int cur = path.getLast();
		boolean unvisited = false;
		// set of adjacent nodes
		int[] j = graph.returnEdges(cur);
		
		double[] p = new double[j.length];
		double ci = 0;
		boolean[] visited = new boolean[j.length];
		
		// find whether visited before or not
		for (int i = 0; i < j.length; i++) {
			if ( path.findWaypoint(j[i]) )
				visited[i] = true;
			else {
				visited[i] = false;
				unvisited = true;
			}
		}
		if (!unvisited) {
			//all adjacents have already been visited
			double uniformBinEdge = 1.0 / j.length;
			return j[(int)(f/uniformBinEdge)];					
		}
		else {
			int i;
			for (i = 0 ; i < j.length ; i++) {
				if (!visited[i]) {
					// calculates cij and sums ci
					p[i] = (alpha + graph.getEdgePayload(cur,j[i]))/(beta + graph.getEdgeWeight(cur, j[i]));
					ci+= p[i];
				}
			}
			// calculates pij
			for (i = 0; i < p.length;i++) {
				p[i] = p[i] / ci;
			}
			// choose next node
			for ( i = 0; i < j.length; i++) {
				comul += p[i];
				if (f <= comul)
					return j[i];
			}
			// sum of p likely < 1: exception here
			return -1;
		}
	}
	
	public static float getAlpha() {
		return alpha;
	}

	public static void setAlpha(float alpha) {
		Ant.alpha = alpha;
	}

	public static float getBeta() {
		return beta;
	}

	public static void setBeta(float beta) {
		Ant.beta = beta;
	}

	public Paths getPath() {
		return path;
	}

	public void setPath(Paths path) {
		this.path = path;
	}
	
	
		
}
