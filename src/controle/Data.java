/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.Calendar;

/**
 *
 * @author acsgs
 */
public class Data {
    public static String data;
    public static String ndata;
    public static void data() {
        Calendar cal = Calendar.getInstance();
        String  mes = String.valueOf(cal.get(Calendar.MONTH) + 1);
        String dia = String.valueOf(cal.get(Calendar.DATE));
        if(dia.length()==1){
            dia="0"+dia;
        }
        if(mes.length()==1){
            mes="0"+mes;
        }
        ndata=+cal.get(Calendar.DATE)+"/"+mes+"/"+cal.get(Calendar.YEAR);
        data="Jandira "+ndata;
    }
}
