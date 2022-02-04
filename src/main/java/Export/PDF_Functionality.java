package Export;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * <h1>PDF create class</h1>
 * Takes String as input and writes it into a PDF file at a specified path location.
 * Uses the itext library.
 *
 * @author Can Dechert
 */
public class PDF_Functionality
{

    public static void CreatePDF(String _text)
    {
        Document document = new Document();
        try
        {

            //  Initialize path information and filewriter
             PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Public\\Downloads\\HealthInformation.pdf")); // change path accordingly

            //  Writing document text
            document.open();
            document.add(new Paragraph(_text));


            //  Close file and writer to finish
            document.close();
            writer.close();
        }
        catch(DocumentException | FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
