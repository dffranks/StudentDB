/* * * * * * * * * * * * *
 *     Daniel Franks     *
 *        Java II        *
 *        Lab #10        *
 *      Apr 13 2015      *
 * * * * * * * * * * * * */

// I've created a custom Students table with MySQL on a Unix machine. //
// The columns are identical to the ones in the Access database.      //

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Student {
	
	private int ID;
	private String fName;
	private String lName;
	private String street;
	private String city;
	private String state;
	private int zip;
	private String email;
	private float GPA;

	String sqlS;
		
	public Student() {
		ID = 0;
		fName = "";
		lName = "";
		street = "";
		city = "";
		state = "";
		zip = 0;
		email = "";
		GPA = 0.0f;
	}
	
	public Student(int id, String fn, String ln, String str, String ct, String st, int z, String em, float gpa) {
		setID(id);
		setFName(fn);
		setLName(ln);
		setStreet(str);
		setCity(ct);
		setState(st);
		setZip(z);
		setEmail(em);
		setGPA(gpa);
	}
	
	/*******SETS*******/
	public void setID(int id) { ID = id; }
	public void setFName(String fn) { fName = fn; }
	public void setLName(String ln) { lName = ln; }
	public void setStreet(String str) { street = str; }
	public void setCity(String ct) { city = ct; }
	public void setState(String st) { state = st; }
	public void setZip(int z) { zip = z; }
	public void setEmail(String em) { email = em; }
	public void setGPA(float gpa) { GPA = gpa; }
	
	/*******GETS*******/
	public int getID() { return ID; }
	public String getFName() { return fName; }
	public String getLName() { return lName; }
	public String getStreet() { return street; }
	public String getCity() { return city; }
	public String getState() { return state; }
	public int getZip() { return zip; }
	public String getEmail() { return email; }
	public float getGPA() { return GPA; }

	/*******CONNECTION*******/
	public void connectDB(String sql, char func) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/JavaDB", "scott", "tiger");
			Statement stmt = connection.createStatement();
			stmt.execute(sql);
			ResultSet rs = stmt.getResultSet();

			switch(func) {
				case 's':
					rs.next();
					fName = rs.getString(2);
					lName = rs.getString(3);
					street = rs.getString(4); 
					city = rs.getString(5);
					state = rs.getString(6);
					zip = rs.getInt(7);
					email = rs.getString(8);
					GPA = rs.getFloat(9);
					break;
				case 'i':
					break;
				case 'u':
					break;
				case 'd':
					break;
				default:
					System.out.println(func + " not a valid SQL function type (Select, Insert, Update, or Delete)");
			}
			connection.close();
		}catch (SQLException sqle) {
			System.out.println("ERROR!: " + sqle);
			
		}catch (ClassNotFoundException cnf) {
			System.out.println("ERROR!: " + cnf);
		}
	}
	
	/*******SELECT*******/
	public void selectDB(int id) {

		setID(id);
		sqlS = "SELECT * FROM Students WHERE ID = " + ID + ";";

		connectDB(sqlS, 's');
		
	}

	/*******INSERT*******/
	public void insertDB(int id, String fn, String ln, String str, String ct, String st, int z, String em, float gpa) {

		setID(id);
		setFName(fn);
		setLName(ln);
		setStreet(str);
		setCity(ct);
		setState(st);
		setZip(z);
		setEmail(em);
		setGPA(gpa);

		sqlS = "INSERT INTO Students VALUES (" + ID + ", '" + fName + "', '" + lName + "', '" + street + "', '" + city + "', '" + state + "', " + zip + ", '" + email + "', " + gpa + ");";

		connectDB(sqlS, 'i');
	} 

	/*******UPDATE*******/
	public void updateDB() {

		sqlS = "UPDATE Students SET Zip = " + zip + " WHERE ID = " + ID + ";";

		connectDB(sqlS, 'u');
	} 

	/*******DELETE*******/
	public void deleteDB() {

		sqlS = "DELETE FROM Students WHERE ID = " + ID + ";";

		connectDB(sqlS, 'd');

	}

} //end class