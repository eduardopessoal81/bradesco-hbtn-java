import java.util.*;

public class Blog {
    private List<Post> postagens;

    public Blog() {
        postagens = new ArrayList<>();
    }

    public void adicionarPostagem(Post postagem) {
        for (Post p : postagens) {
            if (p.getAutor().equals(postagem.getAutor()) &&
                p.getTitulo().equals(postagem.getTitulo())) {
                throw new RuntimeException("Postagem jah existente");
            }
        }
        postagens.add(postagem);
    }

    public Set<Autor> obterTodosAutores() {
        Set<Autor> autores = new TreeSet<>();
        for (Post p : postagens) {
            autores.add(p.getAutor());
        }
        return autores;
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagem = new LinkedHashMap<>();
        contagem.put(Categorias.DEVOPS, 0);
        contagem.put(Categorias.DESENVOLVIMENTO, 0);
        contagem.put(Categorias.DATA_SCIENCE, 0);

        for (Post p : postagens) {
            contagem.put(p.getCategoria(), contagem.get(p.getCategoria()) + 1);
        }
        return contagem;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> posts = new TreeSet<>();
        for (Post p : postagens) {
            if (p.getAutor().equals(autor)) posts.add(p);
        }
        return posts;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> posts = new TreeSet<>();
        for (Post p : postagens) {
            if (p.getCategoria() == categoria) posts.add(p);
        }
        return posts;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> mapa = new LinkedHashMap<>();
        mapa.put(Categorias.DEVOPS, new TreeSet<>());
        mapa.put(Categorias.DESENVOLVIMENTO, new TreeSet<>());
        mapa.put(Categorias.DATA_SCIENCE, new TreeSet<>());

        for (Post p : postagens) {
            mapa.get(p.getCategoria()).add(p);
        }

        return mapa;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> mapa = new TreeMap<>();
        for (Post p : postagens) {
            mapa.computeIfAbsent(p.getAutor(), k -> new TreeSet<>()).add(p);
        }
        return mapa;
    }
}