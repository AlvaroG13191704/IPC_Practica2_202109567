package Main;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.entity.StandardEntityCollection;

class Ordenamiento implements Runnable {

    public static int pasos;
    public static JLabel pasoslb;
    public static String pasosEfectuados;
    public static String datos_ordenados = "";
    Ordenamiento(JLabel lb_pasos) {
        this.pasoslb = lb_pasos;
    }

    @Override
    public void run() {
        try
        {

            quicksort(FrameMain.datosArreglos, 0, (FrameMain.datosArreglos.length - 1));
            FrameMain.iniciahilo = false;
            if (!FrameMain.iniciahilo)
            {
                pasosEfectuados = String.valueOf(pasos);
                for (int i = 0; i < FrameMain.datosArreglos.length; i++)
                {
                    int dat = FrameMain.datosArreglos[i];
                    String datS = String.valueOf(dat);
                    datos_ordenados += dat +",";
                }
                System.out.println(datos_ordenados);
                JOptionPane.showMessageDialog(new FrameMain(), "Se ha terminado el ordenamiento ascendente");
                pdfOrden1(fechaReportes());
            }

        } catch (HeadlessException e)
        {
        } catch (DocumentException ex)
        {
            Logger.getLogger(Ordenamiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(Ordenamiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(Ordenamiento.class.getName()).log(Level.SEVERE, null, ex);
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
                FrameMain.imprimirGrafica();
                FrameMain.panelNuevo.updateUI();
                Thread.sleep(750);
                pasos++;
                pasoslb.setText(String.valueOf(pasos));
                FrameMain.pMain.remove(FrameMain.panelNuevo);
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

    public static void imprimirConsola() {
        for (int i = 0; i < FrameMain.datosArreglos.length; i++)
        {
            System.out.print(FrameMain.datosArreglos[i] + "-");
        }
        System.out.println("");
    }

    public static void pdfOrden1(String fechaActual) throws DocumentException, FileNotFoundException, BadElementException, IOException {
        if (!FrameMain.iniciahilo)
        {
            System.out.println("Se ha terminado el ordenamiento, precede a generar el pdf y limpiar todo");
            //Hacer png la gráfica
            try
            {
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File fileGraf = new File("E:\\Practica 2 IPC\\Grafica1.png");
                ChartUtilities.saveChartAsPNG(fileGraf, FrameMain.chart, 400, 400, info);
            } catch (IOException e)
            {
            }
            //Creacion del pdf
            Document documento = new Document(PageSize.LETTER);
            Image grafica = Image.getInstance("E:\\Practica 2 IPC\\Grafica1.png");
            OutputStream archivo;
            archivo = new FileOutputStream("E:\\Practica 2 IPC\\" +FrameMain.title +"_"+fechaActual + ".pdf");
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
            datosDesor.add("Arrelgo Desordenado: " + FrameMain.arreglo_desordenado);
            datosDesor.setAlignment(Element.ALIGN_LEFT);
            
            Paragraph datosOrde = new Paragraph();
            datosOrde.add("Arrelgo Ordenado: " + "["+datos_ordenados+"]");
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
            documento.add(grafica);
            //Cierre
            documento.close();
        }
    }

    //Generar fecha para los reportes
    public static String fechaReportes() {
        String fechaActual = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
        return fechaActual;
    }

}
