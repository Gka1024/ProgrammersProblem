package prj3;
//https://programmers.co.kr/learn/courses/30/lessons/60057
public class main {

	public static void main(String[] args) {
		String s =  "baabcdcdababcdcd";
		// 4abcdedededed
		String temps = s;
		
	
		int stringLength = temps.length();
		
		for(int i  = 1; i < s.length()/2 + 1; i++)
		{ // i�� ������ ���̷� ���� - ����: ������ �ǹ���
			temps = s;
			for(int j = 0; j < temps.length()+1 - (i * 2); j = j+ i)
			{ // j�� ������ ���� �ε����� ����
				String stringUnit = temps.substring(j , j+ i);
				System.out.println("unit : "+stringUnit);
				
				String stringRemain = temps.substring(j + i,j+i+i);
				// remain�� ���� ������ ���ָ�ŭ�� ���ڿ��� �ǹ�.
				System.out.println("remain : "+stringRemain);
				System.out.println("temps : "+temps);
				
				if(stringUnit.matches(stringRemain))
				{ // ���� ���ְ� �������� ���ٸ�
					int count = 1; // �ݺ� Ƚ��
					while(stringUnit.matches(stringRemain))
					{
						System.out.println(count++);
						temps = temps.substring(0,j) + temps.substring(j, j+i) + temps.substring(j + i + i);
						// tempstring�� (���� �������� ���� ���ڿ�)+ (����) + (������ ������ ���ڿ�) => (������ ����)
						if(j + i + i >temps.length())
						{ //������ ������ ���ڿ��� ������ ���̺��� ª�ٸ�
							break;
						}
						stringRemain = temps.substring(j + i,j+i+i);
						//������ �缳��
					}
					System.out.println(count); 
					System.out.println("remain : "+stringRemain);
					temps = temps.substring(0,j) +count+ temps.substring(j);
					System.out.println("temps : "+temps);
					j = j + (int)(Math.log10(count)+1); 
					// ���ڰ� temps�� ���Ƿ�, ������ �ڸ�����ŭ j�� �ű�� �۾�
				}
				
				if(temps.length() < stringLength)
				{ // ���� temps �� ���̰� ���� ���ڿ��� ���̺��� ª��
					stringLength = temps.length();
					System.out.println("changed!" + temps);
				}
				System.out.println(" ");
			}
			
		}
		
		System.out.println(stringLength);
	}
}

/* take1 - temps = temps.substring(0,j) + repeatNum + stringUnit + temps.substring(j+i);

String stringUnit = temps.substring(pointer, i+ 1);
System.out.println("sun : "+stringUnit);

String stringRemain = temps.substring(stringUnit.length());
System.out.println("sre : "+stringRemain);

if(stringUnit.matches(stringRemain.substring(0,stringUnit.length())))
{
	int repeatNum = 1;
	while(true)
	{
		if(stringUnit.matches(stringRemain.substring(0,stringUnit.length())))
		{
			stringRemain = stringRemain.substring(stringUnit.length());
			repeatNum++;
			System.out.println(repeatNum + "  " + stringRemain);
		}
		else
		{
			temps = repeatNum + stringUnit + stringRemain;
			System.out.println("tmp : " + temps);
			pointer = pointer + 1 + stringUnit.length(); 
			break;
		}
		
	}
}*/
		
		/* take2
		if(stringUnit.length() > stringRemain.length())
		{
			break;
		}
		if(stringUnit.matches(stringRemain.substring(0,stringUnit.length())))
		{
			int repeatNum = 1;
			while(true)
			{
				if(stringRemain.length()!= 0)
				{
					if(stringUnit.matches(stringRemain.substring(0,stringUnit.length())))
					{
						stringRemain = stringRemain.substring(stringUnit.length());
						repeatNum++;
						System.out.println(repeatNum + "-" + stringRemain);
					}
					else
					{
						temps = temps.substring(0,i)+ repeatNum + stringUnit + stringRemain;
						System.out.println("tmp : " + temps);
						i++;
						break;
					}
				}
				else
				{
					temps = temps.substring(0,i)+ repeatNum + stringUnit + stringRemain;
					System.out.println("tmp : " + temps);
					i++;
					break;
				}
				
			}
			break;
		}
	}
}
		*/