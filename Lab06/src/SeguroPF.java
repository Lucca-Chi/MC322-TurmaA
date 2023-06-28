import java.util.ArrayList;
import java.util.Date;

public class SeguroPF extends Seguro {

    private Veiculo veiculo;
    private ClientePF cliente;

    public SeguroPF(Date dataInicio, Date dataFim, Seguradora seguradora,
            ArrayList<Sinistro> listaSinistros, ArrayList<Condutor> listaCondutores,
            Veiculo veiculo, ClientePF cliente) {
        super(dataInicio, dataFim, seguradora, listaSinistros, listaCondutores);
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        String str = super.toString();
        str += String.format("\nCliente: %s - CPF %s\nVeículo: %s - Placa %s",
            this.cliente.getNome(), this.cliente.getCPF(),
            this.veiculo.getModelo(), this.veiculo.getPlaca());
        return str;
    }


    public double calcularValor() {

        int idade = this.cliente.calculaIdade();

        double fatorIdade = 1.0;

        if (idade <= 30) {
            fatorIdade = CalcSeguro.FATOR_18_30.valor;
        }
        else if (idade > 30 && idade <= 60) {
            fatorIdade = CalcSeguro.FATOR_30_60.valor;
        }
        else if (idade > 60) {
            fatorIdade = CalcSeguro.FATOR_60_90.valor;
        }

        int qtdVeiculos = this.cliente.getListaVeiculos().size();
        int qtdSinistrosCliente = this.getSeguradora().obterSinistros(this.cliente).size();
        int qtdSinistrosCondutor = 0;
        for (int i = 0; i < this.getListaCondutores().size(); i++) {
            qtdSinistrosCondutor += this.getListaCondutores().get(i).getListaSinistros().size();
        }

        double valor = CalcSeguro.VALOR_BASE.valor * fatorIdade *
            (1 + 1/(qtdVeiculos + 2)) *
            (2 + qtdSinistrosCliente / 10) *
            (5 + qtdSinistrosCondutor / 10);

        this.setValorMensal(valor);
        return valor;
    }


    // Getters e setters

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public ClientePF getCliente() {
        return cliente;
    }

    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }

}
