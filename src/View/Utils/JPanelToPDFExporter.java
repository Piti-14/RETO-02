package View.Utils;
import View.AddPanel;
import org.w3c.dom.Document;
/*
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;

public class JPanelToPDFExporter {

    public static void exportToPDF(JPanel panel, String filePath) {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Create a temporary PDF file to extract the content
            File tempFile = File.createTempFile("temp", ".pdf");
            PdfWriter tempWriter = PdfWriter.getInstance(document, new FileOutputStream(tempFile));
            document.open();

            // Create a Graphics2D object for the temporary PDF file
            Graphics2D g2d = tempWriter.getDirectContent().createGraphics(800, 1000);

            // Paint the JPanel onto the Graphics2D object
            panel.print(g2d);
            g2d.dispose();
            tempWriter.close();

            // Use PdfWriter to import the content from the temporary PDF file to the final PDF
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            PdfReader reader = new PdfReader(tempFile.getAbsolutePath());
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                document.newPage();
                PdfImportedPage page = writer.getImportedPage(reader, i);
                writer.getDirectContent().addTemplate(page, 0, 0);
            }

            document.close();

            // Delete the temporary PDF file
            tempFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create your JPanel object here
            JPanel panel = new AddPanel();

            // Specify the file path for the exported PDF
            String filePath = "path/to/exported.pdf";

            // Export the JPanel to PDF
            exportToPDF(panel, filePath);

            // Show a message dialog to indicate that the export is complete
            JOptionPane.showMessageDialog(null, "Panel exported to PDF: " + filePath);
        });
    }
}

 */
