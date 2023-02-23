package EX5;

public class Pessoa {
    protected String nome;
    protected String sobrenome;

    protected String obterNomeCompleto() {
        return nome + " " + sobrenome;
    }
}
