import javax.swing.JPanel;				//This is used to hold the button on a panel which is added to the board
import java.awt.Color;					//This is used for the color of the background color of the panel
import javax.swing.JButton;				//Thi is used for the button itself
import java.awt.FlowLayout;				//The panel uses a flow layout
import java.awt.event.ActionListener;	//The action listener is used for the button
import java.awt.event.ActionEvent;		//The action event is for when the button is pressed
import javax.swing.JOptionPane;			//The instructions are displayed in dialog boxes
/*
*Created By : Brendon S. Service.
*Last Updated: 10/15/2015.
*/
public class GameInstructions extends JPanel
{
	
	private	JButton				instruc				=	null	;
	
	private	String				stepOne				=	null	;
	
	private	String				stepTwo				=	null	;
	
	private	String				stepThree			=	null	;
	
	private	String 				stepFour			=	null	;
	
	private	String				stepFive			=	null	;
	
	private	Color				pColor				=	null	;
		
	private	FlowLayout			layout				=	null	;
	
	public GameInstructions(){
		
		pColor				=			Color.BLUE;
		
		layout				=	new		FlowLayout();
		
		instruc				=	new		JButton(" Instructions! ");
		
		stepOne				=	"In order to Play you must know about Binary numbers in binary form, \n"+
								"Binary numbers are a number system based on 0's and 1's only, \n"+
								"Using these 0's and 1's you can make any possible number from 0 to infinity.";
					
		stepTwo				=	"Starting from right to left the numbers increment by powers of two, \n "+
								"The powers being applied start from 0 at the first digit on the right end. \n "+
								"Ex. 0000010 is equal to 2 in decimal form.";
					
		stepThree			=	"When there are many 1's in the binary set you add up each individual value \n "+
								"to find out how much that number adds up to. \n "+
								"Ex. 01010100, this number represents 0+64+0+16+0+4+0+0 which equals 84." ;
					
		stepFour			=	"You are initially given three minutes \n "+
								"to solve the decimal numbers in binary form.";
								
		stepFive			=	"Everytime you solve a decimal number in binary form, \n "+
								"Fifteen seconds will be added to the timer. \n "+
								"However, once time runs out, it's game over. ";
								
		try
		{
			if( (SecurityCheck.thisColor(pColor)) && SecurityCheck.thisFlow(layout) )
			{
				setLayout(layout);
				
				setBackground(pColor);
			}
		
			instruc.addActionListener(new InstructionSet());
		
		
			add(instruc);
		
			setVisible(true);

		}
		catch(Exception e)
		{
			System.out.print(" Instruction Error  "+e.getMessage());
		}
		
	}
	
	public class InstructionSet extends GameWindow implements ActionListener
	{
		public void actionPerformed(ActionEvent n)
		{
			try
			{
				
				
				fitScreen();
			
				if( (SecurityCheck.thisString(stepOne)) &&
					(SecurityCheck.thisString(stepTwo)) &&
					(SecurityCheck.thisString(stepThree)) &&
					(SecurityCheck.thisString(stepFour)) &&
					(SecurityCheck.thisString(stepFive)) )
				{
					JOptionPane.showMessageDialog(null, stepOne);
					JOptionPane.showMessageDialog(null, stepTwo);
					JOptionPane.showMessageDialog(null, stepThree);
					JOptionPane.showMessageDialog(null, stepFour);
					JOptionPane.showMessageDialog(null, stepFive);
				}
			}
			catch(Exception e)
			{
				System.out.println(" Instruction Button Error "+e.getMessage());
			}
		}
	}
}