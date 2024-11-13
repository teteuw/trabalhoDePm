package br.pm.businessLLM;
public class Livro {
    private String nomeLivro;
    private String nomeAutor;
    private int numPaginas;
    private Long idLivro; // Alterado de int para Long
    private String nomeEditora;
    private String idioma;
    private boolean status; // true = disponível, false = emprestado
    private double valor;

    // Construtor
    public Livro(String nomeLivro, String nomeAutor, int numPaginas, Long idLivro, 
                 String nomeEditora, String idioma, boolean status, double valor) {
        setNomeLivro(nomeLivro);
        setNomeAutor(nomeAutor);
        setNumPaginas(numPaginas);
        setIdLivro(idLivro);
        setNomeEditora(nomeEditora);
        setIdioma(idioma);
        setStatus(status);
        setValor(valor);
    }

    // Getters e Setters
    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        if (nomeLivro == null || nomeLivro.isBlank()) {
            throw new IllegalArgumentException("O nome do livro não pode ser vazio.");
        }
        this.nomeLivro = nomeLivro;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        if (nomeAutor == null || nomeAutor.isBlank()) {
            throw new IllegalArgumentException("O nome do autor não pode ser vazio.");
        }
        this.nomeAutor = nomeAutor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        if (numPaginas <= 0) {
            throw new IllegalArgumentException("O número de páginas deve ser maior que zero.");
        }
        this.numPaginas = numPaginas;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        if (idLivro == null || idLivro <= 0) {
            throw new IllegalArgumentException("O ID do livro deve ser válido e positivo.");
        }
        this.idLivro = idLivro;
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        if (nomeEditora == null || nomeEditora.isBlank()) {
            throw new IllegalArgumentException("O nome da editora não pode ser vazio.");
        }
        this.nomeEditora = nomeEditora;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        if (idioma == null || idioma.isBlank()) {
            throw new IllegalArgumentException("O idioma não pode ser vazio.");
        }
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
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do livro deve ser positivo.");
        }
        this.valor = valor;
    }

    // Método para emprestar o livro
    public void emprestar() {
        if (!status) {
            throw new IllegalStateException("Erro: O livro já está emprestado.");
        }
        setStatus(false); // Atualiza o status para emprestado
    }

    // Método para devolver o livro
    public void devolver() {
        if (status) {
            throw new IllegalStateException("Erro: O livro já está disponível na biblioteca.");
        }
        setStatus(true); // Atualiza o status para disponível
    }
}
