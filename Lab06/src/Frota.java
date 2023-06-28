import java.util.ArrayList;

public class Frota {

    private String code;
    private ArrayList<Veiculo> listaVeiculos;

    public Frota(String code, ArrayList<Veiculo> listaVeiculos) {
        this.code = code;
        this.listaVeiculos = listaVeiculos;
    }

    @Override
    public String toString() {

        String str = String.format("Frota - Code: %s\nVeículos: ", this.code);

        int tamanhoLista = this.listaVeiculos.size();
        for (int i = 0; i < tamanhoLista - 1; i++) {
            str += String.format("%s - Placa %s, ",
                this.listaVeiculos.get(i).getMarca(),
                this.listaVeiculos.get(i).getPlaca());
        }
        str += String.format("%s - Placa %s",
            this.listaVeiculos.get(tamanhoLista - 1).getMarca(),
            this.listaVeiculos.get(tamanhoLista - 1).getPlaca());

        return str;
    }


    public boolean adicionarVeiculo(Veiculo veiculo) {

        this.listaVeiculos.add(veiculo);
        return true;
    }


    public int buscarVeiculo(String veiculoPlaca) {

        int tamanhoLista = this.listaVeiculos.size();
        
        for (int i = 0; i < tamanhoLista; i++) {
            if (this.listaVeiculos.get(i).getPlaca() == veiculoPlaca) {
                return i;
            }
        }
        
        return -1;
    }


    public boolean removerVeiculo(String veiculoPlaca) {

        int pos = buscarVeiculo(veiculoPlaca);

        if (pos >= 0) {
            this.listaVeiculos.remove(pos);
            return true;
        }
        else {
            return false;
        }
    }


    // Getters e setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }
    
}
