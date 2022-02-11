package prj26;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class prj026 {

	public static int printer(int [] array, int location)
	{
		int pointer = location;
		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> prQueue = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0; i < array.length; i++)
		{
			queue.add(array[i]);
			prQueue.add(array[i]);
		}
		
		while(true)
		{
			if(queue.peek() != prQueue.peek())
			{ // 큐의 첫번째가 최댓값과 다르다면
				queue.add(queue.poll());
			}
			else // 같다면
			{
				if(pointer == 0)
				{
					return ++count;
				}
				queue.poll();
				prQueue.poll();
				count++;
			}
			
			if(--pointer < 0)
			{
				pointer = queue.size() - 1;
			}
		}
	}
	
	
	public static void main(String[] args)
	{
		int [] priorities = {5, 4, 9, 8, 7, 6};
		int location = 1;
		
		printer(priorities, location);
	}
}
