import java.util.List;
import java.util.stream.Collectors;

public class Consulta {

    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
        return produtos.stream()
                .max(java.util.Comparator.comparing(Produto::getPreco))
                .orElse(null);
    }

    public static List<Produto> obterProdutosPorPrecoMinimo(List<Produto> produtos, double precoMinimo) {
        return produtos.stream()
                .filter(p -> p.getPreco() >= precoMinimo)
                .collect(Collectors.toList());
    }

    public static List<Pedido> obterPedidosComEletronicos(List<Pedido> pedidos) {
        return pedidos.stream()
                .filter(p -> p.getProdutos().stream()
                        .anyMatch(prod -> prod.getCategoria() == CategoriaProduto.ELETRONICO))
                .collect(Collectors.toList());
    }

    public static List<Produto> aplicar15PorcentoDescontoEletronicos(List<Produto> produtos) {
        return produtos.stream()
                .map(p -> {
                    if (p.getCategoria() == CategoriaProduto.ELETRONICO) {
                        Produto produtoComDesconto = new Produto(
                                p.getCodigo(),
                                p.getNome(),
                                p.getCategoria(),
                                Math.round(p.getPreco() * 0.85 * 100.0) / 100.0
                        );
                        return produtoComDesconto;
                    } else {
                        return p;
                    }
                })
                .collect(Collectors.toList());
    }
}