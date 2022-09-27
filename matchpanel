package game;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.border.Border;

public class MatchPanel extends JPanel implements MouseListener
{
    private int WIDTH = 700, HEIGHT = 700, index1, index2, turn = 1, counter = 0;
    private Dimension SIZE = new Dimension(WIDTH,HEIGHT);
    private JLabel[] labels;
    private ImageIcon[] icons;
    private ImageIcon gray = new ImageIcon("src/images/grey.png");
    private Random rand = new Random();
    private Timer myTimer;
    private Border border;
    
    public MatchPanel()
    {
   	 this.setPreferredSize(SIZE);
   	 this.setLayout(new GridLayout(6,6,5,2));
   	 Random r = new Random();
   	 float a = r.nextFloat();
   	 float b = r.nextFloat();
   	 float c = r.nextFloat();
   	 border = BorderFactory.createLineBorder(Color.getHSBColor(a,b,c), 5);
   	 myTimer = new Timer(2000, new TimeListener());
   	 setArrays();
    }
    
    private void setArrays()
    {
   	 labels = new JLabel[36];
   	 icons = new ImageIcon[36];
   	 ImageIcon temp = new ImageIcon();
   	 
   	 for (int x = 0; x < 18; x++)
   	 {
   		 temp = new ImageIcon("src/images/" + x + ".png");
   		 icons[x] = temp;
   		 icons[x + 18] = temp;
   		 
   		 labels[x] = new JLabel(gray);
   		 labels[x + 18] = new JLabel(gray);
   		 labels[x].addMouseListener(this);
   		 labels[x + 18].addMouseListener(this);
   		 this.add(labels[x]);
   		 this.add(labels[x + 18]);
   		 
   	 }
   	 for (int x = 0; x < 36; x++)
   	 {
   		 temp = icons[x];
   		 int number = rand.nextInt(36);
   		 icons[x] = icons[number];
   		 icons[number] = temp;
   	 }
    }
    private void startOver()
    {
    	counter = 0;
    	ImageIcon temp = new ImageIcon();
    	for (int x = 0; x < 36; x++)
    	{
    		labels[x].setIcon(gray);
    		labels[x].removeMouseListener(this);
    		labels[x].addMouseListener(this);
    		temp = icons[x];
    		int num = rand.nextInt(36);
    		icons[x] = icons[num];
      		icons[num] = temp;
    	   	 
    		
    	}
    }


    @Override
    public void mouseClicked(MouseEvent e)
    {
    }
    
    @Override
    public void mousePressed(MouseEvent e)
    {
    	if (myTimer.isRunning()) {
    		return;
    	}
   	 Object src = e.getSource();
   	 
   	 for (int i = 0; i < labels.length; i++)
   	 {
   		 if (src == labels[i])
   		 {
   			 if (turn % 2 == 1)
   			 {
   				 index1 = i;
   			 }
   			 else
   			 {
   				 index2 = i;
   			 }
   			 labels[i].setIcon(icons[i]);
   			 labels[i].setBorder(null);
   			 labels[i].removeMouseListener(this);
   		 }
   	 }
   	 turn++;
   	 if (turn % 2 == 1)
   	 {
   		 if (!icons[index1].equals(icons[index2]))
   		 {
   			 labels[index1].addMouseListener(this);
   			 labels[index2].addMouseListener(this);
   			 myTimer.start();
   		 }
   		 if(icons[index1].equals(icons[index2]))
   		 {
   			 counter++;
   			if (counter == 18)
     		 {
     			 int answer = JOptionPane.showConfirmDialog(null, "Play Again?", "Game Over",JOptionPane.YES_NO_OPTION);
     			 if (answer == 0)
     			 {
     				 startOver();
     			 }
     			 else
     			 {
     				 System.exit(0);
     			 }
     		 }
   		 }
   	 }
    }
    
    @Override
    public void mouseReleased(MouseEvent e)
    {
    }
    @Override
    public void mouseEntered(MouseEvent e)
    {
    	if (myTimer.isRunning()) {
    		return;
    	}
   	 Object src = e.getSource();
   	 for(int x = 0; x < 36; x++)
   	 {
   		 if(labels[x].equals(src))
   		 {
   			 Random r = new Random();
   			 float a = r.nextFloat();
   			 float b = r.nextFloat();
   			 float c = r.nextFloat();
   			 border = BorderFactory.createLineBorder(Color.getHSBColor(a,b,c), 5);
   			 labels[x].setBorder(border);
   		 }
   	 }
    }
    @Override
    public void mouseExited(MouseEvent e)
    {
   	 Object src = e.getSource();
   	 for(int x = 0; x < 36; x++)
   	 {
   		 if(labels[x].equals(src))
   		 {
   			 labels[x].setBorder(null); 
   		 }
   	 }
    }
    public class TimeListener implements ActionListener
    {
   	 @Override
   	 public void actionPerformed(ActionEvent e)
   	 {
   		 labels[index1].setIcon(gray);
   		 labels[index2].setIcon(gray);
   		 myTimer.stop();
   	 }
    }
}
