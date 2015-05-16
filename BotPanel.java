/* * * * * * * * * * * * *
 *     Daniel Franks     *
 *        Java II        *
 *        Lab #10        *
 *      Apr 13 2015      *
 * * * * * * * * * * * * */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BotPanel extends JPanel {

  public JButton bSelect = new JButton("Select");
  public JButton bInsert = new JButton("Insert");
  public JButton bDelete = new JButton("Delete");
  public JButton bUpdate = new JButton("Update");
	public JButton bExit = new JButton("Exit");
	
	public BotPanel() {
		
		this.setLayout(new FlowLayout());

		this.add(bSelect);
    this.add(bInsert);
      bInsert.setForeground(Color.GREEN);
    this.add(bUpdate);
      bUpdate.setForeground(Color.BLUE);
    this.add(bDelete);
      bDelete.setForeground(Color.RED);
    this.add(bExit);   
	}

}
