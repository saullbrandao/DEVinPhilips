public class Cliente {
    private Double peso;
    private Double altura;
    private Integer idade;

    public Cliente(Double peso, Double altura, Integer idade) {
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
