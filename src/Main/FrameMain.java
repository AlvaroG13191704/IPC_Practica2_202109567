package Main;

import java.io.*;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FrameMain extends javax.swing.JFrame {

    /**
     * Creates new form FrameMain
     */
    //Variables
    File archivo;
    FileReader fr;
    BufferedReader bfr;
    public static int[] datosArreglos;
    static int b;
    static int contador = 0;
    static String title;
    //Grafica 1
    public static DefaultCategoryDataset dataset;
    public static JFreeChart chart;
    public static ChartPanel panel;
    public static JPanel panelNuevo;
    //Grafica 2
    public static DefaultCategoryDataset dataset2;
    public static JFreeChart chart2;
    public static ChartPanel panel2;
    public static JPanel panelNuevo2;

    public static boolean iniciahilo = true;
    public static boolean iniciahilo2 = true;
    
    //PDF o HTML
    public static String arreglo_desordenado;

    public FrameMain() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg1 = new javax.swing.ButtonGroup();
        bg2 = new javax.swing.ButtonGroup();
        pMain = new javax.swing.JPanel();
        lb_ruta = new javax.swing.JLabel();
        lb_titulograf = new javax.swing.JLabel();
        b_examinar = new javax.swing.JButton();
        r_ascen = new javax.swing.JRadioButton();
        r_descen = new javax.swing.JRadioButton();
        p_crono = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lb_cronometro = new javax.swing.JLabel();
        lb_pasos = new javax.swing.JLabel();
        b_ordenar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pMain.setBackground(new java.awt.Color(255, 255, 204));

        lb_ruta.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        lb_ruta.setForeground(new java.awt.Color(0, 0, 0));
        lb_ruta.setText(" Ruta del archivo");
        lb_ruta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));

        lb_titulograf.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        lb_titulograf.setForeground(new java.awt.Color(0, 0, 0));
        lb_titulograf.setText(" Titulo de la gráfica ");
        lb_titulograf.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));

        b_examinar.setText("EXAMINAR");
        b_examinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_examinarActionPerformed(evt);
            }
        });

        bg1.add(r_ascen);
        r_ascen.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        r_ascen.setForeground(new java.awt.Color(0, 0, 0));
        r_ascen.setText("Ascendente");

        bg1.add(r_descen);
        r_descen.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        r_descen.setForeground(new java.awt.Color(0, 0, 0));
        r_descen.setText("Descendente");

        p_crono.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CRONOMETRO");

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PASOS");

        lb_cronometro.setBackground(new java.awt.Color(255, 255, 255));
        lb_cronometro.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        lb_cronometro.setForeground(new java.awt.Color(0, 0, 0));
        lb_cronometro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_cronometro.setText("00:00:00");

        lb_pasos.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        lb_pasos.setForeground(new java.awt.Color(0, 0, 0));
        lb_pasos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout p_cronoLayout = new javax.swing.GroupLayout(p_crono);
        p_crono.setLayout(p_cronoLayout);
        p_cronoLayout.setHorizontalGroup(
            p_cronoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_cronoLayout.createSequentialGroup()
                .addGroup(p_cronoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_cronoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(p_cronoLayout.createSequentialGroup()
                        .addGroup(p_cronoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(p_cronoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lb_cronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, p_cronoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_cronoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lb_pasos, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        p_cronoLayout.setVerticalGroup(
            p_cronoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_cronoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_cronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_pasos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        b_ordenar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        b_ordenar.setForeground(new java.awt.Color(0, 0, 0));
        b_ordenar.setText("ORDENAR");
        b_ordenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ordenarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pMainLayout = new javax.swing.GroupLayout(pMain);
        pMain.setLayout(pMainLayout);
        pMainLayout.setHorizontalGroup(
            pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pMainLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lb_titulograf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_ruta, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE))
                    .addGroup(pMainLayout.createSequentialGroup()
                        .addGap(794, 794, 794)
                        .addComponent(p_crono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pMainLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b_examinar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(r_ascen, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(r_descen, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pMainLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(b_ordenar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(81, 81, 81))
        );
        pMainLayout.setVerticalGroup(
            pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_examinar, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_titulograf, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_ordenar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pMainLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(r_ascen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r_descen, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pMainLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(p_crono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(272, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_examinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_examinarActionPerformed
        // TODO add your handling code here: 
        String contenido = "";
        JFileChooser fc = new JFileChooser();
        int valor = fc.showOpenDialog(pMain);
        if (valor == JFileChooser.APPROVE_OPTION)
        {
            System.out.println(" " + fc.getSelectedFile());
            //Ponerle el nombre al lb
            lb_ruta.setText(String.valueOf(fc.getSelectedFile()));
            archivo = fc.getSelectedFile();
        } else
        {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado un archivo");
        }
        try
        {
            //Leer el archivo seleccionado
            fr = new FileReader(archivo); //se obteien el archivo
            bfr = new BufferedReader(fr); //Leer el archivo
            String linea;
            //Leer lineas del codigo
            while ((linea = bfr.readLine()) != null)
            {
                contenido += linea;
            }
            //System.out.println(contenido);
            //Decodificar el JSON
            JSONParser parser = new JSONParser();
            try
            {
                Object obj = parser.parse(contenido);
                JSONObject jsonObj = (JSONObject) obj;
                System.out.println(jsonObj);
                //Datos
                title = (String) jsonObj.get("title");
                lb_titulograf.setText(" " + title);
                System.out.println("title = " + title);
                //Arreglo
                Object jsonArrayDatos = jsonObj.get("dataset");
                JSONArray datos = (JSONArray) jsonArrayDatos;
                arreglo_desordenado = String.valueOf(datos);
                System.out.println(arreglo_desordenado);
                System.out.println(datos.size());

                datosArreglos = new int[datos.size()];

                //Me imprimo los valores
                for (Object i : datos)
                {
                    String a = String.valueOf(i);
                    b = Integer.parseInt(a);
                    System.out.println(b);
                    //Asignarle el valor al arreglo

                    datosArreglos[contador] = b;
                    System.out.println("Contador " + contador);
                    contador++;

                }

                for (int i = 0; i < datosArreglos.length; i++)
                {
                    System.out.println("valores del arreglo = " + datosArreglos[i]);
                }

            } catch (ParseException ex)
            {
                Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b_examinarActionPerformed

    private void b_ordenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ordenarActionPerformed
        // TODO add your handling code here:
        //this.remove(panel);

        if (!r_ascen.isSelected() && !r_descen.isSelected())
        {
            JOptionPane.showMessageDialog(this, "Seleccione una opción");

        } else
        {
            if (r_ascen.isSelected())
            {

                if (iniciahilo)
                {
                    System.out.println("Eligio ascendente");
                    //Manda a llamar la clase
                    Cronometro cronometro = new Cronometro(lb_cronometro);
                    cronometro.start();
                    Ordenamiento ordenamiento = new Ordenamiento(lb_pasos);
                    Thread hilo_ordenamiento = new Thread(ordenamiento);
                    hilo_ordenamiento.start();

                }
            } else if (r_descen.isSelected())
            {

                if (iniciahilo2)
                {
                    System.out.println("Eligio descendente");
                    Cronometro cronometro = new Cronometro(lb_cronometro);
                    cronometro.start();
                    Ordenamiento2 ordenamiento2 = new Ordenamiento2(lb_pasos);
                    Thread hilo_ordenamiento2 = new Thread(ordenamiento2);
                    hilo_ordenamiento2.start();

                }
            }
        }

    }//GEN-LAST:event_b_ordenarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    public static void imprimirGrafica() {
        dataset = new DefaultCategoryDataset();
        for (int i = 0; i < datosArreglos.length; i++)
        {
            dataset.addValue(datosArreglos[i], String.valueOf(datosArreglos[i]), "");

        }
        chart = ChartFactory.createBarChart3D(title, "Valores", "", dataset, PlotOrientation.VERTICAL, true, false, false);
        panel = new ChartPanel(chart);
        panel.setLayout(null);
        panel.setBounds(0, 0, 779, 482);
        panelNuevo = new JPanel();
        panelNuevo.setVisible(true);
        panelNuevo.setBounds(30, 150, 779, 482);
        panelNuevo.add(panel);
        pMain.add(panelNuevo);  
    }

    public static void imprimirGrafica2() {
        dataset2 = new DefaultCategoryDataset();
        for (int i = datosArreglos.length - 1; i >= 0; i--)
        {
            dataset2.addValue(datosArreglos[i], String.valueOf(datosArreglos[i]), "");

        }
        chart2 = ChartFactory.createBarChart3D(title, "Valores", "", dataset2, PlotOrientation.VERTICAL, true, false, false);
        panel2 = new ChartPanel(chart2);
        panel2.setLayout(null);
        panel2.setBounds(0, 0, 779, 482);
        panelNuevo2 = new JPanel();
        panelNuevo2.setVisible(true);
        panelNuevo2.setBounds(30, 150, 779, 482);
        panelNuevo2.add(panel2);
        pMain.add(panelNuevo2);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_examinar;
    private javax.swing.JButton b_ordenar;
    private javax.swing.ButtonGroup bg1;
    private javax.swing.ButtonGroup bg2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel lb_cronometro;
    public static javax.swing.JLabel lb_pasos;
    public static javax.swing.JLabel lb_ruta;
    public static javax.swing.JLabel lb_titulograf;
    public static javax.swing.JPanel pMain;
    private javax.swing.JPanel p_crono;
    public static javax.swing.JRadioButton r_ascen;
    public static javax.swing.JRadioButton r_descen;
    // End of variables declaration//GEN-END:variables
}
