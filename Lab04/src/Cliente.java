import java.util.ArrayList;

public abstract class Cliente {  // Testar pra ver se pode ser abstrata mesmo

    private String nome;
    private String endereco;
    private ArrayList<Veiculo> listaVeiculos;
    private double valorSeguro;

    public Cliente(String nome, String endereco, ArrayList<Veiculo> listaVeiculos) {
        this.nome = nome;
        this.endereco = endereco;
        this.listaVeiculos = listaVeiculos;
    }

    public String toString() {

        String str = String.format("Nome: %s\nEndereço: %s\nValor do Seguro: %.2f\nLista de Veículos: ",
            this.nome, this.endereco, this.valorSeguro);

        int tamanhoLista = listaVeiculos.size();
        for (int i = 0; i < tamanhoLista - 1; i++) {
            str += String.format("%s - Placa %s, ", 
                listaVeiculos.get(i).getModelo(), listaVeiculos.get(i).getPlaca());
        }
        str += String.format("%s - Placa %s\n", 
            listaVeiculos.get(tamanhoLista - 1).getModelo(), listaVeiculos.get(tamanhoLista - 1).getPlaca());

        return str;
    }


    public int buscarVeiculo(String placa) {

        int tamanhoLista = this.listaVeiculos.size();

        for (int i = 0; i < tamanhoLista; i++) {
            if (this.listaVeiculos.get(i).getPlaca().equals(placa)) {
                return i;
            }
        }
        return -1;
    }

    public abstract double calculaScore();


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

    public double getValorSeguro() {
        return valorSeguro;
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

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

}
