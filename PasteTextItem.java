import javax.swing.JMenu;

public class PasteTextItem extends MenuItem{
	PasteTextItem(String label, JMenu menu, String command, SimpleNotePadRefactored pad){
		super(label, menu, command, pad);
	}
	public void DoCommand(SimpleNotePadRefactored pad){
        pad.TextPane.paste();   
	}
}


