public class PersonagemGame {
    private int saudeAtual;
    private String nome;

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {
        if (saudeAtual < 0) {
            this.saudeAtual = 0;
        } else if (saudeAtual > 100) {
            this.saudeAtual = 100;
        } else {
            this.saudeAtual = saudeAtual;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void tomarDano(int quantidadeDeDano) {
        saudeAtual -= quantidadeDeDano;
        if (saudeAtual < 0) {
            saudeAtual = 0;
        }
    }

    public void receberCura(int quantidadeDeCura) {
        saudeAtual += quantidadeDeCura;
        if (saudeAtual > 100) {
            saudeAtual = 100;
        }
    }
}
