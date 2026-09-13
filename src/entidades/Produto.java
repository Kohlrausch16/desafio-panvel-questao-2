package entidades;

public class Produto {

    private String nome;
    private Boolean comprado;

    public Produto(String nome, Boolean comprado){
        this.nome = nome;
        this.comprado = comprado;
    }

    public String getNome() {
        return nome;
    }

    public Boolean getComprado() {
        return comprado;
    }

    public void setComprado(Boolean comprado) {
        this.comprado = comprado;
    }
}
