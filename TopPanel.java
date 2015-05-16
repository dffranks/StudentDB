/* * * * * * * * * * * * *
 *     Daniel Franks     *
 *        Java II        *
 *        Lab #10        *
 *      Apr 13 2015      *
 * * * * * * * * * * * * */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TopPanel extends JPanel {
	
	JLabel info = new JLabel("Student Info:");
	
	public TopPanel() {
		info.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		this.setLayout(new FlowLayout());
		this.add(info);
		
	}
	
}
