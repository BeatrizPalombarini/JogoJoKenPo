import java.util.Scanner;
import java.util.Random;

public class JoKenPo {

	Scanner entrada = new Scanner(System.in);
	Random maquina = new Random();

	private boolean rodando = false;
	private String jogador;
	private int escolhajogador;
	private int escolhamaquina;
	private int pontosjogador;
	private int pontosmaquina;

	// 1 = papel, 2 = pedra, 3 = tesoura
	// J = jogador e M = m�quina
	// j escolhe 1 e M escolhe 2 = 1-2 = -1 = J vence;
	// j escolhe 1 e M escolhe 3 = 1-3 = -2 = M vence;
	// j escolhe 2 e M escolhe 1 = 2-1 = 1 = M vence;
	// j escolhe 2 e M escolhe 3 = 2-3 = -1 = J vence;
	// j escolhe 3 e M escolhe 1 = 3-1 = 2 = J vence;
	// j escolhe 3 e M escolhe 2 = 3-2 = 1 = M vence;

	// Fun��o falar
	public void falar(String texto) {
		System.out.println(texto);
	}

	// Boas Vindas
	public void boasVindas() {
		falar("Bem vindo ao Jo-Ken-Po!");
		falar("Esse jogo consiste em uma melhor de 5!");
		falar("Ser� voc� contra a m�quina!");
		falar("Mas fique tranquilo, a m�quina escolhe aleatoriamente!!");
		falar("Quem vencer 3 ou mais rodadas vence!");
		falar("Esta pronto?");
		falar("Boa sorte " + jogador);
		falar("Vamos l�!");
	}

	// Inicializar o jogo
	public void inicializar() {
		rodando = true;
	}

	// Get rodando
	public boolean getRodando() {
		return rodando;
	}

	// Set jogador
	public void jogador() {
		falar("Por favor insira o nome do jogador:");
		jogador = entrada.next();

	}

	// Jogo
	public void jogar() {

		for (int i = 0; i < 5; i++) {

			while (escolhajogador != 1 && escolhajogador != 2 && escolhajogador != 3) {
				falar("Escolha:");
				falar("1 para papel");
				falar("2 para pedra");
				falar("3 para tesoura");

				escolhajogador = entrada.nextInt();
			}

			switch (escolhajogador) {
			case 1:
				falar("Voc� escolheu Papel");
				break;
			case 2:
				falar("Voc� escolheu Pedra");
				break;
			case 3:
				falar("Voc� escolheu Tesoura");
				break;
			}

			escolhamaquina = maquina.nextInt(3) + 1;
			switch (escolhamaquina) {
			case 1:
				falar("A m�quina escolheu Papel");
				break;
			case 2:
				falar("A m�quina escolheu Pedra");
				break;
			case 3:
				falar("A m�quina escolheu Tesoura");
				break;
			}

			if (escolhajogador == escolhamaquina) {
				falar("Empate!");
				falar("Ningu�m ganha ponto nessa rodada.");
				escolhajogador = 0;
			} else if (escolhajogador - escolhamaquina == -1 || escolhajogador - escolhamaquina == 2) {
				falar(jogador + " venceu!");
				falar(jogador + " ganhou um ponto.");
				pontosjogador = pontosjogador + 1;
				escolhajogador = 0;
			} else {
				falar("A m�quina venceu!");
				falar("A m�quina ganhou um ponto.");
				pontosmaquina = pontosmaquina + 1;
				escolhajogador = 0;
			}
		}

		if (pontosjogador > pontosmaquina) {
			falar(jogador + " fez " + pontosjogador + " pontos!");
			falar(jogador + " venceu o jogo!");
			jogarNovamente();
		} else if (pontosjogador < pontosmaquina) {
			falar("A m�quina fez " + pontosmaquina + " pontos!");
			falar("A m�quina venceu o jogo!");
			jogarNovamente();
		} else {
			falar("Empate!");
			falar("Que tal jogar novamente pra ver quem ganha?");
			jogarNovamente();
		}
	}

	// Verificar se deseja jogar mais 5 rodadas
	public void jogarNovamente() {

		String recebe = ";";

		while (recebe.equals("Sim") == false && recebe.equals("N�o") == false) {
			falar("Deseja jogar novamente? (Sim/N�o)");
			recebe = entrada.next();
		}

		if (recebe.equals("Sim")) {
			inicializar();

		}
		if (recebe.equals("N�o")) {
			rodando = false;
			falar("Obrigado por jogar!");
			falar("\n");
			falar("Desenvolvido por: Beatriz Palombarini");
		}
	}

}