package chap16_GreedyAlgorithms;

import java.util.ArrayList;

/**
 * 16.2-4 Professor Water supplement problem. 
 * @author Xiuwei Zhu
 * ！！！！注意点： 注意某个补给点距离，正好等于totalDistance时的edge case。
 */
public class ProfessorWaterSupplement {
	
	/**
	 * constructor
	 * @param totalDistance	total travel distance
	 * @param m Professor can go m miles after each water supplement
	 */
	public ProfessorWaterSupplement(int totalDistance, int m){
		if(m < 0 || totalDistance < 0){
			System.out.println("m and totalDistance should be greater than 0");
			System.exit(1);
		}
		this.m = m;
		this.totalDistance = totalDistance;
	}
	private int totalDistance = 0;
	private int m = 0;
	
	
	/**
	 * @param map Distances between two WaterSuppliment points
	 */
	public void solution(int map[]){
		//first, turn map array to distance from start point array.
		ArrayList<Integer> a = new ArrayList<Integer>(map.length + 2);
		a.add(0);	//start point
		for (int i = 0; i < map.length; i++) 
			if(map[i] < totalDistance)
				a.add(map[i]);
		a.add(this.totalDistance);	//end point
		
		System.out.print("Supply water at: ");
		int nextMaxDisance = m;	//Next max instance professor can travel to with current water.
		for (int i = 0; i < a.size() - 1; i++) {
			if(a.get(i) == nextMaxDisance){
				System.out.print(a.get(i) + " ");
				nextMaxDisance = a.get(i) + m;
			}
			else if(a.get(i) < nextMaxDisance){
				if(a.get( i + 1) <= nextMaxDisance )
					continue;
				else{
					System.out.print(a.get(i) + " ");
					nextMaxDisance = a.get(i) + m;
				}
			}else{
				System.out.print("WaterSuppliment points too far, Professor can not make it.");
				break;
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ProfessorWaterSupplement p = new ProfessorWaterSupplement(25, 10);
		int[] map = {5, 8, 17, 24};	//8 17 
		p.solution(map);
		int[] map2 = {2, 3, 10, 13, 22, 25};	//10 13 22 
		p.solution(map2);
		int[] map3 = {10, 13, 22, 33};	//WaterSuppliment points too far, Professor can not make it.
		p.solution(map3);
		int[] map4 = {2, 3, 10, 15, 24};	//10 15
		p.solution(map4);
		int[] map5 = {2, 3, 10, 15, 25};	//10 15
		p.solution(map5);
		int[] map6 = {2, 3, 10, 15, 26};	//10 15
		p.solution(map6);
	}
}