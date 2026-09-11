import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ClaseCalendar {
    public static void main(String[] args) {

        // Calendar para asignar fecha en especifico
        Calendar calendario = Calendar.getInstance(); //no se puede usar new() x que es una clase abstracta
        //asignación de forma inmediata
        //calendario.set(2026,Calendar.AUGUST,10,10,10,10);

        //asignación parte x parte
        calendario.set(Calendar.YEAR,2026);
        calendario.set(Calendar.MONTH,Calendar.AUGUST);
        calendario.set(Calendar.DAY_OF_MONTH,8);
        calendario.set(Calendar.HOUR_OF_DAY,12);
        calendario.set(Calendar.MINUTE,30);
        calendario.set(Calendar.SECOND,0);
        calendario.set(Calendar.MILLISECOND,125);
        //calendario.set(Calendar.AM_PM,Calendar.AM); //para asignar am o pm si es hora de 12hrs

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:SSS");
        Date fecha = calendario.getTime();
        System.out.println("fecha = " + formato.format(fecha));

    }
}
