# Análise de Rede Social Utilizando Grafos e BFS

> Projeto desenvolvido para a disciplina de Teoria dos Grafos utilizando uma rede social real do Facebook para análise de conectividade, influência, distância social e propagação de informações através do algoritmo Breadth-First Search (BFS).

O projeto utiliza uma base de dados disponibilizada pelo SNAP (Stanford Network Analysis Project), modelando os usuários como vértices e as amizades como arestas de um grafo não direcionado.

---

# Pré-requisitos

Antes de executar o projeto, é necessário possuir:

* Java JDK 8 ou superior
* Git (opcional)
* IDE Java (IntelliJ, Eclipse ou VSCode) ou terminal

Verifique se o Java está instalado:

```bash
java -version
```

Verifique se o compilador está disponível:

```bash
javac -version
```

---

# Estrutura do Projeto

O projeto é composto pelos seguintes arquivos:

```text
Projeto/
│
└── src/
    ├── facebook_combined.txt
    ├── Main.java
    ├── Grafo.java
    └── BFS.java
```

### Main.java

Responsável por executar todas as análises implementadas.

### Grafo.java

Responsável pela leitura da base de dados e pelas análises estruturais da rede:

* usuário mais influente;
* usuário menos influente;
* média de conexões;
* usuários isolados;
* frequência dos graus.

### BFS.java

Implementa o algoritmo Breadth-First Search (BFS) e suas aplicações:

* caminhos mínimos;
* distância social;
* propagação de informações;
* conectividade global;
* diâmetro da rede.

### facebook_combined.txt

Base de dados da rede social utilizada no projeto.

---

# Instalação do Projeto

## 1. Obter os arquivos do projeto

Faça o download dos arquivos do projeto e extraia seu conteúdo para uma pasta de sua preferência.

Caso esteja utilizando o GitHub, também é possível clonar o repositório:

```bash
git clone https://github.com/abeatrizsm/TrabalhoGrafosAV3
```
Entre na pasta do projeto:

```bash
cd nome-do-projeto
```

Depois execute a classe Main

Se tudo estiver correto, os resultados das análises serão exibidos diretamente no terminal.

---

# Análises Realizadas

O sistema executa automaticamente:

### Análise Estrutural

* usuário com maior potencial de disseminação;
* usuário com menor potencial de disseminação;
* média de conexões da rede;
* identificação de usuários isolados;
* frequência dos graus.

### Análises com BFS

* caminhos mínimos entre usuários;
* cálculo de distância social;
* propagação de informações em diferentes níveis;
* conectividade global da rede;
* cálculo do diâmetro da rede.

---

# Observação

O método:

```java
grafo.frequenciaGraus();
```

gera uma saída bastante extensa no terminal, pois exibe a frequência de todos os graus encontrados na rede.

Recomenda-se executá-lo inicialmente para visualizar essa análise e, posteriormente, comentar a linha correspondente no arquivo `Main.java`:

```java
// grafo.frequenciaGraus();
```

Isso torna a visualização das demais análises muito mais organizada e facilita a leitura dos resultados.

---

