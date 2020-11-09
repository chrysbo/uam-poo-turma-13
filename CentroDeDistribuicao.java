import java.util.ArrayList;
import java.util.List;

public class CentroDeDistribuicao extends Agencia implements Relatorios {

	private List<Doador> doadores = new ArrayList<Doador>();
	private List<Necessitado> necessitados = new ArrayList<Necessitado>();
	private int numCestasBasicas;
	
	public CentroDeDistribuicao(String nome, String endereco, String numero, String telefone) {
		super(nome, endereco, numero, telefone);
		this.setNumCestasBasicas(0);
	}
	
	@Override
	public void gerarRelatorio() {
		System.out.println("\n_____ Centro de Distriduição " + this.getNome() + " _____");
		System.out.println("Situado em " + this.getEndereco() + ", numero " + this.getNumero());
		System.out.println("O numero de necessitados cadastrados nesse centro é de: " + necessitados.size());
		System.out.println("O número de doadores cadastrados nesse centro é de: " + doadores.size());
	}
	
	public void vincularNecessitados(Necessitado necessitado) {
		this.necessitados.add(necessitado);
	}
	
	public void vincularDoadores(Doador doador) {
		this.doadores.add(doador);
	}
	
	public List<Doador> getDoadores() {
		return doadores;
	}
	public void setDoadores(List<Doador> doadores) {
		this.doadores = doadores;
	}
	public List<Necessitado> getNecessitados() {
		return necessitados;
	}
	public void setNecessitados(List<Necessitado> necessitados) {
		this.necessitados = necessitados;
	}

	public int getNumCestasBasicas() {
		return numCestasBasicas;
	}

	public void setNumCestasBasicas(int numCestasBasicas) {
		this.numCestasBasicas = numCestasBasicas;
	}
}
