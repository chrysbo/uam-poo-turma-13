import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int op;
		boolean sistema = true;
		List<Sede> sedes = new ArrayList<Sede>();
		
		Scanner ler = new Scanner(System.in);
		
		do {
			System.out.println("\nSistema de controle de distribuiçãoo de alimentos");
			System.out.println(" ____ MENU ____ \n"
					+ "1 - Popular dados\n"
					+ "2 - Selecionar Sede\n"
					+ "3 - Nova Sede\n"
					+ "0 - Sair do sistema");
			System.out.println("Informe uma opção: ");
			op = ler.nextInt();
			
			switch(op) {
			case 1:
				sedes = popular();
				break;
			case 2:
				System.out.println("Selecione a Sede que deseja: ");
				for (int i = 0; i < sedes.size(); i++) {
					System.out.println(i+1 + " - " + sedes.get(i).getNome());
				}
				op = ler.nextInt();
				menuSede(sedes.get(op-1));
				break;
			case 3:
				System.out.println("\nEm breve. . .");
				break;
			case 0:
				sistema = false;
				System.out.println("\nFinalizando sistema. . .");
				
			default:
				continue;
			}
			
		} while(sistema);
		
	}
	
	public static void menuSede(Sede sede) {
		
		int opSede, numCestas, numNecessitado;
		boolean sistema = true;
		Scanner ler = new Scanner(System.in);
		do {
			System.out.println("\nSede - "+ sede.getNome());
			System.out.println(" ____ MENU ____ \n"
					+ "1 - Gerar relatorio Geral\n"
					+ "2 - Gerar relatorio de um centro\n"
					+ "3 - Doar Cestas Basicas\n"
					+ "4 - Retirar auxílio\n"
					+ "0 - Voltar");
			System.out.println("Informe uma opção: ");
			opSede = ler.nextInt();
		 
			switch(opSede) {
			case 1:
				sede.gerarRelatorio();
				break;
			case 2:
				System.out.println("\nSelecione a CDD que deseja: ");
				for (int i = 0; i < sede.getListCentroDistribuicao().size(); i++) {
					System.out.println(i+1 + " - " + sede.getListCentroDistribuicao().get(i).getNome());
				}
				opSede = ler.nextInt();
				sede.getListCentroDistribuicao().get(opSede-1).gerarRelatorio();
				break;
			case 3:
				System.out.println("\nSelecione a CDD que deseja destinar as doações: ");
				for (int i = 0; i < sede.getListCentroDistribuicao().size(); i++) {
					System.out.println(i+1 + " - " + sede.getListCentroDistribuicao().get(i).getNome());
				}
				opSede = ler.nextInt();
				System.out.println("\nQual a quantidade que será doado: ");
				numCestas = ler.nextInt();
				sede.getListCentroDistribuicao().get(opSede-1).setNumCestasBasicas(sede.getListCentroDistribuicao().get(opSede-1).getNumCestasBasicas() + numCestas);
				break;
			case 4:
				System.out.println("\nSelecione a CDD que deseja disponibilizar o auxilio: ");
				for (int i = 0; i < sede.getListCentroDistribuicao().size(); i++) {
					System.out.println(i+1 + " - " + sede.getListCentroDistribuicao().get(i).getNome() + "(Numero disponivel: " + sede.getListCentroDistribuicao().get(i).getNumCestasBasicas() + ")");
				}
				opSede = ler.nextInt();
				System.out.println("Quem vai retirar esse auxílio: ");
				for (int i = 0; i < sede.getListCentroDistribuicao().get(opSede-1).getNecessitados().size(); i++) {
					System.out.println(i+1 + " - " + sede.getListCentroDistribuicao().get(opSede-1).getNecessitados().get(i).getNome());
				}
				numNecessitado = ler.nextInt();
				sede.getListCentroDistribuicao().get(opSede-1).setNumCestasBasicas(sede.getListCentroDistribuicao().get(opSede-1).getNumCestasBasicas() - 1);
				sede.getListCentroDistribuicao().get(opSede-1).getNecessitados().get(numNecessitado-1).setNumAuxiliosRetirados(sede.getListCentroDistribuicao().get(opSede-1).getNecessitados().get(numNecessitado-1).getNumAuxiliosRetirados() + 1);
				break;
			case 0:
				sistema = false;
			
			default:
				continue;
			}
		
		} while(sistema);
	}
	
	public static List<Sede> popular() {

		List<Sede> sedes = new ArrayList<Sede>();
		System.out.println("Inicializando projeto. . . \n");
		
		System.out.println("\n-> Instanciando Sede...");
		// Instancia da sede
		Sede sedeA = new Sede("Santa Casa", "Rua teste", "4", "1234567");
		
		System.out.println("-> Instanciando 2 centros de distribuição...");
		// Instancias dos Centros de distribui��o
		CentroDeDistribuicao distribuicao1 = new CentroDeDistribuicao("Central 1", "Rua central", "156", "98765432");
		CentroDeDistribuicao distribuicao2 = new CentroDeDistribuicao("Leste 1", "Avenida Marginal", "548", "98764565");
				
		System.out.println("-> Instanciando 4 necessitados...");
		// Instancias dos necessitados
		Necessitado necessitado1 = new Necessitado("Guilherme", "Central 1", "56459878", "465850237", "47855899635");
		Necessitado necessitado2 = new Necessitado("Ana", "Central 1", "56125378", "465865487", "46215899635");
		Necessitado necessitado3 = new Necessitado("Marcos", "Central 1", "77854878", "495450237", "47858749635");
		Necessitado necessitado4 = new Necessitado("Lucas", "Central 1", "32169878", "469518237", "64585899635");
		
		System.out.println("-> Instanciando 4 doadores...");
		// Instancias dos doadores
		Doador doador1 = new Doador("João", "Central", "45698765", "45986548", "45698745632");
		Doador doador2 = new Doador("João", "Leste", "45698765", "45986548", "45698745632");
		Doador doador3 = new Doador("João", "Leste", "45698765", "45986548", "45698745632");
		Doador doador4 = new Doador("João", "Leste", "45698765", "45986548", "45698745632");
			
		System.out.println("-> Vinculando 2 necessitados em cada Centro...");
		distribuicao1.vincularNecessitados(necessitado1);
		distribuicao1.vincularNecessitados(necessitado2);
		distribuicao2.vincularNecessitados(necessitado3);
		distribuicao2.vincularNecessitados(necessitado4);
		
		System.out.println("-> Vinculando 2 doadores em cada Centro...");
		distribuicao1.vincularDoadores(doador1);
		distribuicao1.vincularDoadores(doador2);
		distribuicao2.vincularDoadores(doador3);
		distribuicao2.vincularDoadores(doador4);
		
		System.out.println("-> Disponibilizando 10 cestas basicas em cada Centro...");
		distribuicao1.setNumCestasBasicas(10);
		distribuicao2.setNumCestasBasicas(10);
		
				
		System.out.println("-> Vinculando os 2 Centros na Sede");
		sedeA.vincularCentroDeDistribuicao(distribuicao1);
		sedeA.vincularCentroDeDistribuicao(distribuicao2);
		
		sedes.add(sedeA);
		
		return sedes;
	}

}
