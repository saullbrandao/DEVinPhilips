package EX5;

public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        aluno.nome = "Saull";
        aluno.sobrenome = "Brandão";
        aluno.setMatricula("123456");

        System.out.println(aluno.registrar());
    }
}
