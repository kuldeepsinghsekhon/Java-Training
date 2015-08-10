package string;

public class StringOrdering {
	static String name[] = {"Krishan","prince","sunny","lucky"};
	public static void main(String[]args)
	{
		int size = name.length;
		String free = null;
		for(int i =0;i<size;i++)
		{
			for(int j =i+1;j<size;j++)
			{
				if(name[j].compareTo(name[i])<0)
				{
					free =name [i];
					name[i] = name[j];
					name[j]= free;
					
				}
			}
			System.out.println(name[i]);
		}
		
		
		
	}

}
