public class Mago extends Heroi {

    private int mana;

    public Mago(String nome, int vida, int dano, int mana) {
        super(nome, vida - 10, dano + 15);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public String toString() {
        return super.toString() + " (Mana: " + mana + ")";
    }
}
