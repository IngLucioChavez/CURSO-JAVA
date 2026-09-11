public class InstanceOfTiposAbstractos {
    public static void main(String[] args) {
        
        Boolean validacion;
        Object texto = "texto"; //en object se puede almacenar cualquier instancia de objeto
        Number numero = 12; //en Number se puede almacenar byte,short,int,long,float,double
        Number numero2 = Integer.valueOf(12); //asignación a través de clase Integer
        Number numero3 = 12.3;
        
        validacion = texto instanceof Object;
        System.out.println("texto es tipo Object = " + validacion);

        validacion = texto instanceof Integer;
        System.out.println("texto es tipo Integer = " + validacion);

        validacion = numero instanceof Integer;
        System.out.println("numero es tipo Integer = " + validacion);

        validacion = numero instanceof Double;
        System.out.println("numero es tipo Double = " + validacion);

        validacion = numero3 instanceof Double;
        System.out.println("numero3 es tipo Double = " + validacion);

    }
}
