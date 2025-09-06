import java.util.*;

public class Blog {
    private Set<Post> postagens;

    public Blog() {
        this.postagens = new HashSet<>();
    }

    public void adicionarPostagem(Post post) {
        if (this.postagens.contains(post)) {
            throw new IllegalArgumentException("Postagem jah existente");
        }
        this.postagens.add(post);
    }

    public Set<Autor> obterTodosAutores() {
        Set<Autor> autores = new TreeSet<>();
        for (Post post : this.postagens) {
            autores.add(post.getAutor());
        }
        return autores;
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagem = new TreeMap<>();
        for (Post post : this.postagens) {
            contagem.put(post.getCategoria(), contagem.getOrDefault(post.getCategoria(), 0) + 1);
        }
        return contagem;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> postsPorAutor = new TreeSet<>();
        for (Post post : this.postagens) {
            if (post.getAutor().equals(autor)) {
                postsPorAutor.add(post);
            }
        }
        return postsPorAutor;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> postsPorCategoria = new TreeSet<>();
        for (Post post : this.postagens) {
            if (post.getCategoria().equals(categoria)) {
                postsPorCategoria.add(post);
            }
        }
        return postsPorCategoria;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> postsPorCategoria = new TreeMap<>();
        for (Post post : this.postagens) {
            Set<Post> postsDaCategoria = postsPorCategoria.getOrDefault(post.getCategoria(), new TreeSet<>());
            postsDaCategoria.add(post);
            postsPorCategoria.put(post.getCategoria(), postsDaCategoria);
        }
        return postsPorCategoria;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> postsPorAutor = new TreeMap<>();
        for (Post post : this.postagens) {
            Set<Post> postsDoAutor = postsPorAutor.getOrDefault(post.getAutor(), new TreeSet<>());
            postsDoAutor.add(post);
            postsPorAutor.put(post.getAutor(), postsDoAutor);
        }
        return postsPorAutor;
    }
}