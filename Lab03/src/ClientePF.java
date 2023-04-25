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


    public boolean validarCPF(String cpf) {

        String cpfModificado;

        // Tamanho do CPF
        if (cpf.length() != 11) {
            return false;
        }

        // Caracteres numéricos
        cpfModificado = cpf.replaceAll("[^0-9]", "");
        if (cpfModificado.length() != 11) {
            return false;
        }

        // Sequência não completamente repetida
        cpfModificado = cpf.replaceAll(String.valueOf(cpf.charAt(0)), "");
        if (cpfModificado.length() == 0) {
            return false;
        }

        // Dígitos verificadores
        for(int i = 0; i < 2; i++) {

            int x, soma = 0, j = 10;
            for(int k = i; k < 9 + i; k++, j--) {
                x = Integer.parseInt(String.valueOf(cpf.charAt(k)));
                soma += x * j;
            }

            int resto = soma % 11;
            if (resto == 0 || resto == 1) {
                if (Integer.parseInt(String.valueOf(cpf.charAt(9 + i))) != 0) {
                    return false;
                }
            } 
            else {
                if (Integer.parseInt(String.valueOf(cpf.charAt(9 + i))) != 11 - resto) {
                    return false;
                }
            }
        }
    
        return true;
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
