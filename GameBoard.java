import java.awt.Color;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JToggleButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.util.Random;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import java.lang.Math;

/*
*Created By: Brendon S. Service
*Last Updated : 11/17/2015
*No Modifications were made until   06/05/2016
*Game Board now contains Board Components
*Last Updated : 06/07/2016
*
*/
public class GameBoard extends GameWindow
{
	private		JPanel				GmBrdPnls			=		null		;
	
	private		JPanel				boardComponents		=		null		;
    
    private     Timer               time                =       null        ;
	
    private     JLabel              timeLimit           =       null        ;
    
    private     String              timeText            =       null        ;
    
    private     int                 tensPlace           =       0           ;
    
    private     int                 onesPlace           =       0           ;
    
    private     int                 minutes             =       3           ;
    
	private		BorderLayout		boardBorder			=		null		;
	
	private		JPanel				scoreBoard			=		null		;
	
	private		JTextField			scoreField			=		null		;
	
	private		JPanel				StartGamePanel		=		null		;
	
	private		JButton				startGame			=		null		;
	
	private		Color				startColor			=		null		;
	
	private		JLabel				CurrentDecimal		=		null		;
		
	private		Color				decDisTextBackCol	=		null		;
	
	private		Dimension			areaSize			=		null		;

	private		Color				boardColor			=		Color.GREEN	;
	
	private		final	int			MAX_PANEL			=		8			;
    
    private     final   int         delay               =       1000        ;
		
	public 		int					MAX					=		8			;//MAX controls the toggle buttons & stuff
		
	private		int					bitIntHolder[]		=		null		;
	
	private		Random				randNum				=		null		;
	
	private		RandomControl		rControl			=		null		;
	
	private		String				bitKeeper[]			=		null		;
	
	private		JPanel				boardPanels[]		=		null		;
	
	private 	FlowLayout			fLayout				=		null		;
	
	private		ImageIcon			bulbOn				=		null		;
	
	private		ImageIcon			bulbOff				=		null		;
	
	private		Color				pColor				=		Color.CYAN	;//Color of the board components section
	
	private		Dimension			sizeOfPanels		=		null		;//size of panel occupancy
	
	private		Dimension			sizeOfButtons		=		null		;//size of button occupancy
	
	protected	JToggleButton		gameButtons[]		=		null		;//Button that holds both images
	
	private		String				bulbOnTitle			=		null		;// location of bulb on image
	
	private		String				bulbOffTitle		=		null		;//location the bulb off image
    
    private     String              scoreText           =       null        ;
    
    private     JLabel              scoreLabel          =       null        ;//Label That displays Score: right next to the user score 
	
	private		int					userScore			=		0			;//User score is stored in this variable (+10 per correct answer)
	
	private		JTextArea			deciNumDisplay		=		null		;//to display the changed decimal that needs to be solved
	
	private		String				deciNumText			=		null		;//the text that will be changed and replaced in the area
	
	private		JLabel				deciDisTitle		=		null		;//the label that will hold the name 'decimal number'
	
	private		String				decDisText			=		null		;//the string that will hold the title 'decimal number'
	
	private		Random				randyNum			=		null		;//random variable
	
	private		Dimension			deciAreaSize		=		null		;//self explanatory
			
	private		int					Level				=		1			;//The level
	
	private		int					prevDec				=		1		    ;//hold the prev decimal integer for conversion
	
	private		Color	leColors[]	=	{
										Color.RED, Color.RED, Color.ORANGE, Color.YELLOW,
										Color.GREEN, Color.BLUE, Color.MAGENTA, Color.BLACK
										};
	public GameBoard()
	{
		super(" \"Wattage\" The Binary Game", 1275, 300);
		try
		{	
			GmBrdPnls	        =	new JPanel();
			
			boardBorder	        =	new BorderLayout();
            			
			fLayout			    =	new FlowLayout();
            
            timeLimit           =   new JLabel();
			
			boardComponents 	=	new JPanel();
			
			StartGamePanel  	=	new JPanel();
			
			randNum		    	=	new Random();
            
            scoreLabel          =   new JLabel();
            
			scoreBoard  		=	new JPanel(); // score panel
			
			scoreField		    =	new JTextField(); //score text field
			
			bitIntHolder    	=	new int[MAX_PANEL];
			
			bitKeeper	    	=	new	String[MAX_PANEL];
			
			rControl		    =	new RandomControl(255);
            
            scoreText           =   "Score : ";
			
			bulbOnTitle	    	=	"SmallLighton.jpg";
		
			bulbOffTitle	    =	"SmallLightoff.jpg";
			
			startColor		    =	Color.BLUE;
			
			CurrentDecimal		=	new JLabel("0", SwingConstants.CENTER);

			areaSize			=	new	Dimension(50, 30);

			decDisTextBackCol	=	Color.BLACK;

			if( (SecurityCheck.thisColor(startColor)) && (SecurityCheck.thisColor(decDisTextBackCol)) )
			{
				StartGamePanel.setBackground(startColor);
	
				startGame	=	new JButton("START!");
				
				startGame.addActionListener(new StartGameButton());
		
				CurrentDecimal.setBackground(decDisTextBackCol);
				
				CurrentDecimal.setPreferredSize(areaSize);
				
				StartGamePanel.add(CurrentDecimal);
				
				StartGamePanel.add(startGame);								
			}
			if( (SecurityCheck.thisString(bulbOnTitle)) && (SecurityCheck.thisString(bulbOffTitle)) &&(SecurityCheck.thisString(scoreText)) )
			{
				bulbOn		=	new	ImageIcon(bulbOnTitle);
				
				bulbOff		=	new	ImageIcon(bulbOffTitle);
                
                scoreLabel.setText(scoreText);
				
			}			
			if( (SecurityCheck.thisFlow(fLayout)) && (SecurityCheck.thisColor(pColor)) )
			{
				boardComponents.setLayout(fLayout);
				
				boardComponents.setBackground(pColor);
			}
			
			if( (SecurityCheck.thisPosInteger(MAX)) && (SecurityCheck.thisPosInteger(delay)) ) 
			{
				boardPanels	=	new	JPanel[MAX];
                
                time =   new Timer(delay,new ActionListener()
                {
                    public void actionPerformed(ActionEvent t)
                    {
                        onesPlace--;
                        if( (onesPlace==-1) && (tensPlace>0) )
                        {
                            tensPlace--;
                            onesPlace=9;
                        }
                        if( (onesPlace == -1) )
                        {
                            minutes--;
                            tensPlace = 5;
                            onesPlace = 9;
                        }
                        if( (minutes == -1) )
                        {
                            JOptionPane.showMessageDialog(null,"Game Over!");
                            System.exit(0);
                        }
                        timeText = " "+minutes+":"+tensPlace+onesPlace+" ";
                        timeLimit.setText(timeText);
                    }});
                              
				createPanels(boardPanels);
				
				placeOnBoard(boardPanels);
				
				addGameButtons();
			}
			if( (SecurityCheck.thisColor(boardColor)) )
			{ 
				GmBrdPnls.setBackground(boardColor);
				
				GmBrdPnls.setLayout(new BorderLayout());
			}
			revalidate();
			
			GmBrdPnls.add(StartGamePanel, boardBorder.NORTH);
			
			GmBrdPnls.add(boardComponents, boardBorder.CENTER);
		
			GmBrdPnls.setVisible(true);
			
			super.add(GmBrdPnls, BorderLayout.CENTER);
		}
		catch(Exception ex)
		{
			System.out.print("  Game  Board   Error  "+ex.getMessage());
		}
		finally
		{			
			for(int setOff = 0; setOff<MAX ; setOff++)
			{
				gameButtons[setOff].setEnabled(false);
			}			
			boardComponents.setVisible(true);
			
			CurrentDecimal.setVisible(false);
			
			CurrentDecimal.setEnabled(false);
			
            scoreLabel.setEnabled(false);
			
            scoreField.setEnabled(false);
            
            timeLimit.setEnabled(false);
			
            scoreLabel.setBackground(Color.BLACK);
			
            scoreField.setBackground(Color.BLACK);
            
            scoreField.setVisible(true);
            
            scoreBoard.add(timeLimit);
			
            scoreBoard.add(scoreLabel);
			
            scoreBoard.add(scoreField);
            
            scoreBoard.setVisible(true);
			
			add(scoreBoard, BorderLayout.NORTH);
			            
			fitScreen();
		}
	}
	private JPanel[] createPanels(JPanel[] panels)
	{
		try
		{
			sizeOfPanels	=	new	Dimension(125, 125); 
			
			for(int i = 0; i < MAX; i++)
			{
				panels[i] = new JPanel();
				
				if( (SecurityCheck.thisColor(leColors[i])) )
				{
					panels[i].setBackground(leColors[i]);
					
					panels[i].setPreferredSize(sizeOfPanels);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Creation of panels Error"+e.getMessage());
		}
		
		return	panels;
	}
	private void placeOnBoard(JPanel[] lePanels)
	{
		try
		{
			for(int i = (MAX - 1); i > -1; i--)
			{
				if( (SecurityCheck.thisPanel(lePanels[i])) )
				{
					boardComponents.add(lePanels[i]);
					if( (i >= 4) )
					{
						lePanels[i].setVisible(false);
					}
					if( (i <= 3) )
					{
						lePanels[i].setVisible(true);
					}

				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Placement Error \n "+e.getMessage());
		}
	}
	private void addGameButtons()
	{
		try
		{
			if( (SecurityCheck.thisPosInteger(MAX)) )
			{
				gameButtons		=	new	JToggleButton[MAX];
				
				sizeOfButtons	=	new	Dimension(100, 100);
				
				for(int i = 0; i < MAX; i++)
				{
					gameButtons[i]	=	new		JToggleButton();
					
					gameButtons[i].addItemListener( new GameChangingButtons() );
					
					gameButtons[i].setPreferredSize(sizeOfButtons);
					
					gameButtons[i].setBorder(BorderFactory.createLineBorder(pColor , 2));
					
					if( (SecurityCheck.thisColor(leColors[i])) )
					{
						gameButtons[i].setBackground(leColors[i]);
					}
					gameButtons[i].setVisible(true);

					boardPanels[i].add(gameButtons[i]);
				}
			}			
		}
		catch(Exception be)
		{
			System.out.println("There is an Error with the buttons \n "+be.getMessage());
		}
	}
	public void reValidations()
	{
		revalidate();
		boardComponents.revalidate();
	}
	public void setDecimalText(String cd)
	{
		try
		{
			if ( SecurityCheck.thisString(cd) )
			{
				CurrentDecimal.setText(cd);
			}
		}
		catch(Exception ecd)
		{
			System.out.print("Error: @Param is not String "+ecd.getMessage());
		}
	}
	public void setVisibleScore(int scr)
	{
		int showScore = scr * 5;
		
		String	visibleScore = Integer.toString(showScore);
		
		scoreField.setText(visibleScore);
	}
	public int getRandom()
	{
		int newRandDec = 0;
		
		do
		{
			if(Level == 1)
			{
				newRandDec = randNum.nextInt( ((int)Math.pow(2,4)-1) )+1;
			}
			else
			{
				newRandDec = randNum.nextInt( (((int)Math.pow(2,Level + 3))-((int)Math.pow(2,Level + 2))) - 1 )+(int)Math.pow(2,Level + 2);
			}
		}
		while(!rControl.compareNum(newRandDec));
		
		rControl.addToStorage(newRandDec);
		
		prevDec = newRandDec;
		
		return newRandDec;
	}
	private class StartGameButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			time.start();
            startGame.setVisible(false);
			CurrentDecimal.setVisible(true);
			setDecimalText(String.valueOf(getRandom()));
			for(int setOn = 0; setOn<MAX ; setOn++)
			{
				gameButtons[setOn].setEnabled(true);
                gameButtons[setOn].setIcon(bulbOff);
                bitIntHolder[setOn]=0;
			}
			revalidate();
		}
	}
	private class GameChangingButtons implements ItemListener
	{
		public void itemStateChanged(ItemEvent g)
		{
			int index = 0;//prevDec
			//check which button was clicked
			for(int i = 0; i < MAX; i++)
			{
				if( (g.getSource() == gameButtons[i]) )
				{
					index = i;
				}
			}
			if( (g.getStateChange() == ItemEvent.SELECTED) )
			{
				gameButtons[index].setIcon(bulbOn);
					
				bitIntHolder[index] = 1;
			}
			else
			{
				gameButtons[index].setIcon(bulbOff);
					
				bitIntHolder[index] = 0;
			}
			//convert the integer array, to a string
			String bitConversion = "";
			//compare both string representations
			for(int i = 0;i<bitIntHolder.length;i++)
			{
				if(bitIntHolder[i]!=1)
				{
					bitIntHolder[i]=0;
				}
				bitKeeper[i] = Integer.toString(bitIntHolder[i]);
			}
			for(int r=bitIntHolder.length-1;r>=0;r--)
			{
				bitConversion += bitKeeper[r];
			}
			String ScoreFromDecimal = Integer.toBinaryString(prevDec);
			//turn both decimal and binary from buttons into binary strings
			int playerBits = Integer.parseInt(bitConversion);
			System.out.print(" \n PlayerBits = "+playerBits);
			//once compared we will know if the player is correct.
			int answerBits = Integer.parseInt(ScoreFromDecimal);
			System.out.print(" \n AnswerBits = "+answerBits);
			System.out.print(" \n User Score = "+ userScore);
			//if the decimal matches the player input we add a point to the score &&& we change the decimal also check if the level changed
			if(playerBits==answerBits)
			{
				userScore = (userScore + 1);
				setVisibleScore(userScore);
				System.out.print(" \n User Score = "+ userScore);
				if(userScore > 24)
				{
					JOptionPane.showMessageDialog(null, "You have completed the Binary Tutorial");
                    time.stop();
					System.exit(0);
				}
				else if(userScore%5 == 0)
				{
					Level += 1;
					boardPanels[Level+2].setVisible(true);
					reValidations();
					fitScreen();
                    //setVisibleScore(userScore);
					JOptionPane.showMessageDialog(null, "You are now on Level "+Level);
				}

				//Set Decimal Text
				setDecimalText(String.valueOf(getRandom()));
				/*  
				*Solution: Change the Layout of the Game board to Border, put start button class in this class
				*/
			}
			else
			{
				//do not interact with the player until it is solved [you must interact with player]
			}
			//input level changing effect code here.
		}
	}
}