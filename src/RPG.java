import java.util.Random;
import java.util.Scanner;

public class RPG{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int passos = 0; // conta quantos passos o jogador deu
        boolean inimigoPresente = true;
        int playerVida = 100;
        int playerDano = 15;
        System.out.print("Digite o nome do seu herói: ");
        Heroi heroi = new Heroi(scanner.nextLine(), playerVida, playerDano);
        Item item = new Item("Porcao De forca", "porcao", 20);
        Guerreiro guerreiro = new Guerreiro(heroi.getNome(), heroi.getVida(), heroi.getDano(), 30);
        

        System.out.print("Digite sua classe (1-Guerreiro, 2-Mago, 3-Arqueiro): ");
        int classe = scanner.nextInt();
        scanner.nextLine(); // consumir a nova linha
        
        if(classe == 1) { 
            heroi = guerreiro;
            playerVida = guerreiro.setVida();
            playerDano = guerreiro.setDano();
            System.out.println("Voce escolheu a classe Guerreiro! Vida aumentada para " + playerVida + " e Dano aumentado para " + playerDano + ".");
        }



        System.out.println("Bem-vindo, " + heroi.getNome() + "! Sua aventura começa agora." + "Voce tem " + heroi.getVida() + " de vida e " + heroi.getDano() + " de dano.");

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

            if(chance < 10) {
                System.out.println( "Voce ganhou uma Porcao de forca: " + item);
                playerDano += item.getPoder();
                System.out.println("Seu dano aumentou para: " + playerDano);
                continue;// pula para a próxima iteração do loop
            }
                        if (passos >= 5) {
                int chanceEspecial = random.nextInt(100); // 0 a 99
                if (chanceEspecial < 25) { // 25% de chance
                    System.out.println(" 1 Um inimigo aparece após muitos passos!");
                    inimigoPresente = true;
                }
                
            }


            // 🎯 Evento especial: acontece somente APÓS 5 passos

        }

        System.out.println("Fim dos movimentos!");
        
        if (inimigoPresente = true) {
            // criar inimigo com valores aleatórios
            int inimigoVida = 100 + random.nextInt(41); // 30..70
            int inimigoDano = 15 + random.nextInt(11); // 5..15
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
