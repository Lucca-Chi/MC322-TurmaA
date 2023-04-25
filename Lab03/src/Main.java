import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        // Instanciando cliente PF
        System.out.print("\nCriando registro de cliente...\n");
    
        ArrayList<Veiculo> listaVeiculos1 = new ArrayList<Veiculo>();
    
        ClientePF cliente1 = new ClientePF(
            "Tico", "Lalaland", listaVeiculos1, "12345678900",
            "Masculino", new Date(122, 4, 24), "Superior",
            new Date(102, 11, 16), "Média-alta");

        System.out.print("Registro criado!\n");


        // Instanciando cliente PJ
        System.out.print("\nCriando registro de cliente...\n");
    
        ArrayList<Veiculo> listaVeiculos2 = new ArrayList<Veiculo>();
    
        ClientePJ cliente2 = new ClientePJ(
            "Tycho Brahe Ltd.", "Escânia, Suécia",
            listaVeiculos2, "11222333000181", new Date(122, 4, 23));
    
        System.out.print("Registro criado!\n");


        // Validação de CPF e CNPJ
        System.out.print("\nValidando o CPF do cliente...\n");
    
        if (cliente1.validarCPF(cliente1.getCPF())) {
            System.out.print("CPF do cliente validado!\n");
        }
        else {
            System.out.print("ERRO: CPF do cliente inválido!\n");
        }

        System.out.print("\nValidando o CNPJ do cliente...\n");
    
        if (cliente2.validarCNPJ(cliente2.getCNPJ())) {
            System.out.print("CNPJ do cliente validado!\n");
        }
        else {
            System.out.print("ERRO: CNPJ do cliente inválido!\n");
        }


        // Adicionando veículos aos clientes
        System.out.print("\nRegistrando veículos no sistema...\n");
    
        Veiculo veiculo1 = new Veiculo(
            "TIC1546", "Jaguar", "Jaguar E-type", 1969);

        Veiculo veiculo2 = new Veiculo(
            "TAC1601", "Honda", "Honda Civic", 2008);

        System.out.print("2 veículos registrados!\n");

        System.out.print("\nAdicionando veículo ao cliente...\n");
        listaVeiculos1.add(veiculo1);
        System.out.print("Veículo adicionado!\n");

        System.out.print("\nAdicionando veículo ao cliente...\n");
        listaVeiculos2.add(veiculo2);
        System.out.print("Veículo adicionado!\n");


        // Instanciando seguradora
        System.out.print("\nCriando registro de seguradora...\n");

        ArrayList<Sinistro> listaSinistros1 = new ArrayList<Sinistro>();
        ArrayList<Cliente> listaClientes1 = new ArrayList<Cliente>();

        Seguradora seguradora1 = new Seguradora(
            "Kepler Seguros", "0123456789", "amoastros@gmail.com",
            "Halândia, Suécia", listaSinistros1, listaClientes1);

        System.out.print("Registro de seguradora criado!\n");


        // Adicionando clientes na seguradora
        System.out.print("\nCadastrando clientes na seguradora...\n");

        listaClientes1.add(cliente1);
        listaClientes1.add(cliente2);

        System.out.print("Clientes cadastrados!\n");


        // Instanciando sinistro
        System.out.print("\nCriando registro de sinistro...\n");

        Sinistro sinistro1 = new Sinistro(
            new Date(123, 4, 24), "Esmolândia, Suécia", veiculo1, cliente1);

        System.out.print("Registro de sinistro criado!\n");


        // Adicionando clientes na seguradora
        System.out.print("\nCadastrando sinistro na seguradora...\n");

        listaSinistros1.add(sinistro1);

        System.out.print("Sinistro cadastrado!\n");


        // toString de cada classe
        System.out.print("\nImprimindo dados registrados:\n\n");
    
        System.out.println("Cliente 1");
        System.out.println(cliente1.toString());
        System.out.println("Veículo 1");
        System.out.println(veiculo1.toString());
        System.out.println("Cliente 2");
        System.out.println(cliente2.toString());
        System.out.println("Veículo 2");
        System.out.println(veiculo2.toString());
        System.out.println("Sinistro");
        System.out.println(sinistro1.toString());


        // Métodos adicionais de listagem
        System.out.print("Seguradora\n");
        System.out.println(seguradora1.listarClientes("Qualquer um"));
        System.out.println(seguradora1.listarSinistros());


        // Pesquisa por sinistro com input do usuário
        System.out.print("\nInicializando modo de pesquisa de sinistro...\n\n");

        String buscaSinistroMensagem = 
            "Digite o nome do cliente do qual se quer obter os sinistros (X para finalizar): ";

        System.out.print(buscaSinistroMensagem);        
        String nomeBuscado = sc.nextLine();

        while (!nomeBuscado.equals("X") && !nomeBuscado.equals("x")) {
            
            System.out.println();
            System.out.println(seguradora1.visualizarSinistro(nomeBuscado));
            
            System.out.print(buscaSinistroMensagem);        
            nomeBuscado = sc.nextLine();
        } 

        sc.close();
    }
    
}
