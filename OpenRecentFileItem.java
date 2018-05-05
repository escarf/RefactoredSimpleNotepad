import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class OpenRecentFileItem extends MenuItem{
		
	OpenRecentFileItem(String label, JMenu menu, String command, SimpleNotePadRefactored pad){
		super();
		
    	submenu = new JMenu(label);
    	menu.addSeparator();
    	menu.add(submenu);
    	submenu.addActionListener(pad);
    	submenu.setActionCommand(command); 
    	
		UpdateAndShowRecentFileItems(pad);
	}
	
	public void DoCommand(SimpleNotePadRefactored pad){
		UpdateAndShowRecentFileItems(pad);  		
	}
	
    public boolean CommandTest(ActionEvent e, SimpleNotePadRefactored pad) {
    	if(e.getActionCommand().equals(submenu.getActionCommand())){
    		return true;
    	}	
    	RecentFileFinderAndReader(e, pad);
    	return false;
    }
    
    //where the action events for opening recent files are handled 
    private void RecentFileFinderAndReader(ActionEvent e, SimpleNotePadRefactored pad){
    	for(int i = 0; i < pad.RecentFileList.size(); i++){
    		if(pad.RecentFileList.get(i).equals(e.getActionCommand())){
    			//open this file
    			File fileToOpen = new File(pad.RecentFileList.get(i));
    			pad.AddRecentFile(fileToOpen.getAbsolutePath());
    			UpdateAndShowRecentFileItems(pad);
    			OpenFileItem.readFile(fileToOpen, pad);
    			break;
    		}
    	}		
    	  	
    }
	public void UpdateAndShowRecentFileItems(SimpleNotePadRefactored pad){
		submenu.removeAll();
    	for(int i = 0; i < pad.RecentFileList.size(); i++){
    		JMenuItem FileNameItem = new JMenuItem(pad.RecentFileList.get(i));  		
    		submenu.add(FileNameItem);
    		submenu.addSeparator();
            FileNameItem.addActionListener(pad);
            FileNameItem.setActionCommand(pad.RecentFileList.get(i));   
    	}
	}
}
