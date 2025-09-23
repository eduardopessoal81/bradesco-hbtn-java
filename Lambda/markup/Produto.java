import java.util.function.Consumer;
import java.util.function.Supplier;

public class Produto {
    private String nome;
    private Double preco;
    private Double percentualMarkup = 10.0;

    public Supplier<Double> precoComMarkup = () -> 
        preco + (preco * percentualMarkup / 100);

    public Consumer<Double> atualizarMarkup = novoMarkup -> 
        this.percentualMarkup = novoMarkup;

    public Produto(Double preco, String nome) {
        this.preco = preco;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Double getPercentualMarkup() {
        return percentualMarkup;
    }
}