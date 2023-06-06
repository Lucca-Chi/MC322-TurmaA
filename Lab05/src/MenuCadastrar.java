public enum MenuCadastrar {

    CADASTRAR_CLIENTE_PF(1),
    CADASTRAR_CLIENTE_PJ(2),
    CADASTRAR_VEICULO(3),
    CADASTRAR_SEGURO_PF(4),
    CADASTRAR_SEGURO_PJ(5),
    CADASTRAR_SEGURADORA(6),
    VOLTAR(0);

    public final int operacao;

    MenuCadastrar(int operacao) {
        this.operacao = operacao;
    }
}
