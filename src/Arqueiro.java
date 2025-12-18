public class Arqueiro extends Heroi { 

    private int agilidade;

    public Arqueiro(String nome, int vida, int dano, int agilidade) {
        super(nome, vida, dano + 10);
        this.agilidade = agilidade;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    @Override
    public String toString() {
        return super.toString() + " (Agilidade: " + agilidade + ")";
    }
    @Override

    public int getDano() {
        return super.getDano() + 10;
    }
}