import java.util.Date;

public class Sinistro {

    private final int id;
    private Date data;
    private String endereco;
    private Condutor condutor;
    private Seguro seguro;

    public Sinistro(Date data, String endereco, Condutor condutor, Seguro seguro) {
        this.id = GeracaoId.gerarId();
        this.data = data;
        this.endereco = endereco;
        this.condutor = condutor;
        this.seguro = seguro;
    }

    public String toString() {
        return String.format(
            "ID: %d\nData: %s\nEndereço: %s\nCondutor: %s\nSeguro: ID %s\n",
            this.id, this.data, this.endereco,
            this.condutor.getNome(), this.seguro.getId());
    }


    // Getters e setters

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }
    
}
