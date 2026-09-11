public class WrapperRelacionales {
    public static void main(String[] args) {

        Integer num1 = 10;
        Integer num2 = num1; //se asigna referencia y no valor, ya que son objetos
        
        boolean val = num1 == num2; //comparación por referencia entre objetos Wrapper
        System.out.println("mismo objeto? " + val);
        System.out.println("mismo valor? " + (num1.equals(num2))); //comparación por valor entre objetos Wrapper

        num2 = 1000;

        System.out.println("mismo objeto? " + (num1 == num2));
        System.out.println("mismo valor? " + (num1.equals(num2)));

        int num3 = 10;
        int num4 = 10;

        System.out.println("mismo valor? " + (num3 == num4)); //solo con primitivos se puede comparar x valor con ==
        // == comparar primitivos x valor
        // == comparar referencias objs

        //NOTA! Java compara por valor aunque sean instancias hasta 127
        Integer num5 = 127;
        Integer num6 = 127;

        System.out.println("mismo valor? " + (num5 == num6));
        System.out.println(num5 instanceof Integer);
        System.out.println(num5 >= num6); //auto unboxing - se compara x valor x debajo se hace intValue()

    }
}
