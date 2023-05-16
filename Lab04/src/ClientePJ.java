import java.util.Date;
import java.util.ArrayList;

public class ClientePJ extends Cliente {

    private final String CNPJ;
    private Date dataFundacao;
    private int qtdFuncionarios;

    public ClientePJ(String nome, String endereco, ArrayList<Veiculo> listaVeiculos,
            String CNPJ, Date dataFundacao, int qtdFuncionarios) {
        super(nome, endereco, listaVeiculos);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
        this.qtdFuncionarios = qtdFuncionarios;
    }

    @Override
    public String toString() {
        String str = super.toString();
        str += String.format("CNPJ: %s\nData de Fundação: %s\n", this.CNPJ, this.dataFundacao);
        return str;
    }


    public double calculaScore() {

        return CalcSeguro.VALOR_BASE.valor *
        (1 + (this.qtdFuncionarios)/100) * this.getListaVeiculos().size();
    }

    
    // Getters e setters

    public String getCNPJ() {
        return CNPJ;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public int getQtdFuncionarios() {
        return qtdFuncionarios;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public void setQtdFuncionarios(int qtdFuncionarios) {
        this.qtdFuncionarios = qtdFuncionarios;
    }
    
}
