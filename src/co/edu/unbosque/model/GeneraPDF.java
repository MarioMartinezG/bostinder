/**
 * Clase para construir un PDF
 */
package co.edu.unbosque.model;

import java.io.InputStream;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.facades.PdfFileMend;

/**
 * @author Andres.Martinez
 *
 */
public class GeneraPDF {
	private static String carpeta = "datos/";

	/**
	 * Metodo para crear y escribir un archivo PDF
	 * 
	 * @param nombrePDF - Nombre del archivo PDF a escribir
	 * @param grafico   - Imagen del grafico a generar
	 */
	public void generarPDF(String nombre, InputStream grafico) {
		Document doc = new Document();
		PdfFileMend mender = new PdfFileMend();

		mender.bindPdf(doc);

		Page pag = doc.getPages().add();
		pag.getParagraphs().add(new TextFragment("Informe de Usuarios - Aplicación Vudu"));
		mender.addImage(grafico, 1, 10, 400, 510, 850);

		doc.save(carpeta + nombre);
		System.out.println("PDF guardado en directorio ./datos");
	}
}
