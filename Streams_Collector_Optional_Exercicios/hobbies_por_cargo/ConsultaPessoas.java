import java.util.*;
import java.util.stream.Collectors;

public class ConsultaPessoas {
    public static TreeMap<String, TreeSet<Pessoa>> obterPessoasAgrupadasPorCargoEmOrdemReversa(List<Pessoa> pessoas) {
        return pessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo,
                        () -> new TreeMap<>(Comparator.reverseOrder()),
                        Collectors.toCollection(TreeSet::new)
                ));
    }
	
	public static Map<String, Long> obterContagemPessoasPorCargo(List<Pessoa> pessoas) {
        return pessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo,
                        Collectors.counting()
                ));
    }
	
	public static Map<String, Map<Integer, Long>> obterContagemPessoasPorCargoEIdade(List<Pessoa> pessoas) {
        return pessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo,
                        Collectors.groupingBy(
                                Pessoa::getIdade,
                                Collectors.counting()
                        )
                ));
    }
	
	public static Map<String, Double> obterMediaSalarioPorCargo(List<Pessoa> pessoas) {
        return pessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo,
                        Collectors.averagingDouble(Pessoa::getSalario)
                ));
    }
	
	public static Map<String, TreeSet<String>> obterHobbiesPorCargo(List<Pessoa> pessoas) {
		List<String> ordemDesejada = List.of("Product Owner", "Analista QA", "Desenvolvedor");

		return pessoas.stream()
            .collect(Collectors.groupingBy(
                    Pessoa::getCargo,
                    () -> new LinkedHashMap<String, TreeSet<String>>() {{
                        ordemDesejada.forEach(c -> put(c, new TreeSet<>()));
                    }},
                    Collectors.flatMapping(
                            p -> p.getHobbies().stream(),
                            Collectors.toCollection(TreeSet::new)
                    )
            ));
	}
}