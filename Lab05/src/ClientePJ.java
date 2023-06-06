import java.util.Date;
import java.util.ArrayList;

public class ClientePJ extends Cliente {

    private final String CNPJ;
    private Date dataFundacao;
    private int qtdFuncionarios;
    private ArrayList<Frota> listaFrotas;

    public ClientePJ(String nome, String telefone, String endereco,
            String email, String cNPJ, Date dataFundacao,
            int qtdFuncionarios, ArrayList<Frota> listaFrotas) {
        super(nome, telefone, endereco, email);
        CNPJ = cNPJ;
        this.dataFundacao = dataFundacao;
        this.qtdFuncionarios = qtdFuncionarios;  // Definir pelo número de condutores?
        this.listaFrotas = listaFrotas;
    }

    @Override
    public String toString() {
        String str = super.toString();
        str += String.format("CNPJ: %s\nData de Fundação: %s\n" +
            "Quantidade de Funcionários: %d\nLista de Frotas:\n",
            this.CNPJ, this.dataFundacao, this.qtdFuncionarios);

        int tamanhoLista = this.listaFrotas.size();
        for (int i = 0; i < tamanhoLista; i++) {
            str += listaFrotas.get(i).toString() + "\n";
        }

        return str;
    }


    public int calculaIdade() {

        Date dataAtual = new Date();
        double diferencaData = (dataAtual.getTime() - this.dataFundacao.getTime());

        return (int)(diferencaData/(3.154e+10));
    }


    public boolean adicionarFrota(Frota frota) {

        this.listaFrotas.add(frota);
        return true;
    }


    public int buscarFrota(String frotaCode) {

        int tamanhoLista = this.listaFrotas.size();
        
        for (int i = 0; i < tamanhoLista; i++) {
            if (this.listaFrotas.get(i).getCode().equals(frotaCode)) {
                return i;
            }
        }
        
        return -1;
    }


    public boolean removerFrota(String frotaCode) {

        int pos = buscarFrota(frotaCode);

        if (pos >= 0) {
            this.listaFrotas.remove(pos);
            return true;
        }
        else {
            return false;
        }
    }


    public boolean removerVeiculoFrota(String frotaCode, String veiculoPlaca) {

        int pos = buscarFrota(frotaCode);

        if (pos >= 0) {

            ArrayList<Veiculo> listaveiculosFrota =
                this.listaFrotas.get(pos).getListaVeiculos();

            for (int i = 0; i < listaveiculosFrota.size(); i++) {
                if (listaveiculosFrota.get(i).getPlaca().equals(veiculoPlaca)) {
                    listaveiculosFrota.remove(i);
                    return true;
                }
            }
            return false;
        }
        return false;
    }


    public ArrayList<Veiculo> obterVeiculos(String frotaCode) {

        return listaFrotas.get(buscarFrota(frotaCode)).getListaVeiculos();
    }


    public String visualizarVeiculos(String frotaCode) {

        ArrayList<Veiculo> veiculosEncontrados = obterVeiculos(frotaCode);

        if (veiculosEncontrados.size() > 0) {
            String r = "";
            for (int i = 0; i < veiculosEncontrados.size() - 1; i++) {
                r += String.format("%s\n", veiculosEncontrados.get(i).toString());
            }
            r += veiculosEncontrados.get(veiculosEncontrados.size() - 1).toString();
            return r; 
        } else {
            return "ERROR: FROTA NÃO POSSUI VEÍCULOS OU NÃO ESTÁ NO SISTEMA\n";
        }
    }


    // Getters e setters

    public String getCNPJ() {
        return CNPJ;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public int getQtdFuncionarios() {
        return qtdFuncionarios;
    }

    public void setQtdFuncionarios(int qtdFuncionarios) {
        this.qtdFuncionarios = qtdFuncionarios;
    }

    public ArrayList<Frota> getListaFrotas() {
        return listaFrotas;
    }

    public void setListaFrotas(ArrayList<Frota> listaFrotas) {
        this.listaFrotas = listaFrotas;
    }

}
