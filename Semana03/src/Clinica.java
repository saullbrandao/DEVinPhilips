import java.util.ArrayList;
import java.util.List;

public class Clinica {
    private String nome;
    private String dono;
    private String CNPJ;
    private String logradouro;
    private Integer codigo;
    private final List<Cliente> clientes = new ArrayList<>();

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
}
