package br.pm.businessLLM;
public class Livro {
    private String nomeLivro;
    private String nomeAutor;
    private int numPaginas;
    private int idLivro;
    private String nomeEditora;
    private String idioma;
    private boolean status; // true = disponível, false = emprestado
    private double valor;

    // Construtor
    public Livro(String nomeLivro, String nomeAutor, int numPaginas, int idLivro, 
                 String nomeEditora, String idioma, double valor) {
        this.nomeLivro = nomeLivro;
        this.nomeAutor = nomeAutor;
        this.numPaginas = numPaginas;
        this.idLivro = idLivro;
        this.nomeEditora = nomeEditora;
        this.idioma = idioma;
        this.status = true; // Inicialmente disponível
        this.valor = valor;
    }

    // Getters e Setters
    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    // Método para emprestar o livro
    public void emprestar() {
        if (status) {
            this.status = false; // Define como emprestado
            System.out.println("Livro emprestado com sucesso.");
        } else {
            throw new IllegalStateException("Erro: O livro já está emprestado.");
        }
    }

    // Método para devolver o livro
    public void devolver() {
        if (!status) {
            this.status = true; // Define como disponível
            System.out.println("Livro devolvido com sucesso.");
        } else {
            throw new IllegalStateException("Erro: O livro já está na biblioteca.");
        }
    }
}
