import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pedido {
    private List<PedidoCookie> cookies;

    public Pedido() {
        this.cookies = new ArrayList<>();
    }

    public void adicionarPedidoCookie(PedidoCookie pedidoCookie) {
        cookies.add(pedidoCookie);
    }

    public int obterTotalCaixas() {
        int total = 0;
        for (PedidoCookie pc : cookies) {
            total += pc.getQuantidadeCaixas();
        }
        return total;
    }

    public int removerSabor(String sabor) {
        int removidos = 0;
        Iterator<PedidoCookie> it = cookies.iterator();
        while (it.hasNext()) {
            PedidoCookie pc = it.next();
            if (pc.getSabor().equalsIgnoreCase(sabor)) {
                removidos += pc.getQuantidadeCaixas();
                it.remove();
            }
        }
        return removidos;
    }
}
