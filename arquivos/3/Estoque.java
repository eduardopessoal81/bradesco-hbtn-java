import java.io.*;
import java.util.*;

public class Estoque {
    private List<Produto> produtos = new ArrayList<>();
    private String arquivoCSV;

    public Estoque(String arquivoCSV) {
        this.arquivoCSV = arquivoCSV;
        carregar();
    }

    public void carregar() {
        produtos.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 4) {
                    int id = Integer.parseInt(dados[0]);
                    String nome = dados[1];
                    int quantidade = Integer.parseInt(dados[2]);
                    double preco = Double.parseDouble(dados[3]);
                    produtos.add(new Produto(id, nome, quantidade, preco));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado, criando novo...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvar() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoCSV))) {
            for (Produto p : produtos) {
                bw.write(p.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public boolean adicionarProduto(Produto produto) {
        for (Produto p : produtos) {
            if (p.getId() == produto.getId()) {
                return false;
            }
        }
        produtos.add(produto);
        salvar();
        return true;
    }

    public boolean excluirProduto(int id) {
        Iterator<Produto> it = produtos.iterator();
        while (it.hasNext()) {
            Produto p = it.next();
            if (p.getId() == id) {
                it.remove();
                salvar();
                return true;
            }
        }
        return false;
    }

    public boolean atualizarQuantidade(int id, int novaQuantidade) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);
                salvar();
                return true;
            }
        }
        return false;
    }

    public void exibirEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio!");
        } else {
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
    }
}