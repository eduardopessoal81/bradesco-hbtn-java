import java.util.Random;

public class Produtor extends Thread {
    private final Fila fila;
    private final Random random = new Random();

    public Produtor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int numero = random.nextInt(100) + 1;
                fila.adicionar(numero);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Produtor interrompido.");
        }
    }
}