package br.pm.businessLLM;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    // Construtor
    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    // Métodos para Gerenciar Livros
    public void adicionarLivro(Livro livro) {
        if (livro != null) {
            livros.add(livro);
            System.out.println("Livro adicionado: " + livro.getNomeLivro());
        } else {
            throw new IllegalArgumentException("Livro inválido.");
        }
    }

    public void removerLivro(int idLivro) {
        Livro livro = buscarLivroPorId(idLivro);
        if (livro != null) {
            livros.remove(livro);
            System.out.println("Livro removido: " + livro.getNomeLivro());
        } else {
            throw new IllegalArgumentException("Livro com ID " + idLivro + " não encontrado.");
        }
    }

    public Livro buscarLivroPorId(int idLivro) {
        for (Livro livro : livros) {
            if (livro.getIdLivro() == idLivro) {
                return livro;
            }
        }
        return null; // Retorna null se o livro não for encontrado
    }

    // Métodos para Gerenciar Usuários
    public void adicionarUsuario(Usuario usuario) {
        if (usuario != null) {
            usuarios.add(usuario);
            System.out.println("Usuário adicionado: " + usuario.getNome());
        } else {
            throw new IllegalArgumentException("Usuário inválido.");
        }
    }

    public void removerUsuario(int idUsuario) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        if (usuario != null) {
            usuarios.remove(usuario);
            System.out.println("Usuário removido: " + usuario.getNome());
        } else {
            throw new IllegalArgumentException("Usuário com ID " + idUsuario + " não encontrado.");
        }
    }

    public Usuario buscarUsuarioPorId(int idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == idUsuario) {
                return usuario;
            }
        }
        return null; // Retorna null se o usuário não for encontrado
    }

    // Métodos para Gerenciar Empréstimos
    public void registrarEmprestimo(Emprestimo emprestimo) {
        if (emprestimo != null && !emprestimo.isDevolvido()) {
            emprestimos.add(emprestimo);
            emprestimo.getLivro().emprestar(); // Marca o livro como emprestado
            System.out.println("Empréstimo registrado para o livro: " + emprestimo.getLivro().getNomeLivro());
        } else {
            throw new IllegalArgumentException("Empréstimo inválido ou já devolvido.");
        }
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}

