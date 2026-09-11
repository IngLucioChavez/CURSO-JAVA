import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class StringAFechaDate {
    public static void main(String[] args) throws ParseException {

        Scanner entrada = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); //se define formato a recibir
        String fechaUsuario;

        try{
            System.out.print("ingrese fecha con formato yyyy-MM-dd: ");
            fechaUsuario = entrada.next();
            Date fecha = formato.parse(fechaUsuario); //formato que se recibe
            System.out.println("fecha = " + fecha);
            System.out.println("fecha = " + formato.format(fecha));

            //Date fecha2 = Calendar.getInstance().getTime();
            Date fecha2 = new Date();

            if(fecha.after(fecha2))
                System.out.println("fecha de usuario después de fecha2");
            else if(fecha.before(fecha2))
                System.out.println("fecha de usuario antes de fecha2");
            else if(fecha.equals(fecha2))
                System.out.println("son iguales");

            if(fecha.compareTo(fecha2) > 0)
                System.out.println("fecha de usuario después de fecha2");
            else if(fecha.compareTo(fecha2) < 0)
                System.out.println("fecha de usuario antes de fecha2");
            else if(fecha.compareTo(fecha2) == 0)
                System.out.println("son iguales");


        } catch(ParseException e){
            e.printStackTrace();
        }

    }
}
