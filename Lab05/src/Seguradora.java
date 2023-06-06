import java.util.ArrayList;

public class Seguradora {

    private final String CNPJ;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Seguro> listaSeguros;

    public Seguradora(String cNPJ, String nome, String telefone, String endereco, String email,
            ArrayList<Cliente> listaClientes, ArrayList<Seguro> listaSeguros) {
        CNPJ = cNPJ;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.listaClientes = listaClientes;
        this.listaSeguros = listaSeguros;
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


    public double calcularReceita() {

        double soma = 0;

        for (int i = 0; i < this.listaSeguros.size(); i++) {
            soma += listaSeguros.get(i).calcularValor();
        }

        return soma;
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

}
