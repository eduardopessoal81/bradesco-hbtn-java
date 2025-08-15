import exceptions.OperacaoInvalidaException;

public class ContaBancariaBasica {
    private String numeracao;
    private double saldo;
    private double taxaJurosAnual;

    public ContaBancariaBasica(String numeracao, double taxaJurosAnual) {
        this.numeracao = numeracao;
        this.taxaJurosAnual = taxaJurosAnual;
        this.saldo = 0.0;
    }

    public String getNumeracao() {
        return numeracao;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void depositar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("Valor para deposito deve ser maior que 0");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("Valor de saque deve ser maior que 0");
        }
        if (valor > this.saldo) {
            throw new OperacaoInvalidaException("Valor de saque deve ser menor que o saldo atual");
        }
        this.saldo -= valor;
    }

    public double calcularTarifaMensal() {
        double tarifaFixa = 10.0;
        double tarifaPercentual = this.saldo * 0.1;
        return Math.min(tarifaFixa, tarifaPercentual);
    }

    public double calcularJurosMensal() {
        if (this.saldo <= 0) {
            return 0.0;
        }
        return this.saldo * (this.taxaJurosAnual / 100) / 12;
    }

    public void aplicarAtualizacaoMensal() {
        this.saldo = this.saldo - calcularTarifaMensal() + calcularJurosMensal();
    }
}