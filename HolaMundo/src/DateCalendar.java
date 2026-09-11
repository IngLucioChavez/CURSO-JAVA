import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCalendar {
    public static void main(String[] args) {

        //objeto para definir fecha
        Date fecha = new Date();
        System.out.println("fecha = " + fecha);
        //objeto para definir formato
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
        String fechaStr = formato.format(fecha);
        System.out.println("fechaStr = " + fechaStr);

        long tiempo1 = fecha.getTime(); //unixtime en ms
        long j = 0;
        for(long i = 0L; i < 9999L; i++){
        }
        long tiempo2 = fecha.getTime(); //unixtime en ms

        System.out.println((tiempo2-tiempo1) + "ms");


    }
}
