import java.util.ArrayList;

public class Cliente {

    private String nome;
    private String endereco;
    private ArrayList<Veiculo> listaVeiculos;

    public Cliente(String nome, String endereco, ArrayList<Veiculo> listaVeiculos) {
        this.nome = nome;
        this.endereco = endereco;
        this.listaVeiculos = listaVeiculos;
    }

    public String toString() {

        String str = String.format("Nome: %s\nEndereço: %s\nLista de Veículos: ", this.nome, this.endereco);

        int tamanhoLista = listaVeiculos.size();
        for (int i = 0; i < tamanhoLista - 1; i++) {
            str += String.format("%s - Placa %s, ", 
                listaVeiculos.get(i).getMarca(), listaVeiculos.get(i).getPlaca());
        }
        str += String.format("%s - Placa %s\n", 
            listaVeiculos.get(tamanhoLista - 1).getMarca(), listaVeiculos.get(tamanhoLista - 1).getPlaca());

        return str;
    }


    // Getters e setters

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }
    
}
