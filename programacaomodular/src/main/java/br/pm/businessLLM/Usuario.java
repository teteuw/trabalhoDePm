package br.pm.businessLLM;

public class Usuario {
    private String id;
    private String nome;
    private double multa; // Representa o valor da multa em dinheiro

    // Construtor
    public Usuario(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.multa = 0.0; // Inicialmente, o usuário não tem multas
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        if (multa < 0) {
            throw new IllegalArgumentException("A multa não pode ser negativa.");
        }
        this.multa = multa;
    }

    // Método para pagar a multa
    public void pagarMulta() {
        if (this.multa > 0) {
            this.multa = 0.0;
            System.out.println("Multa paga com sucesso!");
        } else {
            System.out.println("Não há multas pendentes para este usuário.");
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", multa=" + multa +
                '}';
    }
}
