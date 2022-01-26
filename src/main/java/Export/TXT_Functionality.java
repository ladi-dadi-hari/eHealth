package Export;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <h1>TXT create class</h1>
 * Takes String as input and writes it into a TXT file at a specified path location.
 *
 * @author Can Dechert
 */
public class TXT_Functionality
{
    public static void CreateTXT(String _text) throws IOException
    {

        //  Initialize path information
        File file = new File("C:\\HealthInformation.txt"); // change path accordingly

        //  Initialize Filewriter

        FileWriter Fwriter = new FileWriter(file, false); // Boolean = true -> nothing gets overwritten, new text added in the back
        PrintWriter Pwriter = new PrintWriter(Fwriter);          //           false -> document gets wiped and the new text is inserted

        //  Writing document text
        Pwriter.println(_text);

        //  Close file to finish
        Pwriter.close();
    }
}
