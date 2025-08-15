import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {
    public static void main(String[] args) {
        String fileName = "funcionarios.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) {
                    continue;
                }

                String[] dados = linha.split(",", -1);

                String nome = dados.length > 0 ? dados[0] : "";
                String idade = dados.length > 1 ? dados[1] : "";
                String departamento = dados.length > 2 ? dados[2] : "";
                String salarial = dados.length > 3 ? dados[3] : "";

                System.out.println("Funcionário: " + nome);
                System.out.println("Idade: " + idade);
                System.out.println("Departamento: " + departamento);
                System.out.println("Salarial: " + salarial);
                System.out.println("------------------------");
            }

            System.out.println("Leitura do arquivo concluída.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}