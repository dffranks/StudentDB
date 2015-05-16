/* * * * * * * * * * * * *
 *     Daniel Franks     *
 *        Java II        *
 *        Lab #10        *
 *      Apr 13 2015      *
 * * * * * * * * * * * * */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MidPanel extends JPanel {

	JLabel lID = new JLabel("ID Number:", SwingConstants.CENTER);
	public JTextField fID = new JTextField(8);

	JLabel lFName = new JLabel("First Name:", SwingConstants.CENTER);
	public JTextField fFName = new JTextField(8);

	JLabel lLName = new JLabel("Last Name:", SwingConstants.CENTER);
	public JTextField fLName = new JTextField(8);

	JLabel lStreet = new JLabel("Street:", SwingConstants.CENTER);
	public JTextField fStreet = new JTextField(8);

	JLabel lCity = new JLabel("City:", SwingConstants.CENTER);
	public JTextField fCity = new JTextField(8);

	JLabel lState = new JLabel("State:", SwingConstants.CENTER);
	public JTextField fState = new JTextField(8);

	JLabel lZip = new JLabel("Zip:", SwingConstants.CENTER);
	public JTextField fZip = new JTextField(8);

	JLabel lEmail = new JLabel("Email:", SwingConstants.CENTER);
	public JTextField fEmail = new JTextField(8);

	JLabel lGPA = new JLabel("GPA:", SwingConstants.CENTER);
	public JTextField fGPA = new JTextField(8);
	
	public MidPanel() {
		
		this.setLayout(new GridLayout(0,2));

		this.add(lID);
		this.add(fID);

		this.add(lFName);
		this.add(fFName);

		this.add(lLName);
		this.add(fLName);

		this.add(lStreet);
		this.add(fStreet);

		this.add(lCity);
		this.add(fCity);

		this.add(lState);
		this.add(fState);

		this.add(lZip);
		this.add(fZip);

		this.add(lEmail);
		this.add(fEmail);

   		this.add(lGPA);
		this.add(fGPA);
		
	}

}
