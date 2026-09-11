import java.io.IOException;

public class EjemploRuntimeClass {
    public static void main(String[] args) {

        ProcessBuilder pb;
        Process proceso;

        if(System.getProperty("os.name").startsWith("Mac")){
            try{
                //abriendo instancia de visual studio code en MAC
                pb = new ProcessBuilder("open","-n","-a","Visual Studio Code");
                pb.inheritIO();
                proceso = pb.start();
            } catch(Exception e){
                System.err.println("ERROR: " + e.getMessage());
            }
        } else {
            System.out.println("otro sistema");
        }

    }
}
