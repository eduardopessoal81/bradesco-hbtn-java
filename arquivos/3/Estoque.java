import java.io.*;
import java.util.*;

public class Estoque {
    private List<Produto> produtos;
    private String arquivo;

    public Estoque(String arquivo) {
        this.arquivo = arquivo;
        this.produtos = new ArrayList<>();
        carregarProdutos();
    }

    private void carregarProdutos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 4) {
                    try {
                        int id = Integer.parseInt(dados[0]);
                        String nome = dados[1];
                        int quantidade = Integer.parseInt(dados[2]);
                        double preco = Double.parseDouble(dados[3]);
                        produtos.add(new Produto(id, nome, quantidade, preco));
                    } catch (NumberFormatException e) {
                        System.err.println("Erro ao processar linha: " + linha);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    private void salvarProdutos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (Produto produto : produtos) {
                writer.write(produto.toCsv());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar no arquivo: " + e.getMessage());
        }
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome do produto não pode ser vazio!");
            return;
        }
        if (quantidade < 0) {
            System.out.println("Quantidade não pode ser negativa!");
            return;
        }
        if (preco < 0) {
            System.out.println("Preço não pode ser negativo!");
            return;
        }

        int novoId = produtos.isEmpty() ? 1 : produtos.get(produtos.size() - 1).getId() + 1;
        
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Produto com este nome já existe!");
                return;
            }
        }

        Produto produto = new Produto(novoId, nome, quantidade, preco);
        produtos.add(produto);
        salvarProdutos();
        System.out.println("Produto adicionado com sucesso!");
    }

    public void excluirProduto(int id) {
        boolean removido = produtos.removeIf(produto -> produto.getId() == id);
        if (removido) {
            salvarProdutos();
            System.out.println("Produto excluído com sucesso!");
        } else {
            System.out.println("Produto com ID " + id + " não encontrado!");
        }
    }

    public void atualizarQuantidade(int id, int novaQuantidade) {
        if (novaQuantidade < 0) {
            System.out.println("Quantidade não pode ser negativa!");
            return;
        }

        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.setQuantidade(novaQuantidade);
                salvarProdutos();
                System.out.println("Quantidade atualizada com sucesso!");
                return;
            }
        }
        System.out.println("Produto com ID " + id + " não encontrado!");
    }

    public void exibirEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio!");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }
}