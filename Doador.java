
public class Doador extends Pessoa {

	private int numDoacoesRealizadas;
	
	public Doador(String nome, String endereco, String telefone, String rg, String cpf) {
		super(nome, endereco, telefone, rg, cpf);
		this.numDoacoesRealizadas = 0;
	}
	
	public void depositarAuxilio() {
		this.setNumDoacoesRealizadas(this.getNumDoacoesRealizadas() + 1);
	}

	public int getNumDoacoesRealizadas() {
		return numDoacoesRealizadas;
	}

	public void setNumDoacoesRealizadas(int numDoacoesRealizadas) {
		this.numDoacoesRealizadas = numDoacoesRealizadas;
	}
	
	public void doandoUmaCestaBasica(CentroDeDistribuicao cdd) {
		cdd.setNumCestasBasicas(cdd.getNumCestasBasicas() + 1);
	}
}
