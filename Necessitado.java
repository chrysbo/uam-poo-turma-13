
public class Necessitado extends Pessoa {
	

	private int numAuxiliosRetirados;
	
	public Necessitado(String nome, String endereco, String telefone, String rg, String cpf) {
		super(nome, endereco, telefone, rg, cpf);
		this.setNumAuxiliosRetirados(0);
	}
	
	public void retirarAuxilio() {
		this.setNumAuxiliosRetirados(this.getNumAuxiliosRetirados() + 1);
	}

	public int getNumAuxiliosRetirados() {
		return numAuxiliosRetirados;
	}

	public void setNumAuxiliosRetirados(int numAuxiliosRetirados) {
		this.numAuxiliosRetirados = numAuxiliosRetirados;
	}
}
  