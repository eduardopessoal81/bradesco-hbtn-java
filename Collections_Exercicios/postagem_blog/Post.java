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

    public Categorias getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return this.titulo;
    }

    @Override
    public int compareTo(Post outroPost) {
        return this.titulo.compareTo(outroPost.titulo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(autor, post.autor) && Objects.equals(titulo, post.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autor, titulo);
    }
}