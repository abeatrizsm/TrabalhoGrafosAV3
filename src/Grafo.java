import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Grafo {
    int vertices;
    int arestas;
    ArrayList<Integer>[] lista;
    int grau[];

    public Grafo(String grafo) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(grafo));

        vertices = Integer.parseInt(br.readLine());
        arestas = Integer.parseInt(br.readLine());
        grau = new int[vertices];

        lista = new ArrayList[vertices];

        for (int i = 0; i < vertices; i++) {
            lista[i] = new ArrayList<>();
        }

        String linha;

        while ((linha = br.readLine()) != null) {
            String[] p = linha.split(" ");

            int v1 = Integer.parseInt(p[0]);
            int v2 = Integer.parseInt(p[1]);


            lista[v1].add(v2);
            lista[v2].add(v1);

            grau[v1]++;
            grau[v2]++;
        }
    }

    public void imprimirLista() {
        System.out.println("Lista de adjacencia completa  ");

        for (int i = 0; i < vertices; i++) {

            System.out.print(" " + i + " = ");

            for (int j = 0; j < lista[i].size(); j++) {
                System.out.print(lista[i].get(j) + " ");
            }

            System.out.println();
        }
    }

    public void imprimirGrau(){
        System.out.println("Grau dos vertices  ");
        for (int i = 0; i < vertices; i++) {
            System.out.println(" O grau do vertice " + (i+1) + " é: " + grau[i]);
        }
    }

    public void maisInfluente(){
        int maior = 0;;
        int aux = 0;

        for (int i = 0; i < vertices; i++) {
            if (grau[i]>maior){
                maior = grau[i];
                aux = i;
            }
        }
        System.out.print("- usuario(s) com maior potencial de disseminacao: " );
        for (int i = 0; i < vertices; i++) {
            if (grau[i] == maior){
                System.out.print(i + " ");
//                    for (int j = 0; j < lista[i].size(); j++) {
//                        System.out.print(lista[i].get(j) + " ");
//                    } + " = ["
//                    System.out.println("]");
            }
        }
        System.out.println();
        System.out.println("    * Numero de conexões: " + maior);
    }

    public void menosInfluente() {
        int menor = grau[0];
        int aux = 0;

        for (int i = 0; i < vertices; i++) {
            if (grau[i] < menor) {
                menor = grau[i];
            }
        }
        System.out.print("- Usuário(s) com menor potencial de propagação: " );
        for (int i = 0; i < vertices; i++) {
            if (grau[i] == menor){
                System.out.print(i + " ");
            }
        }
        System.out.println();
        System.out.println("    * Numero de conexões: " + menor);
    }

    public void usuariosIsolados() {
        int qtd = 0;
        System.out.print("- Usuarios isolados:");

        for (int i = 0; i < vertices; i++) {
            if (grau[i] == 0) {
                System.out.print(i);
                qtd++;
            }
        }
        if (qtd == 0){
            System.out.println(" nenhum usuário é isolado na rede, todos podem ser acessados a partir de outro usuário");
        }
        else {
            System.out.println("    * Quantidade: " + qtd);

        }

    }

    public void mediaConexoes() {
        int soma = 0;
        for (int i = 0; i < vertices; i++) {
            soma += grau[i];
        }

        double media = (double) soma / vertices;
        System.out.println("- Media de conexoes: " + media);
    }

    public void frequenciaGraus() {
        int maior = 0;

        for (int i = 0; i < vertices; i++) {
            if (grau[i] > maior) {
                maior = grau[i];
            }
        }
        int frequencia[] = new int[maior + 1];

        for (int i = 0; i < vertices; i++) {
            frequencia[grau[i]]++;
        }
        System.out.println("- Frequencia dos graus:");

        for (int i = 0; i < frequencia.length; i++) {
            if (frequencia[i] > 0) {
                System.out.println("    * Usuarios com " + i + " conexoes: " + frequencia[i]);
            }
        }
        System.out.println("");
    }
}

