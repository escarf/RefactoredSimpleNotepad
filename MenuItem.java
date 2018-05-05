import java.awt.event.ActionEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuItem {
	JMenuItem item;
	JMenu submenu;
	
    MenuItem(String label, JMenu menu, String command, SimpleNotePadRefactored pad){
    	item = new JMenuItem(label);
    	AddMenuItem(menu, command, pad);    	
    }
    MenuItem(){
    	//called when you want to handle 'item' or 'submenu' in specific ways
    } 
    
    public void AddMenuItem(JMenu menu, String command, SimpleNotePadRefactored pad){
    	menu.addSeparator();
    	menu.add(item);
        item.addActionListener(pad);
        item.setActionCommand(command);      
    }


    public boolean CommandTest(ActionEvent e, SimpleNotePadRefactored pad) {
    	return e.getActionCommand().equals(item.getActionCommand());
    }
    public void DoCommand(SimpleNotePadRefactored pad){
    	//Overridden in each subclass
    }
    
}
