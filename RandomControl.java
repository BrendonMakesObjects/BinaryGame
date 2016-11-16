/**
*
*This Program is intended to make
*Random numbers be random each time
*the variable they are stored in is
*called more than once.
*
*
*
*Created By: Brendon S. Service.
**/
public class RandomControl
{
	private			int			numStorage[], sna[];
	private			String		display	=	null;
	private static	int 		counted = 0;
	
	public RandomControl(int MAXSTORAGE)
	{
		sna = new int[MAXSTORAGE];
		
		numStorage = new int[MAXSTORAGE];
	}
	public void setStorageNums(int added, int sub)
	{
		numStorage[sub] = added;
	}
	public boolean isFull()
	{
		boolean full = true;
		
		for(int f = 0;f<numStorage.length;f++)
		{
			if(numStorage[f] != 0)
			{
				full = false;
			}
			else if(numStorage[f] == 0)
			{
				full = true;
			}
		}
		return full;
	}
	public void addToStorage(int add)
	{
		if ( (SecurityCheck.thisPosInteger(add)) )
		{
			setStorageNums(add, counted);
			counted++;
		}
	}
	public boolean compareNum(int currentNum)
	{
		for(int i = 0; i < counted ; i++)
		{
			if(numStorage[i] == currentNum)
			{
				return false;
			}
		}
		return true;
	}
	public void displayNumbers()
	{
		for(int d = 0; d < numStorage.length; d++)
		{
			System.out.println(numStorage[d]);
		}
	}
	public int getStorageLength()
	{
		int counter = 0;
		sna = numStorage;
		for(int c = 0; c < numStorage.length; c++)
		{
			if(numStorage[c] != 0)
			{
				counter++;
			}
		}
		return counter;
	}
	public String toString()
	{
		String str = "There are "+getStorageLength()+ " Number(s)";
		
		return (SecurityCheck.thisString(str))? str : null;
	}
}