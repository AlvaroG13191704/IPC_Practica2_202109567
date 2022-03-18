

package Main;

import javax.swing.JLabel;


public class Cronometro extends Thread{
    public static int hora = 0;
    public static int minuto = 0;
    public static int segundo = 0;
    public static String reloj;
    JLabel etiqueta;
    Cronometro(JLabel lb_cronometro) {
        this.etiqueta = lb_cronometro;
    }
    @Override
    public void run(){
        try
        {
            int x = 0;
            while(FrameMain.iniciahilo){
                Thread.sleep(1000);
                ejecutarHilo(x);
                x++;
            } 
            
        } catch (Exception e)
        {
            System.out.println("EXCEPTION EN EL CRONOMETRO" + e.getMessage());
        }
    }

    private void ejecutarHilo(int x) {
        //System.out.println(x +" - "+ Thread.currentThread().getName());
        segundo++;
        if(segundo > 59){
            segundo = 0;
            minuto ++;
            if(minuto>59){
                minuto = 0;
                hora++;
            }
        }
        
        String textoSegundo = "";
        String textoMinuto = "";
        String textoHora = "";
        
        if(segundo < 10){
            textoSegundo = "0"+segundo;
        }else{
            textoSegundo = ""+segundo;
        }
        
        if(minuto < 10){
            textoMinuto = "0"+minuto;
        }else{
            textoMinuto = ""+minuto;
        }
        
        if(hora < 10){
            textoHora = "0"+hora;
        }else{
            textoHora = ""+hora;
        }
        
        reloj = textoHora+":"+textoMinuto+":"+textoSegundo;
        etiqueta.setText(reloj);
    }
    
    
    
}
