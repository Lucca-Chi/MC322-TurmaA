import java.util.Date;
import java.util.ArrayList;

public class ClientePF extends Cliente {

    private final String CPF;
    private String genero;
    private String educacao;
    private Date dataNascimento;
    private ArrayList<Veiculo> listaVeiculos;

    
    public ClientePF(String nome, String telefone, String endereco, String email,
            String cPF, String genero, String educacao, Date dataNascimento,
            ArrayList<Veiculo> listaVeiculos) {
        super(nome, telefone, endereco, email);
        CPF = cPF;
        this.genero = genero;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.listaVeiculos = listaVeiculos;
    }

    @Override
    public String toString() {
        String str = super.toString();
        str += String.format("CPF: %s\nGênero: %s\nEducação: %s\n" +
            "Data de Nascimento: %s\nLista de Veículos: ", 
            this.CPF, this.genero, this.educacao, this.dataNascimento);

        int tamanhoLista = listaVeiculos.size();
        for (int i = 0; i < tamanhoLista - 1; i++) {
            str += String.format("%s - Placa %s, ", 
                listaVeiculos.get(i).getModelo(), listaVeiculos.get(i).getPlaca());
        }
        str += String.format("%s - Placa %s\n", 
            listaVeiculos.get(tamanhoLista - 1).getModelo(),
            listaVeiculos.get(tamanhoLista - 1).getPlaca());

        return str;
    }


    public int calculaIdade() {

        Date dataAtual = new Date();
        double diferencaData = (dataAtual.getTime() - this.dataNascimento.getTime());

        return (int)(diferencaData/(3.154e+10));
    }


    public boolean adicionarVeiculo(Veiculo veiculo) {

        this.listaVeiculos.add(veiculo);
        return true;
    }


    public int buscarVeiculo(String veiculoPlaca) {

        int tamanhoLista = this.listaVeiculos.size();
        
        for (int i = 0; i < tamanhoLista; i++) {
            if (this.listaVeiculos.get(i).getPlaca().equals(veiculoPlaca)) {
                return i;
            }
        }
        
        return -1;
    }


    public boolean removerVeiculo(String veiculoPlaca) {

        int pos = buscarVeiculo(veiculoPlaca);

        if (pos >= 0) {
            this.listaVeiculos.remove(pos);
            return true;
        }
        else {
            return false;
        }
    }


    // Getters e setters

    public String getCPF() {
        return CPF;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

}
