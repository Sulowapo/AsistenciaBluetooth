package funciones;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Tiempo {

    private Calendar fecha = new GregorianCalendar();

    private String anho = Integer.toString(fecha.get(Calendar.YEAR));
    private String mes = Integer.toString(fecha.get(Calendar.MONTH)+1);
    private String dia = Integer.toString(fecha.get(Calendar.DATE));

    public Tiempo() {
    }
    
    public String getFecha() {
        String fechacomp = dia + "-" + mes + "-" + anho;
        return fechacomp;
    }

    
}
