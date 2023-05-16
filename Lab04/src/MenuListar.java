public enum MenuListar {

    LISTAR_CLIENTES_POR_SEGURADORA(1),
    LISTAR_SINISTROS_POR_SEGURADORA(2),
    LISTAR_SINISTROS_POR_CLIENTE(3),
    LISTAR_VEICULOS_POR_SEGURADORA(4),
    LISTAR_VEICULOS_POR_CLIENTE(5),
    VOLTAR(0);

    public final int operacao;

    MenuListar(int operacao) {
        this.operacao = operacao;
    }
}
