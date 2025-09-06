import java.util.HashMap;
import java.util.Map;

public abstract class Armazem<T> implements Armazenavel<T> {
    protected Map<String, T> inventario = new HashMap<>();

    @Override
    public void adicionarAoInventario(String nome, T valor) {
        inventario.put(nome, valor);
    }

    @Override
    public T obterDoInventario(String nome) {
        return inventario.get(nome);
    }
}