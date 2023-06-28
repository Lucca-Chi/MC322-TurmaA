import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dataFormato = new SimpleDateFormat("dd-MM-yyyy");


        // Instanciando cliente PF
        System.out.println("\nCriando registro de cliente PF...");
    
        ArrayList<Veiculo> listaVeiculos1 = new ArrayList<Veiculo>();
        Date data1 = new Date();
        try {
            data1 = dataFormato.parse("16-11-2002");
        } catch (ParseException e) {e.printStackTrace();}
    
        ClientePF cliente1 = new ClientePF("Tico", "0012345678",
            "Lalaland", "tico.teco@gmail.com", "12345678909",
            "Masculino", "Ensino Superior", data1, listaVeiculos1);

        System.out.println("Registro criado!");


        // Instanciando cliente PJ
        System.out.println("\nCriando registro de cliente PJ...");
    
        ArrayList<Frota> listaFrotas1 = new ArrayList<Frota>();
        Date data2 = new Date();
        try {
            data2 = dataFormato.parse("23-3-2022");
        } catch (ParseException e) {e.printStackTrace();}
    
        ClientePJ cliente2 = new ClientePJ(
            "Tycho Brahe Ltd.","9987654321", "Escânia, Suécia",
            "tycho.brahe@gmail.com", "11222333000181",
            data2, 20, listaFrotas1);
    
        System.out.println("Registro criado!");


        // Adicionando veículos aos clientes
        System.out.println("\nRegistrando veículos no sistema...");
    
        Veiculo veiculo1 = new Veiculo(
            "TIC1546", "Jaguar", "Jaguar E-type", 1969);

        Veiculo veiculo2 = new Veiculo(
            "TAC1601", "Honda", "Honda Civic", 2008);

        Veiculo veiculo3 = new Veiculo(
            "TUC1999", "Ferrari", "Ferrari F8", 2019);

        System.out.println("3 veículos registrados!");

        System.out.println("\nRegistrando uma frota...");

        ArrayList<Veiculo> listaVeiculos2 = new ArrayList<Veiculo>();
        Frota frota1 = new Frota("0001", listaVeiculos2);

        System.out.println("Frota registrada!");

        System.out.println("\nAdicionando veículo ao cliente...");
        listaVeiculos1.add(veiculo1);
        System.out.println("Veículo adicionado!");

        System.out.println("\nAdicionando veículos à frota...");
        frota1.adicionarVeiculo(veiculo2);
        frota1.adicionarVeiculo(veiculo3);
        System.out.println("Veículos adicionados!");

        
        // Adicionando frota ao cliente PJ
        System.out.println("\nCadastrando frota no cliente PJ...");

        cliente2.adicionarFrota(frota1);

        System.out.println("Clientes cadastrados!");


        // Instanciando seguradora
        System.out.println("\nCriando registros de seguradoras...");

        ArrayList<Cliente> listaClientes1 = new ArrayList<Cliente>();
        ArrayList<Seguro> listaSeguros1 = new ArrayList<Seguro>();

        Seguradora seguradora1 = new Seguradora(
            "48295532000120", "Kepler Seguros", "0123456789",
            "Halândia, Suécia", "amoastros@gmail.com",
            listaClientes1, listaSeguros1);

        ArrayList<Cliente> listaClientes2 = new ArrayList<Cliente>();
        ArrayList<Seguro> listaSeguros2 = new ArrayList<Seguro>();

        Seguradora seguradora2 = new Seguradora(
            "92835671000190", "Kepler Seguros 2", "0123456789",
            "Halândia, Suécia", "amoastros@gmail.com",
            listaClientes2, listaSeguros2);;

        System.out.println("2 seguradoras registradas!");


        // Adicionando clientes na seguradora
        System.out.println("\nCadastrando clientes na seguradora...");

        listaClientes1.add(cliente1);
        listaClientes1.add(cliente2);

        System.out.println("Clientes cadastrados!");


        // Instanciando condutores
        System.out.println("\nCriando registro de condutor...");

        ArrayList<Sinistro> listaSinistros1 = new ArrayList<Sinistro>();
        Date data3 = new Date();
        try {
            data3 = dataFormato.parse("27-12-1984");
        } catch (ParseException e) {e.printStackTrace();}

        Condutor condutor1 = new Condutor(
            "28573877766", "Kep", "1123581321", "Tomorrowland",
            "bigblue@hotmail.com", data3, listaSinistros1);

        System.out.println("Registro de condutor criado!");


        // Instanciando seguros
        System.out.println("\nCriando registro de seguro PF...");

        ArrayList<Sinistro> listaSinistros2 = new ArrayList<Sinistro>();
        ArrayList<Condutor> listaCondutores1 = new ArrayList<Condutor>();
        Date data4 = new Date();
        Date data5 = new Date();
        try {
            data4 = dataFormato.parse("4-4-2022");
            data5 = dataFormato.parse("5-4-2023");
        } catch (ParseException e) {e.printStackTrace();}

        Seguro seguro1 = new SeguroPF(
            data4, data5, seguradora1, listaSinistros2,
            listaCondutores1, veiculo1, cliente1);

        System.out.println("Registro de seguro criado!");

        System.out.println("\nCriando registro de seguro PJ...");

        ArrayList<Sinistro> listaSinistros3 = new ArrayList<Sinistro>();
        ArrayList<Condutor> listaCondutores2 = new ArrayList<Condutor>();
        Date data6 = new Date();
        Date data7 = new Date();
        try {
            data4 = dataFormato.parse("1-1-2002");
            data5 = dataFormato.parse("1-1-2032");
        } catch (ParseException e) {e.printStackTrace();}

        Seguro seguro2 = new SeguroPJ(
            data6, data7, seguradora2, listaSinistros3,
            listaCondutores2, frota1, cliente2);

        System.out.println("Registro de seguro criado!");


        // Instanciando sinistros
        System.out.println("\nCriando registro de sinistro...");

        Date data8 = new Date();
        try {
            data8 = dataFormato.parse("24-4-2023");
        } catch (ParseException e) {e.printStackTrace();}

        Sinistro sinistro1 = new Sinistro(
            data8, "Esmolândia, Suécia", condutor1, seguro1);

        System.out.println("Registro de sinistro criado!");

        System.out.println("\nCriando registro de sinistro...");

        Date data9 = new Date();
        try {
            data9 = dataFormato.parse("16-5-2023");
        } catch (ParseException e) {e.printStackTrace();}

        Sinistro sinistro2 = new Sinistro(
            data9, "Uplândia, Suécia", condutor1, seguro2);

        System.out.println("Registro de sinistro criado");


        // Adicionando sinistros nos seguros
        System.out.println("\nGerando sinistros nos seguros...");

        seguro1.gerarSinistro(sinistro1);
        seguro2.gerarSinistro(sinistro2);

        System.out.print("Sinistros gerados!\n");


        // Adicionando condutores nos seguros
        System.out.println("\nAutorizando condutores nos seguros...");

        seguro1.autorizarCondutor(condutor1);
        seguro2.autorizarCondutor(condutor1);

        System.out.println("Condutores autorizados!");


        // Adicionando os seguros nas seguradoras
        System.out.println("\nGerando os seguros nas seguradoras...");

        seguradora1.gerarSeguro(seguro1);
        seguradora1.gerarSeguro(seguro2);

        System.out.println("Seguros gerados!");

        // Métodos adicionais de listagem da seguradora
        System.out.println("\n>> Seguradora: " + seguradora1.getNome());
        System.out.println("- Lista de todos os clientes");
        System.out.println(seguradora1.listarClientes());
        System.out.println("- Sinistros de cliente específico por CPF/CNPJ");
        System.out.print(seguradora1.visualizarSinistros("12345678909"));
        System.out.println("- Lista de todos os sinistros");
        System.out.println(seguradora1.listarSinistros());


        // Receita da seguradora (automaticamente atualiza o valorSeguro dos clientes)
        System.out.println("- Receita da seguradora");
        System.out.println(String.format("R$%.2f", seguradora1.calcularReceita()));


        // Lendo os arquivos
        ArrayList<Frota> listaFrotas2 = new ArrayList<Frota>();
        for (Cliente cliente: seguradora2.getListaClientes()) {
            if (cliente instanceof ClientePJ) {
                for (Frota frota: ((ClientePJ)cliente).getListaFrotas()) {
                    listaFrotas2.add(frota);
                }
            }
        }

        seguradora2.lerDados(listaVeiculos2, listaFrotas2, listaCondutores2);
    

        // Menu interativo

        ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
        listaSeguradoras.add(seguradora1);
        listaSeguradoras.add(seguradora2);

        // Foi definida a Kepler Seguros como como a seguradora padrão
        // a fim de acelerar quaisquer testes com o menu interativo.
        // Deve-se adicionar clientes na outra seguradora para testá-la.
        Seguradora seguradoraSelecionada = seguradora1;

        int inputOperacao1 = -1;
        int inputOperacao2 = -1;
        String inputTexto = "#";

        while (inputOperacao1 != MenuPrincipal.SAIR.operacao) {

            // Atualização dos valores de seguro
            for(int i = 0; i < listaSeguradoras.size(); i++) {
                listaSeguradoras.get(i).calcularReceita();
            }

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
            System.out.println(MenuPrincipal.CALCULAR_RECEITA.operacao +
                ". Calcular Receita");
            System.out.println(MenuPrincipal.TROCAR_SEGURADORA.operacao +
                ". Trocar Seguradora");
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
                    System.out.println(MenuCadastrar.CADASTRAR_SEGURO_PF.operacao +
                        ". Cadastrar Seguro PF");
                    System.out.println(MenuCadastrar.CADASTRAR_SEGURO_PJ.operacao +
                        ". Cadastrar Seguro PJ");
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
                                System.out.println("ERRO! NOME INVÁLIDO");
                            iniciou = true;

                            System.out.print("Nome: ");
                            inputTexto = sc.nextLine();
                            cNome = inputTexto;
                        }

                        System.out.print("Telefone: ");
                        inputTexto = sc.nextLine();
                        String cTelefone = inputTexto;

                        System.out.print("Endereço: ");
                        inputTexto = sc.nextLine();
                        String cEndereco = inputTexto;

                        System.out.print("E-mail: ");
                        inputTexto = sc.nextLine();
                        String cEmail = inputTexto;

                        String cCPF = "";
                        iniciou = false;
                        while (!iniciou || !Validacao.validarCPF(inputTexto)) {

                            if (iniciou)
                                System.out.println("ERRO! CPF INVÁLIDO");
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

                        System.out.print("Data de Nascimento (dd-MM-yyyy): ");
                        inputTexto = sc.nextLine();
                        Date cData = new Date();
                        try {
                            cData = dataFormato.parse(inputTexto);
                        } catch (ParseException e) {e.printStackTrace();}

                        ClientePF c = new ClientePF(
                            cNome, cTelefone, cEndereco, cEmail, cCPF,
                            cGenero, cEducacao, cData, new ArrayList<Veiculo>());

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
                                System.out.println("ERRO! NOME INVÁLIDO");
                            iniciou = true;

                            System.out.print("Nome: ");
                            inputTexto = sc.nextLine();
                            cNome = inputTexto;
                        }

                        System.out.print("Telefone: ");
                        inputTexto = sc.nextLine();
                        String cTelefone = inputTexto;

                        System.out.print("Endereço: ");
                        inputTexto = sc.nextLine();
                        String cEndereco = inputTexto;

                        System.out.print("E-mail: ");
                        inputTexto = sc.nextLine();
                        String cEmail = inputTexto;

                        String cCNPJ = "";
                        iniciou = false;                        
                        while (!iniciou || !Validacao.validarCNPJ(inputTexto)) {

                            if (iniciou)
                                System.out.println("ERRO! CNPJ INVÁLIDO");
                            iniciou = true;

                            System.out.print("CNPJ: ");
                            inputTexto = sc.nextLine();
                            cCNPJ = inputTexto;
                        }

                        System.out.print("Data de Fundação (dd-MM-yyyy): ");
                        inputTexto = sc.nextLine();
                        Date cData = new Date();
                        try {
                            cData = dataFormato.parse(inputTexto);
                        } catch (ParseException e) {e.printStackTrace();}

                        System.out.print("Quantidade de Funcionários: ");
                        inputTexto = sc.nextLine();
                        int cQtdFunc = Integer.parseInt(inputTexto);

                        ClientePJ c = new ClientePJ(
                            cNome, cTelefone, cEndereco, cEmail,
                            cCNPJ, cData, cQtdFunc, new ArrayList<Frota>());

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
                        if (!inputTexto.equals("X") && !inputTexto.equals("x")) {

                            int pos = seguradoraSelecionada.buscarCliente(inputTexto);

                            if (pos >= 0) {

                                Cliente vCliente = seguradoraSelecionada.getListaClientes().get(pos);

                                if (vCliente instanceof ClientePF) {
                                    ((ClientePF)vCliente).adicionarVeiculo(v);
                                    System.out.print("Veículo registrado no cliente!");
                                }

                                else if (vCliente instanceof ClientePJ) {
                                    System.out.print("Frota dona (Code, X para qualquer uma): ");
                                    inputTexto = sc.nextLine();
                                    ArrayList<Frota> vClienteFrotas =
                                        ((ClientePJ)vCliente).getListaFrotas();
                                    
                                    boolean encontrou = false;
                                    for (int i = 0; i < vClienteFrotas.size(); i++) {
                                        if (inputTexto.equals("X") || inputTexto.equals("x")) {
                                            vClienteFrotas.get(0).adicionarVeiculo(v);
                                            encontrou = true;
                                        }
                                        else if (vClienteFrotas.get(i).getCode().equals(inputTexto)) {
                                            vClienteFrotas.get(i).adicionarVeiculo(v);
                                            encontrou = true;
                                        }
                                    }

                                    if (encontrou) {
                                        System.out.println("Veículo registrado na frota!");
                                    }
                                    else {
                                        System.out.println("ERRO! FROTA NÃO ENCONTRADA");
                                    }
                                }
                            }
                            else {
                                System.out.println("ERRO! CLIENTE NÃO ENCONTRADO");
                            }
                        }
                    }

                    else if (inputOperacao2 == MenuCadastrar.CADASTRAR_SEGURO_PF.operacao) {

                        System.out.println("\nCadastro de Seguro PF");

                        boolean iniciou;

                        String sCPF = "";
                        iniciou = false;
                        while (!iniciou || !Validacao.validarCPF(inputTexto)) {
                            if (iniciou)
                                System.out.println("ERRO! CPF INVÁLIDO");
                            iniciou = true;

                            System.out.print("Cliente (CPF): ");
                            inputTexto = sc.nextLine();
                            sCPF = inputTexto;
                        }

                        System.out.print("Veículo (Placa): ");
                        inputTexto = sc.nextLine();
                        String sPlaca = inputTexto;

                        System.out.print("Data de Início (dd-MM-yyyy): ");
                        inputTexto = sc.nextLine();
                        Date sData1 = new Date();
                        try {
                            sData1 = dataFormato.parse(inputTexto);
                        } catch (ParseException e) {e.printStackTrace();}

                        System.out.print("Data de Término (dd-MM-yyyy): ");
                        inputTexto = sc.nextLine();
                        Date sData2 = new Date();
                        try {
                            sData2 = dataFormato.parse(inputTexto);
                        } catch (ParseException e) {e.printStackTrace();}

                        int pos = seguradoraSelecionada.buscarCliente(sCPF);
                        if (pos >= 0) {
                            Cliente sCliente = seguradoraSelecionada.getListaClientes().get(
                            seguradoraSelecionada.buscarCliente(sCPF));

                            Veiculo sVeiculo = ((ClientePF)sCliente).getListaVeiculos().get(
                                ((ClientePF)sCliente).buscarVeiculo(sPlaca));
                            
                            Seguro s = new SeguroPF(sData1, sData2, seguradoraSelecionada,
                            new ArrayList<Sinistro>(), new ArrayList<Condutor>(), 
                            sVeiculo, (ClientePF)sCliente);

                            seguradoraSelecionada.gerarSeguro(s);

                            System.out.println("Seguro gerado!");
                        }
                        else {
                            System.out.println("ERRO! Cliente não foi encontrado");
                        }
                    }

                    else if (inputOperacao2 == MenuCadastrar.CADASTRAR_SEGURO_PJ.operacao) {

                        System.out.println("\nCadastro de Seguro PJ");

                        boolean iniciou;

                        String sCNPJ = "";
                        iniciou = false;
                        while (!iniciou || !Validacao.validarCNPJ(inputTexto)) {

                            if (iniciou)
                                System.out.println("ERRO! CNPJ INVÁLIDO");
                            iniciou = true;

                            System.out.print("Cliente (CNPJ): ");
                            inputTexto = sc.nextLine();
                            sCNPJ = inputTexto;
                        }

                        System.out.print("Frota (Code): ");
                        inputTexto = sc.nextLine();
                        String sCode = inputTexto;

                        System.out.print("Data de Início (dd-MM-yyyy): ");
                        inputTexto = sc.nextLine();
                        Date sData1 = new Date();
                        try {
                            sData1 = dataFormato.parse(inputTexto);
                        } catch (ParseException e) {e.printStackTrace();}

                        System.out.print("Data de Término (dd-MM-yyyy): ");
                        inputTexto = sc.nextLine();
                        Date sData2 = new Date();
                        try {
                            sData2 = dataFormato.parse(inputTexto);
                        } catch (ParseException e) {e.printStackTrace();}

                        int pos = seguradoraSelecionada.buscarCliente(sCNPJ);
                        if (pos >= 0) {

                            Cliente sCliente = seguradoraSelecionada.getListaClientes().get(
                            seguradoraSelecionada.buscarCliente(sCNPJ));

                            Frota sFrota = ((ClientePJ)sCliente).getListaFrotas().get(
                            ((ClientePJ)sCliente).buscarFrota(sCode));

                            Seguro s = new SeguroPJ(sData1, sData2, seguradoraSelecionada,
                            new ArrayList<Sinistro>(), new ArrayList<Condutor>(), 
                            sFrota, (ClientePJ)sCliente);

                            seguradoraSelecionada.gerarSeguro(s);

                            System.out.println("Seguro gerado!");
                        }

                        else {
                            System.out.println("ERRO! Cliente não foi encontrado");
                        }
                    }

                    else if (inputOperacao2 == MenuCadastrar.CADASTRAR_SEGURADORA.operacao) {

                        System.out.println("\nCadastro de Seguradora");

                        boolean iniciou;

                        String sCNPJ = "";
                        iniciou = false;                        
                        while (!iniciou || !Validacao.validarCNPJ(inputTexto)) {

                            if (iniciou)
                                System.out.println("ERRO! CNPJ INVÁLIDO");
                            iniciou = true;

                            System.out.print("CNPJ: ");
                            inputTexto = sc.nextLine();
                            sCNPJ = inputTexto;
                        }
                        
                        String sNome = "";
                        iniciou = false;
                        while (!iniciou || !Validacao.validarNome(inputTexto)) {
                            if (iniciou)
                                System.out.println("ERRO! NOME INVÁLIDO");
                            iniciou = true;

                            System.out.print("Nome: ");
                            inputTexto = sc.nextLine();
                            sNome = inputTexto;
                        }

                        System.out.print("Telefone: ");
                        inputTexto = sc.nextLine();
                        String sTelefone = inputTexto;

                        System.out.print("Endereço: ");
                        inputTexto = sc.nextLine();
                        String sEndereco = inputTexto;

                        System.out.print("E-mail: ");
                        inputTexto = sc.nextLine();
                        String sEmail = inputTexto;

                        Seguradora s = new Seguradora(
                            sCNPJ, sNome, sTelefone, sEndereco, sEmail,
                            new ArrayList<Cliente>(), new ArrayList<Seguro>());

                        listaSeguradoras.add(s);

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
                    System.out.println(MenuListar.LISTAR_SEGUROS_POR_CLIENTE.operacao +
                        ". Listar Seguros por Cliente");
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
                        System.out.println(seguradoraSelecionada.getNome());

                        System.out.println(seguradoraSelecionada.listarClientes());
                    }

                    else if (inputOperacao2 == MenuListar.LISTAR_SEGUROS_POR_CLIENTE.operacao) {

                        System.out.println("\nSeguros por cliente");

                        System.out.print("Cliente (CPF ou CNPJ): ");
                        inputTexto = sc.nextLine();

                        System.out.println(seguradoraSelecionada.visualizarSeguros(inputTexto));
                    }

                    else if (inputOperacao2 == MenuListar.LISTAR_SINISTROS_POR_SEGURADORA.operacao) {

                        System.out.println("\nSinistros por seguradora");

                        System.out.print("Seguradora: ");
                        System.out.println(seguradoraSelecionada.getNome());

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
                        System.out.println(seguradoraSelecionada.getNome());

                        Cliente clienteEmAnalise;
                        for (int i = 0; i < seguradoraSelecionada.getListaClientes().size(); i++) {
                        
                            clienteEmAnalise = seguradoraSelecionada.getListaClientes().get(i);

                            if (clienteEmAnalise instanceof ClientePF) {
                                System.out.print(((ClientePF)seguradoraSelecionada.
                                getListaClientes().get(i)).getListaVeiculos().toString().
                                replace("[", "").replace("]", "").replace(", ", ""));
                            }
                            else if (clienteEmAnalise instanceof ClientePJ) {
                                String strVeiculos = "";
                                ArrayList<Frota>listaFrotasCliente =
                                    ((ClientePJ)clienteEmAnalise).getListaFrotas();
                                for (int j = 0; j < listaFrotasCliente.size(); j++) {
                                    strVeiculos += listaFrotasCliente.toString().
                                    replace("[", "").replace("]", "");
                                }
                                if (!(strVeiculos.equals(""))) {
                                    System.out.println(strVeiculos);
                                }
                            }
                        }
                    }

                    else if (inputOperacao2 == MenuListar.LISTAR_VEICULOS_POR_CLIENTE.operacao) {

                        System.out.println("\nVeículos por cliente");

                        System.out.print("Cliente (CPF ou CNPJ): ");
                        inputTexto = sc.nextLine();

                        Cliente clienteEmAnalise;
                        for (int i = 0; i < seguradoraSelecionada.getListaClientes().size(); i++) {
                        
                            clienteEmAnalise = seguradoraSelecionada.getListaClientes().get(i);

                            if (clienteEmAnalise instanceof ClientePF
                                && clienteEmAnalise.equals(
                                    seguradoraSelecionada.getListaClientes().get(
                                    seguradoraSelecionada.buscarCliente(inputTexto)))) {
                                System.out.print(((ClientePF)seguradoraSelecionada.
                                getListaClientes().get(i)).getListaVeiculos().toString().
                                replace("[", "").replace("]", "").replace(", ", ""));
                            }
                            else if (clienteEmAnalise instanceof ClientePJ
                                && clienteEmAnalise.equals(
                                    seguradoraSelecionada.getListaClientes().get(
                                    seguradoraSelecionada.buscarCliente(inputTexto)))) {
                                String strVeiculos = "";
                                ArrayList<Frota>listaFrotasCliente =
                                    ((ClientePJ)clienteEmAnalise).getListaFrotas();
                                for (int j = 0; j < listaFrotasCliente.size(); j++) {
                                    strVeiculos += listaFrotasCliente.toString().
                                    replace("[", "").replace("]", "");
                                }
                                System.out.println(strVeiculos);
                            }
                        }
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

                        System.out.println("Cliente removido!");
                    }

                    else if (inputOperacao2 == MenuExcluir.EXCLUIR_VEICULO.operacao) {

                        System.out.println("\nExclusão de Veículo");

                        System.out.print("Cliente dono (CPF ou CPNPJ): ");
                        inputTexto = sc.nextLine();

                        Cliente c = seguradoraSelecionada.getListaClientes().get(
                            seguradoraSelecionada.buscarCliente(inputTexto));

                        if (c instanceof ClientePF) {
                            System.out.print("Veículo (Placa): ");
                            inputTexto = sc.nextLine();
                            if (((ClientePF)c).removerVeiculo(inputTexto)) {
                                System.out.println("Veículo removido!");
                            }
                            else {
                                System.out.println("ERRO! CADASTRO NÃO ENCONTRADO");
                            }
                        }
                        else if (c instanceof ClientePJ) {

                            System.out.print("Frota (Code): ");
                            inputTexto = sc.nextLine();
                            String codeRemov = inputTexto;
                    
                            System.out.print("Veículo (Placa): ");
                            inputTexto = sc.nextLine();
                            String placaRemov = inputTexto;

                            if (((ClientePJ)c).removerVeiculoFrota(codeRemov, placaRemov)) {
                                System.out.println("Veículo removido!");
                            }
                            else {
                                System.out.println("ERRO! CADASTRO NÃO ENCONTRADO");
                            }
                        }
                    }

                    else if (inputOperacao2 == MenuExcluir.EXCLUIR_SINISTRO.operacao) {

                        System.out.println("\nExclusão de Sinistro");

                        System.out.print("Seguradora: ");
                        System.out.println(seguradoraSelecionada.getNome());
        
                        System.out.print("Sinistro (ID): ");
                        inputTexto = sc.nextLine();

                        if (seguradoraSelecionada.removerSinistro(inputTexto)) {
                                System.out.println("Veículo removido!");
                            }
                            else {
                                System.out.println("ERRO! CADASTRO NÃO ENCONTRADO");
                            }
                    }
                }
            }

            else if (inputOperacao1 == MenuPrincipal.GERAR_SINISTRO.operacao) {

                System.out.println("\nGeração de Sinistro");

                System.out.print("Endereço: ");
                inputTexto = sc.nextLine();
                String sEndereco = inputTexto;

                System.out.print("Seguro (ID): ");
                inputTexto = sc.nextLine();
                String sSeguro = inputTexto;
                if (sSeguro.equals(""))
                    sSeguro = "1";

                System.out.print("Data (dd-MM-yyyy): ");
                inputTexto = sc.nextLine();
                Date sData = new Date();
                try {
                    sData = dataFormato.parse(inputTexto);
                } catch (ParseException e) {e.printStackTrace();}

                ArrayList<Seguro> segurosEmAnalise = seguradoraSelecionada.getListaSeguros();
                for (int i = 0; i < segurosEmAnalise.size(); i++) {
                    if (segurosEmAnalise.get(i).getId() == Integer.parseInt(sSeguro)) {

                        Sinistro s = new Sinistro(
                            sData, sEndereco, condutor1, segurosEmAnalise.get(i));

                        segurosEmAnalise.get(i).gerarSinistro(s);

                        System.out.println("Sinistro gerado!");
                    }
                }
            }

            else if (inputOperacao1 == MenuPrincipal.CALCULAR_RECEITA.operacao) {

                System.out.println("\nReceita da Seguradora");
                System.out.printf("Total: R$%.2f\n", seguradoraSelecionada.calcularReceita());
            }

            else if (inputOperacao1 == MenuPrincipal.TROCAR_SEGURADORA.operacao) {

                System.out.println("\nSeguradoras");

                for(int i = 1; i < listaSeguradoras.size() + 1; i++) {
                    System.out.println(String.format("%d. %s",
                    i, listaSeguradoras.get(i - 1).getNome()));
                }
                System.out.println("0. Voltar");

                inputOperacao2 = Integer.parseInt(sc.nextLine());
                
                if (inputOperacao2 - 1 < listaSeguradoras.size() && inputOperacao2 > 0) {
                    seguradoraSelecionada = listaSeguradoras.get(inputOperacao2 - 1);
                    System.out.println("Seguradora trocada!");
                }
                else if (inputOperacao2 != 0) {
                    System.out.println("ERRO! ESCOLHA INVÁLIDA");
                }
            }
        }
        sc.close();
    }
}
