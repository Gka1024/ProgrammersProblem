package prj51;

public class prj051 { // 오랜만의 커밋입니다. 코로롱은 거의 회복한 듯 합니다.
	public static int skilltree(String skill, String[] skill_trees)
	{
		int count = 0;
		
		for(int i = 0; i < skill_trees.length; i++)
		{
			int learnCheckPointer = 0;
			boolean isCorrect = true;
			
			for(int j = 0; j < skill_trees[i].length(); j++)
			{
				if(skill.indexOf(skill_trees[i].charAt(j)) != -1)
				{
					if(skill.charAt(learnCheckPointer++) != skill_trees[i].charAt(j))
					{
						isCorrect = false;
						break;
					}
				}
			}
			
			if(isCorrect)
			{
				count++;
			}
			
		}
		
		return count;
	}
	
	public static void main(String[] args)
	{
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
	
		skilltree(skill, skill_trees);
		
	
	}
}
