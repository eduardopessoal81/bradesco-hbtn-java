import produtos.Produto;

public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }
        return total - (total * (percentualDesconto / 100.0));
    }

    public void apresentarResumoPedido() {
        double totalProdutos = 0.0;

        System.out.println("------- RESUMO PEDIDO -------");

        for (ItemPedido item : itens) {
            Produto produto = item.getProduto();
            String tipo = produto.getClass().getSimpleName();
            String titulo = produto.getTitulo();
            double preco = produto.obterPrecoLiquido();
            int quantidade = item.getQuantidade();
            double subtotal = preco * quantidade;

            totalProdutos += subtotal;

            System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f%n",
                    tipo, titulo, preco, quantidade, subtotal);
        }

        double valorDesconto = totalProdutos * (percentualDesconto / 100.0);
        double totalFinal = totalProdutos - valorDesconto;

        System.out.println("----------------------------");
        System.out.printf("DESCONTO: %.2f%n", valorDesconto);
        System.out.printf("TOTAL PRODUTOS: %.2f%n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f%n", totalFinal);
        System.out.println("----------------------------");
    }
}