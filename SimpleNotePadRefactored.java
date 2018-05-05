import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

@SuppressWarnings("serial") //not using serialization
public class SimpleNotePadRefactored extends JFrame implements ActionListener{
		
	JMenuBar MenuBar = new JMenuBar();
    JMenu FileMenu = new JMenu("File");
    JMenu EditMenu = new JMenu("Edit");
    JTextPane TextPane = new JTextPane();
    
    ArrayList<MenuItem> ItemList = new ArrayList<MenuItem>();
    ArrayList<JMenu> SubMenuItemList = new ArrayList<JMenu>();
    ArrayList<String> RecentFileList = new ArrayList<String>();
    
    public SimpleNotePadRefactored() {
        MenuSetup();      
        AddScrollPane();
        CreateAndShowFrame();
    }
       
    @Override
    public void actionPerformed(ActionEvent e) { 
        for(int i = 0; i < ItemList.size(); i++){
        	if(ItemList.get(i).CommandTest(e, this)){
        		ItemList.get(i).DoCommand(this);
        		break;
        	}
        }
    }
    public void AddItemToPad(MenuItem item){
    	ItemList.add(item);
    }
    
    public void AddRecentFile(String fileName){   
    	if(RecentFileList.contains(fileName)){ 
    		RecentFileList.remove(fileName); //to preserve order
    	}
    	RecentFileList.add(fileName);
    }
    
    public OpenRecentFileItem getRecentFileObject(){
    	for(int i = 0; i < ItemList.size(); i++ ){
    		
    		if(ItemList.get(i) instanceof OpenRecentFileItem){
    			return (OpenRecentFileItem) ItemList.get(i);
    		}
    	}
    	return null;
    }

    private void MenuSetup(){
        MenuBar.add(FileMenu);
        MenuBar.add(EditMenu);
        setJMenuBar(MenuBar);
    }
    private void AddScrollPane(){
    	add(new JScrollPane(TextPane));
    }
    private void CreateAndShowFrame(){
    	setTitle("A Simple Notepad Tool");
        setPreferredSize(new Dimension(600,600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

}
