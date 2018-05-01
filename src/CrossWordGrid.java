import java.awt.*;

import java.util.ArrayList;

import java.awt.event.*;
import javax.swing.*;

public class CrossWordGrid {
	
	//properties
	private JFrame frame;
	private JPanel panel;
	private ArrayList<GridCell> cellList; 
	//private ArrayList<String> inputLetters;
	private JButton button;
	private JTextArea across;
	private JTextArea down;
	private ArrayList<String> hintsAcross;
	private ArrayList<String> hintsDown;
	private JLabel acc;
	private JLabel dwn;
	private JPanel answerPanel;
	

	//constructor
	public CrossWordGrid() {
		//makeGrid();
		//setup the window
		frame = new JFrame();
		frame.setBounds(300, 120, 600, 600);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
		ImageIcon icon = new ImageIcon("Capture.jpg");
		JLabel label = new JLabel(icon);
		label.setBounds(20,0, 210, 100);
		frame.add(label);
		
		
	}
	
	//methods
	
	public static void main(String[] args) {
		CrossWordGrid crossword = new CrossWordGrid(); 
		crossword.makeGrid();
		crossword.displayHints();
		crossword.displayAnswerGrid();
	
	}
	
	public void makeGrid() {
		
		//make 25 grid cells
		cellList = new ArrayList<GridCell>(26);
		for (int i = 0; i < 25; i++) {
			cellList.add(new GridCell());

		}
		//setup the grid
		panel = new JPanel();
		panel.setBounds(280, 180, 400, 400);
		panel.setLayout(new GridLayout(5,5));
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		panel.setBackground(Color.WHITE);
		
		//add cells to the grid
		for (int i = 0; i < 25; i++) {
			panel.add(cellList.get(i));
		}

		
		button = new JButton("Check");
		button.setBounds(445,600,70,40);
        button.setBackground(new Color(0, 0, 0));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				//int counter = 0;
			    for (int i = 0 ; i < 25; i++) {
			    	System.out.println(cellList.get(i).getLetter());
			    	//if (cellList.get(i).getLetter().equals(CrossWordStrorage.sixMarch[i])) {
			    		//counter++; 
			    	//} 	
			    }
			   // if (counter == 25) {
		    	//	JOptionPane.showMessageDialog(frame,"You Won!");  
		    	//}
		    	//else {
		    		//JOptionPane.showMessageDialog(frame,"Close! Try again");
		    	//}

			}  
	    });
		
		frame.add(button);
		frame.add(panel);
	}
	
	public void displayHints() {
		across = new JTextArea();
		down = new JTextArea();
		
		across.setBounds(755, 280, 300,300);
		down.setBounds(1060,280,300,300);
		across.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		down.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		acc = new JLabel("Across");
		dwn = new JLabel("Down");
		
		acc.setBounds(755, 220, 70, 90);
		dwn.setBounds(1060,220,70,90);
		
		across.setLineWrap(true);
		across.setWrapStyleWord(true);
		down.setLineWrap(true);
		down.setWrapStyleWord(true);
		
		Font font = new Font("Arial",Font.PLAIN, 20);
		across.setFont(font);
		down.setFont(font);
		/*for (int i = 0 ; i < 5 ; i ++ ) {
			across.append(CrossWordStrorage.horizontal[i]);
			across.append("\n");
			across.append("\n");
		}
		for (int i = 0 ; i < 5 ; i ++ ) {
			down.append(CrossWordStrorage.vertical[i]);
			down.append("\n");
			down.append("\n");
		}*/
		
		across.setEditable(false);
		down.setEditable(false);
		
		frame.add(acc);
		frame.add(dwn);
		frame.add(across);
		frame.add(down);
		
	}
	
	public void displayAnswerGrid() {
		//setup the grid
				answerPanel = new JPanel();
				answerPanel.setBounds(15, 380, 200, 200);
				answerPanel.setLayout(new GridLayout(5,5));
				answerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
				//panel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
				answerPanel.setBackground(Color.WHITE);
				
				//add cells to the grid
				for (int i = 0; i < 25; i++) {
					answerPanel.add(new AnswerCell());
				}
				frame.add(answerPanel);
				frame.setVisible(true);
	}
	
}
		




