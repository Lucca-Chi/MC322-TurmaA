package MC322.Labs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Instanciação de objetos
        System.out.print("Criando cadastro de veículo...\n");
        Veiculo veiculo1 = new Veiculo(
            "QUE1234", "Jaguar", "Jaguar E-Type");


        System.out.print("Criando cadastro de seguradora...\n");
        Seguradora seguradora1 = new Seguradora(
            "In Love With My Car - Seguros", "0012345678",
            "ilovemycar@gmail.com", "Inglaterra");

        
        System.out.print("Criando cadastro de cliente...\n");
        Cliente cliente1 = new Cliente(
            "Farrokh Bulsara", "Mr.BadGuy", "05/09/1946", 
            45, "Inglaterra");

        
        // toString do cliente
        System.out.print(cliente1.toString());


        // Validação de CPF com correção por input do usuário
        while (!cliente1.validarCPF(cliente1.getCpf())) {

            System.out.print(
                String.format("\nCPF de %s inválido!\nDigite um novo CPF: ", cliente1.getNome()));
            String novoCpf = sc.nextLine();
            cliente1.setCpf(novoCpf);
        }


        // Modificação de objeto
        System.out.print("\nFazendo alterações adicionais...\n");
        cliente1.setNome("Freddie Mercury");
        cliente1.setIdade(76);
        

        // toString do cliente
        System.out.print(cliente1.toString());


        // Instanciação de sinistro com ID aleatório
        System.out.print("\nCriando cadastro de sinistro...\n");
        Sinistro sinistro1 = new Sinistro("24/03/2023", "Baker Street");

        System.out.print(String.format(
            "O ID gerado para o sinistro é: %s\n", String.format("%06d", sinistro1.getId())));

        sc.close();
    }
}
