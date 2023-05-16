import java.util.Date;
import java.util.Random;

public class Sinistro {

    private final int id;
    private Date data;
    private String endereco;
    private Veiculo veiculo;
    private Cliente cliente;

    public Sinistro(Date data, String endereco, Veiculo veiculo, Cliente cliente) {
        this.id = gerarId();
        this.data = data;
        this.endereco = endereco;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    public String toString() {
        return String.format(
            "ID: %d\nData: %s\nEndereço: %s\nVeículo: %s - Placa %s\nCliente: %s\n",
            this.id, this.data, this.endereco, this.veiculo.getModelo(),
            this.veiculo.getPlaca(), this.cliente.getNome());
    }

    
    private int gerarId() {
        Random rand = new Random();
        int randomId = rand.nextInt(999999);

        return randomId;
    }


    // Getters e setters

    public int getId() {
        return this.id;
    }

    public Date getData() {
        return this.data;
    }

    public String getEndereco() {
        return endereco;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
