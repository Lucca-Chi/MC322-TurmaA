package MC322.MC322TurmaA.Lab02.src;

import java.util.Random;

public class Sinistro {

    private int id;
    private String data;
    private String endereco;

    public Sinistro(String data, String endereco) {
        this.id = gerarId();
        this.data = data;
        this.endereco = endereco;
    }

    // Fazer um N que aumenta a cada novo sinistro
    private int gerarId() {
        Random rand = new Random();
        int randomId = rand.nextInt(999999);

        return randomId;
    }


    // Getters e setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
