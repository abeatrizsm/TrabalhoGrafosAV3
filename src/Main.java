import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Grafo grafo = new Grafo("src/facebook_combined.txt");
        BFS bfs = new BFS();

        System.out.println("--------- Análise geral ---------");
        grafo.maisInfluente();
        grafo.menosInfluente();
        grafo.mediaConexoes();
        grafo.usuariosIsolados();
        grafo.frequenciaGraus();
        bfs.diametro();

        System.out.println("--------- Bfs ---------");
        bfs.bfs(11, 107);
        bfs.bfs(11, 12);
        bfs.bfs(11, 4008);
        bfs.bfs(11, 4000);
        bfs.bfs(107, 4000);

        System.out.println("--------- Propagação na rede ---------");
        bfs.propagacao(0, 8);
        bfs.propagacao(11, 8);
        bfs.propagacao(100, 8);
        bfs.propagacao(107, 8);

        System.out.println("--------- Conectovidade da rede ---------");
        bfs.conectividadeTotal();

    }

}