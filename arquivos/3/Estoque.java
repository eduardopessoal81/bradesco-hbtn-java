import java.io.*;
import java.util.*;

public class Estoque {
    private List<Produto> produtos;
    private final String arquivoCSV;

    public Estoque(String arquivoCSV) {
        this.arquivoCSV = arquivoCSV;
        this.produtos = new ArrayList<>();
        carregarDoArquivo();
    }

    private void carregarDoArquivo() {
        produtos.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 4) {
                    int id = Integer.parseInt(dados[0].trim());
                    String nome = dados[1].trim();
                    int quantidade = Integer.parseInt(dados[2].trim());
                    double preco = Double.parseDouble(dados[3].trim());
                    produtos.add(new Produto(id, nome, quantidade, preco));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo: " + e.getMessage());
        }
    }

    private void salvarNoArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoCSV))) {
            for (Produto p : produtos) {
                bw.write(p.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    private int gerarNovoId() {
        int maxId = 0;
        for (Produto p : produtos) {
            if (p.getId() > maxId) {
                maxId = p.getId();
            }
        }
        return maxId + 1;
    }

    public boolean adicionarProduto(String nome, int quantidade, double preco) {
        int novoId = gerarNovoId();
        Produto novo = new Produto(novoId, nome, quantidade, preco);
        produtos.add(novo);
        salvarNoArquivo();
        return true;
    }

    public boolean excluirProduto(int id) {
        Iterator<Produto> it = produtos.iterator();
        while (it.hasNext()) {
            Produto p = it.next();
            if (p.getId() == id) {
                it.remove();
                salvarNoArquivo();
                return true;
            }
        }
        return false;
    }

    public boolean atualizarQuantidade(int id, int novaQuantidade) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);
                salvarNoArquivo();
                return true;
            }
        }
        return false;
    }

    public void exibirEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
    }
}