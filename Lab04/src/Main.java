import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat dataFormato = new SimpleDateFormat("dd-MM-yyyy");

        // Instanciando cliente PF
        System.out.print("\nCriando registro de cliente...\n");
    
        ArrayList<Veiculo> listaVeiculos1 = new ArrayList<Veiculo>();
    
        ClientePF cliente1 = new ClientePF(
            "Tico", "Lalaland", listaVeiculos1, "12345678909",
            "Masculino", new Date(122, 4, 24), "Superior",
            new Date(102, 11, 16), "Média-alta");

        System.out.print("Registro criado!\n");


        // Instanciando cliente PJ
        System.out.print("\nCriando registro de cliente...\n");
    
        ArrayList<Veiculo> listaVeiculos2 = new ArrayList<Veiculo>();
    
        ClientePJ cliente2 = new ClientePJ(
            "Tycho Brahe Ltd.", "Escânia, Suécia", listaVeiculos2,
            "11222333000181", new Date(122, 4, 23), 20);
    
        System.out.print("Registro criado!\n");


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


        // Instanciando sinistros
        System.out.print("\nCriando registro de sinistro...\n");

        Sinistro sinistro1 = new Sinistro(
            new Date(123, 4, 24), "Esmolândia, Suécia", veiculo1, cliente1);

        System.out.print("Registro de sinistro criado!\n");

        System.out.print("\nCriando registro de sinistro...\n");

        Sinistro sinistro2 = new Sinistro(
            new Date(123, 5, 16), "Uplândia, Suécia", veiculo2, cliente2);

        System.out.print("Registro de sinistro criado!\n");


        // Adicionando sinistros na seguradora
        System.out.print("\nCadastrando sinistros na seguradora...\n");

        seguradora1.gerarSinistro(sinistro1);
        seguradora1.gerarSinistro(sinistro2);

        System.out.print("Sinistros cadastrados!\n");


        // Métodos adicionais de listagem da seguradora
        System.out.print("\n>> Seguradora: " + seguradora1.getNome() + "\n");
        System.out.print("- Lista de todos os clientes\n");
        System.out.println(seguradora1.listarClientes());
        System.out.print("- Sinistros de cliente específico por CPF/CNPJ\n");
        System.out.print(seguradora1.visualizarSinistros("12345678909"));
        System.out.print("- Lista de todos os sinistros\n");
        System.out.println(seguradora1.listarSinistros());


        // Receita da seguradora (automaticamente atualiza o valorSeguro dos clientes)
        System.out.print("- Receita da seguradora\n");
        System.out.println(String.format("%.2f", seguradora1.calcularReceita()));


        // Menu interativo

        ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
        listaSeguradoras.add(seguradora1);

        // Foi definida a Kepler Seguros como como a seguradora padrão fixa
        // a fim de acelerar quaisquer testes com o menu interativo.
        Seguradora seguradoraSelecionada = seguradora1;

        int inputOperacao1 = -1;
        int inputOperacao2 = -1;
        String inputTexto = "#";

        while (inputOperacao1 != MenuPrincipal.SAIR.operacao) {

            inputOperacao2 = -1;
            inputTexto = "#";

            System.out.println(
                "\nMenu Principal");
            System.out.println(MenuPrincipal.CADASTRAR.operacao +
                ". Cadastrar");
            System.out.println(MenuPrincipal.LISTAR.operacao +
                ". Listar");
            System.out.println(MenuPrincipal.EXCLUIR.operacao +
                ". Excluir");
            System.out.println(MenuPrincipal.GERAR_SINISTRO.operacao +
                ". Gerar Sinistro");
            System.out.println(MenuPrincipal.TRANSFERIR_SEGURO.operacao +
                ". Transferir Seguro");
            System.out.println(MenuPrincipal.CALCULAR_RECEITA.operacao +
                ". Calcular Receita");
            System.out.println(MenuPrincipal.SAIR.operacao +
                ". Sair");

            inputOperacao1 = Integer.parseInt(sc.nextLine());

            if (inputOperacao1 == MenuPrincipal.CADASTRAR.operacao) {

                while (inputOperacao2 != MenuCadastrar.VOLTAR.operacao) {

                    System.out.println(
                        "\nMenu de Cadastros");
                    System.out.println(MenuCadastrar.CADASTRAR_CLIENTE_PF.operacao +
                        ". Cadastrar Cliente PF");
                    System.out.println(MenuCadastrar.CADASTRAR_CLIENTE_PJ.operacao +
                        ". Cadastrar Cliente PJ");
                    System.out.println(MenuCadastrar.CADASTRAR_VEICULO.operacao +
                        ". Cadastrar Veículo");
                    System.out.println(MenuCadastrar.CADASTRAR_SEGURADORA.operacao +
                        ". Cadastrar Seguradora");
                    System.out.println(MenuCadastrar.VOLTAR.operacao +
                        ". Voltar");

                    inputOperacao2 = Integer.parseInt(sc.nextLine());

                    if (inputOperacao2 == MenuCadastrar.CADASTRAR_CLIENTE_PF.operacao) {

                        System.out.println("\nCadastro de Cliente PF");

                        boolean iniciou;

                        String cNome = "";
                        iniciou = false;
                        while (!iniciou || !Validacao.validarNome(inputTexto)) {
                            if (iniciou)
                                System.out.println("ERRO! NOME INVÁLIDO!");
                            iniciou = true;

                            System.out.print("Nome: ");
                            inputTexto = sc.nextLine();
                            cNome = inputTexto;
                        }

                        System.out.print("Endereço: ");
                        inputTexto = sc.nextLine();
                        String cEndereco = inputTexto;

                        String cCPF = "";
                        iniciou = false;
                        while (!iniciou || !Validacao.validarCPF(inputTexto)) {

                            if (iniciou)
                                System.out.println("ERRO! CPF INVÁLIDO!");
                            iniciou = true;

                            System.out.print("CPF: ");
                            inputTexto = sc.nextLine();
                            cCPF = inputTexto;
                        }

                        System.out.print("Gênero: ");
                        inputTexto = sc.nextLine();
                        String cGenero = inputTexto;

                        System.out.print("Educação: ");
                        inputTexto = sc.nextLine();
                        String cEducacao = inputTexto;

                        System.out.print("Classe Econômica: ");
                        inputTexto = sc.nextLine();
                        String cClasse = inputTexto;

                        ClientePF c = new ClientePF(
                            cNome, cEndereco, new ArrayList<Veiculo>(), cCPF,
                            cGenero, new Date(), cEducacao, new Date(), cClasse);

                        seguradoraSelecionada.cadastrarCliente(c);
                        System.out.println("Cliente cadastrado!");
                    }

                    else if (inputOperacao2 == MenuCadastrar.CADASTRAR_CLIENTE_PJ.operacao) {

                        System.out.println("\nCadastro de Cliente PJ");

                        boolean iniciou;
                        
                        String cNome = "";
                        iniciou = false;
                        while (!iniciou || !Validacao.validarNome(inputTexto)) {
                            if (iniciou)
                                System.out.println("ERRO! NOME INVÁLIDO!");
                            iniciou = true;

                            System.out.print("Nome: ");
                            inputTexto = sc.nextLine();
                            cNome = inputTexto;
                        }

                        System.out.print("Endereço: ");
                        inputTexto = sc.nextLine();
                        String cEndereco = inputTexto;

                        String cCNPJ = "";
                        iniciou = false;                        
                        while (!iniciou || !Validacao.validarCNPJ(inputTexto)) {

                            if (iniciou)
                                System.out.println("ERRO, CNPJ INVÁLIDO");
                            iniciou = true;

                            System.out.print("CNPJ: ");
                            inputTexto = sc.nextLine();
                            cCNPJ = inputTexto;
                        }

                        System.out.print("Quantidade de Funcionários: ");
                        inputTexto = sc.nextLine();
                        int cQtdFunc = Integer.parseInt(inputTexto);

                        ClientePJ c = new ClientePJ(cNome, cEndereco,
                        new ArrayList<Veiculo>(), cCNPJ, new Date(), cQtdFunc);

                        seguradoraSelecionada.cadastrarCliente(c);
                        System.out.println("Cliente cadastrado!");
                    }

                    else if (inputOperacao2 == MenuCadastrar.CADASTRAR_VEICULO.operacao) {

                        System.out.println("\nCadastro de Veículo");

                        System.out.print("Placa: ");
                        inputTexto = sc.nextLine();
                        String vPlaca = inputTexto;

                        System.out.print("Marca: ");
                        inputTexto = sc.nextLine();
                        String vMarca = inputTexto;

                        System.out.print("Modelo: ");
                        inputTexto = sc.nextLine();
                        String vModelo = inputTexto;

                        System.out.print("Ano de Fabricação: ");
                        inputTexto = sc.nextLine();
                        int vAnoFabr = Integer.parseInt(inputTexto);

                        Veiculo v = new Veiculo(vPlaca, vMarca, vModelo, vAnoFabr);
                        System.out.println("Veículo cadastrado!");

                        System.out.print("Cliente dono (CPF ou CNPJ, X para nenhum): ");
                        inputTexto = sc.nextLine();
                        if (inputTexto != "X" && inputTexto != "x") {
                            Cliente vCliente = seguradoraSelecionada.getListaClientes().get(
                            seguradoraSelecionada.buscarCliente(inputTexto));

                            vCliente.getListaVeiculos().add(v);
                        }
                    }

                    else if (inputOperacao2 == MenuCadastrar.CADASTRAR_SEGURADORA.operacao) {

                        System.out.println("\nCadastro de Seguradora");

                        boolean iniciou;
                        
                        String sNome = "";
                        iniciou = false;
                        while (!iniciou || !Validacao.validarNome(inputTexto)) {
                            if (iniciou)
                                System.out.println("ERRO! NOME INVÁLIDO!");
                            iniciou = true;

                            System.out.print("Nome: ");
                            inputTexto = sc.nextLine();
                            sNome = inputTexto;
                        }

                        System.out.print("Telefone: ");
                        inputTexto = sc.nextLine();
                        String sTelefone = inputTexto;

                        System.out.print("E-Mail: ");
                        inputTexto = sc.nextLine();
                        String sEmail = inputTexto;

                        System.out.print("Endereço: ");
                        inputTexto = sc.nextLine();
                        String sEndereco = inputTexto;

                        Seguradora s = new Seguradora(sNome, sTelefone, sEmail,
                        sEndereco, new ArrayList<Sinistro>(), new ArrayList<Cliente>());

                        System.out.println("Seguradora cadastrada!");
                    }
                }
            }

            else if (inputOperacao1 == MenuPrincipal.LISTAR.operacao) {

                while (inputOperacao2 != MenuListar.VOLTAR.operacao) {

                    System.out.println(
                        "\nMenu de Listagem");
                    System.out.println(MenuListar.LISTAR_CLIENTES_POR_SEGURADORA.operacao +
                        ". Listar Clientes por Seguradora");
                    System.out.println(MenuListar.LISTAR_SINISTROS_POR_SEGURADORA.operacao +
                        ". Listar Sinistros por Seguradora");
                    System.out.println(MenuListar.LISTAR_SINISTROS_POR_CLIENTE.operacao +
                        ". Listar Sinistros por Cliente");
                    System.out.println(MenuListar.LISTAR_VEICULOS_POR_SEGURADORA.operacao +
                        ". Listar Veículos por Seguradora");
                    System.out.println(MenuListar.LISTAR_VEICULOS_POR_CLIENTE.operacao +
                        ". Listar Veículos por Cliente");
                    System.out.println(MenuListar.VOLTAR.operacao +
                        ". Voltar");

                    inputOperacao2 = Integer.parseInt(sc.nextLine());

                    if (inputOperacao2 == MenuListar.LISTAR_CLIENTES_POR_SEGURADORA.operacao) {

                        System.out.println("\nClientes por seguradora");

                        System.out.print("Seguradora: ");
                        System.out.println("Kepler Seguros");

                        System.out.println(seguradoraSelecionada.listarClientes());
                    }

                    else if (inputOperacao2 == MenuListar.LISTAR_SINISTROS_POR_SEGURADORA.operacao) {

                        System.out.println("\nSinistros por seguradora");

                        System.out.print("Seguradora: ");
                        System.out.println("Kepler Seguros");

                        System.out.println(seguradoraSelecionada.listarSinistros());
                    }

                    else if (inputOperacao2 == MenuListar.LISTAR_SINISTROS_POR_CLIENTE.operacao) {

                        System.out.println("\nSinistros por cliente");

                        System.out.print("Cliente (CPF ou CNPJ): ");
                        inputTexto = sc.nextLine();

                        System.out.print(seguradoraSelecionada.visualizarSinistros(inputTexto));
                    }

                    else if (inputOperacao2 == MenuListar.LISTAR_VEICULOS_POR_SEGURADORA.operacao) {

                        System.out.println("\nVeículos por seguradora");

                        System.out.print("Seguradora: ");
                        System.out.println("Kepler Seguros");

                        for (int i = 0; i < seguradoraSelecionada.getListaClientes().size(); i++)
                            System.out.print(seguradoraSelecionada.getListaClientes().get(i).
                            getListaVeiculos().toString().
                            replace("[", "").replace("]", "").replace(", ", ""));
                    }

                    else if (inputOperacao2 == MenuListar.LISTAR_VEICULOS_POR_CLIENTE.operacao) {

                        System.out.println("\nVeículos por cliente");

                        System.out.print("Cliente (CPF ou CNPJ): ");
                        inputTexto = sc.nextLine();

                        System.out.print(seguradoraSelecionada.getListaClientes().
                        get(seguradoraSelecionada.buscarCliente(inputTexto)).
                        getListaVeiculos().toString().
                        replace("[", "").replace("]", "").replace(", ", ""));
                    }
                }
            }

            else if (inputOperacao1 == MenuPrincipal.EXCLUIR.operacao) {

                while (inputOperacao2 != MenuExcluir.VOLTAR.operacao) {

                    System.out.println(
                        "\nMenu de Exclusão");
                    System.out.println(MenuExcluir.EXCLUIR_CLIENTE.operacao +
                        ". Excluir Cliente");
                    System.out.println(MenuExcluir.EXCLUIR_VEICULO.operacao +
                        ". Excluir Veículo");
                    System.out.println(MenuExcluir.EXCLUIR_SINISTRO.operacao +
                        ". Excluir Sinistro");
                    System.out.println(MenuExcluir.VOLTAR.operacao +
                        ". Voltar");

                    inputOperacao2 = Integer.parseInt(sc.nextLine());

                    if (inputOperacao2 == MenuExcluir.EXCLUIR_CLIENTE.operacao) {

                        System.out.println("\nExclusão de Cliente");

                        System.out.print("Cliente (CPF ou CNPJ): ");
                        inputTexto = sc.nextLine();
                        seguradoraSelecionada.removerCliente(inputTexto);
                    }

                    else if (inputOperacao2 == MenuExcluir.EXCLUIR_VEICULO.operacao) {

                        System.out.println("\nExclusão de Veículo");

                        System.out.print("Cliente dono (CPF ou CNPJ): ");
                        inputTexto = sc.nextLine();
                        Cliente c = seguradoraSelecionada.getListaClientes().get(
                            seguradoraSelecionada.buscarCliente(inputTexto));
        
                        System.out.print("Veículo (Placa): ");
                        inputTexto = sc.nextLine();
                        c.getListaVeiculos().remove(c.buscarVeiculo(inputTexto));
                    }

                    else if (inputOperacao2 == MenuExcluir.EXCLUIR_SINISTRO.operacao) {

                        System.out.println("\nExclusão de Sinistro");

                        System.out.print("Seguradora: ");
                        System.out.println("Kepler Seguros");
        
                        System.out.print("Sinistro (ID): ");
                        inputTexto = sc.nextLine();
                        seguradoraSelecionada.getListaSinistros().remove(
                            seguradoraSelecionada.buscarSinistro(Integer.parseInt(inputTexto)));
                    }
                }
            }

            else if (inputOperacao1 == MenuPrincipal.GERAR_SINISTRO.operacao) {

                System.out.println("\nGeração de Sinistro");

                System.out.print("Endereço: ");
                inputTexto = sc.nextLine();
                String sEndereco = inputTexto;

                System.out.print("Cliente (CPF ou CNPJ): ");
                inputTexto = sc.nextLine();
                Cliente sCliente = seguradoraSelecionada.getListaClientes().get(
                    seguradoraSelecionada.buscarCliente(inputTexto));

                System.out.print("Veículo (Placa): ");
                inputTexto = sc.nextLine();
                Veiculo sVeiculo = sCliente.getListaVeiculos().get(
                    sCliente.buscarVeiculo(inputTexto));

                Sinistro s = new Sinistro(new Date(), sEndereco, sVeiculo, sCliente);

                seguradoraSelecionada.gerarSinistro(s);

                System.out.println("Sinistro gerado!");
            }

            else if (inputOperacao1 == MenuPrincipal.TRANSFERIR_SEGURO.operacao) {

                System.out.println("\nTransferência de seguro");

                System.out.print("Cliente doador (CPF ou CNPJ): ");
                inputTexto = sc.nextLine();
                Cliente c1 = seguradoraSelecionada.getListaClientes().get(
                    (seguradoraSelecionada.buscarCliente(inputTexto)));

                System.out.print("Cliente receptor (CPF ou CNPJ): ");
                inputTexto = sc.nextLine();
                Cliente c2 = seguradoraSelecionada.getListaClientes().get(
                    (seguradoraSelecionada.buscarCliente(inputTexto)));

                seguradoraSelecionada.transferirSeguro(c1, c2);

                System.out.println("Transferência concluída!");
            }

            else if (inputOperacao1 == MenuPrincipal.CALCULAR_RECEITA.operacao) {

                System.out.println("\nReceita da Seguradora");
                System.out.printf("Total: R$%.2f\n", seguradoraSelecionada.calcularReceita());
            }
            
        }
        sc.close();
    }
    
}
