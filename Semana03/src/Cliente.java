public class Cliente {
    private Double peso;
    private Double altura;
    private Integer idade;
    private String nome;

    public Cliente(Double peso, Double altura) {
        this.peso = peso;
        this.altura = altura;
    }
    public Cliente(Double peso, Double altura, Integer idade, String nome) {
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.nome = nome;
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

    @Override
    public String toString() {
        return "Cliente{" +
                "peso=" + peso +
                ", altura=" + altura +
                ", idade=" + idade +
                ", nome='" + nome + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
