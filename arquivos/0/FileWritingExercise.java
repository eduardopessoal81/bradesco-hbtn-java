import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWritingExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String fileName = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            System.out.println("Digite o texto (digite 'sair' para finalizar):");

            while (true) {
                String linha = scanner.nextLine();

                if (linha.equalsIgnoreCase("sair")) {
                    break;
                }

                writer.write(linha);
                writer.newLine();
            }

            System.out.println("Arquivo \"" + fileName + "\" criado e salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
        }

        scanner.close();
    }
}
