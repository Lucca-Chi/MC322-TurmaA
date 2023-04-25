import java.util.Date;
import java.util.ArrayList;

public class ClientePJ extends Cliente {

    private final String CNPJ;
    private Date dataFundacao;

    public ClientePJ(String nome, String endereco, ArrayList<Veiculo> listaVeiculos,
            String CNPJ, Date dataFundacao) {
        super(nome, endereco, listaVeiculos);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
    }

    @Override
    public String toString() {
        String str = super.toString();
        str += String.format("CNPJ: %s\nData de Fundação: %s\n", this.CNPJ, this.dataFundacao);
        return str;
    }


    public boolean validarCNPJ(String cnpj) {
    
        String cnpjModificado;

        // Tamanho do CNPJ
        if (cnpj.length() != 14) {
            return false;
        }

        // Caracteres numéricos
        cnpjModificado = cnpj.replaceAll("[^0-9]", "");
        if (cnpjModificado.length() != 14) {
            return false;
        }

        // Sequência não completamente repetida
        cnpjModificado = cnpj.replaceAll(String.valueOf(cnpj.charAt(0)), "");
        if (cnpjModificado.length() == 0) {
            return false;
        }

        // Dígitos verificadores
        for(int i = 0; i < 2; i++) {

            int x, soma = 0, j = 5 + i;
            for(int k = 0; k < 12 + i; k++, j--) {
                if (j < 2) {
                    j = 9;
                }
                x = Integer.parseInt(String.valueOf(cnpj.charAt(k)));
                soma += x * j;
            }

            int resto = soma % 11;
            if (resto < 2) {
                if (Integer.parseInt(String.valueOf(cnpj.charAt(12 + i))) != 0) {
                    return false;
                }
            } 
            else {
                if (Integer.parseInt(String.valueOf(cnpj.charAt(12 + i))) != 11 - resto) {
                    return false;
                }
            }
        }
    
        return true;
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
    
}
