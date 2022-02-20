package prj34;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class prj034 {
	public static int bridge_cross(int len, int wei, int[] truck)
	{
		int pointer = 0, outpointer = 0;
		Queue<Integer> bridge = new LinkedList<>();
		HashMap<Integer, Integer> out = new HashMap<>();
		int truckWeight = 0;
		int time = 0;
		
		while(true)
		{
			time++;
			
			System.out.println("시간 : "+time);
			
			if(!bridge.isEmpty())
			{
				if(out.get(outpointer) == time)
				{
					bridge.poll();
					System.out.println(truck[outpointer] + "통과" );
					truckWeight -= truck[outpointer];
					outpointer++;
				}
			}
			
			if(pointer < truck.length)
			{
				if(truckWeight + truck[pointer] <= wei)
				{
					bridge.add(truck[pointer]);
					System.out.println(truck[pointer] + "진입" );
					out.put(pointer, time + len);
					truckWeight += truck[pointer];
					System.out.println("p : "+pointer+ " -> "+ (pointer + 1));
					pointer++;
				}
			}
			
			if(outpointer == truck.length)
			{
				break;
			}
			System.out.println();
		}
		
		return 0;
	}
	 
	public static void main(String[] args)
	{
		int bridge_length = 5;
		int weight = 5;
		int[] truck_weights = {2, 2, 2, 2, 1, 1, 1, 1, 1};
		
		bridge_cross(bridge_length, weight, truck_weights);
	}
}
