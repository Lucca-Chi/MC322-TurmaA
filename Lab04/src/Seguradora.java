import java.util.ArrayList;

public class Seguradora {

    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Cliente> listaClientes;

    public Seguradora(String nome, String telefone, String email, String endereco,
            ArrayList<Sinistro> listaSinistros, ArrayList<Cliente> listaClientes) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistros = listaSinistros;
        this.listaClientes = listaClientes;
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
            
            ArrayList<Sinistro> sinistrosCliente = this.obterSinistros(clienteCadastro);
            for (int i = 0; i < this.listaSinistros.size(); i++) {
                if (sinistrosCliente.contains(this.listaSinistros.get(i))) {
                    this.listaSinistros.remove(i);
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

    public boolean gerarSinistro(Sinistro sinistro) {

        this.listaSinistros.add(sinistro);
        return true;
    }

    public int buscarSinistro(int id) {

        int tamanhoLista = this.listaSinistros.size();

        for (int i = 0; i < tamanhoLista; i++) {
            if (this.listaSinistros.get(i).getId() == id) {
                return i;
            }
        }
        return -1;

    }

    public ArrayList<Sinistro> obterSinistros(String clienteCadastro) {

        boolean isCPF = (clienteCadastro.length() == 11);
        boolean isCNPJ = (clienteCadastro.length() == 14);
    
        int tamanhoLista = this.listaSinistros.size();
        
        ArrayList<Sinistro> sinistrosEncontrados = new ArrayList<Sinistro>();

        Cliente clienteEmAnalise;

        for (int i = 0; i < tamanhoLista; i++) {

            clienteEmAnalise = listaSinistros.get(i).getCliente();

            if (isCPF) {
                if (clienteEmAnalise instanceof ClientePF) {
                    if (((ClientePF)clienteEmAnalise).getCPF().equals(clienteCadastro))
                        sinistrosEncontrados.add(listaSinistros.get(i));
                }
            }
            else if (isCNPJ) {
                if (clienteEmAnalise instanceof ClientePJ) {
                    if (((ClientePJ)clienteEmAnalise).getCNPJ().equals(clienteCadastro))
                        sinistrosEncontrados.add(listaSinistros.get(i));
                }                
            }
        }

        return sinistrosEncontrados;
    }

    public ArrayList<Sinistro> obterSinistros(Cliente cliente) {
    
        int tamanhoLista = this.listaSinistros.size();
        
        ArrayList<Sinistro> sinistrosEncontrados = new ArrayList<Sinistro>();

        Cliente clienteEmAnalise;

        for (int i = 0; i < tamanhoLista; i++) {

            clienteEmAnalise = listaSinistros.get(i).getCliente();

            if (clienteEmAnalise == cliente) {
                sinistrosEncontrados.add(listaSinistros.get(i));
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
            return "ERROR: CLIENTE NÃO POSSUI SINISTRO OU NÃO ESTÁ NO SISTEMA\n";
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
            return "ERROR: CLIENTE NÃO POSSUI SINISTRO OU NÃO ESTÁ NO SISTEMA\n";
        }
    }

    public String listarSinistros() {

        String str = "Sinistros: ";

        int tamanhoLista = this.listaSinistros.size();
        for(int i = 0; i < tamanhoLista - 1; i++) {
            str += String.format("ID %d, ", this.listaSinistros.get(i).getId());
        }
        str += String.format("ID %d", this.listaSinistros.get(tamanhoLista-1).getId());
    
        return str;
    }

    public double calcularPrecoSeguroCliente(Cliente cliente) {
        
        double valorSeguro = cliente.calculaScore() * (1 + obterSinistros(cliente).size());
        cliente.setValorSeguro(valorSeguro);

        return valorSeguro;
    }

    public double calcularPrecoSeguroCliente(String clienteCadastro) {
        
        Cliente cliente = this.listaClientes.get(buscarCliente(clienteCadastro));
        double valorSeguro = cliente.calculaScore() * (1 + obterSinistros(cliente).size());
        cliente.setValorSeguro(valorSeguro);
        
        return valorSeguro;
    }

    public double calcularReceita() {

        double soma = 0;

        for (int i = 0; i < this.listaClientes.size(); i++) {
            soma += calcularPrecoSeguroCliente(listaClientes.get(i));
        }

        return soma;
    }

    public void transferirSeguro(Cliente clienteDoador, Cliente clienteReceptor) {

        for (int i = 0; i < clienteDoador.getListaVeiculos().size(); i++) {
            clienteReceptor.getListaVeiculos().add(clienteDoador.getListaVeiculos().get(i));
            clienteDoador.getListaVeiculos().remove(i);
        }

        ArrayList<Sinistro> sinistrosCliente = this.obterSinistros(clienteDoador);

        for (int i = 0; i < sinistrosCliente.size(); i++) {
            sinistrosCliente.get(i).setCliente(clienteReceptor);
        }

        clienteReceptor.setValorSeguro(
            clienteReceptor.getValorSeguro() + clienteDoador.getValorSeguro());

        this.listaClientes.remove(clienteDoador);
    }


    // Getters e setters

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
 
    public String getEndereco() {
        return endereco;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
}
