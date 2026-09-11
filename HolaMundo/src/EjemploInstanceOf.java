public class EjemploInstanceOf {
    public static void main(String[] args) {

        String nombre = "hola lucio";
        Integer num = 10;
        int primitivo = 10; //los primitivos no se pueden comparar con instanceof
        Double numero = 0D;
        Boolean valor = true;

        // instanceof -> valida si un objeto es una instancia de algun tipo de objeto
        // Object -> es el tipo del que extienden/heredan todos los demás objetos
        if( num instanceof Integer && num instanceof Object ){
            if(num instanceof Number){ // validación en clase abstracta Number
                System.out.println(true);
            }
        }
        if( nombre instanceof String && nombre instanceof Object ){
            System.out.println(true);
        }
        if( valor instanceof Boolean){
            System.out.println(true);
        }




    }
}
