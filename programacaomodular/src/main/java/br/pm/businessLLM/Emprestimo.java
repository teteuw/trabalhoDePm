package br.pm.businessLLM;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo implements Multa {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean devolvido; // true = devolvido, false = ainda emprestado

    // Construtor
    public Emprestimo(Livro livro, Usuario usuario, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.devolvido = false; // Inicia como não devolvido
    }

    // Getters e Setters
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

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    // Implementação do método calcularMulta
    @Override
    public double calcularMulta(int diasAtrasados) {
        if (diasAtrasados <= 0) {
            return 0.0; // Sem multa se não houver atraso
        }

        double multa = diasAtrasados * 1.0; // R$ 1,00 por dia de atraso
        double valorMaximoMulta = livro.getValor() * 1.5; // Multa máxima = valor do livro * 1.5

        return Math.min(multa, valorMaximoMulta); // Garante que a multa não exceda o limite
    }

    // Método para calcular o número de dias de atraso
    public int calcularDiasAtraso() {
        if (LocalDate.now().isAfter(dataDevolucao)) {
            return (int) ChronoUnit.DAYS.between(dataDevolucao, LocalDate.now());
        }
        return 0; // Sem atraso se a data atual for antes ou igual à data de devolução
    }

    // Método para finalizar o empréstimo (devolução)
    public void devolver() {
        if (devolvido) {
            throw new IllegalStateException("Erro: O empréstimo já foi finalizado.");
        }
        this.devolvido = true;
        livro.setStatus(true); // Marca o livro como disponível
        System.out.println("Livro devolvido com sucesso.");
    }
}
