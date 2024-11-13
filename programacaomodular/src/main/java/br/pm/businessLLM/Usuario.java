package br.pm.businessLLM;
public class Usuario {
    private Long id; // Alterado de String para Long
    private String nome;
    private String email;
    private String telefone;
    private double multa; // Novo atributo para armazenar o valor da multa

    // Construtor
    public Usuario(Long id, String nome, String email, String telefone) {
        setId(id);
        setNome(nome);
        setEmail(email);
        setTelefone(telefone);
        setMulta(0); // Inicializa a multa com zero
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("O ID deve ser um número positivo e válido.");
        }
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Email inválido.");
        }
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || !telefone.matches("\\d{10,11}")) {
            throw new IllegalArgumentException("O telefone deve conter apenas números e ter entre 10 e 11 dígitos.");
        }
        this.telefone = telefone;
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
        if (multa > 0) {
            setMulta(0);
            System.out.println("Multa paga com sucesso.");
        } else {
            System.out.println("Não há multas pendentes.");
        }
    }
}
