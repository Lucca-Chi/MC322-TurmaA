package MC322.MC322TurmaA.Lab02.src;

public class Cliente {

    private String nome;
    private String cpf;
    private String dataNascimento;
    private int idade;
    private String endereco;

    public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.endereco = endereco;
    }

    public String toString() {
        return String.format(
            "Nome: %s\nCPF: %s\nData de Nascimento: %s\nIdade: %d\nEndereço: %s\n", 
            this.nome, this.cpf, this.dataNascimento, this.idade, this.endereco);
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
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
