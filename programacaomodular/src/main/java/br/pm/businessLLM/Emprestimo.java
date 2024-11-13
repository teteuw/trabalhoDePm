package br.pm.businessLLM;
import java.time.*;
import java.time.temporal.ChronoUnit;
public class Emprestimo implements CalculadoraMulta {
    private Long idEmprestimo;
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    // Construtor
    public Emprestimo(Long idEmprestimo, Livro livro, Usuario usuario, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        setIdEmprestimo(idEmprestimo);
        setLivro(livro);
        setUsuario(usuario);
        setDataEmprestimo(dataEmprestimo);
        setDataDevolucao(dataDevolucao);
    }

    // Getters e setters
    public Long getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    // Método devolver
    public void devolver() {
        if (livro.isStatus()) { // Livro já está disponível
            System.out.println("Este empréstimo já foi finalizado.");
        } else {
            livro.setStatus(true); // Marca o livro como disponível
            System.out.println("Livro devolvido com sucesso.");
        }
    }

    // Sobrescrever os métodos da interface Multa
    @Override
    public double calcularMulta(int diasAtrasados) {
        if (diasAtrasados <= 0) {
            return 0.0; // Sem multa
        }

        double multa = diasAtrasados * 1.0; // R$ 1,00 por dia de atraso
        double valorMaximoMulta = livro.getValor() * 1.5; // Multa máxima = valor do livro * 1.5

        return Math.min(multa, valorMaximoMulta); // Garante que a multa não exceda o limite
    }

    @Override
    public int calcularDiasAtraso() {
        if (LocalDate.now().isAfter(dataDevolucao)) {
            return (int) ChronoUnit.DAYS.between(dataDevolucao, LocalDate.now());
        }
        return 0; // Sem atraso
    }
}
