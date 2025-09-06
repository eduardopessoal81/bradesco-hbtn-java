import java.util.*;

public class Blog {
    private List<Post> postagens;

    public Blog() {
        this.postagens = new ArrayList<>();
    }

    public void adicionarPostagem(Post post) {
        if (postagens.contains(post)) {
            throw new IllegalArgumentException("Postagem jah existente");
        }
        postagens.add(post);
    }

    public Set<Autor> obterTodosAutores() {
        TreeSet<Autor> autores = new TreeSet<>();
        for (Post p : postagens) {
            autores.add(p.getAutor());
        }
        return autores;
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagem = new HashMap<>();
        for (Post p : postagens) {
            contagem.put(p.getCategoria(), contagem.getOrDefault(p.getCategoria(), 0) + 1);
        }
        return contagem;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        TreeSet<Post> resultados = new TreeSet<>();
        for (Post p : postagens) {
            if (p.getAutor().equals(autor)) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        TreeSet<Post> resultados = new TreeSet<>();
        for (Post p : postagens) {
            if (p.getCategoria() == categoria) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> map = new HashMap<>();
        for (Post p : postagens) {
            map.computeIfAbsent(p.getCategoria(), k -> new TreeSet<>()).add(p);
        }
        return map;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> map = new TreeMap<>();
        for (Post p : postagens) {
            map.computeIfAbsent(p.getAutor(), k -> new TreeSet<>()).add(p);
        }
        return map;
    }
}