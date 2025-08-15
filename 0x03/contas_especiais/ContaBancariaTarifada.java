import exceptions.OperacaoInvalidaException;

public class ContaBancariaTarifada extends ContaBancariaBasica {
    private int quantidadeTransacoes;
    private static final double TARIFA_TRANSACAO = 0.10;

    public ContaBancariaTarifada(String numeracao, double taxaJurosAnual) {
        super(numeracao, taxaJurosAnual);
        this.quantidadeTransacoes = 0;
    }

    @Override
    public void depositar(double valor) throws OperacaoInvalidaException {
        super.depositar(valor);
        super.sacar(TARIFA_TRANSACAO);
        quantidadeTransacoes++;
    }

    @Override
    public void sacar(double valor) throws OperacaoInvalidaException {
        super.sacar(valor);
        super.sacar(TARIFA_TRANSACAO);
        quantidadeTransacoes++;
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }
}