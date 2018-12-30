package vnuk.huong170205.finalexam.viewGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vnuk.huong170205.finalexam.define.Define;

public class AddNewPersonFrame extends JFrame {
   
	private static ArrayList<JPanel> panels = new ArrayList<>();
	private static JFrame frame;
	
    public AddNewPersonFrame(int typeOfEmployee,int id, boolean isEdited) {
    	frame = this;
        panels.clear();
        
        setSize(400, 600);
        setTitle("Dialog");
        setLayout(null);               
        
        PanelTop panelTop = new PanelTop();
        panelTop.setSize(400, 90);
        panelTop.setLocation(0,0);
        
        PanelMiddle panelMiddle = new PanelMiddle();
        panelMiddle.setSize(400, 90);
        panelMiddle.setLocation(0,100);
          
        PanelButtonLecturer panelButtonLecturer = new PanelButtonLecturer();
        panelButtonLecturer.setSize(400, 320);
        panelButtonLecturer.setVisible(false);
        panelButtonLecturer.setLocation(0,190);
        
        PanelButtonStaff panelButtonStaff = new PanelButtonStaff();
        panelButtonStaff.setSize(400, 320);
        panelButtonStaff.setVisible(false);
        panelButtonStaff.setLocation(0,190);
        
        PanelButtonCasualWorker panelButtonCasualWorker = new PanelButtonCasualWorker();
        panelButtonCasualWorker.setVisible(false);
        panelButtonCasualWorker.setSize(400, 80);
        panelButtonCasualWorker.setLocation(0,190);
        
       
        
        PanelButtonAction panelButtonAction = new PanelButtonAction(isEdited);
        panelButtonAction.setSize(400, 40);
        panelButtonAction.setVisible(true);
                
      
        this.add(panelTop);
        this.add(panelMiddle);
        this.add(panelButtonLecturer);
        this.add(panelButtonStaff);
        this.add(panelButtonCasualWorker);
        this.add(panelButtonAction);        
        panels.add(panelTop);
        panels.add(panelMiddle);
        panels.add(panelButtonLecturer);
        panels.add(panelButtonStaff);
        panels.add(panelButtonCasualWorker);
        panels.add(panelButtonAction);
        showPanelMiddleAndPanelBottom(typeOfEmployee);
    }
       
       public static void showPanelMiddleAndPanelBottom(int typeOfEmployee) {
	       	switch(typeOfEmployee) {
	       	case 0: { // lecturer
	       		panels.get(2).setVisible(true);
	       		panels.get(3).setVisible(false);
	       		panels.get(4).setVisible(false);
	       		panels.get(5).setLocation(panels.get(2).getLocation().x, (int) (panels.get(2).getLocation().y + panels.get(2).getSize().getHeight() + 20));
	       		break;
	       	}
	       	case 1: { // staff
	       		panels.get(2).setVisible(false);
	       		panels.get(3).setVisible(true);
	       		panels.get(4).setVisible(false);
	       		panels.get(5).setLocation(panels.get(3).getLocation().x, (int) (panels.get(3).getLocation().y + panels.get(3).getSize().getHeight() + 20));
	       		break;
	       	}
	       	case 2: { //casual worker
	       		panels.get(2).setVisible(false);
	       		panels.get(3).setVisible(false);
	       		panels.get(4).setVisible(true);
	       		panels.get(5).setLocation(panels.get(4).getLocation().x, (int) (panels.get(4).getLocation().y + panels.get(4).getSize().getHeight() + 20));
	       		break;
	       	}
	       }
	       	AddNewPersonFrame.frame.setSize(400, (int) (panels.get(5).getLocation().y + panels.get(5).getSize().getHeight() + 40));
	       
       }
  
      class PanelTop extends JPanel {
    	  
    	  public PanelTop() {
    	
    		  this.setLayout(null);
    		  
    		  //id
	    	  JLabel labelId = new JLabel("Id");
	          labelId.setLocation(20,20);
	          labelId.setSize(labelId.getPreferredSize());
	          this.add(labelId);
	               
	          JTextField textFieldId = new JTextField();
	          textFieldId.setBounds(150, 20, 200, 25);
	          this.add(textFieldId);
	          textFieldId.setText(Integer.toString(Define.latestId++));
	          textFieldId.setEditable(false);
	          
	          //type
	          JLabel labelType = new JLabel("Type");
	          labelType.setLocation(20, 60);
	          labelType.setSize(labelType.getPreferredSize());
	          this.add(labelType);
	
	          String typeEmployee[]={Define.TYPE_OF_LECTURER_VALUE, Define.TYPE_OF_STAFF_VALUE, Define.TYPE_OF_CASUALWORKER_VALUE};
	          JComboBox cbType = new JComboBox(typeEmployee);
	          cbType.setBounds(150, 60, 200, 25);
	          cbType.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						AddNewPersonFrame.showPanelMiddleAndPanelBottom(cbType.getSelectedIndex());
						
					}
				});
	          this.add(cbType);
    	  }
      }
      
      class PanelMiddle extends JPanel{
    	  public PanelMiddle () {
    		  	
    		  	this.setLayout(null);
    		  	
    		  	//name
    		    JLabel labelName = new JLabel("Name");
    	        labelName.setLocation(20, 0);
    	        labelName.setSize(labelName.getPreferredSize());
    	        this.add(labelName);
    	             
    	        JTextField textFieldName = new JTextField();
    	        textFieldName.setBounds(150, 0, 200, 25);
    	        this.add(textFieldName);
    	        
    	        //yearOfBirth
    	        JLabel labelYearOfBirth = new JLabel("Year Of Birth");
    	        labelYearOfBirth.setLocation(20, 40);
    	        labelYearOfBirth.setSize(labelYearOfBirth.getPreferredSize());
    	        this.add(labelYearOfBirth);
    	             
    	        JTextField textFieldYearOfBirth = new JTextField();
    	        textFieldYearOfBirth.setBounds(150, 40 ,200, 25);
    	        this.add(textFieldYearOfBirth);
    	  }
      }
      
      class PanelButtonLecturer extends JPanel {
  	    
  	    public PanelButtonLecturer() {
  	        
  	        this.setLayout(null);
  	        
  	        //Hometown
  	        JLabel labelHometown = new JLabel("Hometown");
  	        labelHometown.setLocation(20, 0);
  	        labelHometown.setSize(labelHometown.getPreferredSize());
  	        this.add(labelHometown);
  	             
  	        JTextField textFieldHometown = new JTextField();
  	        textFieldHometown.setBounds(150, 0, 200, 25);
  	        this.add(textFieldHometown);
  	        
  	        //Department
  	        JLabel labelDepartment = new JLabel("Department");
  	        labelDepartment.setLocation(20, 40);
  	        labelDepartment.setSize(labelDepartment.getPreferredSize());
  	        this.add(labelDepartment);
  	             
  	        JTextField textFieldDepartment = new JTextField();
  	        textFieldDepartment.setBounds(150, 40, 200, 25);
  	        this.add(textFieldDepartment);

  	        //Allowance
  	        JLabel labelAllowance = new JLabel("Allowance");
	        labelAllowance.setLocation(20, 280);
	        labelAllowance.setSize(labelAllowance.getPreferredSize());
	        this.add(labelAllowance);
	             
	        JTextField textFieldAllowance = new JTextField();
	        textFieldAllowance.setBounds(150, 280, 200, 25);
	        textFieldAllowance.setEditable(false);
	        this.add(textFieldAllowance);
  	          
	        //Qualification
  	        JLabel labelQualification = new JLabel("Qualification");
  	        labelQualification.setLocation(20, 80);
  	        labelQualification.setSize(labelQualification.getPreferredSize());
  	        this.add(labelQualification);
  	        
  	        String typeQualification[]={Define.QUALIFICATION_OF_BACHELOR, Define.QUALIFUCATION_OF_MASTER, Define.QUALIFICATION_OF_DOCTOR};
  	        JComboBox cbTypeQualification = new JComboBox(typeQualification);
  	        cbTypeQualification.setBounds(150, 80, 200, 25);
  	        cbTypeQualification.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					switch (cbTypeQualification.getSelectedIndex()) {
					case 0: {
						textFieldAllowance.setText(Float.toString(Define.ALLOWANCE_OF_BACHELOR));
						break;
					}
					case 1: {
						textFieldAllowance.setText(Float.toString(Define.ALLOWANCE_OF_MASTER));
						break;
					}
					case 2: {
						textFieldAllowance.setText(Float.toString(Define.ALLOWANCE_OF_DOCTOR));
						break;
					}
					}
				}
			});
  	        this.add(cbTypeQualification);
  	        
  	        //Periods in month
  	        JLabel labelPeriodsInMonth = new JLabel("Periods in month");
  	        labelPeriodsInMonth.setLocation(20, 120);
  	        labelPeriodsInMonth.setSize(labelPeriodsInMonth.getPreferredSize());
  	        this.add(labelPeriodsInMonth);
  	             
  	        JTextField textFieldPeriodsInMonth = new JTextField();
  	        textFieldPeriodsInMonth.setBounds(150, 120, 200, 25);
  	        this.add(textFieldPeriodsInMonth);
  	        
  	        //Salary ratio
  	        JLabel labelSalaryRatio = new JLabel("Salary ratio");
  	        labelSalaryRatio.setLocation(20, 160);
  	        labelSalaryRatio.setSize(labelSalaryRatio.getPreferredSize());
  	        this.add(labelSalaryRatio);
  	             
  	        JTextField textFieldSalaryRatio = new JTextField();
  	        textFieldSalaryRatio.setBounds(150, 160, 200, 25);
  	        this.add(textFieldSalaryRatio);
  	        
  	        //Years Of Work
  	        JLabel labelYearsOfWork = new JLabel("Years Of Work");
  	        labelYearsOfWork.setLocation(20, 200);
  	        labelYearsOfWork.setSize(labelYearsOfWork.getPreferredSize());
  	        this.add(labelYearsOfWork);
  	             
  	        JTextField textFieldYearsOfWork = new JTextField();
  	        textFieldYearsOfWork.setBounds(150, 200, 200, 25);
  	        this.add(textFieldYearsOfWork);
  	        
  	        //Basic Salary
  	        JLabel labelBasicSalary = new JLabel("Basic Salary");
  	        labelBasicSalary.setLocation(20, 240);
  	        labelBasicSalary.setSize(labelYearsOfWork.getPreferredSize());
	        this.add(labelBasicSalary);
	             
	        JTextField textFieldBasicSalary = new JTextField();
	        textFieldBasicSalary.setBounds(150, 240, 200, 25);
	        textFieldBasicSalary.setText(Float.toString(Define.DEFAULT_BASIC_SALARY));
	        textFieldBasicSalary.setEditable(false);
	        this.add(textFieldBasicSalary);
  	    }
     }

      class PanelButtonStaff extends JPanel {
    	  
    		public PanelButtonStaff() {

    	        this.setLayout(null);
    	        
    	        //Hometown
    	        JLabel labelHometown = new JLabel("Hometown");
    	        labelHometown.setLocation(20, 0);
    	        labelHometown.setSize(labelHometown.getPreferredSize());
    	        this.add(labelHometown);
    	             
    	        JTextField textFieldHometown = new JTextField();
    	        textFieldHometown.setBounds(150, 0, 200, 25);
    	        this.add(textFieldHometown);
    	        
    	        //Department
    	        JLabel labelDepartment = new JLabel("Department");
    	        labelDepartment.setLocation(20, 40);
    	        labelDepartment.setSize(labelDepartment.getPreferredSize());
    	        this.add(labelDepartment);
    	             
    	        JTextField textFieldDepartment = new JTextField();
    	        textFieldDepartment.setBounds(150, 40, 200, 25);
    	        this.add(textFieldDepartment);
    	        
    	        //Allowance
    	        JLabel labelAllowance = new JLabel("Allowance");
    	        labelAllowance.setLocation(20, 280);
    	        labelAllowance.setSize(labelAllowance.getPreferredSize());
    	        this.add(labelAllowance);
    	             
    	        JTextField textFieldAllowance = new JTextField();
    	        textFieldAllowance.setBounds(150, 280, 200, 25);
    	        textFieldAllowance.setEditable(false);
    	        this.add(textFieldAllowance);
    	            
    	        //Position
    	        JLabel labelPosition = new JLabel("Position");
    	        labelPosition.setLocation(20, 80);
    	        labelPosition.setSize(labelPosition.getPreferredSize());
    	        this.add(labelPosition);
    	         
    	        String typePosition[]={Define.POSITION_OF_CHIEF, Define.POSITION_OF_DEBUTY, Define.POSITION_OF_EMPLOYEE};
    	        JComboBox cbTypePosition = new JComboBox(typePosition);
    	        cbTypePosition.setBounds(150, 80, 200, 25);
    	        cbTypePosition.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						switch (cbTypePosition.getSelectedIndex()) {
						case 0: {
							textFieldAllowance.setText(Float.toString(Define.ALLOWANCE_OF_CHIEF));
							break;
						}
						case 1: {
							textFieldAllowance.setText(Float.toString(Define.ALLOWANCE_OF_DEBUTY));
							break;
						}
						case 2: {
							textFieldAllowance.setText(Float.toString(Define.ALLOWANCE_OF_EMPLOYEE));
							break;
						}
						}
					}
				});
    	        this.add(cbTypePosition);
    	        
    	        //Work days
    	        JLabel labelWorkDays = new JLabel("Work days");
    	        labelWorkDays.setLocation(20, 120);
    	        labelWorkDays.setSize(labelWorkDays.getPreferredSize());
    	        this.add(labelWorkDays);
    	             
    	        JTextField textFieldWorkDays = new JTextField();
    	        textFieldWorkDays.setBounds(150, 120, 200, 25);
    	        this.add(textFieldWorkDays);
    	        
    	        //Salary ratio
    	        JLabel labelSalaryRatio = new JLabel("Salary ratio");
    	        labelSalaryRatio.setLocation(20, 160);
    	        labelSalaryRatio.setSize(labelSalaryRatio.getPreferredSize());
    	        this.add(labelSalaryRatio);
    	             
    	        JTextField textFieldSalaryRatio = new JTextField();
    	        textFieldSalaryRatio.setBounds(150, 160, 200, 25);
    	        this.add(textFieldSalaryRatio);
    	        
    	        //Years Of Work
    	        JLabel labelYearsOfWork = new JLabel("Years Of Work");
    	        labelYearsOfWork.setLocation(20, 200);
    	        labelYearsOfWork.setSize(labelYearsOfWork.getPreferredSize());
    	        this.add(labelYearsOfWork);
    	             
    	        JTextField textFieldYearsOfWork = new JTextField();
    	        textFieldYearsOfWork.setBounds(150, 200, 200, 25);
    	        this.add(textFieldYearsOfWork);
    	        
    	        //Basic Salary
    	        JLabel labelBasicSalary = new JLabel("Basic Salary");
      	        labelBasicSalary.setLocation(20, 240);
      	        labelBasicSalary.setSize(labelBasicSalary.getPreferredSize());
    	        this.add(labelBasicSalary);
    	             
    	        JTextField textFieldBasicSalary = new JTextField();
    	        textFieldBasicSalary.setBounds(150, 240, 200, 25);
    	        textFieldBasicSalary.setText(Float.toString(Define.DEFAULT_BASIC_SALARY));
    	        textFieldBasicSalary.setEditable(false);
    	        this.add(textFieldBasicSalary);
    	        
    	        
    	    }
    	}
      
      class PanelButtonCasualWorker extends JPanel {
    	  
    	  public PanelButtonCasualWorker() {
    		 
    	    this.setLayout(null);  
    		  
    	    //Work days
    		JLabel labelWorkDays = new JLabel("Work days");
  	        labelWorkDays.setLocation(20, 0);
  	        labelWorkDays.setSize(labelWorkDays.getPreferredSize());
  	        this.add(labelWorkDays);
  	             
  	        JTextField textFieldWorkDays = new JTextField();
  	        textFieldWorkDays.setBounds(150, 0, 200, 25);
  	        this.add(textFieldWorkDays);
  	        
  	        //Price Of Work Day
  	        JLabel labelPriceOfWorkDay = new JLabel("Price Of Work Day");
	        labelPriceOfWorkDay.setLocation(20, 40);
	        labelPriceOfWorkDay.setSize(labelPriceOfWorkDay.getPreferredSize());
	        this.add(labelPriceOfWorkDay);
	             
	        JTextField textFieldPriceOfWorkDay = new JTextField();
	        textFieldPriceOfWorkDay.setBounds(150, 40, 200, 25);
	        this.add(textFieldPriceOfWorkDay);
    	  }
      }
      
      class PanelButtonAction extends JPanel {
      	
	      	public PanelButtonAction(boolean isEdited) {
	      		setLayout(null);
	      		
	      		JButton actionButton = new JButton();
	      		actionButton.setText("Update");
	      		actionButton.setLocation(50, 0);
	      		actionButton.setSize(100, 30);
	      		
	      		actionButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
	      			}
	      		});
	      		
	      		this.add(actionButton);
	      		
	      	}
      }
}
