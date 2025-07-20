import atividades.Atividade;
import java.util.ArrayList;
import java.util.List;

public class Workflow {
    private List<Atividade> atividades = new ArrayList<>();

    public void registrarAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }
}