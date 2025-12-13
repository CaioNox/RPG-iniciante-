import java.util.Random;
import java.util.Scanner;

public class RPG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int passos = 0; // conta quantos passos o jogador deu
        boolean inimigoPresente = false;
        int playerVida = 100;
        int playerDano = 15;

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite um movimento (W/A/S/D): ");
            String comando = scanner.nextLine();

            if (comando.equalsIgnoreCase("W")) {
                System.out.println("Você andou para frente!");
            }
            else if (comando.equalsIgnoreCase("S")) {
                System.out.println("Você andou para trás!");
            }
            else if (comando.equalsIgnoreCase("A")) {
                System.out.println("Você andou para a esquerda!");
            }
            else if (comando.equalsIgnoreCase("D")) {
                System.out.println("Você andou para a direita!");
            }
            else {
                System.out.println("Comando inválido! Tente de novo.");
                i--; // não conta tentativa errada
                continue;
            }

            passos++; // aumentamos a quantidade de passos

            // 🎲 SORTE: 20% de chance de algo acontecer
            int chance = random.nextInt(100); // 0 a 99

            if (chance < 20) { // 20% de probabilidade
                System.out.println("✨ Algo aconteceu! Você encontrou um item raro!");
            }

            // 🎯 Evento especial: acontece somente APÓS 5 passos
            if (passos >= 5) {
                int chanceEspecial = random.nextInt(100); // 0 a 99
                if (chanceEspecial < 10) { // 10% de chance
                    System.out.println("🔥 Um inimigo aparece após muitos passos!");
                    inimigoPresente = true;
                }
            }
        }

        System.out.println("Fim dos movimentos!");
        
        if (inimigoPresente) {
            // criar inimigo com valores aleatórios
            int inimigoVida = 30 + random.nextInt(41); // 30..70
            int inimigoDano = 5 + random.nextInt(11); // 5..15
            Inimigo inimigo = new Inimigo("Goblin", inimigoVida, inimigoDano);

            System.out.println("Um inimigo apareceu: " + inimigo);
            System.out.print("Digite uma ação (F para fugir / L para lutar): ");
            String acao = scanner.nextLine();

            if (acao.equalsIgnoreCase("F")) {
                int fuga = random.nextInt(100);
                if (fuga < 50) {
                    System.out.println("Você conseguiu fugir com sucesso!");
                } else {
                    System.out.println("Falha na fuga! O inimigo aproveita e ataca.");
                    playerVida -= inimigo.getDano();
                    System.out.println("Sua vida agora: " + playerVida);
                }
            }
            else if (acao.equalsIgnoreCase("L")) {
                System.out.println("Iniciando combate (sorte) contra " + inimigo.getNome() + ".");
                while (playerVida > 0 && inimigo.getVida() > 0) {
                    int rollPlayer = random.nextInt(100) + playerDano;
                    int rollInimigo = random.nextInt(100) + inimigo.getDano();

                    if (rollPlayer >= rollInimigo) {
                        // jogador acerta
                        inimigo.setVida(inimigo.getVida() - playerDano);
                        System.out.println("Você acertou! " + inimigo.getNome() + " agora tem " + Math.max(0, inimigo.getVida()) + " de vida.");
                    } else {
                        // inimigo acerta
                        playerVida -= inimigo.getDano();
                        System.out.println("O inimigo acertou! Sua vida agora é " + Math.max(0, playerVida) + ".");
                    }

                    try { Thread.sleep(400); } catch (InterruptedException e) { /* ignore */ }
                }

                if (playerVida > 0) {
                    System.out.println("Você venceu o combate!");
                } else {
                    System.out.println("Você foi derrotado pelo inimigo...");
                }
            }
            else {
                System.out.println("Comando inválido! O inimigo aproveitou para atacar!");
                playerVida -=  inimigo.getDano();
                System.out.println("Sua vida agora: " + playerVida);
            }
        }
        
        scanner.close();
    }
}
