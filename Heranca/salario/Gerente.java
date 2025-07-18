public class Gerente extends Empregado {

    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }

    @Override
    public double calcularBonus(Departamento departamento) {
        if (departamento.alcancouMeta()) {
            double bonusBase = getSalarioFixo() * 0.20;
            double excedente = departamento.getValorAtingidoMeta() - departamento.getValorMeta();
            double bonusExtra = excedente * 0.01;
            return bonusBase + bonusExtra;
        }
        return 0.0;
    }
}