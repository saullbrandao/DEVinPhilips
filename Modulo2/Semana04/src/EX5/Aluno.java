package EX5;

public class Aluno extends Pessoa {
    private String matricula;

    public String registrar() {
        return "Sou o " + this.obterNomeCompleto() + " e minha matrícula é " + matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
