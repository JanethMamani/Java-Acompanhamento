import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        while(true){
            int leitor = System.in.read();
            System.out.println("Input" + leitor);
            if(filtro(leitor)){
                processar(leitor);
            }
        }
    }

    private static boolean filtro(int leitor){
        return leitor != '\n' && leitor != 'a';
    }

    private static void processar(int arg){
        if(Math.max(arg, 98) %2 == 0){
            System.out.println("!");
        }
    }
}
