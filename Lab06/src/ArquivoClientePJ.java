import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArquivoClientePJ implements Interface {

    @Override
    public boolean gravarArquivo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gravarArquivo'");
    }

    @Override
    public ArrayList<String> lerArquivo() {

        ArrayList<String> elementosArquivo = new ArrayList<String>();
        try {

            Scanner sc = new Scanner(new File("src/arquivos/clientesPJ.csv"));
            sc.useDelimiter(",|\n");
            while (sc.hasNext()) {  
                elementosArquivo.add(sc.next());
            }   
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return elementosArquivo;
    }   
}
