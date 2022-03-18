package Main;

import static Main.Ordenamiento.datos_ordenados;
import static Main.Ordenamiento.pasosEfectuados;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.entity.StandardEntityCollection;

class Ordenamiento2 implements Runnable {

    public static int pasos;
    public static JLabel pasoslb;
    public static String pasosEfectuados;
    public static String datos_ordenados = "";

    Ordenamiento2(JLabel lb_pasos) {
        this.pasoslb = lb_pasos;
    }

    @Override
    public void run() {
        try
        {

            quicksort(FrameMain.datosArreglos, 0, (FrameMain.datosArreglos.length - 1));
            FrameMain.iniciahilo2 = false;
            FrameMain.iniciahilo = false;
            if (!FrameMain.iniciahilo2)
            {
                pasosEfectuados = String.valueOf(pasos);
                for (int i = FrameMain.datosArreglos.length-1; i >=0; i--)
                {
                    int dat = FrameMain.datosArreglos[i];
                    String datS = String.valueOf(dat);
                    datos_ordenados += dat + ",";
                }
                
            }
            System.out.println(datos_ordenados);
            pdfOrden2(Ordenamiento.fechaReportes());
            html2(Ordenamiento.fechaReportes());
            JOptionPane.showMessageDialog(new FrameMain(), "Se ha terminado el ordenamiento descendente y creado los reportes");
        } catch (HeadlessException e)
        {
        } catch (DocumentException | IOException ex)
        {
            Logger.getLogger(Ordenamiento2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void quicksort(int A[], int izq, int der) {
        try
        {
            int pivote = A[izq];
            int i = izq;
            int j = der;
            int aux;
            
            while (i < j)
            {

                while (A[i] <= pivote && i < j)
                {
                    i++;
                }

                while (A[j] > pivote)
                {
                    j--;
                }
                imprimirConsola();
                FrameMain.imprimirGrafica2();
                FrameMain.panelNuevo2.updateUI();
                Thread.sleep(750);
                pasos++;
                pasoslb.setText(String.valueOf(pasos));
                FrameMain.pMain.remove(FrameMain.panelNuevo2);
                if (i < j)
                {
                    aux = A[i];
                    A[i] = A[j];
                    A[j] = aux;

                }
            }
            A[izq] = A[j];
            A[j] = pivote;

            if (izq < j - 1)
            {
                quicksort(A, izq, j - 1);
            }
            if (j + 1 < der)
            {
                quicksort(A, j + 1, der);
            }

        } catch (InterruptedException e)
        {
        }
    }

    public static void pdfOrden2(String fechaActual) throws DocumentException, FileNotFoundException, BadElementException, IOException {
        if (!FrameMain.iniciahilo)
        {
            System.out.println("Se ha terminado el ordenamiento, precede a generar el pdf y limpiar todo");
            //Hacer png la gráfica
            try
            {
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File fileGraf = new File("E:\\Practica 2 IPC\\Grafica2.png");
                ChartUtilities.saveChartAsPNG(fileGraf, FrameMain.chart2, 500, 400, info);
            } catch (IOException e)
            {
            }
            //Creacion del pdf
            Document documento = new Document(PageSize.LETTER);
            Image grafica = Image.getInstance("E:\\Practica 2 IPC\\Grafica2.png");
            OutputStream archivo;
            archivo = new FileOutputStream("E:\\Practica 2 IPC\\" + FrameMain.title + "_" + fechaActual + ".pdf");
            PdfWriter.getInstance(documento, archivo);
            //Abrir
            documento.open();
            //Paragraphs
            Paragraph nombre = new Paragraph();
            nombre.add("Alvaro Norberto García Meza");
            nombre.setAlignment(Element.ALIGN_LEFT);

            Paragraph carnet = new Paragraph();
            carnet.add("Carnet: 202109567");
            carnet.setAlignment(Element.ALIGN_LEFT);

            Paragraph tipo = new Paragraph();
            tipo.add("Ordenamiento utilizado: QUICKSORT");
            tipo.setAlignment(Element.ALIGN_LEFT);

            Paragraph tiempo = new Paragraph();
            tiempo.add("Transcurrieron: " + Cronometro.reloj);
            tiempo.setAlignment(Element.ALIGN_LEFT);

            Paragraph pasos = new Paragraph();
            pasos.add("Pasos efecutados: " + pasosEfectuados);
            pasos.setAlignment(Element.ALIGN_LEFT);

            Paragraph datosDesor = new Paragraph();
            datosDesor.add("Arreglo Desordenado: " + FrameMain.arreglo_desordenado);
            datosDesor.setAlignment(Element.ALIGN_LEFT);

            Paragraph datosOrde = new Paragraph();
            datosOrde.add("Arreglo Ordenado: " + "[" + datos_ordenados + "]");
            datosOrde.setAlignment(Element.ALIGN_LEFT);

            //Agregar gráfica
            grafica.setAlignment(Element.ALIGN_CENTER);

            //Adds
            documento.add(nombre);
            documento.add(Chunk.NEWLINE);
            documento.add(carnet);
            documento.add(Chunk.NEWLINE);
            documento.add(tipo);
            documento.add(Chunk.NEWLINE);
            documento.add(tiempo);
            documento.add(Chunk.NEWLINE);
            documento.add(pasos);
            documento.add(Chunk.NEWLINE);
            documento.add(datosDesor);
            documento.add(Chunk.NEWLINE);
            documento.add(datosOrde);
            documento.add(Chunk.NEWLINE);
            documento.newPage();
            documento.add(grafica);
            //Cierre
            documento.close();
        }
    }
    public static void html2(String fechaActual) {
        String nombre_reporte;
        File reporteHTML;
        FileWriter fw;
        BufferedWriter buff;
        String contenidoHTML;

        try
        {
            nombre_reporte = "E:\\Practica 2 IPC\\" + FrameMain.title + "_" + fechaActual + ".html";
            reporteHTML = new File(nombre_reporte);
            fw = new FileWriter(reporteHTML);
            buff = new BufferedWriter(fw);
            //Texto en HTML
            contenidoHTML = "<html>\n"
                    + "    <head>\n"
                    + "        <title>PRACTICA 2 </title>\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <h2>Alvaro Norberto Garcia Meza</h2>\n"
                    + "        <h3>Carnet: 202109567</h3>\n"
                    + "        <h3>Ordenamiento Utilizado: QUICKSORT</h3>\n"
                    + "        <h3>Transcurrieron: " + Cronometro.reloj + "</h3>\n"
                    + "        <h3>Pasos efectuados: " + pasosEfectuados + "</h3>\n"
                    + "        <h3>Arreglo Desordenado: " + FrameMain.arreglo_desordenado + "</h3>\n"
                    + "        <h3>Arreglo Ordenado: [" + datos_ordenados + "]</h3>\n"
                    + "        <div style=\"text-align: center;\">\n"
                    + "            <img src=\"E:\\\\Practica 2 IPC\\\\Grafica2.png\">"
                    + "        </div>"
                    + "    </body>\n"
                    + "</html>";
            buff.write(contenidoHTML);
            buff.close();
            fw.close();
            //pdfOrden1(fechaActual, contenidoHTML);
            Document documentoHTML = new Document();
            documentoHTML.open();
            HTMLWorker htmlWorker = new HTMLWorker(documentoHTML);
            htmlWorker.parse(new StringReader(contenidoHTML));
            documentoHTML.close();
            
        } catch (Exception e)
        {
        }
    }

    public static void imprimirConsola() {
        for (int i = FrameMain.datosArreglos.length - 1; i >= 0; i--)
        {
            System.out.print(FrameMain.datosArreglos[i] + "-");
        }
        System.out.println("");
    }

}
