import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JMenu;

public class OpenFileItem extends MenuItem{
	OpenFileItem(String label, JMenu menu, String command, SimpleNotePadRefactored pad){
		super(label, menu, command, pad);
	}
	public void DoCommand(SimpleNotePadRefactored pad){
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(pad);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            String fileName = file.getAbsolutePath();
            pad.AddRecentFile(fileName);
            
            pad.getRecentFileObject().UpdateAndShowRecentFileItems(pad);
            readFile(file, pad);
        }
	}
	public static void readFile(File file, SimpleNotePadRefactored pad){
		pad.TextPane.setText("");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        	String line;
        	while ((line = br.readLine()) != null) {
        		pad.TextPane.setText(pad.TextPane.getText()  +  line + "\n");
			}
        }

        catch (IOException e) {
		}
	}
}

