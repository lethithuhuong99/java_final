package vnuk.huong170205.finalexam.viewGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    
    public MainFrame() {
        JPanel mainPanel = new JPanel();
        getContentPane().add(mainPanel);
        
        setTitle("Main Panel");
        setVisible(true);
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        
        Menu1(menuBar);  
    }
    
    public void Menu1(JMenuBar menubar) {
        JMenu menu = new JMenu("Menu 1");
        menubar.add(menu);
        
        JMenuItem menuItem_1 = new JMenuItem("Add new staff in the bottom");
        menu.add(menuItem_1);
        
        menuItem_1.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add new staff™");
                AddNewPersonFrame addNewPersonFrame = new AddNewPersonFrame(1, 1, false);
                addNewPersonFrame.setVisible(true);
            }
        });
        
        JMenuItem menuItem_2 = new JMenuItem("Add new staff on the top");
        menu.add(menuItem_2);
        
        menuItem_2.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add new staff™");
                AddNewPersonFrame addNewPersonFrame = new AddNewPersonFrame(1, 1, false);
                addNewPersonFrame.setVisible(true);
            }
        });
        
        JMenuItem menuItem_3 = new JMenuItem("Add new staff after specific position");
        menu.add(menuItem_3);
        
        JMenuItem menuItem_4 = new JMenuItem("Add new staff in the bottom from staff.txt");
        menu.add(menuItem_4);
        
        JMenuItem menuItem_5 = new JMenuItem("Add new casual worker from labor.txt");
        menu.add(menuItem_5);
    }   
}
