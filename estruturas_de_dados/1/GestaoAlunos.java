import java.util.ArrayList;
import java.util.List;

public class GestaoAlunos {
    private List<Aluno> alunos;

    public GestaoAlunos() {
        this.alunos = new ArrayList<>();
    }

    // Adicionar aluno
    public void adicionarAluno(String nome, int idade) {
        alunos.add(new Aluno(nome, idade));
    }

    // Excluir aluno pelo nome
    public void excluirAluno(String nome) {
        boolean removido = alunos.removeIf(a -> a.getNome().equalsIgnoreCase(nome));
        if (removido) {
            System.out.println("Aluno removido: " + nome);
        } else {
            System.out.println("Aluno não encontrado: " + nome);
        }
    }

    // Buscar aluno pelo nome
    public void buscarAluno(String nome) {
        for (Aluno a : alunos) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Aluno encontrado: " + a);
                return;
            }
        }
        System.out.println("Aluno não encontrado: " + nome);
    }

    // Listar todos os alunos
    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("Lista de alunos:");
            for (Aluno a : alunos) {
                System.out.println(a);
            }
        }
    }

    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();

        // Adicionar três alunos
        gestao.adicionarAluno("Eduardo", 43);
        gestao.adicionarAluno("Fernanda", 25);
        gestao.adicionarAluno("Carlos", 20);

        // Exibir todos
        gestao.listarAlunos();

        // Buscar um aluno
        gestao.buscarAluno("Fernanda");

        // Excluir um aluno
        gestao.excluirAluno("Eduardo");

        // Tentar excluir aluno inexistente
        gestao.excluirAluno("Ana");

        // Buscar aluno que não existe
        gestao.buscarAluno("Eduardo");

  
    }
}