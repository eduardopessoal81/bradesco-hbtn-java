public class Post implements Comparable<Post> {
    private Autor autor;
    private String titulo;
    private String corpo;
    private Categorias categoria;

    public Post(Autor autor, String titulo, String corpo, Categorias categoria) {
        this.autor = autor;
        this.titulo = titulo;
        this.corpo = corpo;
        this.categoria = categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return titulo;
    }

    @Override
    public int compareTo(Post outro) {
        return this.titulo.compareTo(outro.titulo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Post)) return false;
        Post outro = (Post) obj;
        return autor.equals(outro.autor) && titulo.equals(outro.titulo);
    }

    @Override
    public int hashCode() {
        return autor.hashCode() * 31 + titulo.hashCode();
    }
}