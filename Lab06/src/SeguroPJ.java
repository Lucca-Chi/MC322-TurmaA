import java.util.ArrayList;
import java.util.Date;

public class SeguroPJ extends Seguro {

    private Frota frota;
    private ClientePJ cliente;

    public SeguroPJ(Date dataInicio, Date dataFim, Seguradora seguradora,
            ArrayList<Sinistro> listaSinistros, ArrayList<Condutor> listaCondutores,
            Frota frota, ClientePJ cliente) {
        super(dataInicio, dataFim, seguradora, listaSinistros, listaCondutores);
        this.frota = frota;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        String str = super.toString();
        str += String.format("\nCliente: %s - CNPJ %s\n",
            this.cliente.getNome(), this.cliente.getCNPJ());
        str += this.frota.toString();

        return str;
    }


    public double calcularValor() {

        int qtdFuncionarios = this.cliente.getQtdFuncionarios();
        int qtdVeiculos = this.frota.getListaVeiculos().size();  // Só os veículos da frota do seguro
        int anosPosFundacao = this.cliente.calculaIdade();
        int qtdSinistrosCliente = this.getSeguradora().obterSinistros(this.cliente).size();
        int qtdSinistrosCondutor = 0;
        for (int i = 0; i < this.getListaCondutores().size(); i++) {
            qtdSinistrosCondutor += this.getListaCondutores().get(i).getListaSinistros().size();
        }

        double valor = CalcSeguro.VALOR_BASE.valor *
            (10 + qtdFuncionarios / 10) *
            (1 + 1 / (qtdVeiculos + 2)) *
            (1 + 1 / (anosPosFundacao + 2)) *
            (2 + qtdSinistrosCliente / 10) *
            (5 + qtdSinistrosCondutor / 10);

        this.setValorMensal(valor);
        return valor;
    }


    // Getters e setters

    public Frota getFrota() {
        return frota;
    }

    public void setFrota(Frota frota) {
        this.frota = frota;
    }

    public ClientePJ getCliente() {
        return cliente;
    }

    public void setCliente(ClientePJ cliente) {
        this.cliente = cliente;
    }

}
