package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MatchFrame extends JFrame {

    private JPanel panel;

    
    public static void main(String[] args) {
   	 EventQueue.invokeLater(new Runnable() {
   		 public void run() {
   			 try {
   				 MatchFrame frame = new MatchFrame();
   				 frame.setVisible(true);
   			 } catch (Exception e) {
   				 e.printStackTrace();
   			 }
   		 }
   	 });
    }

    
    public MatchFrame() {
   	 this.setTitle("Match Cards");
    	ImageIcon icon = new ImageIcon("src/images/custom_java_icon.jpg");
    	setIconImage(icon.getImage());
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setLocation(100, 100);
    	this.setResizable(false);
    	this.setLayout(null);
    	panel = new MatchPanel();
    	setContentPane(panel);
    	pack();
    }

}
