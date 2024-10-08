import java.util.ArrayList;
import java.util.List;

// Interface base para o Composite
interface Component {
    void display();
}

// Classe Leaf (folha) que representa um Livro
class Livro implements Component {
    private String titulo;
    private String autor;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    @Override
    public void display() {
        System.out.println("Livro: " + titulo + ", Autor: " + autor);
    }
}

// Classe Composite que representa uma Biblioteca
class Biblioteca implements Component {
    private String nome;
    private List<Component> componentes = new ArrayList<>();

    public Biblioteca(String nome) {
        this.nome = nome;
    }

    // Método para adicionar componentes
    public void add(Component component) {
        componentes.add(component);
    }

    // Método para remover componentes
    public void remove(Component component) {
        componentes.remove(component);
    }

    @Override
    public void display() {
        System.out.println("Biblioteca: " + nome);
        for (Component component : componentes) {
            component.display();
        }
    }
}

// Classe principal para testar o padrão Composite
public class CompositePatternExample {
    public static void main(String[] args) {
        // Cria alguns livros (folhas)
        Component livro1 = new Livro("1984", "George Orwell");
        Component livro2 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien");

        // Cria uma biblioteca (composite)
        Biblioteca biblioteca1 = new Biblioteca("Biblioteca Central");
        biblioteca1.add(livro1);
        biblioteca1.add(livro2);

        // Cria outra biblioteca (composite)
        Biblioteca biblioteca2 = new Biblioteca("Biblioteca Secundária");
        biblioteca2.add(new Livro("Dom Quixote", "Miguel de Cervantes"));
        biblioteca2.add(new Livro("A Revolução dos Bichos", "George Orwell"));

        // Biblioteca principal que contém outras bibliotecas
        Biblioteca bibliotecaPrincipal = new Biblioteca("Biblioteca Principal");
        bibliotecaPrincipal.add(biblioteca1);
        bibliotecaPrincipal.add(biblioteca2);

        // Exibe a estrutura da biblioteca
        System.out.println("Estrutura das Bibliotecas:");
        bibliotecaPrincipal.display();
    }
}
