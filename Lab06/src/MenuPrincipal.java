public enum MenuPrincipal {

    CADASTRAR(1),
    LISTAR(2),
    EXCLUIR(3),
    GERAR_SINISTRO(4),
    CALCULAR_RECEITA(5),
    TROCAR_SEGURADORA(6),
    SAIR(0);

    public final int operacao;

    MenuPrincipal(int operacao) {
        this.operacao = operacao;
    }
}
