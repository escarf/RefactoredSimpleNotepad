
public class NotePadApp {
	SimpleNotePadRefactored pad = new SimpleNotePadRefactored();
	public static void main(String[] args) {
		NotePadApp app = new NotePadApp();
		app.addItems();
	}
	private void addItems(){
    	NewFileItem newItem = new NewFileItem("New File", pad.FileMenu, "new", pad);
    	pad.AddItemToPad(newItem);
    	
    	SaveFileItem saveItem = new SaveFileItem("Save File", pad.FileMenu, "save", pad);
    	pad.AddItemToPad(saveItem); 

    	PrintFileItem printItem = new PrintFileItem("Print File", pad.FileMenu, "print", pad);
    	pad.AddItemToPad(printItem); 
    	
    	OpenFileItem openItem = new OpenFileItem("Open File", pad.FileMenu, "open", pad);
    	pad.AddItemToPad(openItem);    
    	
    	UndoTextItem undoItem = new UndoTextItem("Undo", pad.EditMenu, "undo", pad);
    	pad.AddItemToPad(undoItem);
    	
    	CopyTextItem copyItem = new CopyTextItem("Copy", pad.EditMenu, "copy", pad);
    	pad.AddItemToPad(copyItem);
    	
    	PasteTextItem pasteItem = new PasteTextItem("Paste", pad.EditMenu, "paste", pad);
    	pad.AddItemToPad(pasteItem);  
    	
    	OpenRecentFileItem recentItem = new OpenRecentFileItem("Open Recent Files", pad.FileMenu, "recent", pad);
    	pad.AddItemToPad(recentItem); 
    	
    	SimpleReplaceTextItem simpleReplaceItem = new SimpleReplaceTextItem("Simple Replace", pad.EditMenu, "simplereplace", pad);
    	pad.AddItemToPad(simpleReplaceItem); 
    	
	}

}
