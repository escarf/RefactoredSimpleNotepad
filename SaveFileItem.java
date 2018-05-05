import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

public class SaveFileItem extends MenuItem{
	SaveFileItem(String label, JMenu menu, String command, SimpleNotePadRefactored pad){
		super(label, menu, command, pad);
	}
	public void DoCommand(SimpleNotePadRefactored pad){
        File fileToWrite = null;
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            fileToWrite = fc.getSelectedFile();
            String fileName = fileToWrite.getAbsolutePath();
            pad.AddRecentFile(fileName);
            pad.getRecentFileObject().UpdateAndShowRecentFileItems(pad);
        }
        try {
            PrintWriter out = new PrintWriter(new FileWriter(fileToWrite));
            out.println(pad.TextPane.getText());
            JOptionPane.showMessageDialog(null, "File is saved success/fully...");
            out.close();
        } catch (IOException ex) {
        } 
	}
}