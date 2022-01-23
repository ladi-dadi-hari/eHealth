package Export;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//Kein Grade insert nötig, alles in java mit drin :]

public class TXT_Functionality {
	public static void CreateTXT(String _text) throws IOException 
	{
		File file = new File("E:\\TestTXT.txt"); // PFAD ANPASSEN!
		FileWriter Fwriter = new FileWriter(file, true); // Boolean = true -> Es wird nix überschrieben, false -> Datei wird mit jedem Aufruf gewiped und nur der neue Text reingemacht
		PrintWriter Pwriter = new PrintWriter(Fwriter);
		
		Pwriter.println(_text);
		
		Pwriter.close();
	}
}
