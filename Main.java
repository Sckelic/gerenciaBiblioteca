import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Biblioteca biblio = new Biblioteca();
    static Scanner input = new Scanner(System.in);

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static int inputNumerico(String mensagem) {
        int valor = 0;
        boolean entradaValida = false;
        System.out.println(mensagem);
        do {
            String valorStr = input.nextLine();
            try {
                valor = Integer.parseInt(valorStr);
                entradaValida = true;
            } catch (Exception e) {
                System.out.println("Erro! informe um numero interio!");
            }
        } while (!entradaValida);
        return valor;

    }

    private static void listar() {
        // List<Livro> livros = biblio.pesquisarTodos();
        var livros = biblio.pesquisarTodos();
        livros.sort(Comparator.comparing(Livro::getTitulo));
        System.out.println("======== LISTA DE LIVROS =========");
        for (Livro livro : livros) {
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Ano: " + livro.getAnoPublicacao());
            System.out.println("N. Páginas: " + livro.getnPaginas());
        }
    }

    private static void adicionar() {
        Livro novoLivro = new Livro();
        System.out.println("======== ADICIONANDO NOVO LIVRO ========");
        System.out.print("Informe o título do livro: ");
        String titulo = input.nextLine();
        novoLivro.setTitulo(titulo);

        System.out.print("Informe o nome do autor: ");
        novoLivro.setAutor(input.nextLine());

        System.out.print("Informe o ano de publicação: ");
        novoLivro.setAnoPublicacao(input.nextInt());
        input.nextLine(); // buffer

        System.out.print("Informe o número de páginas: ");
        novoLivro.setnPaginas(input.nextInt());
        input.nextLine(); // buffer

        try {
            biblio.adicionar(novoLivro);
            System.out.println("Livro adicionado com Sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        input.nextLine(); // espera o usuário dar um enter para continuar
    }

    public static void main(String[] args) {
        clear();
        String menu = 
            """
                SISTEMA DE GERENCIAMENTO DE BIBLIOTECA
                Escolha uma das opções:
                1 - Adicionar novo livro;
                2 - Listar todos os livros;
                3 - Pesquisar livro;
                4 - Remover livro;
                0 - Sair;
            """;
        int opcao;
        do {
            // System.out.println(menu);
            // opcao = input.nextInt();
            // input.nextLine(); // limpar buffer
            opcao = inputNumerico(menu);
            switch (opcao) {
                case 0:
                    clear();
                    System.out.println("VOLTE SEMPRE!!!");
                    break;
                case 1:
                    clear();
                    adicionar();
                    break;
                case 2:
                    clear();
                    listar();
                    break;
                case 3:
                    // pesquisar por titulo
                    break;
                case 4:
                    // remover
                    break;
                default:
                    System.out.println("Opção Inválida!!!");
                    input.nextLine();
                    break;
            }
        } while (opcao != 0);
    }
}