import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TareaEdadDate {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Proporciona tu fecha de nacimiento en formato yyyy-MM-dd: ");
        String fechaUsuarioStr = entrada.next(); //recibe texto de usuario

        try {

            //define formato que se espera recibir
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance(); //calendar1 para fecha actual
            calendar.setTime(new Date()); //define calendar con fecha actual
            Calendar fechaUsuario = Calendar.getInstance(); //calendar2 para fecha de usuario
            fechaUsuario.setTime(formato.parse(fechaUsuarioStr)); //asigna fecha date conforme a formato
            Integer edadUsuario = calendar.get(Calendar.YEAR) - fechaUsuario.get(Calendar.YEAR); //calculo
            System.out.println("tu edad es: " + edadUsuario);

        } catch(ParseException e){
            e.printStackTrace();
        }

    }
}
