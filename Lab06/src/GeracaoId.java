import java.util.Random;

public class GeracaoId {

    public static int gerarId() {

        Random rand = new Random();
        int randomId = rand.nextInt(999999);

        return randomId;
    }
    
}
