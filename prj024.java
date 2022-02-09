package prj24;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class prj024 {
	
	public static int[] report_result(String[] idarr, String[] reportarr, int k)
	{
		int[] answer = new int[idarr.length];
		
		HashMap<String, Set<String>> reportmap = new HashMap<>();
		HashMap<String, Integer> mailmap = new HashMap<>();
		
		for(int i = 0; i < idarr.length; i++)
		{
			reportmap.put(idarr[i], new HashSet<String>());
			mailmap.put(idarr[i], 0);
		}
		
		for(int i = 0; i < reportarr.length; i++)
		{
			String reporter = reportarr[i].split(" ")[0];
			String reported = reportarr[i].split(" ")[1];
			
			reportmap.get(reported).add(reporter);
		}
		
		for(int i = 0; i < idarr.length; i++)
		{
			if(reportmap.get(idarr[i]).size() >= k)
			{
				Iterator iter = reportmap.get(idarr[i]).iterator();
				
				while(iter.hasNext())
				{
					String id = (String) iter.next();
					mailmap.put(id, mailmap.get(id) + 1);
				}
			}
		}
		
		for(int i = 0; i < idarr.length;i++)
		{
			answer[i] = mailmap.get(idarr[i]);
		}
		
		return answer;
	}

	public static void main(String[] args) {

		String [] id_list = {"muzi", "frodo", "apeach", "neo"};
		String [] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		
		report_result(id_list, report, k);
		
	}

}
