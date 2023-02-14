public class Clinica {
    String nome;
    String dono;
    String CNPJ;
    String logradouro;
    Integer codigo;

    public Clinica(String nome, String dono, String CNPJ, String logradouro, Integer codigo) {
        this.nome = nome;
        this.dono = dono;
        this.CNPJ = CNPJ;
        this.logradouro = logradouro;
        this.codigo = codigo;
    }

    public Double calcularImc(Double peso, Double altura) {
        double imc = peso / (altura * altura);
        imprimeCategoriaImc(imc);
        return imc;
    }

    private void imprimeCategoriaImc(double imc) {
        if(imc < 18.5) {
            System.out.println("Magreza");
        } else if(imc < 25d) {
            System.out.println("Normal");
        } else if(imc < 30d) {
            System.out.println("Sobrepeso");
        } else if(imc < 40d) {
            System.out.println("Obesidade");
        } else {
            System.out.println("Obesidade Grave");
        }
    }
}
