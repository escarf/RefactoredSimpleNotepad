import javax.swing.JMenu;

public class SimpleReplaceTextItem extends MenuItem{
	SimpleReplaceTextItem(String label, JMenu menu, String command, SimpleNotePadRefactored pad){
		super(label, menu, command, pad);
	}
	public void DoCommand(SimpleNotePadRefactored pad){
        pad.TextPane.paste();
	}

}