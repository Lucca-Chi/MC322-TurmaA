import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Seguradora {

    private final String CNPJ;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Seguro> listaSeguros;
    private ArquivoClientePF arquivoClientePF;
    private ArquivoClientePJ arquivoClientePJ;
    private ArquivoCondutor arquivoCondutor;
    private ArquivoFrota arquivoFrota;
    private ArquivoSeguro arquivoSeguro;
    private ArquivoSinistro arquivoSinistro;
    private ArquivoVeiculo arquivoVeiculo;

    public Seguradora(String cNPJ, String nome, String telefone, String endereco, String email,
            ArrayList<Cliente> listaClientes, ArrayList<Seguro> listaSeguros) {
        CNPJ = cNPJ;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.listaClientes = listaClientes;
        this.listaSeguros = listaSeguros;
        this.arquivoClientePF = new ArquivoClientePF();
        this.arquivoClientePJ = new ArquivoClientePJ();
        this.arquivoCondutor = new ArquivoCondutor();
        this.arquivoFrota = new ArquivoFrota();
        this.arquivoSeguro = new ArquivoSeguro();
        this.arquivoSinistro = new ArquivoSinistro();
        this.arquivoVeiculo = new ArquivoVeiculo();
    }


    public boolean cadastrarCliente(Cliente cliente) {

        this.listaClientes.add(cliente);
        return true;
    }


    public int buscarCliente(String clienteCadastro) {

        boolean isCPF = (clienteCadastro.length() == 11);
        boolean isCNPJ = (clienteCadastro.length() == 14);

        int tamanhoLista = this.listaClientes.size();

        Cliente clienteEmAnalise;
        
        for (int i = 0; i < tamanhoLista; i++) {

            clienteEmAnalise = this.listaClientes.get(i);

            if (isCPF) {
                if (clienteEmAnalise instanceof ClientePF) {
                    if (((ClientePF)clienteEmAnalise).getCPF().equals(clienteCadastro)) {
                        return i;
                    }
                }
            }
            else if (isCNPJ) {
                if (clienteEmAnalise instanceof ClientePJ) {
                    if (((ClientePJ)clienteEmAnalise).getCNPJ().equals(clienteCadastro)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }


    public boolean removerCliente(String clienteCadastro) {

        int pos = buscarCliente(clienteCadastro);

        if (pos >= 0) {
            this.listaClientes.remove(pos);
            
            ArrayList<Seguro> segurosCliente = this.obterSeguros(clienteCadastro);
            for (int i = 0; i < this.listaSeguros.size(); i++) {
                if (segurosCliente.contains(this.listaSeguros.get(i))) {
                    this.listaSeguros.remove(i);
                }
            }
            return true;
        }
        else {
            return false;
        }
    }


    public String listarClientes(String tipoCliente) {
    
        String str = "Clientes";

        if (tipoCliente == "PF")
            str += " PF: ";
        else if (tipoCliente == "PJ")
            str += " PJ: ";
        else
            str += ": ";

        boolean enumeracaoIniciada = false;

        int tamanhoLista = this.listaClientes.size();

        for (int i = 0; i < tamanhoLista; i++) {

            Cliente clienteEmAnalise = this.listaClientes.get(i);

            if ((tipoCliente.equals("PF") && clienteEmAnalise instanceof ClientePF) ||
                (tipoCliente.equals("PJ") && clienteEmAnalise instanceof ClientePJ) ||
                (tipoCliente != "PF" && tipoCliente != "PJ")) {

                if (!enumeracaoIniciada) {
                    str += String.format("%s", clienteEmAnalise.getNome());
                    enumeracaoIniciada = true;
                } else {
                    str += String.format(", %s", this.listaClientes.get(i).getNome());
                }
            }
        }      
        return str;
    }


    public String listarClientes() {
    
        String str = "Clientes: ";

        boolean enumeracaoIniciada = false;

        int tamanhoLista = this.listaClientes.size();

        for (int i = 0; i < tamanhoLista; i++) {

            Cliente clienteEmAnalise = this.listaClientes.get(i);

            if (!enumeracaoIniciada) {
                str += String.format("%s", clienteEmAnalise.getNome());
                enumeracaoIniciada = true;
            } else {
                str += String.format(", %s", this.listaClientes.get(i).getNome());
            }
        }      
        return str;
    }


    public boolean gerarSeguro(Seguro seguro) {

        this.listaSeguros.add(seguro);
        return true;
    }


    public int buscarSeguro(int id) {

        int tamanhoLista = this.listaSeguros.size();

        for (int i = 0; i < tamanhoLista; i++) {
            if (this.listaSeguros.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }


    public ArrayList<Seguro> obterSeguros(String clienteCadastro) {

        boolean isCPF = (clienteCadastro.length() == 11);
        boolean isCNPJ = (clienteCadastro.length() == 14);
    
        int tamanhoLista = this.listaSeguros.size();
        
        ArrayList<Seguro> segurosEncontrados = new ArrayList<Seguro>();

        Cliente clienteEmAnalise;

        for (int i = 0; i < tamanhoLista; i++) {

            clienteEmAnalise = this.listaSeguros.get(i).getCliente();

            if (isCPF) {
                if (clienteEmAnalise instanceof ClientePF) {
                    if (((ClientePF)clienteEmAnalise).getCPF().equals(clienteCadastro))
                        segurosEncontrados.add(this.listaSeguros.get(i));
                }
            }
            else if (isCNPJ) {
                if (clienteEmAnalise instanceof ClientePJ) {
                    if (((ClientePJ)clienteEmAnalise).getCNPJ().equals(clienteCadastro))
                        segurosEncontrados.add(this.listaSeguros.get(i));
                }                
            }
        }

        return segurosEncontrados;
    }


    public ArrayList<Seguro> obterSeguros(Cliente cliente) {
    
        int tamanhoLista = this.listaSeguros.size();
        
        ArrayList<Seguro> segurosEncontrados = new ArrayList<Seguro>();

        Cliente clienteEmAnalise;

        for (int i = 0; i < tamanhoLista; i++) {

            clienteEmAnalise = this.listaSeguros.get(i).getCliente();

            if (clienteEmAnalise == cliente) {
                segurosEncontrados.add(this.listaSeguros.get(i));
            }
        }

        return segurosEncontrados;
    }


    public String visualizarSeguros(String clienteCadastro) {

        ArrayList<Seguro> segurosEncontrados = obterSeguros(clienteCadastro);

        if (segurosEncontrados.size() > 0) {
            String r = "";
            for (int i = 0; i < segurosEncontrados.size() - 1; i++) {
                r += String.format("%s\n", segurosEncontrados.get(i).toString());
            }
            r += segurosEncontrados.get(segurosEncontrados.size() - 1).toString();
            return r; 
        } else {
            return "ERRO: CLIENTE NÃO POSSUI SEGURO OU NÃO ESTÁ NO SISTEMA\n";
        }
    }


    public String visualizarSeguros(Cliente cliente) {

        ArrayList<Seguro> segurosEncontrados = obterSeguros(cliente);

        if (segurosEncontrados.size() > 0) {
            String r = "";
            for (int i = 0; i < segurosEncontrados.size() - 1; i++) {
                r += String.format("%s\n", segurosEncontrados.get(i).toString());
            }
            r += segurosEncontrados.get(segurosEncontrados.size() - 1).toString();
            return r; 
        } else {
            return "ERRO: CLIENTE NÃO POSSUI SEGURO OU NÃO ESTÁ NO SISTEMA\n";
        }
    }


    public ArrayList<Sinistro> obterSinistros(String clienteCadastro) {

        boolean isCPF = (clienteCadastro.length() == 11);
        boolean isCNPJ = (clienteCadastro.length() == 14);
    
        ArrayList<Sinistro> sinistrosEncontrados = new ArrayList<Sinistro>();

        int tamanhoLista = this.listaSeguros.size();
        Seguro seguroEmAnalise;
        Cliente clienteEmAnalise;
        for (int i = 0; i < tamanhoLista; i++) {

            seguroEmAnalise = this.listaSeguros.get(i);
            clienteEmAnalise = seguroEmAnalise.getCliente();

            if (isCPF) {
                if (clienteEmAnalise instanceof ClientePF) {
                    if (((ClientePF)clienteEmAnalise).getCPF().equals(clienteCadastro)) {
                        for (int j = 0; j < seguroEmAnalise.getListaSinistros().size(); j++) {
                            sinistrosEncontrados.add(seguroEmAnalise.getListaSinistros().get(j));
                        }
                    }
                }
            }
            else if (isCNPJ) {
                if (clienteEmAnalise instanceof ClientePJ) {
                    if (((ClientePJ)clienteEmAnalise).getCNPJ().equals(clienteCadastro)) {
                        for (int j = 0; j < seguroEmAnalise.getListaSinistros().size(); j++) {
                            sinistrosEncontrados.add(seguroEmAnalise.getListaSinistros().get(j));
                        }
                    }
                }                
            }
        }

        return sinistrosEncontrados;
    }


    public ArrayList<Sinistro> obterSinistros(Cliente cliente) {
        
        ArrayList<Sinistro> sinistrosEncontrados = new ArrayList<Sinistro>();

        Seguro seguroEmAnalise;
        for (int i = 0; i < this.listaSeguros.size(); i++) {

            seguroEmAnalise = this.listaSeguros.get(i);
                
            if (seguroEmAnalise.getCliente().equals(cliente)) {

                for (int j = 0; j < seguroEmAnalise.getListaSinistros().size(); j++) {
                    sinistrosEncontrados.add(seguroEmAnalise.getListaSinistros().get(j));
                }
            }
        }

        return sinistrosEncontrados;
    }


    public String visualizarSinistros(String clienteCadastro) {

        ArrayList<Sinistro> sinistrosEncontrados = obterSinistros(clienteCadastro);

        if (sinistrosEncontrados.size() > 0) {
            String r = "";
            for (int i = 0; i < sinistrosEncontrados.size() - 1; i++) {
                r += String.format("%s\n", sinistrosEncontrados.get(i).toString());
            }
            r += sinistrosEncontrados.get(sinistrosEncontrados.size() - 1).toString();
            return r; 
        } else {
            return "ERRO: CLIENTE NÃO POSSUI SINISTRO OU NÃO ESTÁ NO SISTEMA\n";
        }
    }


    public String visualizarSinistros(Cliente cliente) {

        ArrayList<Sinistro> sinistrosEncontrados = obterSinistros(cliente);

        if (sinistrosEncontrados.size() > 0) {
            String r = "";
            for (int i = 0; i < sinistrosEncontrados.size() - 1; i++) {
                r += String.format("%s\n", sinistrosEncontrados.get(i).toString());
            }
            r += sinistrosEncontrados.get(sinistrosEncontrados.size() - 1).toString();
            return r; 
        } else {
            return "ERRO: CLIENTE NÃO POSSUI SINISTRO OU NÃO ESTÁ NO SISTEMA\n";
        }
    }


    public String listarSinistros() {

        ArrayList<Seguro> segurosAnalisados = new ArrayList<Seguro>();

        String str = "Sinistros: ";

        for (int i = 0; i < this.listaClientes.size(); i++) {

            segurosAnalisados = obterSeguros(this.listaClientes.get(i));

            int tamanhoLista = segurosAnalisados.size();
            for (int j = 0; j < tamanhoLista; j++) {
                if (i != this.listaClientes.size() - 1) {
                    str += String.format("ID %d, ", segurosAnalisados.get(j).getId());
                }
                else {
                    str += String.format("ID %d", segurosAnalisados.get(tamanhoLista-1).getId());
                }
            }
        }
        return str;
    }


    public boolean removerSinistro(String id) {

        Seguro seguroEmAnalise;
        for (int i = 0; i < this.listaSeguros.size(); i++) {

            seguroEmAnalise = this.listaSeguros.get(i);

            Sinistro sinistroEmAnalise;
            for (int j = 0; j < seguroEmAnalise.getListaSinistros().size(); j++) {

                sinistroEmAnalise = seguroEmAnalise.getListaSinistros().get(j);
                
                if (sinistroEmAnalise.getId() == Integer.parseInt(id)) {

                    seguroEmAnalise.getListaSinistros().remove(j);
                    return true;
                }
            }
        }
        return false;
    }


    public double calcularReceita() {

        double soma = 0;

        for (int i = 0; i < this.listaSeguros.size(); i++) {
            soma += listaSeguros.get(i).calcularValor();
        }

        return soma;
    }


    public void lerDados(ArrayList<Veiculo> listaVeiculos,
            ArrayList<Frota> listaFrotas, ArrayList<Condutor> listaCondutores) {

        SimpleDateFormat dataFormato = new SimpleDateFormat("dd-MM-yyyy");
        Date data = new Date();
        ArrayList<String> l;

        // Veículos
        l = arquivoVeiculo.lerArquivo();;
        for (int i = 4; i < l.size(); i += 4) {

            Veiculo v = new Veiculo(l.get(i), l.get(i+1), l.get(i+2),
                Integer.valueOf(l.get(i+3)));

            listaVeiculos.add(v);
        }

        l.clear();

        // Frotas
        l = arquivoFrota.lerArquivo();
        for (int i = 4; i < l.size(); i += 4) {

            Frota f = new Frota(l.get(i), new ArrayList<Veiculo>());

            int veiculosAdicionados = 0;
            for (Veiculo veiculo: listaVeiculos) {
                if (veiculo.getPlaca().equals(l.get(i+1))) {
                    f.adicionarVeiculo(veiculo);
                    veiculosAdicionados++;
                } else if (veiculo.getPlaca().equals(l.get(i+2))) {
                    f.adicionarVeiculo(veiculo);
                    veiculosAdicionados++;
                } else if (veiculo.getPlaca().equals(l.get(i+3))) {
                    f.adicionarVeiculo(veiculo);
                    veiculosAdicionados++;
                }
                if (veiculosAdicionados == 3) {
                    break;
                }
            }
        }

        l.clear();

        // Condutores
        l = arquivoCondutor.lerArquivo();;
        for (int i = 6; i < l.size(); i += 6) {
            try {
                data = dataFormato.parse(l.get(i+5));
            } catch (ParseException e) {e.printStackTrace();}

            Condutor c = new Condutor(l.get(i), l.get(i+1), l.get(i+2), l.get(i+3),
                l.get(i+4), data, new ArrayList<Sinistro>());

            listaCondutores.add(c);
        }

        l.clear();

        // Clientes PF
        l = arquivoClientePF.lerArquivo();
        for (int i = 9; i < l.size(); i += 9) {
            try {
                data = dataFormato.parse(l.get(i+7));
            } catch (ParseException e) {e.printStackTrace();}

            ClientePF c = new ClientePF(l.get(i+1), l.get(i+2), l.get(i+3), l.get(i+4),
                l.get(i), l.get(i+5), l.get(i+6), data, new ArrayList<Veiculo>());

            for (Veiculo veiculo: listaVeiculos) {
                if (veiculo.getPlaca().equals(l.get(i+8))) {
                    c.adicionarVeiculo(veiculo);
                    break;
                }
            }
            this.cadastrarCliente(c);
        }

        l.clear();

        // Clientes PJ
        l = arquivoClientePJ.lerArquivo();
        for (int i = 7; i < l.size(); i += 7) {
            try {
                data = dataFormato.parse(l.get(i+5));
            } catch (ParseException e) {e.printStackTrace();}

            ClientePJ c = new ClientePJ(l.get(i+1), l.get(i+2), l.get(i+3), l.get(i+4),
                l.get(i), data, 0, new ArrayList<Frota>());

            for (Frota frota: listaFrotas) {
                if (frota.getCode().equals(l.get(i+6))) {
                    c.adicionarFrota(frota);
                    break;
                }
            }
            this.cadastrarCliente(c);
        }
    }


    public void gravarDados() {
        
        arquivoClientePF.gravarArquivo();
        arquivoClientePJ.gravarArquivo();
        arquivoCondutor.gravarArquivo();
        arquivoFrota.gravarArquivo();
        arquivoSeguro.gravarArquivo();
        arquivoSinistro.gravarArquivo();
        arquivoVeiculo.gravarArquivo();
    }


    // Getters e setters

    public String getCNPJ() {
        return CNPJ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Seguro> getListaSeguros() {
        return listaSeguros;
    }

    public void setListaSeguros(ArrayList<Seguro> listaSeguros) {
        this.listaSeguros = listaSeguros;
    }

    public ArquivoClientePF getArquivoClientePF() {
        return arquivoClientePF;
    }

    public void setArquivoClientePF(ArquivoClientePF arquivoClientePF) {
        this.arquivoClientePF = arquivoClientePF;
    }

    public ArquivoClientePJ getArquivoClientePJ() {
        return arquivoClientePJ;
    }

    public void setArquivoClientePJ(ArquivoClientePJ arquivoClientePJ) {
        this.arquivoClientePJ = arquivoClientePJ;
    }

    public ArquivoCondutor getArquivoCondutor() {
        return arquivoCondutor;
    }

    public void setArquivoCondutor(ArquivoCondutor arquivoCondutor) {
        this.arquivoCondutor = arquivoCondutor;
    }

    public ArquivoFrota getArquivoFrota() {
        return arquivoFrota;
    }

    public void setArquivoFrota(ArquivoFrota arquivoFrota) {
        this.arquivoFrota = arquivoFrota;
    }

    public ArquivoSeguro getArquivoSeguro() {
        return arquivoSeguro;
    }

    public void setArquivoSeguro(ArquivoSeguro arquivoSeguro) {
        this.arquivoSeguro = arquivoSeguro;
    }

    public ArquivoSinistro getArquivoSinistro() {
        return arquivoSinistro;
    }

    public void setArquivoSinistro(ArquivoSinistro arquivoSinistro) {
        this.arquivoSinistro = arquivoSinistro;
    }

    public ArquivoVeiculo getArquivoVeiculo() {
        return arquivoVeiculo;
    }

    public void setArquivoVeiculo(ArquivoVeiculo arquivoVeiculo) {
        this.arquivoVeiculo = arquivoVeiculo;
    }
}
