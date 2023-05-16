public enum MenuCadastrar {

    CADASTRAR_CLIENTE_PF(1),
    CADASTRAR_CLIENTE_PJ(2),
    CADASTRAR_VEICULO(3),
    CADASTRAR_SEGURADORA(4),
    VOLTAR(0);

    public final int operacao;

    MenuCadastrar(int operacao) {
        this.operacao = operacao;
    }
}
