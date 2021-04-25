
public class main {

	public static void main(String[] args) {
		
		JoKenPo jogo = new JoKenPo();
		
		jogo.inicializar();
		jogo.jogador();
		jogo.boasVindas();

		while (jogo.getRodando() == true) {
			jogo.jogar();
		}
	}

}
