public class FolhaPagamento {
    public static double calcularLiquido(Funcionario funcionario, CalculadorDeSalario calculador) {
        return calculador.calcular(funcionario.getSalario());
    }
}