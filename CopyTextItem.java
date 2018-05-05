import javax.swing.JMenu;

public class CopyTextItem extends MenuItem{
	CopyTextItem(String label, JMenu menu, String command, SimpleNotePadRefactored pad){
		super(label, menu, command, pad);
	}
	public void DoCommand(SimpleNotePadRefactored pad){
		pad.TextPane.copy();
	}
}


