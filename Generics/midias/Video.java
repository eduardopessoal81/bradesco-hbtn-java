public class Video extends Midia {
    private int duracao;

    public Video(String nome, int duracao) {
        super(nome);
        this.duracao = duracao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}