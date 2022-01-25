package Export;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TXT_Functionality
{

    public static void CreateTXT(String _text) throws IOException
    {
        File file = new File("C:\\HealthInformation.txt"); // PFAD ANPASSEN!
        FileWriter Fwriter = new FileWriter(file, true); // Boolean = true -> Es wird nix überschrieben, false -> Datei wird mit jedem Aufruf gewiped und nur der neue Text reingemacht
        PrintWriter Pwriter = new PrintWriter(Fwriter);

        Pwriter.println(_text);

        Pwriter.close();
    }
}
