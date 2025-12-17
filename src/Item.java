public class Item {
    private String nome;
    private String tipo;
    private int poder;

    public Item(String nome, String tipo, int poder) {
        this.nome = nome;
        this.tipo = tipo;
        this.poder = poder;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = (int) (poder + 1.5);
    }

    public double usar() { 
        return poder * 1.5;
    }

    @Override
    public String toString() {
        return nome + " (Tipo: " + tipo + ", Poder: " + poder + ")";
    }
}
