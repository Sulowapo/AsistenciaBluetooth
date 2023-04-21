/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formularios;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Tiempo {
  
    Calendar fecha = new GregorianCalendar();
    
    String anho = Integer.toString(fecha.get(Calendar.YEAR));
     String mes = Integer.toString(fecha.get(Calendar.MONTH));
    String dia = Integer.toString(fecha.get(Calendar.DATE));
    
    
    String fechacomp = anho+"-"+mes+"-"+dia;
    
    
    
    
    
    
    
    
    
}
