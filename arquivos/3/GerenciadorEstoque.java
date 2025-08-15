import java.util.Scanner;

public class GerenciadorEstoque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque("estoque.csv");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Excluir Produto");
            System.out.println("3. Exibir Estoque");
            System.out.println("4. Atualizar Quantidade de Produto");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();

                    int quantidade;
                    while (true) {
                        System.out.print("Digite a quantidade: ");
                        try {
                            quantidade = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Quantidade inválida! Digite um número inteiro.");
                        }
                    }

                    double preco;
                    while (true) {
                        System.out.print("Digite o preço: ");
                        try {
                            preco = Double.parseDouble(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Preço inválido! Digite um número válido.");
                        }
                    }

                    estoque.adicionarProduto(nome, quantidade, preco);
                    break;

                case 2:
                    System.out.print("Digite o ID do produto a ser excluído: ");
                    int idExcluir;
                    try {
                        idExcluir = Integer.parseInt(scanner.nextLine());
                        estoque.excluirProduto(idExcluir);
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido!");
                    }
                    break;

                case 3:
                    System.out.println("Estoque atual:");
                    estoque.exibirEstoque();
                    break;

                case 4:
                    System.out.print("Digite o ID do produto: ");
                    int idAtualizar;
                    try {
                        idAtualizar = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido!");
                        break;
                    }

                    int novaQuantidade;
                    while (true) {
                        System.out.print("Digite a nova quantidade: ");
                        try {
                            novaQuantidade = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Quantidade inválida! Digite um número inteiro.");
                        }
                    }

                    estoque.atualizarQuantidade(idAtualizar, novaQuantidade);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}