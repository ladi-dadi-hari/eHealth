package Export;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

class PDF_Functionalty 
{
	public static void CreatePDF(String _text) 
	{
		Document document = new Document();
		try 
		{
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("E:\\TestPDF.pdf")); // PFAD ANPASSEN!
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
