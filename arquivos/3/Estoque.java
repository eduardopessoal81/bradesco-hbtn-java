import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;
    private String arquivo;

    public Estoque(String arquivo) {
        this.arquivo = arquivo;
        this.produtos = new ArrayList<>();
        carregarArquivo();
    }

    private void carregarArquivo() {
        produtos.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                String[] dados = linha.split(",", -1);
                if (dados.length == 4) {
                    int id = Integer.parseInt(dados[0]);
                    String nome = dados[1];
                    int quantidade = Integer.parseInt(dados[2]);
                    double preco = Double.parseDouble(dados[3]);
                    produtos.add(new Produto(id, nome, quantidade, preco));
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    private void salvarArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (Produto p : produtos) {
                writer.write(p.toCsv());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    private int gerarNovoId() {
        int maxId = 0;
        for (Produto p : produtos) {
            if (p.getId() > maxId) maxId = p.getId();
        }
        return maxId + 1;
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        int id = gerarNovoId();
        Produto produto = new Produto(id, nome, quantidade, preco);
        produtos.add(produto);
        salvarArquivo();
        System.out.println("Produto adicionado com sucesso: " + produto);
    }

    public void excluirProduto(int id) {
        Produto produtoParaRemover = null;
        for (Produto p : produtos) {
            if (p.getId() == id) {
                produtoParaRemover = p;
                break;
            }
        }
        if (produtoParaRemover != null) {
            produtos.remove(produtoParaRemover);
            salvarArquivo();
            System.out.println("Produto removido com sucesso: " + produtoParaRemover.getNome());
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    public void atualizarQuantidade(int id, int novaQuantidade) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);
                salvarArquivo();
                System.out.println("Quantidade atualizada para o produto: " + p.getNome());
                return;
            }
        }
        System.out.println("Produto com ID " + id + " não encontrado.");
    }

    public void exibirEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("O estoque está vazio.");
            return;
        }
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }
}