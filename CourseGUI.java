/* * * * * * * * * * * * *
 *     Daniel Franks     *
 *        Java II        *
 *        Lab #10        *
 *      Apr 13 2015      *
 * * * * * * * * * * * * */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CourseGUI extends JFrame implements ActionListener {

	Student s = new Student();
	TopPanel tp = new TopPanel();
	MidPanel mp = new MidPanel();
	BotPanel bp = new BotPanel();
	
	public CourseGUI() {
		this.setTitle("CourseGUI");
		
		this.setLayout(new BorderLayout());
		
		this.add(tp, BorderLayout.NORTH);
		this.add(mp, BorderLayout.CENTER);
		this.add(bp, BorderLayout.SOUTH);

		bp.bSelect.addActionListener(this);
		bp.bInsert.addActionListener(this);
		bp.bUpdate.addActionListener(this);
		bp.bDelete.addActionListener(this);
		bp.bExit.addActionListener(this);

		
		this.setSize(425, 320);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public void actionPerformed(ActionEvent ae) {
		int id;
		String fname;
		String lname;
		String street;
		String city;
		String state;
		int zip;
		String email;
		float gpa;
		String sql;

		/*******SELECT BUTTON*******/
		if(ae.getSource() == bp.bSelect) {
			id = Integer.parseInt(mp.fID.getText());
			s.selectDB(id);
			display();
		}
		/*******INSERT BUTTON*******/
		else if(ae.getSource() == bp.bInsert) {
			id = Integer.parseInt(mp.fID.getText());
			fname = mp.fFName.getText();
			lname = mp.fLName.getText();
			street = mp.fStreet.getText();
			city = mp.fCity.getText();
			state = mp.fState.getText();
			zip = Integer.parseInt(mp.fZip.getText());
			email = mp.fEmail.getText();
			gpa = Float.parseFloat(mp.fGPA.getText());

			s.insertDB(id, fname, lname, street, city, state, zip, email, gpa);
			JOptionPane.showMessageDialog(null, "Insertion Successful!");
		}
		/*******UPDATE BUTTON*******/
		else if(ae.getSource() == bp.bUpdate) {
			id = Integer.parseInt(mp.fID.getText());
			fname = mp.fFName.getText();
			lname = mp.fLName.getText();
			street = mp.fStreet.getText();
			city = mp.fCity.getText();
			state = mp.fState.getText();
			zip = Integer.parseInt(mp.fZip.getText());
			email = mp.fEmail.getText();
			gpa = Float.parseFloat(mp.fGPA.getText());

			s.selectDB(id);

			s.setFName(fname);
			s.setLName(lname);
			s.setStreet(street);
			s.setCity(city);
			s.setState(state);
			s.setZip(zip);
			s.setEmail(email);
			s.setGPA(gpa);

			s.updateDB();
			JOptionPane.showMessageDialog(null, "Update Successful!");
		}
		/*******DELETE BUTTON*******/
		else if(ae.getSource() == bp.bDelete) {
			id = Integer.parseInt(mp.fID.getText());
			int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?");
    		if(option == JOptionPane.YES_OPTION) {
				s.selectDB(id);
				s.deleteDB();
				JOptionPane.showMessageDialog(null, "Deletion Successful!");
      		}
      	}
      	/*******EXIT BUTTON*******/
		else if(ae.getSource() == bp.bExit) {
			int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
    		if(option == JOptionPane.YES_OPTION) {
      			System.exit(0);
      		}
		}
	}

	/*******DISPLAY*******/
	public void display() {
		mp.fFName.setText(s.getFName());
		mp.fLName.setText(s.getLName());
		mp.fStreet.setText(s.getStreet());
		mp.fCity.setText(s.getCity());
		mp.fState.setText(s.getState());
		String z = Integer.toString(s.getZip());
		mp.fZip.setText(z);
		mp.fEmail.setText(s.getEmail());
		String g = Float.toString(s.getGPA());
		mp.fGPA.setText(g);
	}
	
	public static void main(String args[]) {
		
		CourseGUI cg = new CourseGUI();
		
	}
	
}
