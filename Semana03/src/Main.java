public class Main {
    public static void main(String[] args) {
        Clinica clinica = new Clinica("Teste", "Teste", "123123123", "Rua Teste", 1234);
        Cliente cliente = new Cliente(84.2,1.88,31, "Saull");
        Cliente cliente2 = new Cliente(70d,1.73,25, "Teste");

//        IMC
        Double imc = clinica.calcularImc(84.2, 1.88);
        System.out.println(imc);

//        Clientes
        clinica.addCliente(cliente);
        System.out.println(clinica.getClientes());

        System.out.println(clinica.tratamento(cliente));
        System.out.println(clinica.tratamento(cliente, 10d));
        System.out.println(clinica.tratamento(cliente2));

        clinica.addCliente(cliente2);
        System.out.println(clinica.getClientes());
    }
}