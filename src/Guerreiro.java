public class Guerreiro extends Heroi {
    private int forca;
    private int vida;
    private int dano;

    public Guerreiro(String nome, int vida, int dano, int forca) {
        super(nome, vida, dano);
        this.forca = forca;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    @Override
    public String toString() {
        return super.toString() + " (Força: " + forca + ")";
    }

    @Override
    public int getVida() {
        return super.getVida();
    }

    public int setVida() {
        return super.getVida() + 20;
    }
        @Override

    public void setVida(int vida) {
        this.vida = vida;
    }
        @Override

    public void setDano(int dano) {
        this.dano = dano;
    }
    @Override

    public int getDano() {
        return super.getDano();
    }

    public int setDano() {
        return super.getDano() + 15;
    }

    
    
}
