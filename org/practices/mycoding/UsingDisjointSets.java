package org.practices.mycoding;

public class UsingDisjointSets {
	static int m[][] = 
		{{1,1,0},
         {1,1,0},
         {0,0,1}};

	static int m1[][] = 
		{{1,1,0},
		 {1,1,1},
		 {0,1,1}};
	
	static int m2[][] = 
		{{1,1,0,0,0},
  		 {1,1,1,0,0},
		 {0,1,1,0,0},
		 {0,0,0,1,1},
		 {0,0,0,1,1}};
	
	public static void main(String[] args) {
	
		findFriendCircles(m);
		findFriendCircles(m1);
		findFriendCircles(m2);
		

	}

	private static void findFriendCircles(int[][] m) {
		
		int n = m.length;
		int x, y;
		int [] parent = new int[n];
		
		for(int i = 0; i<n ; i++) {
			parent[i] = -1;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i != j && m[i][j] == 1) {
					x = findParent(i, parent);
					y = findParent(j, parent);
					
					if(x == y ) {
						continue;
					} else {
						union(parent, x, y);
					}
				}
			}
		}
		
		int numOfCircles = 0;
		for(int i=0; i<n; i++) {
			if(parent[i] < 0){
				numOfCircles++;
			}
			System.out.print(parent[i] + " ");
		}
		
		System.out.println("\nNumber of FriendCircles: " + numOfCircles);
	}

	private static void union(int[] parent, int x, int y) {
		if(parent[x] <= parent[y]) {
			parent[x] += parent[y];
			parent[y] = x;
		} else {
			parent[y] += parent[x];
			parent[x] = y;
		}
		
	}

	private static int findParent(int i, int[] parent) {
		while(parent[i] >= 0) {
			i = parent[i];
		}
		
		return i;
	}
}
