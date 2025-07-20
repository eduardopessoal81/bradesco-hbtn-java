public class Numero {

    public static void dividir(int a, int b) {
        int resultado = 0;
        boolean sucesso = true;

        try {
            resultado = a / b;
        } catch (ArithmeticException e) {
            sucesso = false;
        } finally {
            if (sucesso) {
                System.out.println(a + " / " + b + " = " + resultado);
            } else {
                System.out.println("Nao eh possivel dividir por zero");
                System.out.println(a + " / " + b + " = " + resultado);
            }
        }
    }
}