import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    //BD em memória
    private List<Livro> acervo = new ArrayList<>();

    public void adicionar(Livro livro) throws Exception{
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty())
            throw new Exception("Nao e permitido cadastrar livro sem titulo");
        if (livro.getAutor() == null || livro.getAutor().isEmpty())
            throw new Exception("Nao e possivel cadastrar um livro sem aultor");
        if (livro.getAnoPublicacao() <= 1400 && livro.getAnoPublicacao() > LocalDate.now().getYear())
            throw new Exception("Nao e um ano de publicacao valido");
        if (livro.getnPaginas() <= 0)
            throw new Exception("nao e possivel cadastrar um livro com menos ou igual a 0 paginas");
        for (Livro livroAcervo : acervo) {
            if (livroAcervo.getTitulo().equalsIgnoreCase(livro.getTitulo()));
                throw new Exception("Ja existe livro cadastrado com este titulo");
        }
        acervo.add(livro);
    }

    public List <Livro> pesquisarPorTitulo(String titulo){
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                livrosEncontrados.add(livro);
            }
        }
        return null;
    }

    public void removerPorTitulo(String titulo){
        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)){
                acervo.remove(livro);
                System.out.println("Livro removido com sucesso");
                break;
            }
            
        }
        
    }

    public List<Livro> pesquisarTodos(){
        return this.acervo;
    }
    
}