package org.practices.mycoding;

import java.util.ArrayList;
import java.util.List;

public class FriendsCircleUsingBFS {

	static int m[][] = {{1,1,0},
	             {1,1,0},
	             {0,0,1}};
	
	static int m1[][] = {{1,1,0},
        {1,1,1},
        {0,1,1}};
	
	static int m2[][] = 
		{{1,1,0,0,0},
         {1,1,1,0,0},
         {0,1,1,0,0},
         {0,0,0,1,1},
         {0,0,0,1,1}};
	
	public static void main(String[] args) {
		
		findNumberOfFriendCircles(m);
		findNumberOfFriendCircles(m1);
		findNumberOfFriendCircles(m2);

	}

	private static void findNumberOfFriendCircles(int[][] m) {
		int x = m.length;
		boolean found = false;
		
		List<List<Integer>> queue= new ArrayList<>();
		List<Integer> temp = null;
		
		for(int i=0; i < x; i++) {
			for(int j=0; j <x; j++) {
				if(i != j) {
					if(m[i][j] == 1) {
						int n = 0;
						found = false;
						while(n < queue.size()) {
							temp = queue.get(n);
							if(temp.contains(j)) {
								found = true;
								break;
							} 
							n++;
						}
						if(!found) {
							temp.add(j);
						}						
					}	
					
				} else {
					if(queue.size() == 0) {
						temp = new ArrayList<>();
						temp.add(i);
						queue.add(temp);
					} else {
						int n = 0;
						found = false;
						while(n < queue.size()) {
							temp = queue.get(n);
							if(temp.contains(j)) {
								found = true;
								break;
							} 
							n++;
						}
						if(!found) {
							temp = new ArrayList<>();
							temp.add(i);
							queue.add(temp);
						}
					}
				}
			}
			
		}
		
		System.out.println("numOfCircles: " + queue.size());
		
		for(int i=0; i < queue.size(); i++) {
			System.out.println(queue.get(i));
		}
		
				
	}

	/*private static void dfs(int i, int[][] m, List<LinkedList<Integer>> queue, Set<Integer> visited) {
		int n = 0;
		while(n < m.length) {
			
			if(m[i][n] == 1 && visited.contains(m[i][n])){
				
			}
			
			n++;
		}
		
	}*/
	
	

}
