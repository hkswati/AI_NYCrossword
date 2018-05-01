import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class GridCell extends JPanel {
	
	//properties
	JTextField field;
	JLabel superscript;
	String letter;
	int isBlack;
	int hasNumber;
	int cellNo;
	
	public GridCell() {
		isBlack = 0;
		hasNumber = 1;
		cellNo = 0;
		letter = null;

		makeCell();		
	}
	
	//methods
	public void setIsBlack(int val) {
		isBlack = val;
		makeCell();
	}
	public void setHasNumber(int val) {
		hasNumber = val;
	}
	public void setCellNo(int val) {
		cellNo = val;
	}
	public String getLetter() {
		return letter;
	}
	public void makeCell() {
		setPreferredSize(new Dimension(50, 50));
		setLayout(new BorderLayout());
		//setBackground(Color.WHITE);
		
		if (isBlack == 1) {
			setBackground(Color.BLACK);
			letter = "black";
			superscript.setVisible(false);
			field.setVisible(false);
		}
		else {
			// put a superscript if cell has a number
			if (hasNumber == 1) {
				String strCellNo = cellNo + "";
				superscript = new JLabel(strCellNo);
				superscript.setSize(new Dimension(10,10));
				superscript.setBackground(Color.WHITE);
				superscript.setOpaque(true);
				add(superscript, BorderLayout.NORTH);
			}
			
			Font font = new Font("SansSerif", Font.BOLD, 20);
			field = new JTextField();
		
			//field.setText("A");
			field.setBorder(BorderFactory.createEmptyBorder());
			field.setFont(font);
			field.setHorizontalAlignment(JTextField.CENTER);
			
			field.addKeyListener(new KeyAdapter() {
		    
				public void keyTyped(KeyEvent e) { 
					if (field.getText().length() >= 1 ) {//limit text to 1 characters
						e.consume(); 
						letter = field.getText();
						printLetter();
					}	
				}  
			});
        
			add(field, BorderLayout.CENTER);

			//setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
			setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		} 
	}
	public void printLetter() {
		System.out.println(letter);
	}
}
