import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/*
*Created By: Brendon S. Service.
* Last Updated: 10/26/2015.
*/
public class GameWindow extends JFrame
{	
	
	private	FlowLayout			flowPanel		=	null	;
	
	private	GameInstructions	GInstructions	=	null	;
		
	private	Color				basePanelColor	=	null	;
		
	private	String				welcomeMessage	=	null	;
	
	private	Color				topColor		=	null	;
	
	private	JPanel				topPanel		=	null	;
	
	public GameWindow() {}
	
	public GameWindow(String title, int width, int height)
	{
		
		try
		{			
			basePanelColor		=	Color.CYAN;
			
			flowPanel		=	new	FlowLayout(85);
						
			SwingUtilities.updateComponentTreeUI(this);

			if( ( SecurityCheck.thisString(title)) && ( SecurityCheck.thisPosInteger(width)) && ( SecurityCheck.thisPosInteger(height)) )
			{
				setTitle(title);
				
				setSize(width, height);
				
				setLayout(new BorderLayout());
				
				topPanel		=	new		JPanel();
								
				GInstructions	=	new		GameInstructions();
			}
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		}
		catch(Exception eg)
		{
			System.out.println("ERROR: \n Game Window Constructor Error" + eg.getMessage());
		}
		finally
		{						
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			setVisible(true);
			
			setResizable(true);
			
			if( (SecurityCheck.thisColor(basePanelColor)) )
			{
				topPanel.setBackground(basePanelColor);
				
				topPanel.setLayout(flowPanel);
				
				topPanel.setAlignmentY(CENTER_ALIGNMENT);
				
				topPanel.setAlignmentX(CENTER_ALIGNMENT);
				
				topPanel.add(GInstructions);
			}
			add(topPanel, BorderLayout.NORTH);
		}
	}
	protected void fitScreen()
	{
		setResizable(true);
		
		pack();
		
		revalidate();
		
		setResizable(false);
	}
}