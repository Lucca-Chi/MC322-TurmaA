import java.util.Date;
import java.util.ArrayList;

public class Condutor {

    private final String CPF;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private Date dataNascimento;
    private ArrayList<Sinistro> listaSinistros;

    public Condutor(String cPF, String nome, String telefone, String endereco,
            String email, Date dataNascimento, ArrayList<Sinistro> listaSinistros) {
        CPF = cPF;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.listaSinistros = listaSinistros;
    }

    @Override
    public String toString() {

        String str = String.format("CPF: %s\nNome: %s\nTelefone: %s\nEndereço: %s\n" +
        "E-mail: %s\nData de Nascimento: %s\nLista de Sinistros: ", this.CPF,
        this.nome, this.telefone, this.endereco, this.email, this.dataNascimento);

        int tamanhoLista = listaSinistros.size();
        for (int i = 0; i < tamanhoLista - 1; i++) {
            str += String.format("ID %d, ", listaSinistros.get(i).getId());
        }
        str += String.format("ID %d", listaSinistros.get(tamanhoLista - 1).getId());

        return str;
    }


    public boolean adicionarSinistro(Sinistro sinistro) {

        this.listaSinistros.add(sinistro);
        sinistro.getSeguro().gerarSinistro(sinistro);

        return true;
    }


    public String getCPF() {
        return CPF;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

}
