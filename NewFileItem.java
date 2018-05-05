import javax.swing.JMenu;

public class NewFileItem extends MenuItem{
	NewFileItem(String label, JMenu menu, String command, SimpleNotePadRefactored pad){
		super(label, menu, command, pad);
	}
	public void DoCommand(SimpleNotePadRefactored pad){
		pad.TextPane.setText("");
	}
}
