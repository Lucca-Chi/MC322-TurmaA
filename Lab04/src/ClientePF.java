import java.util.Date;
import java.util.ArrayList;

public class ClientePF extends Cliente {

    private final String CPF;
    private String genero;
    private Date dataLicenca;
    private String educacao;
    private Date dataNascimento;
    private String classeEconomica;

    public ClientePF(String nome, String endereco, ArrayList<Veiculo> listaVeiculos, 
            String CPF, String genero, Date dataLicenca, String educacao,
            Date dataNascimento, String classeEconomica) {
        super(nome, endereco, listaVeiculos);
        this.CPF = CPF;
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;
    }

    @Override
    public String toString() {
        String str = super.toString();
        str += String.format("CPF: %s\nGênero: %s\nData de Licença: %s\nEducação: %s\n" +
            "Data de Nascimento: %s\nClasse Econômica: %s\n", this.CPF, this.genero,
            this.dataLicenca, this.educacao, this.dataNascimento, this.classeEconomica);
        return str;
    }


    public int calculaIdade() {

        Date dataAtual = new Date();
        double diferencaData = (dataAtual.getTime() - this.dataNascimento.getTime());

        return (int)(diferencaData/(3.154e+10));
    }

    public double calculaScore() {

        int idade = this.calculaIdade();

        double fatorIdade = 1.0;

        if (idade <= 30) {
            fatorIdade = CalcSeguro.FATOR_18_30.valor;
        }
        else if (idade > 30 && idade <= 60) {
            fatorIdade = CalcSeguro.FATOR_30_60.valor;
        }
        else if (idade > 60) {
            fatorIdade = CalcSeguro.FATOR_60_90.valor;
        }

        return CalcSeguro.VALOR_BASE.valor * fatorIdade * this.getListaVeiculos().size();
    }


    // Getters e setters

    public String getCPF() {
        return CPF;
    }

    public String getGenero() {
        return genero;
    }

    public Date getDataLicenca() {
        return dataLicenca;
    }

    public String getEducacao() {
        return educacao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDataLicenca(Date dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }
    
}
