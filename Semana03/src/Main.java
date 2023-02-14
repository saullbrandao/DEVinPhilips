public class Main {
    public static void main(String[] args) {
        Clinica clinica = new Clinica("Teste", "Teste", "123123123", "Rua Teste", 1234);
        Cliente cliente = new Cliente(84.2,1.88,31);

//        IMC
        Double imc = clinica.calcularImc(84.2, 1.88);
        System.out.println(imc);

//        Clientes
        clinica.addCliente(cliente);
        System.out.println(clinica.getClientes());
    }
}