import java.util.ArrayList;
import java.util.List;

public class Biblioteca<T extends Midia> {
    private List<T> listaMidias;

    public Biblioteca() {
        this.listaMidias = new ArrayList<>();
    }

    public void adicionarMidia(T midia) {
        this.listaMidias.add(midia);
    }

    public List<T> obterListaMidias() {
        return this.listaMidias;
    }
}