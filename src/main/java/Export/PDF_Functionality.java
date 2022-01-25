package Export;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDF_Functionality
{

    public static void CreatePDF(String _text)
    {
        Document document = new Document();
        try
        {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\HealthInformation.pdf")); // PFAD ANPASSEN!
            document.open();
            document.add(new Paragraph(_text));
            document.close();
            writer.close();
        }
        catch(DocumentException e)
        {
            e.printStackTrace();
        }
        catch(FileNotFoundException f)
        {
            f.printStackTrace();
        }
    }
}
