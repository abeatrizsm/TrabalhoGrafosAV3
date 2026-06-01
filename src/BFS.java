import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    Grafo grafo;

    public BFS() throws IOException {
        grafo = new Grafo("src/facebook_combined.txt");
    }

    private int[] reconstruirCaminho(int anterior[], int destino) {
        int caminho[] = new int[grafo.vertices];
        int tam = 0;
        int v = destino;

        while (v != -1) {
            caminho[tam] = v;
            tam++;
            v = anterior[v];
        }

        int resultado[] = new int[tam];
        int aux = 0;

        for (int i = tam - 1; i >= 0; i--) {
            resultado[aux] = caminho[i];
            aux++;
        }
        return resultado;
    }

    private void imprimirCaminho(int caminho[]) {
        System.out.print("Caminho: ");
        for (int i = 0; i < caminho.length; i++) {
            System.out.print(caminho[i]);

            if (i < caminho.length - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println("");
    }

    public void bfs(int origem, int destino) {
        boolean visitado[] = new boolean[grafo.vertices];
        int anterior[] = new int[grafo.vertices];
        int distancia[] = new int[grafo.vertices];
        Queue<Integer> fila = new LinkedList<>();

        for (int i = 0; i < grafo.vertices; i++) {
            anterior[i] = -1;
        }
        fila.add(origem);
        visitado[origem] = true;
        distancia[origem] = 0;

        while (!fila.isEmpty()) {
            int atual = fila.poll();
            if (atual == destino) {
                break;
            }

            for (int i = 0; i < grafo.lista[atual].size(); i++) {
                int vizinho = grafo.lista[atual].get(i);
                if (!visitado[vizinho]) {
                    fila.add(vizinho);
                    visitado[vizinho] = true;
                    anterior[vizinho] = atual;
                    distancia[vizinho] = distancia[atual] + 1;
                }
            }
        }

        if (!visitado[destino]) {
            System.out.println("Nao existe caminho.");
            return;
        }

        int caminho[] = reconstruirCaminho(anterior, destino);
        imprimirCaminho(caminho);
        System.out.println("Distancia social: " + distancia[destino]);
        System.out.println("");
    }

    public void propagacao(int origem, int limite) {
        boolean visitado[] = new boolean[grafo.vertices];
        int distancia[] = new int[grafo.vertices];
        Queue<Integer> fila = new LinkedList<>();

        fila.add(origem);
        visitado[origem] = true;
        distancia[origem] = 0;

        while (!fila.isEmpty()) {
            int atual = fila.poll();

            for (int i = 0; i < grafo.lista[atual].size(); i++) {
                int vizinho = grafo.lista[atual].get(i);

                if (!visitado[vizinho]) {
                    fila.add(vizinho);
                    visitado[vizinho] = true;
                    distancia[vizinho] = distancia[atual] + 1;
                }
            }
        }
        int niveis[] = new int[limite + 1];

        for (int i = 0; i < grafo.vertices; i++) {
            if (visitado[i]) {
                if (distancia[i] <= limite) {
                    niveis[distancia[i]]++;
                }
            }
        }

        System.out.println("Propagacao da informacao do vertice: " + origem);
        System.out.println("");

        for (int i = 0; i <= limite; i++) {
            System.out.println("Nivel " + i + " = " + niveis[i] + " usuarios");
        }

        System.out.println("");
    }

    public void conectividadeTotal() {

        int conectados = 0;

        for (int origem = 0; origem < grafo.vertices; origem++) {
            boolean visitado[] = new boolean[grafo.vertices];
            Queue<Integer> fila = new LinkedList<>();
            fila.add(origem);
            visitado[origem] = true;

            while (!fila.isEmpty()) {
                int atual = fila.poll();

                for (int i = 0; i < grafo.lista[atual].size(); i++) {
                    int vizinho = grafo.lista[atual].get(i);

                    if (!visitado[vizinho]) {
                        fila.add(vizinho);
                        visitado[vizinho] = true;
                    }
                }
            }
            int total = 0;

            for (int i = 0; i < grafo.vertices; i++) {
                if (visitado[i]) {
                    total++;
                }
            }
            if (total == grafo.vertices) {
                conectados++;
            }
        }

        double percentual =((double) conectados / grafo.vertices) * 100;

        System.out.println("Vertices que alcancam toda a rede: " + conectados);
        System.out.println("Total de vertices: " + grafo.vertices);
        System.out.println("Conectividade global: " + percentual + "%");

        if (conectados == grafo.vertices) {
            System.out.println("A rede e totalmente conectada.");

        } else {
            System.out.println("A rede possui componentes desconectados.");
        }
        System.out.println("");
    }
    public void diametro() {
        int maiorDistancia = 0;

        for (int origem = 0; origem < grafo.vertices; origem++) {
            boolean visitado[] = new boolean[grafo.vertices];
            int distancia[] = new int[grafo.vertices];
            Queue<Integer> fila = new LinkedList<>();

            fila.add(origem);
            visitado[origem] = true;

            while (!fila.isEmpty()) {
                int atual = fila.poll();

                for (int i = 0; i < grafo.lista[atual].size(); i++) {
                    int vizinho = grafo.lista[atual].get(i);
                    if (!visitado[vizinho]) {
                        fila.add(vizinho);
                        visitado[vizinho] = true;
                        distancia[vizinho] = distancia[atual] + 1;
                    }
                }
            }

            for (int i = 0; i < grafo.vertices; i++) {
                if (distancia[i] > maiorDistancia) {
                    maiorDistancia = distancia[i];
                }
            }
        }
        System.out.println("Diametro da rede: " + maiorDistancia);
    }
}