public class ClaseEjecucionParametros {
    public static void main(String[] args) {

        if( args.length < 3 ){
            System.err.println("ingresar num1,num2,operacion");
            System.exit(-1);
        }

        try{
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);

            switch (args[2]){
                case "suma":
                    System.out.println("suma: " + (num1 + num2));
                    break;
                case "resta":
                    System.out.println("resta: " + (num1 - num2));
                    break;
                case "multi":
                    System.out.println("multi: " + (num1 * num2));
                    break;
                case "divi":
                    System.out.println("divi: " + (num1 / num2));
                    break;
                default:
                    System.err.println("Operación no identificada");
                    System.exit(-1);
                    break;
            }
        } catch(NumberFormatException e){
            System.err.println("ERROR - formato de numero erroneo " + e.getMessage());
            System.exit(-1);
        } catch(ArrayIndexOutOfBoundsException e){
            System.err.println("ERROR - falta de parámetros " + e.getMessage());
            System.exit(-1);
        } catch(ArithmeticException e){
            System.err.println("ERROR - aritmético " + e.getMessage());
            System.exit(-1);
        }

    }
}
