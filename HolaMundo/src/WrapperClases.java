public class WrapperClases {
    public static void main(String[] args) {

        //Integer intObj = new Integer(10); //forma obsoleta
        //Integer intObj = Integer.valueOf(10); //forma unboxing - explicito
        Integer intObj = 10; //forma implicita

        int num = 10; //primitivo
        Integer num1 = num; // asignando a Wrapper

        String valorTv = "2500";
        Integer valorTv2 = Integer.valueOf(valorTv);

        System.out.println(valorTv2.byteValue()); //-60 -> perdida de información, no se puede convertir
        // un número grande a uno pequeño

        Integer[] numeros = {1,2,3,4,5,6,7,8,9,10}; //declaración con inicialización Autoboxing

        for(Integer i:numeros){
            System.out.println(i.intValue() + " " + i); //intValue retorna un int como un primitivo, unboxing
        }

    }
}
