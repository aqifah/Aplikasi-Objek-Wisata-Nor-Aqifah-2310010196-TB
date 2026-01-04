
package objekwisata.app;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JTable;

public class StrukPDF {

    public static void buatStruk(
            String noTransaksi,
            String tanggal,
            String namaPelanggan,
            JTable tabelWisata,
            int total
    ) {
        try {
            // ===== BUAT FOLDER =====
            File folder = new File("struk");
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // ===== FILE PDF =====
            String namaFile = "struk/Struk_" + noTransaksi + ".pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(namaFile));

            document.open();

            // ===== HEADER =====
            document.add(new Paragraph("STRUK PEMBELIAN TIKET"));
            document.add(new Paragraph("----------------------------------"));
            document.add(new Paragraph("No Transaksi : " + noTransaksi));
            document.add(new Paragraph("Tanggal      : " + tanggal));
            document.add(new Paragraph("Pelanggan    : " + namaPelanggan));
            document.add(new Paragraph("----------------------------------"));

            // ===== ISI TABEL =====
            for (int i = 0; i < tabelWisata.getRowCount(); i++) {
                String namaWisata = tabelWisata.getValueAt(i, 1).toString();
                String harga      = tabelWisata.getValueAt(i, 2).toString();
                String qty        = tabelWisata.getValueAt(i, 3).toString();
                String subtotal   = tabelWisata.getValueAt(i, 4).toString();

                document.add(new Paragraph(
                        namaWisata +
                        " | Qty: " + qty +
                        " | Harga: " + harga +
                        " | Subtotal: " + subtotal
                ));
            }

            // ===== FOOTER =====
            document.add(new Paragraph("----------------------------------"));
            document.add(new Paragraph("TOTAL BAYAR : Rp " + total));
            document.add(new Paragraph("TERIMA KASIH"));

            document.close();

        } catch (Exception e) {
            System.out.println("Gagal membuat struk PDF");
            e.printStackTrace();
        }
    }
}

