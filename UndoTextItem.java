import javax.swing.JMenu;

public class UndoTextItem extends MenuItem{
	UndoTextItem(String label, JMenu menu, String command, SimpleNotePadRefactored pad){
		super(label, menu, command, pad);
	}
	public void DoCommand(SimpleNotePadRefactored pad){
	}
}