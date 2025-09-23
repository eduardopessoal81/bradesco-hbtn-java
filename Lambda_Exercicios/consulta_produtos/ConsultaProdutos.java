import java.util.ArrayList;
import java.util.List;

public class ConsultaProdutos {
    public static List<Produto> filtrar(List<Produto> produtos, CriterioFiltro criterio) {
        List<Produto> resultado = new ArrayList<>();
        for (Produto p : produtos) {
            if (criterio.testar(p)) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}