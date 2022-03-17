package Main;

import java.awt.HeadlessException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class Ordenamiento2 implements Runnable {

    public static int pasos;
    public static JLabel pasoslb;

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
                JOptionPane.showMessageDialog(new FrameMain(), "Se ha terminado el ordenamiento descendente");
            }

        } catch (HeadlessException e)
        {
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
                Thread.sleep(500);
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

   

    
    public static void imprimirConsola() {
        for (int i = FrameMain.datosArreglos.length-1; i >=0 ; i--)
        {
            System.out.print(FrameMain.datosArreglos[i] + "-");
        }
        System.out.println("");
    }

}
