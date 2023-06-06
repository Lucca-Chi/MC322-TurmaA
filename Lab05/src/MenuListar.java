public enum MenuListar {

    LISTAR_CLIENTES_POR_SEGURADORA(1),
    LISTAR_SEGUROS_POR_CLIENTE(2),
    LISTAR_SINISTROS_POR_SEGURADORA(3),
    LISTAR_SINISTROS_POR_CLIENTE(4),
    LISTAR_VEICULOS_POR_SEGURADORA(5),
    LISTAR_VEICULOS_POR_CLIENTE(6),
    VOLTAR(0);

    public final int operacao;

    MenuListar(int operacao) {
        this.operacao = operacao;
    }
}
