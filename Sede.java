import java.util.ArrayList;
import java.util.List;

public class Sede extends Agencia implements Relatorios {

	private List<CentroDeDistribuicao> listCentroDistribuicao = new ArrayList<CentroDeDistribuicao>();
	
	public Sede(String nome, String endereco, String numero, String telefone) {
		super(nome, endereco, numero, telefone);
	}

	@Override
	public void gerarRelatorio() {
		int numTotaldeNecessitados = 0;
		int numTotaldeDoadores = 0;
		int numCestasDisponiveis = 0;
		System.out.println("\n_____ RELATORIO GERAL _____");
		System.out.println("\nNumero de Centros de distribuição: " + listCentroDistribuicao.size());
		for (int i = 0; i < listCentroDistribuicao.size(); i++) {
			numTotaldeNecessitados += listCentroDistribuicao.get(i).getNecessitados().size();
			numTotaldeDoadores += listCentroDistribuicao.get(i).getDoadores().size();
			numCestasDisponiveis += listCentroDistribuicao.get(i).getNumCestasBasicas();
		}
		System.out.println("Numero de necessitados cadastrados na rede é de: " + numTotaldeNecessitados);
		System.out.println("Numero de necessidados cadastrados na rede é de: " + numTotaldeDoadores);
		System.out.println("Numero de cestas basicas disponiveis na rede é de: " + numCestasDisponiveis);
	}
	
	public void vincularCentroDeDistribuicao(CentroDeDistribuicao centrodedistribuicao) {
		this.listCentroDistribuicao.add(centrodedistribuicao);
	}

	public List<CentroDeDistribuicao> getListCentroDistribuicao() {
		return listCentroDistribuicao;
	}

	public void setListCentroDistribuicao(List<CentroDeDistribuicao> listCentroDistribuicao) {
		this.listCentroDistribuicao = listCentroDistribuicao;
	}

}
