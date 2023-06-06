import java.util.ArrayList;
import java.util.Date;

public abstract class Seguro {

    private final int id;
    private Date dataInicio;
    private Date dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores;
    private double valorMensal;

    public Seguro(Date dataInicio, Date dataFim, Seguradora seguradora,
            ArrayList<Sinistro> listaSinistros, ArrayList<Condutor> listaCondutores) {
        this.id = GeracaoId.gerarId();
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = listaSinistros;
        this.listaCondutores = listaCondutores;
        this.valorMensal = 0.0;
    }

    @Override
    public String toString() {

        String str = String.format("ID: %d\nData de Início: %s\nData de Término: %s\n" +
        "Seguradora: %s\nValor Mensal do Seguro: R$%.2f\nLista de Sinistros: ",
        this.id, this.dataInicio, this.dataFim, this.seguradora.getNome(), this.valorMensal);

        int tamanhoLista = listaSinistros.size();

        if (tamanhoLista != 0) {

            for (int i = 0; i < tamanhoLista - 1; i++) {
                str += String.format("ID %d, ", listaSinistros.get(i).getId());
            }
            str += String.format("ID %d", listaSinistros.get(tamanhoLista - 1).getId());

            str += "\nLista de Condutores: ";

            tamanhoLista = listaCondutores.size();
            for (int i = 0; i < tamanhoLista - 1; i++) {
                str += String.format("%s, ", listaCondutores.get(i).getNome());
            }
            str += String.format("%s", listaCondutores.get(tamanhoLista - 1).getNome());
        }
        return str;
    }


    public boolean autorizarCondutor(Condutor condutor) {

        this.listaCondutores.add(condutor);

        int tamanhoLista = condutor.getListaSinistros().size();
        for (int i = 0; i < tamanhoLista; i++) {
            this.listaSinistros.add(condutor.getListaSinistros().get(i));
        }

        return true;
    }


    public int buscarCondutor(String condutorCadastro) {

        int tamanhoLista = this.listaCondutores.size();
        
        for (int i = 0; i < tamanhoLista; i++) {
            if (this.listaCondutores.get(i).getCPF() == condutorCadastro) {
                return i;
            }
        }
        
        return -1;
    }


    public boolean desautorizarCondutor(String condutorCadastro) {

        int pos = buscarCondutor(condutorCadastro);

        if (pos >= 0) {

            this.listaCondutores.remove(pos);
    
            for (int i = 0; i < this.listaSinistros.size(); i++) {
                if (listaSinistros.get(i).getCondutor().getCPF() == condutorCadastro) {
                    listaSinistros.remove(i);
                }
            }
            return true;
        }
        else {
            return false;
        }
    }

    public boolean gerarSinistro(Sinistro sinistro) {
        this.listaSinistros.add(sinistro);
        return true;
    }


    public abstract double calcularValor();


    public abstract Cliente getCliente();


    // Getters e setters

    public int getId() {
        return id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public ArrayList<Condutor> getListaCondutores() {
        return listaCondutores;
    }

    public void setListaCondutores(ArrayList<Condutor> listaCondutores) {
        this.listaCondutores = listaCondutores;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }
    
}
