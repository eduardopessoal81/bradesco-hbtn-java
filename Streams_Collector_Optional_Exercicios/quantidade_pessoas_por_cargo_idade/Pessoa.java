import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Pessoa implements Comparable<Pessoa> {
    private int codigo;
    private String nome;
    private String cargo;
    private int idade;
    private double salario;

    public Pessoa(int codigo, String nome, String cargo, int idade, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
    }

	@Override
	public String toString() {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
		DecimalFormat df = new DecimalFormat("0.000000", symbols);
		return String.format("[%d] %s %s %d R$ %s", codigo, nome, cargo, idade, df.format(salario));
	}

    @Override
    public int compareTo(Pessoa outra) {
        int nomeComparison = this.nome.compareTo(outra.nome);
        if (nomeComparison != 0) {
            return nomeComparison;
        }
        int idadeComparison = Integer.compare(this.idade, outra.idade);
        if (idadeComparison != 0) {
            return idadeComparison;
        }
        return Double.compare(this.salario, outra.salario);
    }

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}