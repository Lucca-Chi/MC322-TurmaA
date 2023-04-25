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

    public boolean removerCliente(String cliente) {

        int tamanhoLista = this.listaClientes.size();

        for (int i = 0; i < tamanhoLista; i++) {
            if (listaClientes.get(i).getNome().equals(cliente)) {
                listaClientes.remove(i);
            }
        }

        return true;
    }

    public String listarClientes(String tipoCliente) {
    
        String str = "Clientes: ";

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
                    str += String.format(", %s", this.listaClientes.get(tamanhoLista-1).getNome());
                }
            }
        }      
        return str;
    }

    public boolean gerarSinistro(Sinistro sinistro) {

        this.listaSinistros.add(sinistro);
        return true;
    }

    public String visualizarSinistro(String cliente) {
    
        int tamanhoLista = this.listaSinistros.size();
        ArrayList<Sinistro> sinistrosEncontrados = new ArrayList<Sinistro>();

        for (int i = 0; i < tamanhoLista; i++) {
            if (listaSinistros.get(i).getCliente().getNome().equals(cliente)) {
                sinistrosEncontrados.add(listaSinistros.get(i));
            }
        }

        if (sinistrosEncontrados.size() > 0) {
            String r = "";
            for (int i = 0; i < sinistrosEncontrados.size()-1; i++) {
                r += String.format("%s\n", sinistrosEncontrados.get(i).toString());
            }
            r += sinistrosEncontrados.get(sinistrosEncontrados.size()-1).toString();
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
