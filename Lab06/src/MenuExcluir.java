public enum MenuExcluir {

    EXCLUIR_CLIENTE(1),
    EXCLUIR_VEICULO(2),
    EXCLUIR_SINISTRO(3),
    VOLTAR(0);

    public final int operacao;

    MenuExcluir(int operacao) {
        this.operacao = operacao;
    }
}
