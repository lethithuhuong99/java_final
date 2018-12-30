package vnuk.huong170205.finalexam.view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DisplayTable extends JFrame{
	JFrame frame =new JFrame("List employee");
	
	public DisplayTable() { 
		    String data[][] = {};
		    
		    String column[]={"NO.", "NAME", "YEAR OF BIRTH", "HOMETOWN", "TYPE", "C1", "C2", "C3", "C4", "C5"};     
		    
		    JTable jt=new JTable(data,column);    
		    jt.setBounds(30,40,200,300);          
		    JScrollPane sp=new JScrollPane(jt);  
		    
		    frame.add(sp);          
		    frame.setSize(1000, 500);    
		    frame.setVisible(true);    
	}     
	public static void main(String[] args) {    
	    new DisplayTable();    
	}  	
}