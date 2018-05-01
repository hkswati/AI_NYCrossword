
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class AnswerCell extends JPanel {
	
	//properties
	JTextField field;
	JLabel superscript;
	String letter;
	int isBlack;
	int hasNumber;
	int cellNo;
	
	public AnswerCell() {
		isBlack = 1;
		hasNumber = 1;
		cellNo = 0;
		field = new JTextField();
		letter = null;

		//makeCell();		
	}
	
	//methods
	public void setIsBlack(int val) {
		isBlack = val;
		//makeCell();
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
		setPreferredSize(new Dimension(35, 35));
		setLayout(new BorderLayout());
		
		
		if (isBlack == 1) {
			setBackground(Color.BLACK);
			letter = "black";
			superscript.setVisible(false);
			field.setText("");
			field.setVisible(false);
			
		}
		else {
			// put a superscript if cell has a number

				String strCellNo = cellNo + "";
				superscript = new JLabel(strCellNo);
				superscript.setSize(new Dimension(1,1));
				superscript.setBackground(Color.WHITE);
				superscript.setOpaque(true);
				add(superscript, BorderLayout.NORTH);

			
			Font font = new Font("SansSerif", Font.PLAIN, 17);
		
			field.setText(letter);
			field.setBorder(BorderFactory.createEmptyBorder());
			field.setFont(font);
			field.setHorizontalAlignment(JTextField.CENTER);
            field.setEditable(false);
            field.setBackground(Color.WHITE);
        
			add(field, BorderLayout.CENTER);

			//setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
			setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		} 
	}

}
