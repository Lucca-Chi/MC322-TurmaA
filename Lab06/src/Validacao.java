public class Validacao {
    
    public static boolean validarCPF(String cpf) {

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


    public static boolean validarCNPJ(String cnpj) {
    
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


    public static boolean validarNome(String nome) {

        String nomeModificado;

        // Caracteres alfabéticos
        nomeModificado = nome.replaceAll("[^A-Za-z ]", "");
        if (nomeModificado.length() == 0 || nomeModificado.length() != nome.length()) {
            return false;
        }
        
        return true;
    }
}
