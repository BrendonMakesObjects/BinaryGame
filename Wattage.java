/*
*Created By : Brendon S. Service.
*Last Updated: 10/15/2015.
*/
public class Wattage
{
	public static void main (String[] args)
	{
		GameBoard GB		=	null	;
		
		try
		{
			GB = new GameBoard();
		}
		catch(Exception e)
		{
			System.out.println(" Main Error "+e.getMessage()+"\n"+e.getStackTrace()+"\n"+"\n"+e.toString());
		}
	}
}